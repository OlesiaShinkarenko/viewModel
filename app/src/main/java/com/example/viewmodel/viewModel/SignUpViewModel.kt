package com.example.viewmodel.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.viewmodel.useCase.SignUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase,
): ViewModel(){
    private val _email = mutableStateOf<String>("")
    val email : State<String> = _email

    private val  _password = mutableStateOf("")
    val password: State<String> = _password

}