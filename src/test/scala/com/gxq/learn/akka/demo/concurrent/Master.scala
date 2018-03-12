package com.gxq.learn.akka.demo.concurrent

import scala.collection.mutable.ListBuffer
import akka.actor.Actor
import akka.actor.ActorRef
import akka.actor.Props
import akka.routing.FromConfig
import akka.routing.ConsistentHashingRouter.ConsistentHashableEnvelope

class Master extends Actor {
  val worker = context.actorOf(Props[Worker].withRouter(FromConfig()), "workerRouter")

  def receive = {
    case StartFind() =>
      worker ! Work()
      
    case Shutdown() =>
      println("master shutdown @@@@@@@@@@@@@...")
      //worker ! Shutdown()
     // context.stop(worker)
     // context.system.terminate()
      System.exit(0)
  }
} 