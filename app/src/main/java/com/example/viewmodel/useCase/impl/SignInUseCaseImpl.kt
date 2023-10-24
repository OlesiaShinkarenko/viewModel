package com.example.viewmodel.useCase.impl

import com.example.viewmodel.data.AuthenticationRepository
import com.example.viewmodel.useCase.SignInUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SignInUseCaseImpl @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
) : SignInUseCase{
    override suspend fun execute(input: SignInUseCase.Input): SignInUseCase.Output {
        return withContext(Dispatchers.IO){
            val  result = authenticationRepository.signIn(input.email, input.password)
            if(result){
                SignInUseCase.Output.Success
            }
            else{
                SignInUseCase.Output.Failure
            }
        }
    }
}