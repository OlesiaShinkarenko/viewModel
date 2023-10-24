package com.example.viewmodel.data.impl

import com.example.viewmodel.data.AuthenticationRepository
import io.github.jan.supabase.gotrue.GoTrue
import io.github.jan.supabase.gotrue.providers.builtin.Email
import javax.inject.Inject

class AuthenticationRepositoryImpl @Inject constructor(
    private val goTrue: GoTrue
) : AuthenticationRepository{
    override suspend fun signIn(email: String, password: String): Boolean {
        return try{
            goTrue.loginWith(Email){
                this.email = email
                this.password = password
            }
            true
        } catch (e:Exception){
            false
        }
    }

    override suspend fun signUp(email: String, password: String): Boolean {
       return try {
           goTrue.signUpWith(Email){
               this.email = email
               this.password = password
           }
           true
       }catch (e:Exception){
           false
       }
    }
}