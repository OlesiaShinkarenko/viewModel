package com.example.viewmodel.useCase

import kotlinx.serialization.Serializable

@Serializable
data class Client (
    val id :Int,
    val surname:String,
    val name:String,
    val middleName:String,
    val address:String,
    val telephone:String
)
