package com.example.viewmodel.di

import com.example.viewmodel.data.AuthenticationRepository
import com.example.viewmodel.data.ClientRepository
import com.example.viewmodel.data.impl.AuthenticationRepositoryImpl
import com.example.viewmodel.data.impl.ClientRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindClientRepository(impl: ClientRepositoryImpl): ClientRepository

    @Binds
    abstract fun bindAutheticationRepository(impl: AuthenticationRepositoryImpl): AuthenticationRepository
}