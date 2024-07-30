package com.anshu.scaladesignpattern.mainandconfig.utils

case class Person(name: String, age: Int)

object Person{
  // Implicit ordering based on age
  implicit object AgeOrdering extends Ordering[Person]{
    override def compare(x: Person, y: Person): Int = x.age.compare(y.age)
  }
}
