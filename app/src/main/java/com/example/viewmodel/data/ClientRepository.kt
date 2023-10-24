package com.example.viewmodel.data

import com.example.viewmodel.model.Client

interface ClientRepository {
    suspend fun getClients():Flow<List<Client?>>
    suspend fun addClients(client: Client)
}