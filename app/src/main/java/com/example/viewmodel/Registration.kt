package com.example.viewmodel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.viewmodel.navigation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Registration(navController:NavHostController){
    Column(modifier= Modifier
        .fillMaxSize()
        .padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        val textLogin = remember {
            mutableStateOf("")
        }
        val textPassword = remember {
            mutableStateOf("")
        }
            Text(text = "Email")
            Spacer(modifier = Modifier.height(4.dp))
            TextField(value = textLogin.value, onValueChange ={
                    newText -> textLogin.value = newText
            } )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Пароль")
            TextField(value = textPassword.value, onValueChange ={
                    newText -> textPassword.value = newText
            } )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            navController.navigate(Screens.Home.route)
        }, modifier = Modifier.fillMaxWidth() ) {
            Text(text = "Зарегистрироваться")
        }
    }
}