package com.anshu.scaladesignpattern.mainandconfig.utils

trait FieldChecker [T]{
  def check(t: T): Option[T]

}

object FieldChecker{
  case class Employee(name: String, isManager: Boolean = false)
  case class Student(name: String, inFinalYear: Boolean = true)

  implicit object CheckEmployee extends FieldChecker[Employee]{
    override def check(t: Employee): Option[Employee] = if(t.isManager) None else Some(t)
  }

  implicit object CheckStudent extends FieldChecker[Student] {
    override def check(t: Student): Option[Student] = if(t.inFinalYear) Some(t) else None
  }

  def filterPlayers[T](t: T)(implicit fieldChecker: FieldChecker[T]): Option[T] = {
    fieldChecker.check(t)
  }
}
