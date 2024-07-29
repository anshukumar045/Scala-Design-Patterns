package com.anshu.scaladesignpattern.mainandconfig.utils


/**
 * we will have Vehicle types - newCar & oldCar
 * Partial Function to have string -> Vehicle type mapping
 * use it in the implicit conversion
 */
abstract class VehicleTypes (val name: String)

case object NewCar extends VehicleTypes("newCar")
case object OldCar extends VehicleTypes("oldCar")

object VehicleTypes{
   val newCar = "newCar"
   val oldCar = "oldCar"

  val vehicleTypesPF: PartialFunction[String, VehicleTypes]= {
    case `newCar` => NewCar
    case `oldCar` => OldCar
  }

  val vehicleTypesOption = vehicleTypesPF.lift



}