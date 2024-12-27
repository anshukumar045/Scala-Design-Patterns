package com.anshu.scaladesignpattern.mainandconfig.universalmaintrait

import com.anshu.scaladesignpattern.mainandconfig.carapp.Car
import com.anshu.scaladesignpattern.mainandconfig.configtrait.AppArg
import com.anshu.scaladesignpattern.mainandconfig.truckapp.Truck
import com.anshu.scaladesignpattern.mainandconfig.typeclasses.TypeClassApp
import org.apache.spark.sql.SparkSession

object MainApp extends App{

  val appMaps = Map(
    "cars" -> classOf[Car],
    "trucks" -> classOf[Truck],
    "typeclasses" -> classOf[TypeClassApp]
  )

  val parsedArgs: Option[AppArg] = AppArg.parsingArgs(args)
  parsedArgs match {
    case Some(options) =>
      val appClass = appMaps.get(options.appName)
        .getOrElse(throw new RuntimeException("No valid app name found"))

      val appInstance = appClass.getDeclaredConstructor().newInstance()
      val spark: SparkSession = SparkSession.builder()
        .master("local[*]")
        .appName(options.appName)
        .enableHiveSupport()
        .getOrCreate()

      spark.sparkContext.setLogLevel("ERROR")

      appInstance.runWithSpark(options)(spark)
      spark.stop()

    case _ => println("invalid apps")
  }

}
