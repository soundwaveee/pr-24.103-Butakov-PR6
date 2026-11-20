package com.example.composepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composepractice.ui.theme.ComposePracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    // Счетчик кликов (Урок 6)
    var clickCount by remember { mutableStateOf(0) }

    var isChecked by remember { mutableStateOf(false) }

    var textInput by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(text = "Практическая работа 6", fontSize = 24.sp, color = MaterialTheme.colorScheme.primary)

        Button(onClick = { clickCount++ }) {
            Text(text = "Нажато раз: $clickCount")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = isChecked,
                onCheckedChange = { isChecked = it }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Показать скрытый текст")
        }

        if (isChecked) {
            Text(
                text = "Ура! Текст появился.",
                color = MaterialTheme.colorScheme.secondary,
                fontSize = 18.sp
            )
        }

        OutlinedTextField(
            value = textInput,
            onValueChange = { textInput = it },
            label = { Text("Введите ваше имя") },
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = if (textInput.isNotEmpty()) "Привет, $textInput!" else "Введите текст выше",
            fontSize = 18.sp
        )
    }
}