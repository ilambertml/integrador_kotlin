package com.example.myapplication.model

import java.util.*


/**
 * @param vehicles: Its a set because It is faster to do membership operations, in addition no order needit
 *
 */
data class Parking(val vehicles: MutableSet<Vehicle>){

    companion object {
        val vehiclesList: MutableSet<Vehicle> = mutableSetOf()
        val cantMaxVehicles = 20
        var countRemove = 0
        var earning = 0
        var pair = Pair(countRemove, earning)


        fun addVehicle(vehicle: Vehicle): Boolean {
            return if (vehiclesList.size < cantMaxVehicles) vehiclesList.add(vehicle) else false
        }

        fun removeVehicle(vehicle: Vehicle): Boolean {
            countRemove++
            return vehiclesList.remove(vehicle)
        }

        fun searchVehicle(plate: String): Vehicle? {
            var vehicleFound:Vehicle? = null
            val vehicleTemp = Vehicle(plate, VehicleType.CAR, Calendar.getInstance().timeInMillis, "")
            vehiclesList.toMutableList().forEach{
                if (vehicleTemp.equals(it)) vehicleFound = it
            }
            //vehiclesList.toList().find { elem -> elem.equals(vehicleFound) } other option to resolve this funtion
            return vehicleFound
        }

        fun updateVehiclesAndEarning(fee: Int): Unit {
            val valueEarning = pair.second
            val cantVehicles = pair.first
            val newValueEarning = (valueEarning + fee);
            val newValueCantVehicles = (cantVehicles + 1)
            val vehiclesAndEarningNew = pair.copy(first = newValueCantVehicles, second = newValueEarning )  //copy the pair because the elements cannot be reassigned
            pair = vehiclesAndEarningNew
        }

        /**
         * get Pair(first, second) where first = count of vehicles removed and second = earning
         */
        fun getEarning(){
            return println ("${pair.first} vehicles have checked out and have earnings of $${pair.second}")
        }

        fun listVehicles(){
            return vehiclesList.toList().forEach{ println(it.plate)}
        }

    }
}