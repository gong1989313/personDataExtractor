package com.gxq.learn.extractor.util

import org.scalatest.FlatSpec

class ScalikeJdbcUtilSpec extends FlatSpec {
  "The method " should "get person records" in {
    ScalikeJdbcUtil.name.foreach(println)
  }
}