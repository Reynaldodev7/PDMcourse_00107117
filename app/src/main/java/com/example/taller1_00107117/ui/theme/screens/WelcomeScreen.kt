package com.example.taller1_00107117.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WelcomeScreen(onStart: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "AndroidPedia",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "¿Cuánto sabes de Android?",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Nombre: Reynaldo Alcides Bonilla Ventura")
        Text(text = "Carnet: 00107117")

        Spacer(modifier = Modifier.height(40.dp))

        Button(onClick = onStart) {
            Text(text = "Comenzar Quiz")
        }
    }
}