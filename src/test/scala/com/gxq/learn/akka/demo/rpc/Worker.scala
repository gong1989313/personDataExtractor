package com.gxq.learn.akka.demo.rpc

import java.util.UUID

import akka.actor.{Actor, ActorSelection, ActorSystem, Props}
import com.typesafe.config.ConfigFactory
import scala.concurrent.duration._

class Worker(val masterHost: String, val masterPort: Int, val memory: Int, val cores: Int) extends Actor{

  var master : ActorSelection = _
  val workerId = UUID.randomUUID().toString
  val HEART_INTERVAL = 10000

  //
  override def preStart(): Unit = {
    //跟Master建立连接
    master = context.actorSelection(s"akka.tcp://MasterSystem@$masterHost:$masterPort/user/Master")
    //向Master发送注册消息
    master ! RegisterWorker(workerId, memory, cores)
  }

  override def receive: Receive = {
    case RegisteredWorker(masterUrl) => {
      println(masterUrl)
      //启动定时器发送心跳
      import context.dispatcher
      //多长时间后执行 单位,多长时间执行一次 单位, 消息的接受者(直接给master发不好, 先给自己发送消息, 以后可以做下判断, 什么情况下再发送消息), 信息
      context.system.scheduler.schedule(0 millis, HEART_INTERVAL millis, self, SendHeartbeat)
    }

    case SendHeartbeat => {
      println("send heartbeat to master")
      master ! Heartbeat(workerId)
    }
  }
}