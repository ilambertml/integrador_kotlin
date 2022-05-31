package com.example.myapplication.model
/**
 * @param type: we define it as val because for a license plate the type of vehicle does not change over time
 * @param checkInTime: we add it in Vehicle because it is a property of the vehicle and its entrance to the parking lot
 * @param discountCard: we add it in Vehicle because it is a property of the vehicle and its entrance to the parking lot and
 * add nullable with the ?
 */
data class Vehicle(val plate: String,val type: VehicleType,val checkInTime: Long,val discountCard: String? = null) {
    override fun equals(other: Any?): Boolean {
        if (other is Vehicle) {
            return this.plate == other.plate
        }

        return super.equals(other)
    }
    override fun hashCode(): Int = this.plate.hashCode()
}