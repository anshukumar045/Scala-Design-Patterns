package com.anshu.scaladesignpattern.mainandconfig.carapp

import com.anshu.scaladesignpattern.mainandconfig.configtrait.AppArg
import scopt._

case class CarConfig(override val appName: String = "", cost: Int = 0) extends AppArg

object CarConfig{
  val carConfig = "CarConfig"
  val parser: OptionParser[CarConfig] = new OptionParser[CarConfig](carConfig) {
    head(carConfig)
    opt[String]("app-name").action((x,c) => c.copy(appName = x))
    opt[Int]("cost").action((x,c) => c.copy(cost = x))
  }
}
