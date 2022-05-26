package com.example.myapplication.model

import java.util.*


/**
 * @param vehicles: se define como un set porque es mas rapido para realizar operaciones de pertenencia, ademas de que no precisamos orden
 */
data class Parking(val vehicles: MutableSet<Vehicle>) {

    companion object {
        val vehiclesList: MutableSet<Vehicle> = mutableSetOf()
        val cantMaxVehicles = 20

        fun addVehicle(vehicle: Vehicle): Boolean {
            return if (vehiclesList.size < cantMaxVehicles) vehiclesList.add(vehicle) else false
        }

        fun removeVehicle(vehicle: Vehicle): Boolean {
            return vehiclesList.remove(vehicle)
        }

        fun searchVehicle(plate: String): Vehicle? {
            var vehicleFound : Vehicle = Vehicle(plate, VehicleType.CAR, Calendar.getInstance().timeInMillis, "")
            vehiclesList.forEach{
                if (vehicleFound.equals(it)) vehicleFound = it
            }
            return vehicleFound
        }


    }
}