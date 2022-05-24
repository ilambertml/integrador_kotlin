package com.example.myapplication.model
import com.example.myapplication.VehicleType
/**
 * @param
 * type: lo definimos como val porque para una placa no cambia el tipo de vehiculo en el tiempo
 * checkInTime: lo agregamos en Vehicle pues es una propiedad del vehiculo y su ingreso al parking
 * discountCard: lo agregamos en Vehicle pues es una propiedad del vehiculo y su ingreso al parking; lo
 * agregamos nullable con el ?
 */

data class Vehicle(val plate: String,val type: VehicleType,val checkInTime: Long,val discountCard?: String) {
    override fun equals(other: Any?): Boolean {
        if (other is Vehicle) {
            return this.plate == other.plate
        }
        return super.equals(other)
    }
    override fun hashCode(): Int = this.plate.hashCode()
}