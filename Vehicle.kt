package com.example.myapplication.model
import com.example.myapplication.VehicleType
/**
 * @param chekInTime
 */
data class Vehicle(val plate: String,var type: VehicleType) {
    override fun equals(other: Any?): Boolean {
        if (other is Vehicle) {
            return this.plate == other.plate
        }
        return super.equals(other)
    }

    override fun hashCode(): Int = this.plate.hashCode()
}