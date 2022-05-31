package com.example.myapplication.model

/**
 * @parkedTime: It is the time the vehicle has been in the parking lot. Type: Long because represents the time in milliseconds
 * **/

data class ParkingSpace(
    var vehicle: Vehicle,
    var parkedTime: Long
){


    fun checkOutVehicle(plate:String, onSucces: (Int) -> Unit, onError: () -> Unit) {
        (Parking.searchVehicle(plate))?.let { it->
            var hasDiscount = false
            it.discountCard?.let { hasDiscount=true } ?: run{hasDiscount=false} //if not null, hasDiscount=true
            val fee = calculateFee(it.type,parkedTime,hasDiscount)
            if (Parking.removeVehicle(it)) {
                onSucces(fee)
                Parking.updateVehiclesAndEarning(fee)
                Parking.getEarning()
            } else onError()
        } ?: onError()
    }


    /**
     * calculate value to pay
     * @param type: Type of Vehicle
     * @param parkedTime: Time transcurrido
     */
    fun calculateFee(type: VehicleType, parkedTime: Long, hasDiscountCard: Boolean = false):Int{
        var fee = 0

        when{
            parkedTime <= 7200000 -> fee = (type.price) // less than or equal to 2 hours
            parkedTime > 7200000 -> { // greater than 2 hours
                val minutes = (parkedTime-7200000) / 1000 / 60
                var cantBlock = (minutes.toDouble() / 15) //unrounded blocks
                val cantBlockRound=Math.ceil(cantBlock) //rounded blocks
                fee =(type.price)+cantBlockRound.toInt() * 5
            }
        }
        if (hasDiscountCard) fee = (fee.toFloat() * (0.85)).toInt()
        return fee
    }
}