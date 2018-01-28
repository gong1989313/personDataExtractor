/*package com.gxq.learn.extractor.actor

import akka.actor.Actor
import com.citi.dw.messages.MapData
import com.citi.dw.messages.WordCount
import scala.collection.mutable.ListBuffer
import akka.actor.ActorRef
 
class MapActor(val reduceActor: ActorRef) extends Actor {
  def receive: Actor.Receive = {
    case msg: String => {
      val mapData = evaluateExpression(msg)
      reduceActor ! mapData
    }
    case _ => println("MapActor receive wrong message.")
  }
   
  private[this] def evaluateExpression(line: String): MapData = {
    val dataList = ListBuffer[WordCount]()
    line.split(" ").map(word => dataList += WordCount(word, 1))
    MapData(dataList.toList)
  }
}*/