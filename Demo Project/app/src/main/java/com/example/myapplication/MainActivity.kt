package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                CalculatorApp()
            }
        }
    }
}

@Composable
fun CalculatorApp() {
    var num1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        // First Number Input
        TextField(
            value = num1,
            onValueChange = { num1 = it },
            placeholder = { Text("Enter first number") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Second Number Input
        TextField(
            value = num2,
            onValueChange = { num2 = it },
            placeholder = { Text("Enter second number") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Buttons Row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {
                result = try { (num1.toDouble() + num2.toDouble()).toString() } catch (e: Exception) { "Error" }
            }) { Text("+") }

            Button(onClick = {
                result = try { (num1.toDouble() - num2.toDouble()).toString() } catch (e: Exception) { "Error" }
            }) { Text("-") }

            Button(onClick = {
                result = try { (num1.toDouble() * num2.toDouble()).toString() } catch (e: Exception) { "Error" }
            }) { Text("×") }

            Button(onClick = {
                result = try { (num1.toDouble() / num2.toDouble()).toString() } catch (e: Exception) { "Error" }
            }) { Text("÷") }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Display Result
        Text(text = "Result: $result", style = MaterialTheme.typography.titleMedium)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCalculator() {
    MaterialTheme {
        CalculatorApp()
    }
}
