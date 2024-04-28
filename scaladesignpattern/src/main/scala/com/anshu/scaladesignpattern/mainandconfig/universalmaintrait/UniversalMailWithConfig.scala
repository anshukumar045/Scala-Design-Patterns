package com.anshu.scaladesignpattern.mainandconfig.universalmaintrait

import com.anshu.scaladesignpattern.mainandconfig.configtrait.AppArg
import org.apache.spark.sql.SparkSession

trait UniversalMailWithConfig {

  def runWithSpark[T <: AppArg](config: T):(SparkSession => Unit)

}
