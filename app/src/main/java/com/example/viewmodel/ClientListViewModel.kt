package com.example.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.viewmodel.useCase.Client
import com.example.viewmodel.useCase.GetClientUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientListViewModel @Inject constructor(
    private val getClientUseCase: GetClientUseCase
) : ViewModel() {
    private val _clientList = MutableStateFlow<List<Client>?>(listOf())
    val clientList : Flow<List<Client>?> = _clientList

    init {
        getClients()
    }

     fun getClients() {
        viewModelScope.launch {
            when (val clients = getClientUseCase.execute(input = Unit)){
                is GetClientUseCase.Output.Success -> {
                    _clientList.emit(clients.data)
                }
                is GetClientUseCase.Output.Failure -> {

                }
            }
        }
    }

}