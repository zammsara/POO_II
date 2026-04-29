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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
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
import com.example.mysecretfate.ui.theme.FondoCrema
import com.example.mysecretfate.ui.theme.MarronTinta
import com.example.mysecretfate.ui.theme.MySecretFateTheme
import com.example.mysecretfate.ui.theme.OroBorde
import com.example.mysecretfate.ui.theme.Pergamino
import com.example.mysecretfate.ui.theme.RosaBorde
import com.example.mysecretfate.ui.theme.TextoMarron
import com.example.mysecretfate.ui.theme.TextoPergamino

@Composable
fun PantallaDetalle(
    navController: NavController,
    decision: String
) {

    val mensajeDecision: String
    val destinoFinal: String
    val fondoDetalle : Int


    if (decision == "puerta") {

        mensajeDecision =
            "La carta contiene una confesión inesperada y un secreto olvidado."

        destinoFinal = "guardiana"
        fondoDetalle= R.drawable.fondo_desicion_puerta

    } else {

        mensajeDecision =
            "Te alejas con la duda de lo que pudo haber cambiado tu destino."

        destinoFinal = "prudente"
        fondoDetalle = R.drawable.fondo_desicion_alejarse
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        //FONDO DE PANTALLA
        Image(
            painter = painterResource(id = fondoDetalle),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        //TITULO
        Card(
            shape = RoundedCornerShape(18.dp),
            border = BorderStroke(2.dp, OroBorde),
            colors = CardDefaults.cardColors(Pergamino),
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(start = 20.dp, end = 20.dp, top = 20.dp)
                .statusBarsPadding(),

            ) {
            Text(
                text = "Tu elección ha sido tomada",
                fontFamily = FuentePixel,
                fontSize = 16.sp,
                color = MarronTinta,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
            )
        }


        //CONTENIDO PRINCIPAL
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),

            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Card(
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(
                    2.dp,
                    OroBorde
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Pergamino
                )
            ) {

                Text(
                    text = mensajeDecision,
                    color = MarronTinta,
                    textAlign = TextAlign.Center,
                    fontFamily = FuentePixel,
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    modifier = Modifier.padding(22.dp)
                )
            }


            Spacer(
                modifier = Modifier.height(28.dp)
            )


            Button(
                onClick = {

                    navController.navigate(
                        "resumen/$destinoFinal"
                    )

                },
                colors = ButtonDefaults.buttonColors(BorgonaBoton),
                border = BorderStroke(2.dp, OroBorde),
                shape = RoundedCornerShape(14.dp),
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(48.dp)
            ) {

                Row(verticalAlignment = Alignment.CenterVertically)
                {
                    Text(
                        text = "Continuar",
                        fontFamily = FuentePixel,
                        fontSize = 12.sp,
                        color = TextoPergamino
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.icon_flecha),
                        contentDescription = null,
                        tint = Color.Unspecified,
                        modifier = Modifier.size(30.dp) //tamaño del icono
                    )
                }

            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaDetallePreview() {

    MySecretFateTheme {

        PantallaDetalle(
            navController = rememberNavController(),
            decision = "puerta"
        )

    }

}

@Preview(showBackground = true)
@Composable
fun PantallaDetallePrudentePreview() {

    MySecretFateTheme {

        PantallaDetalle(
            navController = rememberNavController(),
            decision = "alejarse"
        )

    }

}
