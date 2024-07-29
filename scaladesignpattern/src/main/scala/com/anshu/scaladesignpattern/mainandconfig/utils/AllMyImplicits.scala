package com.anshu.scaladesignpattern.mainandconfig.utils

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

}
