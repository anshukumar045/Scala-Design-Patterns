package com.anshu.scaladesignpattern.mainandconfig.configtrait

import com.anshu.scaladesignpattern.mainandconfig.carapp.CarConfig
import com.anshu.scaladesignpattern.mainandconfig.truckapp.TruckConfig

abstract class AppArg (val appName: String)

object AppArg{

  import com.anshu.scaladesignpattern.mainandconfig.carapp.CarConfig._
  import com.anshu.scaladesignpattern.mainandconfig.truckapp.TruckConfig._

  def parsingArgs(args: Array[String]): Option[AppArg] = {
    args.headOption.flatMap{
      case `carConfig` => CarConfig.parser.parse(args.tail, CarConfig())
      case `truckConfig` => TruckConfig.parser.parse(args.tail, TruckConfig())
      case _ => None
    }
  }
}
