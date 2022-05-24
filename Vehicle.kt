package com.example.myapplication.model
import com.example.myapplication.VehicleType
/**
 * @param type: lo definimos como val porque para una placa no cambia el tipo de vehiculo en el tiempo
 */
data class Vehicle(val plate: String,val type: VehicleType) {
    override fun equals(other: Any?): Boolean {
        if (other is Vehicle) {
            return this.plate == other.plate
        }
        return super.equals(other)
    }

    override fun hashCode(): Int = this.plate.hashCode()
}