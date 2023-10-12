package com.example.viewmodel.useCase.impl

import com.example.viewmodel.ClientRepository
import com.example.viewmodel.useCase.Client
import com.example.viewmodel.useCase.GetClientUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetClientUseCaseImpl @Inject constructor(
    private val clientRepository: ClientRepository,
) : GetClientUseCase {
    override suspend fun execute(input: Unit): GetClientUseCase.Output =
        withContext(Dispatchers.IO) {
            val result = clientRepository.getClients()
            return@withContext result?.let { it ->
                GetClientUseCase.Output.Success(data = it.map {
                    Client(
                        id = it.id,
                        name = it.name,
                        middleName = it.middleName,
                        address = it.address,
                        telephone = it.telephone,
                        surname = it.surname
                    )
                })
            } ?: GetClientUseCase.Output.Failure
        }
}