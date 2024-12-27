package com.anshu.scaladesignpattern.mainandconfig.typeclasses

import com.anshu.scaladesignpattern.mainandconfig.configtrait.AppArg
import com.anshu.scaladesignpattern.mainandconfig.universalmaintrait.UniversalMailWithConfig
import org.apache.spark.sql.SparkSession

class TypeClassApp extends UniversalMailWithConfig{
  override def runWithSpark[T <: AppArg](config: T): SparkSession => Unit = (spark) => {
    val typeConfig = config.asInstanceOf[TypeClassAppConfig]
    println(typeConfig)
    println(show("Scala"))
    println(show(2025))
    println(show(Seq(1,2,3)))

  }

  // define a type class
  trait Show[T]{
    def show(value: T): String
  }

  // concrete implementation of the type class
  object Show {
    implicit val stringShow: Show[String] = (value: String) => s"the input is $value"
    implicit val intShow: Show[Int] =  (value: Int) => s"the input is $value"
    implicit val seqShow: Show[Seq[Int]] = (value: Seq[Int]) => s"the input is ${value.mkString(",")}"
  }

  def show[T](value: T)(implicit ev: Show[T]): String = ev.show(value)



}
