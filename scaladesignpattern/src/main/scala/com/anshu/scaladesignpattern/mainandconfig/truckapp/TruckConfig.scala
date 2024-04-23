package com.anshu.scaladesignpattern.mainandconfig.truckapp

import com.anshu.scaladesignpattern.mainandconfig.configtrait.AppArg
import scopt._

case class TruckConfig(override val appName: String = "", age: Int = 0) extends AppArg

object TruckConfig{
  val truckConfig = "TruckConfig"
  val parser: OptionParser[TruckConfig] = new OptionParser[TruckConfig](truckConfig) {
    head(truckConfig)
    opt[String]("app-name").action((x,c) => c.copy(appName = x))
    opt[Int]("age").action((x,c) => c.copy(age = x))
  }
}