package com.example.taller1_00107117.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.taller1_00107117.data.quizQuestions

@Composable
fun QuizScreen(
    currentIndex: Int,
    score: Int,
    onAnswerCorrect: () -> Unit,
    onNextQuestion: () -> Unit
) {
    val question = quizQuestions[currentIndex]
    var selectedOption by remember { mutableStateOf<String?>(null) }
    var answered by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Pregunta ${currentIndex + 1} de 3", style = MaterialTheme.typography.titleLarge)
        Text(text = "Puntaje: $score/3", style = MaterialTheme.typography.bodyMedium)

        Card(
            modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Text(text = question.question, modifier = Modifier.padding(16.dp))
        }

        question.options.forEach { option ->
            val color = when {
                !answered -> MaterialTheme.colorScheme.primary
                option == question.correctAnswer -> Color.Green
                option == selectedOption && option != question.correctAnswer -> Color.Red
                else -> Color.LightGray
            }

            Button(
                onClick = {
                    if (!answered) {
                        selectedOption = option
                        answered = true
                        if (option == question.correctAnswer) onAnswerCorrect()
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = color,
                    disabledContainerColor = color
                ),
                enabled = !answered,
                modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
            ) {
                Text(text = option, color = if (!answered) Color.White else Color.Black)
            }
        }

        if (answered) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Dato curioso: ${question.funFact}")

            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = {
                answered = false
                selectedOption = null
                onNextQuestion()
            }) {
                Text(text = if (currentIndex < 2) "Siguiente" else "Ver Resultado")
            }
        }
    }
}