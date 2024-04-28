package com.anshu.scaladesignpattern.mainandconfig.truckapp

import com.anshu.scaladesignpattern.mainandconfig.configtrait.AppArg
import com.anshu.scaladesignpattern.mainandconfig.universalmaintrait.UniversalMailWithConfig
import org.apache.spark.sql.SparkSession

class Truck extends UniversalMailWithConfig{

  override def runWithSpark[T <: AppArg](config: T): SparkSession => Unit = (spark) => {
    val truckConfig = config.asInstanceOf[TruckConfig]
    println(truckConfig)
  }
}
