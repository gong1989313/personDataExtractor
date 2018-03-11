package com.gxq.learn.extractor.actor

import akka.actor.Actor
import akka.actor.Props
import com.gxq.learn.extractor.message.Result

class MasterActor extends Actor {
 
 // private val aggregateActor = context.actorOf(Props(classOf[AggregateActor]), "aggregateActor")
 // private val reduceActor = context.actorOf(Props(classOf[ReduceActor], aggregateActor), "reduceActor")
 // private val mapActor = context.actorOf(Props(classOf[MapActor], reduceActor), "mapActor")
 
  def receive: Actor.Receive = {
    case msg: String => {
     // mapActor ! msg
    }
    case msg: Result => {
     // aggregateActor.forward(msg)
    }
//    case msg: Map[String, Int] =>
    case _ => println("MasterActor receive wrong message.")
  }
}