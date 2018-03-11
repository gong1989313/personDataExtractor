package com.gxq.learn.extractor

import akka.pattern.ask
import scala.concurrent.duration._
import akka.util.Timeout
import scala.util._
import scala.concurrent.Await
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.actorRef2Scala
import com.gxq.learn.extractor.actor.MasterActor
import com.gxq.learn.extractor.message.Result

object AkkaPersonExtrator extends App {
  implicit val timeout = Timeout(5 seconds)
  val system = ActorSystem("WordCountAkka")
  val master = system.actorOf(Props(classOf[MasterActor]), "master")
 
  master ! "Hi! Hi!"
  master ! ("My name is Sky. I am so so so happy to be here ")
  master ! ("Today, I am going to introduce word count for Akka ")
  master ! ("I hope hope It is helpful to you ")
  master ! ("Thank you ")
 
  Thread.sleep(1000)
 
  val future = master ? Result()
 
  val result = Await.result(future, timeout.duration).asInstanceOf[Map[String, Int]]
  result.map(m => println(m._1, m._2))
 
  system.terminate()
}