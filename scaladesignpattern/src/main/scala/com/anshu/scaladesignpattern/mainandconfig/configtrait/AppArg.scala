package com.anshu.scaladesignpattern.mainandconfig.configtrait

import com.anshu.scaladesignpattern.mainandconfig.carapp.CarConfig
import com.anshu.scaladesignpattern.mainandconfig.truckapp.TruckConfig
import com.anshu.scaladesignpattern.mainandconfig.typeclasses.TypeClassAppConfig

abstract class AppArg (val appName: String)

object AppArg{

  import com.anshu.scaladesignpattern.mainandconfig.carapp.CarConfig._
  import com.anshu.scaladesignpattern.mainandconfig.truckapp.TruckConfig._
  import com.anshu.scaladesignpattern.mainandconfig.typeclasses.TypeClassAppConfig._

  def parsingArgs(args: Array[String]): Option[AppArg] = {
    args.headOption.flatMap{
      case `carConfig` => CarConfig.parser.parse(args.tail, CarConfig())
      case `truckConfig` => TruckConfig.parser.parse(args.tail, TruckConfig())
      case `typeClassAppConfig` => TypeClassAppConfig.parser.parse(args.tail, TypeClassAppConfig())
      case _ => None
    }
  }
}
