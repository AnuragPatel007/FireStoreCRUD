package com.example.firestorecrud.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.firestorecrud.nav.Screens

@Composable
fun MainScreen(
    navController: NavController,
    //sharedViewModel: SharedViewModel
){
    Column(
        modifier = Modifier
            .padding(
                start = 50.dp,
                end = 50.dp
            )
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Get User Data Button
        Button(modifier = Modifier.fillMaxWidth(),
            onClick = {
                navController.navigate(Screens.GetDataScreen.route)
            }) {
            Text(text = "Get User Data")
        }

        //Add User Data Button
        OutlinedButton(modifier = Modifier.fillMaxWidth(),
            onClick = {
                navController.navigate(Screens.AddDataScreen.route)
            }) {
            Text(text = "Add User Data")
        }
    }
}