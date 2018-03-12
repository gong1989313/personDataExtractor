package com.gxq.learn.akka.demo.concurrent

import scala.concurrent.duration._
import scala.collection.mutable.ListBuffer
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.Actor
import com.typesafe.config.ConfigFactory
import akka.routing.FromConfig

object PerfectNumber {

  def main(args: Array[String]): Unit = {
    val system = ActorSystem("MasterApp", ConfigFactory.load.getConfig("multiThread"))
    val master = system.actorOf(Props[Master], "master")
    master ! StartFind()
    Thread.sleep(1000)
    println("  read to stop system...")
    master ! Shutdown()
    master ! Shutdown()
   // System.exit(0)
    //system.terminate()
  }
}