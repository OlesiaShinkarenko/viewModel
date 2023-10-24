package com.example.viewmodel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.viewmodel.navigation.Screens

@Composable
fun MainScreen(navHostController: NavHostController){
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Button(onClick = { navHostController.navigate(Screens.Registration.route) }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Зарегистрироваться")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { navHostController.navigate(Screens.Authorization.route)},modifier = Modifier.fillMaxWidth()) {
            Text(text = "Войти")
        }
    }
}