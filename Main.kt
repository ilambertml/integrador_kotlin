package com.example.myapplication.model

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.*


@RequiresApi(Build.VERSION_CODES.O)
fun main() {


    //Example Car1 checkIn: set example date in calendar
    val calendar = Calendar.getInstance()
    calendar.set(2022,4,31, 10, 0 ,0) // 31-05-2022 10:00:00
    val checkIn = calendar.time

    //Example Car2 checkIn: set example date in calendar
    val calendar2 = Calendar.getInstance()
    calendar2.set(2022,4,31, 12, 0 ,0) // 31-05-2022 10:00:00
    val checkIn2 = calendar2.time


    val car1 = Vehicle("AAAA111", VehicleType.CAR, checkIn.time)
    val car2 = Vehicle("AAAA112", VehicleType.CAR, checkIn2.time, "DISCOUNT_CARD001")
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
    val car2Repeat = Vehicle("AAAA112", VehicleType.CAR, Calendar.getInstance().timeInMillis, "DISCOUNT_CARD001")

    //put vehicles into parking. Test fun add
    var arrayVehicles = arrayOf(car1,car2,car3,car4,car5,car6,car7,car8,car9,car10,car11,car12,car13,car14,car15,car16,car17,motorCycle,miniBus,bus,car17)
    var i = 1;
    for (vh in arrayVehicles){
        if (Parking.addVehicle(vh)) println(""+i+"-Welcome to AlkeParking!") else println(""+i+"-Sorry, the check-in failed")
        i++;
    }


    //check out succes
    val onSucces: (Int)-> Unit = {
        println("Your fee is $$it. Come back soon.")
        }

    //check out error
    val onError: ()-> Unit = {println("error")}
    //check out car1
    ParkingSpace(car1, Calendar.getInstance().timeInMillis-car1.checkInTime).checkOutVehicle(car1.plate, onSucces, onError)
    //check out car2
    ParkingSpace(car2, Calendar.getInstance().timeInMillis-car2.checkInTime).checkOutVehicle(car2.plate, onSucces, onError)

    //7140000 son 1 hora 59 minutos, $20
    //7200000 son 2 horas, $20
    //10740000 son 2 horas 59 min, $40
    //11880000 son 3 horas 18 min, $50
    //11580000 son 3 horas 13 min, $45
    //12600000 son 3 horas 30 min, $50

    println("\n//////////////////////////////// CARS IN THE PARKING /////////////////////////")
    Parking.listVehicles()

}

