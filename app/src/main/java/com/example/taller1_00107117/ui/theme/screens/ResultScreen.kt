package com.example.taller1_00107117.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ResultScreen(score: Int, onRestart: () -> Unit) {
    val message = when (score) {
        3 -> "¡Excelente! Eres un experto en Android."
        2 -> "¡Muy bien! Conoces bastante sobre el sistema."
        else -> "Puedes mejorar, ¡inténtalo de nuevo!"
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Obtuviste $score de 3", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = message, style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = onRestart) {
            Text(text = "Reiniciar Quiz")
        }
    }
}