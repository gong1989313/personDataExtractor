package com.gxq.learn.akka.demo.rpc

class WorkerInfo(val id: String, val memory: Int, val cores: Int) {
  var lastHeartbeatTime : Long = _
}