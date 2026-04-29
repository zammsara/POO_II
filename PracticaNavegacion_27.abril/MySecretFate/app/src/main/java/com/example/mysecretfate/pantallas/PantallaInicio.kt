package com.example.mysecretfate.pantallas

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
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
import androidx.compose.material3.Text
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
import com.example.mysecretfate.R
import com.example.mysecretfate.recursos.FuentePixel
import com.example.mysecretfate.ui.theme.BorgonaBoton
import com.example.mysecretfate.ui.theme.CiruelaBoton
import com.example.mysecretfate.ui.theme.MarronTinta
import com.example.mysecretfate.ui.theme.OroBorde
import com.example.mysecretfate.ui.theme.Pergamino
import com.example.mysecretfate.ui.theme.TextoPergamino

//COLORES PERSONALIZADOS

@Composable
fun PantallaInicio(
    navController: NavController
) {


    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        //FONDO DE PANTALLA
        Image(
            painter = painterResource(id = R.drawable.fondo_inicio),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        //TÍTULO
        Card(
            shape = RoundedCornerShape(18.dp),
            border = BorderStroke(2.dp, OroBorde),
            colors = CardDefaults.cardColors(Pergamino),
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(start = 20.dp, end = 20.dp, top = 8.dp)
                .statusBarsPadding(),

            ) {
            Text(
                text = "ELIGE TU DESTINO",
                fontFamily = FuentePixel,
                fontSize = 28.sp,
                lineHeight = 40.sp,
                color = MarronTinta,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(26.dp)
                    .fillMaxWidth()
            )
        }

        //CONTENIDO DE LA PANTALLA
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Card(
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(2.dp, OroBorde),
                colors = CardDefaults.cardColors(Pergamino)
            ) {
                Text(
                    text = "En el salón de una antigua mansión encuentras una carta sellada con cera. \n¿Te atreves a abrirla?",
                    color = MarronTinta,
                    textAlign = TextAlign.Center,
                    fontFamily = FuentePixel,
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    modifier = Modifier.padding(22.dp)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    navController.navigate("detalle/puerta")
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
                    Icon(
                        painter = painterResource(id = R.drawable.icon_sobre),
                        contentDescription = null,
                        tint = Color.Unspecified,
                        modifier = Modifier.size(30.dp) //tamaño del icono
                    )

                    Spacer(modifier = Modifier.size(12.dp))

                    Text(
                        text = "Abrir la puerta",
                        fontFamily = FuentePixel,
                        fontSize = 12.sp,
                        color = TextoPergamino
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Button(
                onClick = {
                    navController.navigate("detalle/alejarse")
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
                        painter = painterResource(id = R.drawable.icon_corazon),
                        contentDescription = null,
                        tint = Color.Unspecified,
                        modifier = Modifier.size(28.dp) //tamaño del icono
                    )

                    Spacer(modifier = Modifier.size(12.dp))

                    Text(
                        text = "Alejarse",
                        fontFamily = FuentePixel,
                        fontSize = 12.sp,
                        color = TextoPergamino
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaInicioPreview() {
    PantallaInicio(navController = NavController(LocalContext.current))
}