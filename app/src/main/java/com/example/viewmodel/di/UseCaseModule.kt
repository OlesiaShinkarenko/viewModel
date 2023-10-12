package com.example.viewmodel.di

import com.example.viewmodel.useCase.GetClientUseCase
import com.example.viewmodel.useCase.impl.GetClientUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class UseCaseModule {
    @Binds
    abstract fun bindGetClientsUseCase(impl: GetClientUseCaseImpl):GetClientUseCase
}