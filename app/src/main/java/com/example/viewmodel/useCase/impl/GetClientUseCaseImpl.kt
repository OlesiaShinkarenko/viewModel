package com.example.viewmodel.useCase.impl

import com.example.viewmodel.data.ClientRepository
import com.example.viewmodel.model.Client
import com.example.viewmodel.useCase.GetClientUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetClientUseCaseImpl @Inject constructor(
    private val clientRepository: ClientRepository,
) : GetClientUseCase {
    override suspend fun execute(input: Unit): GetClientUseCase.Output = flow {
        val result = clientRepository.getClients()
        emit (result?.let { it ->
            com.example.viewmodel.useCase.GetClientUseCase.Output.Success(data = it.map {
                com.example.viewmodel.model.Client(
                    id = it.id,
                    name = it.name,
                    middleName = it.middleName,
                    address = it.address,
                    telephone = it.telephone,
                    surname = it.surname
                )
            })
        })
    }
}