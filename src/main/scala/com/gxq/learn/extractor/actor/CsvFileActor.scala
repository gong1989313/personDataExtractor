package com.gxq.learn.extractor.actor

import akka.actor.Actor
import com.gxq.learn.extractor.message.Result
import java.io.File
import com.gxq.learn.extractor.constant.ParserConstant

class CsvFileActor extends Actor {

  def receive: Actor.Receive = {
    case msg: String => {
      // mapActor ! msg
    }
    case msg: Result => {
      // aggregateActor.forward(msg)
    }
    case _ => println("CsvFileActor receive wrong message.")
  }

  private def scanFile(): List[String] = {
   // ParserConstant.fileDirectory
    //subDir()
    null
  }

  private def subDir(dir: File): Iterator[File] = {
    val dirs = dir.listFiles().filter(_.isDirectory())
    val files = dir.listFiles().filter(_.isFile())
    files.toIterator ++ dirs.toIterator.flatMap(subDir _)
  }
}