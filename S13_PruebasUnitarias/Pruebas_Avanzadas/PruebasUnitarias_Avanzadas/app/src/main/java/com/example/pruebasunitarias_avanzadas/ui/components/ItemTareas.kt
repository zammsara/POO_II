package com.example.pruebasunitarias_avanzadas.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.outlined.RadioButtonUnchecked
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.pruebasunitarias_avanzadas.data.model.Tarea

@Composable
fun ItemTarea(
    tarea: Tarea,
    onCompletar: () -> Unit,
    onEliminar: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        shape = RoundedCornerShape(16.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(
                onClick = onCompletar
            ) {
                Icon(
                    imageVector = Icons.Outlined.RadioButtonUnchecked,
                    contentDescription = "Completar"
                )
            }

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = tarea.titulo,
                    style = MaterialTheme.typography.titleMedium,
                    textDecoration =
                        if (tarea.completada)
                            TextDecoration.LineThrough
                        else
                            TextDecoration.None
                )

                if (tarea.descripcion.isNotBlank()) {
                    Text(
                        text = tarea.descripcion,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray
                    )
                }
            }

            IconButton(
                onClick = onEliminar
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Eliminar",
                    tint = Color(0xFFFFB74D)
                )
            }
        }
    }
}