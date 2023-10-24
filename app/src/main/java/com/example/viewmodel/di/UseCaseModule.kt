package com.example.viewmodel.di

import com.example.viewmodel.useCase.AddClientUseCase
import com.example.viewmodel.useCase.GetClientUseCase
import com.example.viewmodel.useCase.SignInUseCase
import com.example.viewmodel.useCase.SignUpUseCase
import com.example.viewmodel.useCase.impl.AddClientUseCaseImpl
import com.example.viewmodel.useCase.impl.GetClientUseCaseImpl
import com.example.viewmodel.useCase.impl.SignInUseCaseImpl
import com.example.viewmodel.useCase.impl.SignUpUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class UseCaseModule {
    @Binds
    abstract fun bindGetClientsUseCase(impl: GetClientUseCaseImpl):GetClientUseCase
    @Binds
    abstract fun bindAddClientsUseCase(impl: AddClientUseCaseImpl):AddClientUseCase
    @Binds
    abstract fun bindSignInUseCase(impl: SignInUseCaseImpl): SignInUseCase
    @Binds
    abstract fun bindSignUpUseCase(impl: SignUpUseCaseImpl): SignUpUseCase
}