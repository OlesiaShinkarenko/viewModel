package com.example.viewmodel.useCase

interface SignUpUseCase : UseCase<SignUpUseCase.Input,SignUpUseCase.Output>{
    class Input(val email:String, val password:String)

    sealed class Output(){
        object Success : Output()
        object Failure: Output()
    }
}