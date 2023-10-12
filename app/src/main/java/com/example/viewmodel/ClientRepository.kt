package com.example.viewmodel

import com.example.viewmodel.useCase.Client

interface ClientRepository {
    suspend fun getClients():List<Client>
}