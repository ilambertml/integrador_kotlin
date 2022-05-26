package com.example.myapplication.model

import com.example.myapplication.VehicleType

/**
 * parkedTime: lo agregamos de tipo Long pues es el tipo devuelto por la funcion Calendar.getInstance()
 **/

data class ParkingSpace(
    var vehicle: Vehicle,
    var parkedTime: Long
) {

    //fun getParkedTime(chekInTime:Long) = Calendar.getInstance().timeInMillis - chekInTime

    fun checkOutVehicle(plate:String, onSucces: (Int) -> Unit, onError: () -> Unit) {
        (Parking.searchVehicle(plate))?.let {
            var hasDiscount = false
            it.discountCard.let { hasDiscount=true }
            if (Parking.removeVehicle(it)) onSucces(800) else onError()
        } ?: onError()
    }

    /**
     * calculate value to pay
     * @param type: Type of Vehicle
     * @param parkedTime: Time transcurrido
     */
    fun calculateFee(type: VehicleType, parkedTime: Long, hasDiscountCard: Boolean):Int{
        var fee = 0
        when{
            parkedTime <= 7200000 -> fee = (type.price)
            parkedTime > 7200000 -> {
                val minutes = (parkedTime-7200000) / 1000 / 60
                println("ver"+minutes)
                fee =(type.price)+(minutes / 15).toInt() * 5
            }
        }
        println("time parquimetro $parkedTime")
        return fee
    }
}