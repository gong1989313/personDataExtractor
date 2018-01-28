package com.gxq.learn.extractor.util

import scalikejdbc.config.DBs
import scalikejdbc._

object ScalikeJdbcUtil {
  DBs.setupAll()

  val name: List[String] = DB readOnly { implicit session =>
    sql"select name from person".map(rs => rs.string("name")).list.apply()
  }
}