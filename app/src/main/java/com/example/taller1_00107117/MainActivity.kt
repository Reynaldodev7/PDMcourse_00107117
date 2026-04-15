package com.example.taller1_00107117

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.*
import com.example.taller1_00107117.data.quizQuestions
import com.example.taller1_00107117.ui.theme.AndroidPediaByBonillaTheme
import com.example.taller1_00107117.ui.theme.screens.WelcomeScreen
import com.example.taller1_00107117.ui.theme.screens.QuizScreen
import com.example.taller1_00107117.ui.theme.screens.ResultScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidPediaByBonillaTheme {
                AndroidPediaApp()
            }
        }
    }
}

@Composable
fun AndroidPediaApp() {
    var currentScreen by remember { mutableStateOf("WELCOME") }
    var score by remember { mutableIntStateOf(0) }
    var currentIndex by remember { mutableIntStateOf(0) }

    when (currentScreen) {
        "WELCOME" -> WelcomeScreen(onStart = { currentScreen = "QUIZ" })
        "QUIZ" -> QuizScreen(
            currentIndex = currentIndex,
            score = score,
            onAnswerCorrect = { score++ },
            onNextQuestion = {
                if (currentIndex < quizQuestions.size - 1) {
                    currentIndex++
                } else {
                    currentScreen = "RESULTS"
                }
            }
        )
        "RESULTS" -> ResultScreen(
            score = score,
            onRestart = {
                score = 0
                currentIndex = 0
                currentScreen = "WELCOME"
            }
        )
    }
}