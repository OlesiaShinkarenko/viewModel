package com.example.viewmodel.useCase

import com.example.viewmodel.model.Client
import kotlinx.coroutines.flow.Flow

interface GetClientUseCase : UseCase<Unit, GetClientUseCase.Output> {
    sealed class Output {
        class Success(val data: List<Client>): Flow<List<Client?>>
        object Failure : Output()
    }
}