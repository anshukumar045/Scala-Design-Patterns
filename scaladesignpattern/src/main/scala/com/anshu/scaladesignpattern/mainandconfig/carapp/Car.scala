package com.anshu.scaladesignpattern.mainandconfig.carapp

import com.anshu.scaladesignpattern.mainandconfig.configtrait.AppArg
import com.anshu.scaladesignpattern.mainandconfig.universalmaintrait.UniversalMailWithConfig
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

class Car extends UniversalMailWithConfig {

  override def runWithSpark[T <: AppArg](config: T): SparkSession => Unit = (spark) => {
    import spark.implicits._

    val carConfig = config.asInstanceOf[CarConfig]
    println(carConfig)

    val df = Seq(
      (1, "car1", 1000),
      (2, "car2", 2000),
      (3, "car3", 3000),
      (4, "car4", 4000),
    ).toDF("id","model","cost")

//    df.filter(col("cost") > lit(carConfig.cost)).show(10, false)

    println(discountCost(carConfig.cost)(100))
    implicit val discountX: Int = 100
    implicit val discount: Double = 120.00

    val disc = 100

    println(discountCost(carConfig.cost)(disc))
    println(discountCost(carConfig.cost))

  }

  // TODO: Implicit parameter
  private def discountCost(cost: Int)(implicit discount: Int): Int = cost-discount

  // TODO: Implicit Methods or Conversions
  // TODO: Implicit Objects
  // TODO: Implicit Classes

}
