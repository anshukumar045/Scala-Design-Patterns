package com.anshu.scaladesignpattern.mainandconfig.carapp

import com.anshu.scaladesignpattern.mainandconfig.configtrait.AppArg
import com.anshu.scaladesignpattern.mainandconfig.universalmaintrait.UniversalMailWithConfig
import com.anshu.scaladesignpattern.mainandconfig.utils.FieldChecker._
import com.anshu.scaladesignpattern.mainandconfig.utils.Person
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import com.anshu.scaladesignpattern.mainandconfig.utils.AllMyImplicits._

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


    df.filterLessThanCost(carConfig.cost).show(10, false)


//    df.filter(col("cost") > lit(carConfig.cost)).show(10, false)

//    println(discountCost(carConfig.cost)(100))
    implicit val discountX: Int = 100
    implicit val discount: Double = 120.00

    val disc = 100

//    println(discountCost(carConfig.cost)(disc))
//    println(discountCost(carConfig.cost))

    // TODO: Implicit Objects
    /**
     * Person(name. age)
     * List(Person).sorted
     * List(3,2,1).sorted
     */

    val list = List(Person("A", 2), Person("B", 1), Person("C", 3))
    val sortedList = list.sorted
//    println(sortedList)

    val listOfEmployees = List(Employee("A"), Employee("B", true), Employee("C"))
    val listOfStudents = List(Student("D", false), Student("E"), Student("F", false))

    val selectedEmployees = listOfEmployees.flatMap(filterPlayers(_))
    val selectedStudents = listOfStudents.flatMap(filterPlayers(_))

//    println(selectedEmployees)
//    println(selectedStudents)
  }

  // TODO: Implicit parameter
  private def discountCost(cost: Int)(implicit discount: Int): Int = cost-discount

  // TODO: Implicit Methods or Conversions

  // TODO: Implicit Objects
  /**
   * Person(name. age)
   * List(Person).sorted
   * List(3,2,1).sorted
   */

  // TODO: Implicit Classes

}
