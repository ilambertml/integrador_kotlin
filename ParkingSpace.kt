package com.example.myapplication.model

//import com.example.myapplication.VehicleType

/**
 * parkedTime: lo agregamos de tipo Long pues es el tipo devuelto por la funcion Calendar.getInstance()
 **/

data class ParkingSpace(
    var vehicle: Vehicle,
    var parkedTime: Long
) {

    //fun getParkedTime(chekInTime:Long) = Calendar.getInstance().timeInMillis - chekInTime

    fun checkOutVehicle(plate:String, onSucces: (Int) -> Unit, onError: () -> Unit) {

        (Parking.searchVehicle(plate))?.let { it->

            //var hasDiscount = (it.discountCard != "")
            var hasDiscount = false
            it.discountCard?.let { hasDiscount=true } ?: run{hasDiscount=false} //if not null, hasDiscount=true
            if (Parking.removeVehicle(it)) onSucces(calculateFee(it.type,parkedTime,hasDiscount)) else onError()
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
            parkedTime <= 7200000 -> fee = (type.price)
            parkedTime > 7200000 -> {
                val minutes = (parkedTime-7200000) / 1000 / 60
                var cantBlock = (minutes.toDouble() / 15) //unrounded blocks
                val cantBlockRound=Math.ceil(cantBlock) //rounded blocks
                fee =(type.price)+cantBlockRound.toInt() * 5
            }
        }
        if (hasDiscountCard){
            val newFee = (fee.toFloat() * (0.85))
            fee = newFee.toInt()
        }
        //println("time parquimetro $parkedTime")
        return fee
    }
}