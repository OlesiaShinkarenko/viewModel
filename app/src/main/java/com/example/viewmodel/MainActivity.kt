package com.example.viewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.viewmodel.model.Client
import com.example.viewmodel.navigation.NavGraph
import com.example.viewmodel.ui.theme.ViewModelTheme
import com.example.viewmodel.viewModel.ClientListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            ViewModelTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavGraph(navController = navController)
                }
            }
        }
    }
}

@Preview
Greeting()


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(viewModel: ClientListViewModel = hiltViewModel(), modifier: Modifier = Modifier) {
    val clients =viewModel.clientList.collectAsState()
        val openDialog = remember { mutableStateOf(false) }
        val textSurname = remember {
            mutableStateOf("")
        }
        val textName = remember {
            mutableStateOf("")
        }
        val textMiddleName = remember {
            mutableStateOf("")
        }
        val textAddress = remember {
            mutableStateOf("")
        }
        val textPhone = remember {
            mutableStateOf("")
        }
        if(openDialog.value){
            Dialog({
                openDialog.value = false
                textSurname.value = ""
                textName.value = ""
                textMiddleName.value = ""
                textAddress.value = ""
                textPhone.value = ""
            }) {
                Column(modifier = Modifier
                    .background(Color.White)
                    .padding(8.dp)) {
                    Text(text = "Фамилия: ")
                        TextField(
                            value = textSurname.value,
                            onValueChange = { newText -> textSurname.value = newText },
                                    modifier = Modifier.fillMaxWidth()
                        )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Имя: ")
                    TextField(value = textName.value, onValueChange ={ newText -> textName.value = newText }, modifier = Modifier.fillMaxWidth() )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Отчество: ")
                    TextField(value = textMiddleName.value, onValueChange ={ newText -> textMiddleName.value = newText }, modifier = Modifier.fillMaxWidth() )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Адрес: ")
                    TextField(value = textAddress.value, onValueChange ={ newText -> textAddress.value = newText }, modifier = Modifier.fillMaxWidth() )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Телефон: ")
                    TextField(value = textPhone.value, onValueChange ={ newText -> textPhone.value = newText },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(onClick = {
                        viewModel.addClient(
                            Client(
                                name = textSurname.value,
                                surname = textSurname.value,
                                middleName=  textMiddleName.value,
                                address= textAddress.value,
                                telephone= textPhone.value
                            )
                        )
                        openDialog.value = false
                        textSurname.value = ""
                        textName.value = ""
                        textMiddleName.value = ""
                        textAddress.value = ""
                        textPhone.value = ""
                    }, modifier = Modifier.fillMaxWidth()) {
                        Text(text = "Добавить")
                    }
                }
            }
        }

        LazyColumn (modifier = Modifier.padding(8.dp)){
            items(clients.value!!){
                item ->
                Column {
                    LazyColumnItem("Фамилия: ",item.surname )
                    LazyColumnItem( "Имя: ",item.name )
                    LazyColumnItem( "Отчество: ",item.middleName )
                    LazyColumnItem( "Адрес: ",item.address )
                    LazyColumnItem( "Телефон: ",item.telephone )
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
            item {
                    Button(onClick = {
                        openDialog.value = true
                    }, modifier = Modifier.fillMaxWidth()) {
                        Text("Добавить")
                    }

            }
        }


}
@Composable
fun LazyColumnItem(title:String, value:String){
    Row {
        Text(text = title)
        Spacer(modifier = Modifier.weight(.1f))
        Text(text = value)
    }
    Spacer(modifier = Modifier.height(4.dp))
}
