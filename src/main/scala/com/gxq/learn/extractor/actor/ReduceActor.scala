/*package com.gxq.learn.extractor.actor

import akka.actor.Actor
import com.citi.dw.messages.MapData
import com.citi.dw.messages.ReduceData
import com.citi.dw.messages.WordCount
import scala.collection.mutable.HashMap
import akka.actor.ActorRef
 
class ReduceActor(val aggregateActor: ActorRef) extends Actor {
 
  def receive: Actor.Receive = {
    case msg: MapData => {
      val reduceData = reduce(msg.dataList)
      aggregateActor ! reduceData
    }
    case _ => println("ReduceActor receive wrong message.")
  }
 
  private[this] def reduce(dataList: List[WordCount]): ReduceData = {
    val reduceMap = HashMap[String, Int]()
 
    for (wc <- dataList) {
      wc match {
        case WordCount(key, count) if reduceMap.contains(key) => {
          val localSumCount = reduceMap.get(key).get + count
          reduceMap += ((key, localSumCount))
          //          println(reduceMap)
        }
        case WordCount(key, count) => {
          reduceMap += ((key, 1))
          //          println(reduceMap)
        }
      }
    }
    ReduceData(reduceMap.toMap)
  }
 
}*/