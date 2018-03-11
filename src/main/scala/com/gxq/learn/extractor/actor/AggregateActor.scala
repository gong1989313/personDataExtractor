package com.gxq.learn.extractor.actor

import akka.actor.Actor
import scala.collection.mutable.HashMap
import akka.actor.ActorRef
import com.gxq.learn.extractor.message.Result

class AggregateActor extends Actor {
 
  private[this] var finalReduceMap = HashMap[String, Int]()
 
  def receive: Actor.Receive = {
    /*case msg: ReduceData => {
      aggregateAndReduce(msg.reduceDataList)
    }*/
    case msg: Result => {
//      println(f"Result: ${finalReduceMap}")
//      sender().tell(finalReduceMap.toMap, ActorRef.noSender)
      sender ! finalReduceMap.toMap
    }
    case _ => println("AggregateActor receive wrong message.")
  }
 
  private[this] def aggregateAndReduce(reduceList: Map[String, Int]) = {
//   println(s"final: ${finalReduceMap}")
    for (key <- reduceList.keys) {
      if (finalReduceMap.contains(key)) {
      
        val count = finalReduceMap.get(key).get + reduceList.get(key).get
        finalReduceMap += ((key, count))
      } else {
        finalReduceMap += ((key, reduceList.get(key).get))
      }
    }
 
  }
 
}