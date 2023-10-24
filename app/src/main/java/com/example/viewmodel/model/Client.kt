package com.example.viewmodel.model

import kotlinx.serialization.Serializable

@Serializable
data class Client (
    val id :Int = 0,
    val surname:String = "",
    val name:String= "",
    val middleName:String= "",
    val address:String= "",
    val telephone:String= ""
)
