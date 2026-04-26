package com.example.darcyscounsel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.darcyscounsel.ui.theme.DarcysCounselTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            DarcysCounselTheme {
                PrideScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrideScreen() {

    //+++++++++++++++VARIABLES DE ESTADO+++++++++++++++++++
    var nombre by remember { mutableStateOf("") }
    var emocion by remember { mutableStateOf("") }
    var opciones by remember { mutableStateOf(false) }

    var fraseFinal by remember {
        mutableStateOf("Aquí aparecerá su consejo...")
    }

    // Retrato de mr.darcy que cambia según la emoción seleccionada
    var imageRes by remember {
        mutableStateOf(R.drawable.darcy_default)
    }

    ///+++++++++++++++++++++++++FRASES+++++++++++++++++++++++++++
    val frasesTriste = listOf(
        "%s, incluso en la tristeza, su valor es admirable.",
        "No todo está perdido, %s.",
        "%s, permítame ofrecerle consuelo."
    )

    val frasesFeliz = listOf(
        "%s, su alegría es verdaderamente encantadora.",
        "Nada me complace más que verla feliz, %s.",
        "%s, su sonrisa ilumina todo."
    )

    val fraseEspecial =
        "You have bewitched me, body and soul, and I love, I love, I love you."

    //+++++EMOCIONES+++++++++++
    val emociones = listOf(
        "Triste",
        "Feliz",
        "Especial"
    )


    //++++++++++++++++++++UI++++++++++++++++++++++++++++++++++++
    //+++++CAPA 1 — FONDO DE PANTALLA+++++++++++++++++++++++++++++++
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )


        //+++++CAPA 2 — CONTENIDO SOBRE EL FONDO++++++++++++++++++
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 6.dp, 12.dp)
                .systemBarsPadding(),

            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            //++++PANEL PRINCIPAL+++++++++++++
            Box(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .height(650.dp),
                contentAlignment = Alignment.Center
            ) {

                //Imagen del gran pergamino principal
                Image(
                    painter = painterResource(R.drawable.panel_main),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )


                //+++++++++Contenido encima del panel++++++++++++
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            top = 70.dp,
                            start = 49.dp,
                            end = 49.dp,
                            bottom = 40.dp
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    // Retrato de Darcy
                    Image(
                        painter = painterResource(imageRes),
                        contentDescription = null,
                        modifier = Modifier
                            .height(170.dp)
                            .fillMaxWidth(0.62f),
                        contentScale = ContentScale.Fit
                    )

                    Spacer(
                        modifier = Modifier.height(24.dp)
                    )


                    //Campo del nombre
                    OutlinedTextField(
                        value = nombre,
                        onValueChange = {
                            nombre = it
                        },
                        label = {
                            Text("¿Podría saber su nombre?")
                        },
                        modifier = Modifier.fillMaxWidth(),

                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = Color(0xFFF8EFE4),
                            unfocusedContainerColor = Color(0xFFF8EFE4),
                            focusedBorderColor = Color(0xFFD6B6A2),
                            unfocusedBorderColor = Color(0xFFD6B6A2),
                            focusedLabelColor = Color(0xFF6E4E42)
                        )
                    )

                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )


                    // Menú desplegable para seleccionar la emoción
                    ExposedDropdownMenuBox(
                        expanded = opciones,
                        onExpandedChange = {
                            opciones = !opciones
                        }
                    ) {

                        OutlinedTextField(
                            value = emocion,
                            onValueChange = {},
                            readOnly = true,
                            label = {
                                Text("¿Cómo se encuentra usted hoy?")
                            },
                            trailingIcon = {
                                ExposedDropdownMenuDefaults.TrailingIcon(
                                    expanded = opciones
                                )
                            },
                            modifier = Modifier
                                .menuAnchor(type = ExposedDropdownMenuAnchorType.PrimaryNotEditable) //Define este TextField como ancla del dropdown y evita edición manual
                                .fillMaxWidth(),

                            colors = OutlinedTextFieldDefaults.colors(
                                focusedContainerColor = Color(0xFFF8EFE4),
                                unfocusedContainerColor = Color(0xFFF8EFE4),
                                focusedBorderColor = Color(0xFFD6B6A2),
                                unfocusedBorderColor = Color(0xFFD6B6A2),
                                focusedLabelColor = Color(0xFF6E4E42)
                            )
                        )

                        ExposedDropdownMenu(
                            expanded = opciones,
                            onDismissRequest = {
                                opciones = false
                            }
                        ) {
                            emociones.forEach {
                                DropdownMenuItem(
                                    text = {
                                        Text(it)
                                    },
                                    onClick = {
                                        emocion = it
                                        opciones = false
                                    }
                                )
                            }
                        }
                    }

                    Spacer(
                        modifier = Modifier.height(26.dp)
                    )


                    //++++Botón para obtener el consejo+++++++++++++++
                    Button(
                        onClick = {

                            // Validación
                            if (
                                nombre.isBlank() || emocion.isBlank()
                            ) {
                                fraseFinal =
                                    "Le ruego completar todos los campos."
                                return@Button
                            }


                            // Cambio de retrato + consejo
                            val quote = when (emocion) {

                                "Triste" -> {
                                    imageRes = R.drawable.darcy_triste
                                    frasesTriste.random().format(nombre)
                                }

                                "Feliz" -> {
                                    imageRes = R.drawable.darcy_feliz
                                    frasesFeliz.random().format(nombre)
                                }

                                else -> {
                                    imageRes = R.drawable.darcy_especial
                                    fraseEspecial
                                }
                            }

                            fraseFinal = quote
                        },

                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent
                        ),

                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .height(180.dp)
                    ) {

                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(
                                    R.drawable.boton
                                ),
                                contentDescription = null,
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.FillBounds
                            )

                            Text(
                                text = "Obtener consejo",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color(0xFF5A3E36)
                            )
                        }
                    }
                }
            }


            Spacer(
                modifier = Modifier.height(12.dp)
            )

            // ++++++++++++++++++++CARD CONSEJO++++++++++++++++++
            Card(
                modifier = Modifier
                    .fillMaxWidth(0.89f) //ocupa el 89% del ancho de pantalla
                    .height(200.dp),
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFF5E6D3).copy(alpha = 0.9f)
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),
                border = BorderStroke(
                    2.dp,
                    Color(0xFFD6B6A2)
                )
            ) {

                // Contenedor interno para el texto
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),   //espaciado interno
                    contentAlignment = Alignment.Center //texto centrado
                ) {

                    // Texto del consejo
                    Text(
                        text = fraseFinal,
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        color = Color(0xFF5A3E36)
                    )
                }
            }
            }
        }
    }



@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    DarcysCounselTheme {
        PrideScreen()
    }
}
