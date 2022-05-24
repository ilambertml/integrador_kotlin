package com.example.myapplication.model


/**
 * @param vehicles: se define como un set porque es mas rapido para realizar operaciones de pertenencia, ademas de que no precisamos orden
 */
data class Parking(val vehicles: MutableSet<Vehicle>) {

    val cantMaxVehicles = 20

    fun addVehicle(vehicle: Vehicle): Boolean {
        return if (vehicles.size<cantMaxVehicles) vehicles.add(vehicle) else false
    }
}