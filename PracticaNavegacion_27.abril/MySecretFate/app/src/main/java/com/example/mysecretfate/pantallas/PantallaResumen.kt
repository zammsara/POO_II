package com.example.mysecretfate.pantallas

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mysecretfate.R
import com.example.mysecretfate.recursos.FuentePixel
import com.example.mysecretfate.ui.theme.BorgonaBoton
import com.example.mysecretfate.ui.theme.CiruelaBoton
import com.example.mysecretfate.ui.theme.MarronTinta
import com.example.mysecretfate.ui.theme.MySecretFateTheme
import com.example.mysecretfate.ui.theme.OroBorde
import com.example.mysecretfate.ui.theme.Pergamino
import com.example.mysecretfate.ui.theme.TextoPergamino

@Composable
fun PantallaResumen(
    navController: NavController,
    destino: String,

) {
    val fondoFinal: Int
    val spriteFinal: Int
    val tituloDestino: String
    val descripcionDestino : String

    if(destino == "guardiana") {
            fondoFinal = R.drawable.fondo_final_guardiana
            spriteFinal = R.drawable.sprite_guardiana
            tituloDestino = "GUARDIANA DE SECRETOS"
            descripcionDestino =  "Has elegido conocer lo desconocido. Ahora custodiarás secretos olvidados y cartas jamás reveladas."

    }
    else
    {
          fondoFinal = R.drawable.fondo_final_prudente
          spriteFinal = R.drawable.sprite_prudente
          tituloDestino = "GUARDIANA DEL SILENCIO"
          descripcionDestino =  "Elegiste la cautela sobre la tentación. Algunos misterios sobreviven precisamente \nporque no fueron abiertos."
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Image(
            painter = painterResource(fondoFinal),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {





            Card(
                shape = RoundedCornerShape(18.dp),
                border = BorderStroke(2.dp, OroBorde),
                colors = CardDefaults.cardColors(containerColor = Pergamino)
            ) {


                Column(
                    modifier = Modifier.padding(22.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(
                            id = spriteFinal
                        ),
                        contentDescription = null,
                        modifier = Modifier.size(180.dp)
                    )


                    Spacer(modifier = Modifier.height(22.dp))

                    Text(
                        text = tituloDestino,
                        color = MarronTinta,
                        fontFamily = FuentePixel,
                        fontSize = 18.sp,
                        lineHeight = 20.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth()
                    )


                    Spacer(
                        modifier = Modifier.height(20.dp)
                    )


                    Text(
                        text = descripcionDestino,
                        color = MarronTinta,
                        fontFamily = FuentePixel,
                        fontSize = 12.sp,
                        lineHeight = 20.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth()
                    )

                }

            }


            Spacer(
                modifier = Modifier.height(28.dp)
            )


            Button(
                onClick = {

                    navController.navigate("inicio") {

                        popUpTo("inicio") {
                            inclusive = true
                        }

                    }

                },
                colors = ButtonDefaults.buttonColors(CiruelaBoton),
                border = BorderStroke(2.dp, OroBorde),
                shape = RoundedCornerShape(14.dp),
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(48.dp)
            ) {

                Row(verticalAlignment = Alignment.CenterVertically)
                {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_replay),
                        contentDescription = null,
                        tint = Color.Unspecified,
                        modifier = Modifier.size(30.dp) //tamaño del icono
                    )
                    Spacer(modifier = Modifier.size(12.dp))
                    Text(
                        text = "Jugar otra vez",
                        fontFamily = FuentePixel,
                        fontSize = 12.sp,
                        color = TextoPergamino
                    )
                }

            }

        }

    }

}

@Preview(
    name = "Final Guardiana",
    showBackground = true
)
@Composable
fun PantallaResumenGuardianaPreview() {

    MySecretFateTheme {

        PantallaResumen(
            navController = rememberNavController(),
            destino = "guardiana"
        )

    }

}

@Preview(
    name = "Final Prudente",
    showBackground = true
)
@Composable
fun PantallaResumenPrudentePreview() {

    MySecretFateTheme {

        PantallaResumen(
            navController = rememberNavController(),
            destino = "prudente"
        )

    }

}