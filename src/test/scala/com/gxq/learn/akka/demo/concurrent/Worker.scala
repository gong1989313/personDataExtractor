package com.gxq.learn.akka.demo.concurrent

import akka.actor.Actor
import akka.actor.ActorRef
class Worker extends Actor {
  def receive = {
    case Work() =>
      println("recieved Work command...")
      while(true){
        println(Thread.currentThread().getName+"  sleep...")
        Thread.sleep(1000)
      }
      
      
    case Shutdown() =>
      println("worker recieved Shutdown command...")
      context.stop(self)
  }
}