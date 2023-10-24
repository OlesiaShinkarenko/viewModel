package com.example.viewmodel.data.impl

import com.example.viewmodel.data.ClientRepository
import com.example.viewmodel.model.Client
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.query.Returning
import javax.inject.Inject

class ClientRepositoryImpl @Inject constructor(
    private val postgrest: Postgrest
) : ClientRepository {
    override suspend fun getClients()= flow{
        emit(postgrest["Clients"]
            .select().decodeList())
    }

    override suspend fun addClients(client: Client) {
        postgrest["Clients"].insert(client, returning = Returning.MINIMAL)
    }

}