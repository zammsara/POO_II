package com.example.practicasunitariascalculadora.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practicasunitariascalculadora.models.Calculadora

@Composable
fun PantallaCalculadora() {

    val calculadora = Calculadora()

    var resultado by remember {
        mutableStateOf("")
    }

    var operacion by remember {
        mutableStateOf("")
    }

    val fondoPantalla = Color(0xFFE8E3D7)
    val colorBoton = Color(0xFFF3F0E6)
    val colorSombra = Color(0xFF2E2E2E)
    val colorPanel = Color(0xFFBDE6D2)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(fondoPantalla),
        contentAlignment = Alignment.Center
    ) {

        // sombra
        Box(
            modifier = Modifier
                .offset(x = 8.dp, y = 8.dp)
                .width(320.dp)
                .height(450.dp)
                .background(
                    colorSombra,
                    RoundedCornerShape(24.dp)
                )
        )

        // tarjeta principal
        Column(
            modifier = Modifier
                .width(320.dp)
                .height(450.dp)
                .background(
                    Color(0xFFF6F2E9),
                    RoundedCornerShape(24.dp)
                )
                .border(
                    2.dp,
                    Color.Black,
                    RoundedCornerShape(24.dp)
                )
        ) {

            // area del resultado
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(24.dp),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = if (resultado.isEmpty()) "--" else resultado,
                    modifier = Modifier.testTag("resultado"),
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text(
                    text = operacion,
                    fontSize = 16.sp,
                    color = Color.DarkGray
                )
            }

            // area de botones
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(2f)
                    .clip(
                        RoundedCornerShape(
                            topStart = 24.dp,
                            topEnd = 24.dp,
                            bottomStart = 24.dp,
                            bottomEnd = 24.dp
                        )
                    )
                    .background(colorPanel)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    BotonOperacion(
                        texto = "Sumar",
                        colorBoton = colorBoton
                    ) {

                        val res =
                            calculadora.sumar(5.0, 3.0)

                        resultado =
                            formatearNumero(res)

                        operacion = "5 + 3"
                    }

                    BotonOperacion(
                        texto = "Restar",
                        colorBoton = colorBoton
                    ) {

                        val res =
                            calculadora.restar(5.0, 3.0)

                        resultado =
                            formatearNumero(res)

                        operacion = "5 - 3"
                    }
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    BotonOperacion(
                        texto = "Multiplicar",
                        colorBoton = colorBoton
                    ) {

                        val res =
                            calculadora.multiplicar(5.0, 3.0)

                        resultado =
                            formatearNumero(res)

                        operacion = "5 x 3"
                    }

                    BotonOperacion(
                        texto = "Dividir",
                        colorBoton = colorBoton
                    ) {

                        val res =
                            calculadora.dividir(6.0, 3.0)

                        resultado =
                            formatearNumero(res)

                        operacion = "6 / 3"
                    }
                }
            }
        }
    }
}

// elimina los .0 cuando el numero es entero
private fun formatearNumero(
    numero: Double
): String {

    return if (numero % 1.0 == 0.0) {
        numero.toInt().toString()
    } else {
        numero.toString()
    }
}

@Composable
private fun RowScope.BotonOperacion(
    texto: String,
    colorBoton: Color,
    onClick: () -> Unit
) {

    Button(
        onClick = onClick,
        modifier = Modifier
            .weight(1f)
            .height(70.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorBoton,
            contentColor = Color.Black
        )
    ) {

        Text(
            text = texto,
            fontWeight = FontWeight.Bold
        )
    }
}