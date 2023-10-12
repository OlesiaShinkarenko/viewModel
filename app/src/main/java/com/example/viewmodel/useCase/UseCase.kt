package com.example.viewmodel.useCase

interface UseCase<InputT, OutputT> {
    suspend fun execute(input: InputT): OutputT
}