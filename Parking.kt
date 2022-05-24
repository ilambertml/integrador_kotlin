package com.example.myapplication.model

import java.util.*

/**
 * @param vehicles: se define como un set porque es mas rapido para realizar operaciones de pertenencia, ademas de que no precisamos orden
 */
data class Parking(val vehicles: MutableSet<Vehicle>) {


}