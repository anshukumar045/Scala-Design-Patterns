package com.anshu.scaladesignpattern.mainandconfig.utils

import java.sql.Date
import scala.util.Try

object AllMyImplicits {

  implicit def stringToDate(s: String): Date =
    Try(Date.valueOf(s)).toOption
      .getOrElse(throw new RuntimeException(s"the value is not in the given date format ${s}"))

  implicit def StringToGivenFOrmat(s: String): UserFormat

}
