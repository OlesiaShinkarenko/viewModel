package com.example.viewmodel

import com.example.viewmodel.useCase.Client
import io.github.jan.supabase.postgrest.Postgrest
import javax.inject.Inject

class ClientRepositoryImpl @Inject constructor(
    private val postgrest: Postgrest
) :ClientRepository {
    override suspend fun getClients(): List<Client> {
        return postgrest["Clients"]
            .select().decodeList()
    }
}