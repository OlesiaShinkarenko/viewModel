package com.example.viewmodel.useCase

interface GetClientUseCase : UseCase<Unit, GetClientUseCase.Output> {
    sealed class Output {
        class Success(val data: List<Client>): Output()
        object Failure : Output()
    }
}