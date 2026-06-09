package com.example.pruebasunitarias_avanzadas.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pruebasunitarias_avanzadas.ui.components.ContadorPendientes
import com.example.pruebasunitarias_avanzadas.ui.components.ItemTarea
import com.example.pruebasunitarias_avanzadas.viewmodel.TareaViewModel

@Composable
fun PantallaTareas(
    viewModel: TareaViewModel = viewModel()
) {

    var titulo by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF4E8))
            .padding(16.dp)
            .statusBarsPadding()
    ) {

        Text(
            text = "☀️ Tareas del día",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Tú puedes con todo 💖",
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = "Nueva tarea ❤️",
                    color = Color(0xFFFF6F91)
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = titulo,
                    onValueChange = { titulo = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = {
                        Text("Título de la tarea")
                    }
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = descripcion,
                    onValueChange = { descripcion = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = {
                        Text("Descripción (opcional)")
                    }
                )

                Spacer(modifier = Modifier.height(12.dp))

                Button(
                    onClick = {

                        viewModel.agregarTarea(
                            titulo,
                            descripcion
                        )

                        titulo = ""
                        descripcion = ""
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFF7D774)
                    )
                ) {

                    Icon(
                        Icons.Default.Add,
                        contentDescription = null
                    )

                    Spacer(
                        modifier = Modifier.width(8.dp)
                    )

                    Text("Agregar tarea")
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        ContadorPendientes(
            cantidad = viewModel.cantidadPendientes
        )

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(18.dp)
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = "Porcentaje completado"
                )

                Spacer(
                    modifier = Modifier.height(4.dp)
                )

                Text(
                    text = "${viewModel.porcentajeCompletadas}%"
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Button(
                onClick = {
                    viewModel.mostrarTodas()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFF7D774)
                )
            ) {
                Text("Todas")
            }

            Button(
                onClick = {
                    viewModel.mostrarPendientes()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFF7D774)
                )
            ) {
                Text("Pendientes")
            }

            Button(
                onClick = {
                    viewModel.mostrarCompletadas()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFF7D774)
                )
            ) {
                Text("Completadas")
            }
        }

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Button(
            onClick = {
                viewModel.ordenarAlfabeticamente()
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF7D774)
            )
        ) {
            Text("Ordenar A-Z")
        }

        LazyColumn {

            items(viewModel.tareas) { tarea ->

                ItemTarea(
                    tarea = tarea,
                    onCompletar = {
                        viewModel.marcarComoCompletada(
                            tarea.id
                        )
                    },
                    onEliminar = {
                        viewModel.eliminarTarea(
                            tarea.id
                        )
                    }
                )
            }
        }
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun PantallaTareasPreview() {
    PantallaTareas()
}