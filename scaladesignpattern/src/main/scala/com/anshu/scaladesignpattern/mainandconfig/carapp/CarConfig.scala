package com.anshu.scaladesignpattern.mainandconfig.carapp

import com.anshu.scaladesignpattern.mainandconfig.configtrait.AppArg
import com.anshu.scaladesignpattern.mainandconfig.utils.AllMyImplicits._
import com.anshu.scaladesignpattern.mainandconfig.utils.{OldCar, VehicleTypes}
import scopt._

import java.sql.Date

// CarConfig --app-name "cars" --cost 1500
case class CarConfig(
    override val appName: String = "",
    cost: Int = 0,
    starDate: Date = Date.valueOf("2024-06-31"),
    vehicleType: VehicleTypes = OldCar) extends AppArg(appName)

object CarConfig{
  val carConfig = "CarConfig"

  val parser: OptionParser[CarConfig] = new OptionParser[CarConfig](carConfig) {
    head(carConfig)
    opt[String]("app-name").action((x,c) => c.copy(appName = x))
    opt[Int]("cost").action((x,c) => c.copy(cost = x))
    opt[String]("start-date").action((x,c) => c.copy(starDate = x))
    opt[String]("vehicle-type").action((x,c) => c.copy(vehicleType = x))
  }
}
