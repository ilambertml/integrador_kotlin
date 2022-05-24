package com.example.myapplication.model

import com.example.myapplication.VehicleType
import java.util.*


    fun main() {

        val parking = Parking(mutableSetOf())

        var plateRandom = 0

        val arrayVehicles = arrayListOf<Vehicle>()


        //create array of vehicles
        for(position in 0..20) {
            var car = Vehicle(
                (plateRandom++).toString(),
                VehicleType.CAR,
                Calendar.getInstance().timeInMillis,
                "DISCOUNT_CARD_001"
            )
            arrayVehicles.add(car)
        }



        //put vehicles into parking
        for (elem in arrayVehicles){
            if (parking.addVehicle(elem)) println("Welcome to AlkeParking!") else println("Sorry, the check-in failed")
        }

    }