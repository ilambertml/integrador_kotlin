package com.example.myapplication.model

import com.example.myapplication.VehicleType
import java.util.*

fun main() {


   /* val car =
        Vehicle("AAAA111", VehicleType.CAR, Calendar.getInstance().timeInMillis, "DISCOUNT_CARD001")
    val motorCycle =
        Vehicle("BBBB111", VehicleType.MOTORCYCLE, Calendar.getInstance().timeInMillis, null)
    val miniBus = Vehicle("CCCC111", VehicleType.MINIBUS, Calendar.getInstance().timeInMillis, null)
    val bus = Vehicle("B2B2B111", VehicleType.BUS, Calendar.getInstance().timeInMillis, "DISCOUNT_CARD002")
    //repeat car
    val car2 = Vehicle("AAAA111", VehicleType.CAR, Calendar.getInstance().timeInMillis, "DISCOUNT_CARD001")


     val parking = Parking(vehiclesSet)
     println(parking.vehicles.contains(car))
     println(parking.vehicles.contains(motorCycle))
     println(parking.vehicles.contains(miniBus))
     println(parking.vehicles.contains(bus))

     val isCar2Inserted = parking.vehicles.add(car2)
     println("Car 2 repeted is inserted: "+isCar2Inserted)
 */


    val car1 = Vehicle("AAAA111", VehicleType.CAR, Calendar.getInstance().timeInMillis, "DISCOUNT_CARD001")
    val car2 = Vehicle("AAAA112", VehicleType.CAR, Calendar.getInstance().timeInMillis, "DISCOUNT_CARD001")
    val car3 = Vehicle("AAAA113", VehicleType.CAR, Calendar.getInstance().timeInMillis, "DISCOUNT_CARD001")
    val car4 = Vehicle("AAAA114", VehicleType.CAR, Calendar.getInstance().timeInMillis, "DISCOUNT_CARD001")
    val car5 = Vehicle("AAAA115", VehicleType.CAR, Calendar.getInstance().timeInMillis, "DISCOUNT_CARD001")
    val car6 = Vehicle("AAAA116", VehicleType.CAR, Calendar.getInstance().timeInMillis, "DISCOUNT_CARD001")
    val car7 = Vehicle("AAAA117", VehicleType.CAR, Calendar.getInstance().timeInMillis, "DISCOUNT_CARD001")
    val car8 = Vehicle("AAAA118", VehicleType.CAR, Calendar.getInstance().timeInMillis, "DISCOUNT_CARD001")
    val car9 = Vehicle("AAAA119", VehicleType.CAR, Calendar.getInstance().timeInMillis, "DISCOUNT_CARD001")
    val car10 = Vehicle("AAAA120", VehicleType.CAR, Calendar.getInstance().timeInMillis, "DISCOUNT_CARD001")
    val car11 = Vehicle("AAAA121", VehicleType.CAR, Calendar.getInstance().timeInMillis, "DISCOUNT_CARD001")
    val car12 = Vehicle("AAAA122", VehicleType.CAR, Calendar.getInstance().timeInMillis, "DISCOUNT_CARD001")
    val car13 = Vehicle("AAAA123", VehicleType.CAR, Calendar.getInstance().timeInMillis, "DISCOUNT_CARD001")
    val car14 = Vehicle("AAAA124", VehicleType.CAR, Calendar.getInstance().timeInMillis, "DISCOUNT_CARD001")
    val car15= Vehicle("AAAA125", VehicleType.CAR, Calendar.getInstance().timeInMillis, "DISCOUNT_CARD001")
    val car16 = Vehicle("AAAA126", VehicleType.CAR, Calendar.getInstance().timeInMillis, "DISCOUNT_CARD001")
    val car17 = Vehicle("AAAA127", VehicleType.CAR, Calendar.getInstance().timeInMillis, "DISCOUNT_CARD001")
    val motorCycle = Vehicle("BBBB111", VehicleType.MOTORCYCLE, Calendar.getInstance().timeInMillis, null)
    val miniBus = Vehicle("CCCC111", VehicleType.MINIBUS, Calendar.getInstance().timeInMillis, null)
    val bus = Vehicle("B2B2B111", VehicleType.BUS, Calendar.getInstance().timeInMillis, "DISCOUNT_CARD002")

    //repeat car
    //val car2 = Vehicle("AAAA111", VehicleType.CAR, Calendar.getInstance().timeInMillis, "DISCOUNT_CARD001")

    //put vehicles into parking. Test fun add
    var arrayVehicles = arrayOf(car1,car2,car3,car4,car5,car6,car7,car8,car9,car10,car11,car12,car13,car14,car15,car16,car17,motorCycle,miniBus,bus,car17)
    var i = 1;
    for (vh in arrayVehicles){
        if (Parking.addVehicle(vh)) println(""+i+"-Welcome to AlkeParking!") else println(""+i+"-Sorry, the check-in failed")
        i++;
    }

    val onSucces: (Int)-> Unit = {
        println("Your fee is $$it. Come back soon.")
        }

    val onError: ()-> Unit = {println("error")}

    //Calendar.getInstance().timeInMillis-car.checkInTime
    val car =Vehicle("AAAA111", VehicleType.CAR, Calendar.getInstance().timeInMillis, "DISCOUNT_CARD001")
    ParkingSpace(car,  11268000).checkOutVehicle(car.plate, onSucces, onError) //remove car

    println("parking vehicles " + Parking.vehiclesList)

}

