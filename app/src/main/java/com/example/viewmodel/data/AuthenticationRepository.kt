package com.example.viewmodel.data

interface AuthenticationRepository {
    suspend fun signIn(email:String, password:String): Boolean
    suspend fun signUp(email:String, password:String): Boolean
}