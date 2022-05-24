package com.example.myapplication.model

import com.example.myapplication.VehicleType
import java.util.*

fun main() {


    val car = Vehicle("AAAA111", VehicleType.CAR, Calendar.getInstance().timeInMillis, "DISCOUNT_CARD001")
    val motorCycle = Vehicle("BBBB111", VehicleType.MOTORCYCLE, Calendar.getInstance().timeInMillis, null)
    val miniBus = Vehicle("CCCC111", VehicleType.MINIBUS, Calendar.getInstance().timeInMillis, null)
    val bus = Vehicle("B2B2B111", VehicleType.BUS, Calendar.getInstance().timeInMillis, "DISCOUNT_CARD002")

    //repeat car
    val car2 = Vehicle("AAAA111", VehicleType.CAR, Calendar.getInstance().timeInMillis, "DISCOUNT_CARD001")


    val parking = Parking(mutableSetOf(car, motorCycle, miniBus, bus))

    println(parking.vehicles.contains(car))
    println(parking.vehicles.contains(motorCycle))
    println(parking.vehicles.contains(miniBus))
    println(parking.vehicles.contains(bus))

    val isCar2Inserted = parking.vehicles.add(car2)
    println("Car 2 repeted is inserted: "+isCar2Inserted)

    //put vehicles into parking. Test fun add
    val car3 = Vehicle("AAAA222", VehicleType.CAR, Calendar.getInstance().timeInMillis, "DISCOUNT_CARD001")
    if (parking.addVehicle(car3)) println("Welcome to AlkeParking!") else println("Sorry, the check-in failed")

}