package com.example.myapplication.model

/**
 * parkedTime: lo agregamos de tipo Long pues es el tipo devuelto por la funcion Calendar.getInstance()
 **/

data class ParkingSpace(
    var vehicle: Vehicle,
    var parkedTime: Long
){

}