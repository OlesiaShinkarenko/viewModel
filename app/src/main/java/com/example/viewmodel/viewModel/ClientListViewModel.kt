package com.example.viewmodel.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.viewmodel.model.Client
import com.example.viewmodel.useCase.AddClientUseCase
import com.example.viewmodel.useCase.GetClientUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientListViewModel @Inject constructor(
    private val getClientUseCase: GetClientUseCase,
    private val addClientUseCase: AddClientUseCase
) : ViewModel() {
    private var _clientList = MutableLiveData<List<Client>?>(mutableListOf())
    val clientList : LiveData<List<Client>?> = _clientList

    init {
        getClients()
    }

    fun getClients() {
        viewModelScope.launch {
            getClientUseCase.execute(Unit).collect{
                getClientUseCase.postValue(it)
            }
        }
    }

    fun addClient(client: Client){
        viewModelScope.launch {
            addClientUseCase.execute(client)
            getClients()
        }
    }
}