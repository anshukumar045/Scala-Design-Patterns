package com.anshu.scaladesignpattern.mainandconfig.utils

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions._

import java.sql.Date
import scala.util.Try

object AllMyImplicits {
  import VehicleTypes._
  implicit def stringToDate(s: String): Date =
    Try(Date.valueOf(s)).toOption
      .getOrElse(throw new RuntimeException(s"the value is not in the given date format ${s}"))

  implicit def stringToVehicleTypes(s: String): VehicleTypes =
    vehicleTypesOption(s)
      .getOrElse(throw new RuntimeException(s"the value  - $s is not a vehicle type $newCar or $oldCar"))

  implicit class CarsImplicits(df: DataFrame){

    def filterLessThanCost(cost: Int): DataFrame =
      df.filter(col("cost") <= lit(cost))
  }

}
