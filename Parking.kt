package com.example.myapplication.model


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
            var vehicleFound : Vehicle? = null
            vehiclesList.forEach{
                if (it.plate == plate) vehicleFound = it
            }
            return vehicleFound
        }

    }
}