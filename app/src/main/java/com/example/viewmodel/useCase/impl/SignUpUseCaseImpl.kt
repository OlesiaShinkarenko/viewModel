package com.example.viewmodel.useCase.impl

import com.example.viewmodel.data.AuthenticationRepository
import com.example.viewmodel.useCase.SignUpUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SignUpUseCaseImpl @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
): SignUpUseCase{
    override suspend fun execute(input: SignUpUseCase.Input): SignUpUseCase.Output {
        return withContext(Dispatchers.IO){
            val result = authenticationRepository.signUp(input.email, input.password)
            if(result){
                SignUpUseCase.Output.Success
            }
            else{
                SignUpUseCase.Output.Failure
            }
        }
    }
}