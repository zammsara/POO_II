package com.example.materialtheme03_prueba01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.materialtheme03_prueba01.ui.theme.MaterialTheme03_Prueba01Theme
import kotlinx.coroutines.launch

// Estados posibles de la tarea
enum class TaskStatus {
    TODO,
    IN_PROGRESS,
    DONE
}

// Modelo de tarea
data class Task(
    val id: Int,
    val description: String,
    val status: TaskStatus = TaskStatus.TODO
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MaterialTheme03_Prueba01Theme {
                Surface {
                    TaskApp()
                }
            }
        }
    }
}

// ======================= UI PRINCIPAL =======================
// Aquí está TODA la lógica, pero separada del Main (mejor práctica)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskApp() {

    var text by remember { mutableStateOf("") }
    var tasks by remember { mutableStateOf(listOf<Task>()) }
    var filter by remember { mutableStateOf<TaskStatus?>(null) }
    var counter by remember { mutableStateOf(0) }

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            TopAppBar(title = { Text("Gestor de Tareas") })
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {

            // Campo de entrada
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Descripción de la tarea") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Botón agregar
            Button(
                onClick = {
                    if (text.isBlank()) {
                        scope.launch {
                            snackbarHostState.showSnackbar("La tarea no puede estar vacía")
                        }
                    } else {
                        tasks = tasks + Task(counter++, text)
                        text = ""
                        scope.launch {
                            snackbarHostState.showSnackbar("Tarea agregada")
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Agregar tarea")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Filtros
            Text("Filtrar por estado:")

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                FilterChip(
                    selected = filter == null,
                    onClick = { filter = null },
                    label = { Text("Todas") }
                )
                FilterChip(
                    selected = filter == TaskStatus.TODO,
                    onClick = { filter = TaskStatus.TODO },
                    label = { Text("Sin empezar") }
                )
                FilterChip(
                    selected = filter == TaskStatus.IN_PROGRESS,
                    onClick = { filter = TaskStatus.IN_PROGRESS },
                    label = { Text("En proceso") }
                )
                FilterChip(
                    selected = filter == TaskStatus.DONE,
                    onClick = { filter = TaskStatus.DONE },
                    label = { Text("Finalizado") }
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            val filteredTasks = tasks.filter {
                filter == null || it.status == filter
            }

            // Mensaje dinámico
            Text("Total: ${filteredTasks.size} tareas")

            Spacer(modifier = Modifier.height(8.dp))

            // Lista
            LazyColumn {
                items(filteredTasks) { task ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp),
                        elevation = CardDefaults.cardElevation(6.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {

                            Text(
                                text = task.description,
                                style = MaterialTheme.typography.titleMedium
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Text("Estado: ${task.status}")

                            Spacer(modifier = Modifier.height(8.dp))

                            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {

                                AssistChip(
                                    onClick = {
                                        tasks = tasks.map {
                                            if (it.id == task.id) it.copy(status = TaskStatus.TODO) else it
                                        }
                                    },
                                    label = { Text("Sin empezar") }
                                )

                                AssistChip(
                                    onClick = {
                                        tasks = tasks.map {
                                            if (it.id == task.id) it.copy(status = TaskStatus.IN_PROGRESS) else it
                                        }
                                    },
                                    label = { Text("En proceso") }
                                )

                                AssistChip(
                                    onClick = {
                                        tasks = tasks.map {
                                            if (it.id == task.id) it.copy(status = TaskStatus.DONE) else it
                                        }
                                    },
                                    label = { Text("Finalizado") }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TaskAppPreview() {
    MaterialTheme03_Prueba01Theme {
        TaskApp()
    }
}