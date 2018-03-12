package com.gxq.learn.akka.demo.concurrent

import akka.actor.ActorRef  
  
sealed trait Message  
case class StartFind() extends Message  
case class Work() extends Message  
case class Result(num: Int, isPerfect: Boolean) extends Message  
case class Shutdown() extends Message  