package com.example.viewmodel.di

import com.example.viewmodel.ClientRepository
import com.example.viewmodel.ClientRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindClientRepository(impl: ClientRepositoryImpl): ClientRepository
}