package com.example.perfildeusuario

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ChatBubbleOutline
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material.icons.rounded.Verified
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.perfildeusuario.ui.theme.PerfilDeUsuarioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PerfilDeUsuarioTheme {
                PantallaPerfilUsuario(perfil = PerfilUsuario(
                    nombre = "Elizabeth Bennet",
                    usuario = "lizzy.bennet",
                    biografia = "Observadora aguda, amante de los paseos largos, los libros y las conversaciones inteligentes. Ingenio, libertad y un poco de terquedad.",
                    publicaciones = 55,
                    seguidores = "10M",
                    siguiendo = 6
                ),

                    imagenPortada = R.drawable.portada,
                    imagenAvatar = R.drawable.avatar)
            }
        }
    }
}

//Modelo de datos: información centralizada de la info del usuario
data class PerfilUsuario(
    val nombre: String,
    val usuario: String,
    val biografia: String,
    val publicaciones: Int,
    val seguidores: String,
    val siguiendo: Int
)

@Composable
fun PantallaPerfilUsuario(
    perfil: PerfilUsuario,
    modificador: Modifier = Modifier,

    imagenPortada: Int,
    imagenAvatar: Int? = null // opcional: foto de avatar

) {
    //fondo general de la pantalla
    Surface(
        modifier = modificador.fillMaxSize(),
        color = Color(0xFFF5F7FB)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding() //padding para evitar superponer contenido con la barra de estado
                .padding( 16.dp)
        ) {
            Text(
                text = "Perfil",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF111827)
            )

            Spacer(Modifier.height(18.dp))

            //box para superponer la tarjeta sobre la imagen
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(imagenPortada),
                    contentDescription = "Imagen de portada",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(600.dp)
                        .clip(RoundedCornerShape(30.dp)) //se cortan las esquinas para una forma redondeada
                )

                //overlay oscuro para mejorar contraste con el texto
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(600.dp)
                        .clip(RoundedCornerShape(30.dp))
                        .background(Color.Black.copy(alpha = 0.18f))
                )

                //tarjeta de perfil superpuesta
                TarjetaPerfil(
                    perfil = perfil,
                    imagenAvatar = imagenAvatar,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(14.dp)
                )
            }

            Spacer(Modifier.height(18.dp))

            BarraAcciones()
        }
    }
}

@Composable
fun TarjetaPerfil(
    perfil: PerfilUsuario,
    imagenAvatar: Int?,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(28.dp), //bordes redondeados
        //efecto oscuro semitransparente
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF111827).copy(alpha = 0.80f) //alpha controla la opacidad, 0.80f = 80% opaco, 20% transparente
        ),
        elevation = CardDefaults.cardElevation( //cardElevation introduce profundidad con sombra, haciendo que la tarjeta se destaque sobre el fondo
            defaultElevation = 12.dp // sombra más pronunciada para un efecto de elevación más fuerte
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(22.dp)
        ) {
            //imagen de avatar, opcional: si no se proporciona, se omite el espacio
            if (imagenAvatar != null) {
                Image(
                    painter = painterResource(imagenAvatar),
                    contentDescription = "Avatar usuario",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(72.dp)
                        .clip(CircleShape)
                )

                Spacer(Modifier.height(14.dp))
            }

            //nombre + icono verificado
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = perfil.nombre,
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.width(8.dp))

                //icono moderno Material 3
                Icon(
                    imageVector = Icons.Rounded.Verified,
                    contentDescription = "Cuenta verificada",
                    tint = Color(0xFF60A5FA)
                )
            }

            Spacer(Modifier.height(6.dp))

            //username secundario
            Text(
                text = "@${perfil.usuario}",
                color = Color(0xFFCBD5E1),
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(Modifier.height(14.dp))

            //bio
            Text(
                text = perfil.biografia,
                color = Color(0xFFF3F4F6),
                lineHeight = 22.sp,
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(Modifier.height(22.dp))

            //estadisticas del perfil
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ItemEstadistica(
                    valor = perfil.publicaciones.toString(),
                    titulo = "Publicaciones"
                )

                ItemEstadistica(
                    valor = perfil.seguidores,
                    titulo = "Seguidores"
                )

                ItemEstadistica(
                    valor = perfil.siguiendo.toString(),
                    titulo = "Siguiendo"
                )
            }
        }
    }
}

//componente reutilizable para mostrar las estadisticas
@Composable
fun ItemEstadistica(
    valor: String, //numero o dato principal
    titulo: String // etiqueta descripcitva
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //valor principal destacado
        Text(
            text = valor,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleMedium
        )

        //espacio entre valor y etiqueta
        Spacer(Modifier.height(4.dp))

        Text(
            text = titulo,
            color = Color(0xFFCBD5E1),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
fun BarraAcciones() {

    //tarjeta para los botones de accion
    Card(
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BotonAccion(
                icono = Icons.Outlined.FavoriteBorder,
                texto = "Me gusta",
                color = Color(0xFFFB7185)
            )

            BotonAccion(
                icono = Icons.Outlined.ChatBubbleOutline,
                texto = "Comentar",
                color = Color(0xFF3B82F6)
            )

            BotonAccion(
                icono = Icons.Outlined.Send,
                texto = "Compartir",
                color = Color(0xFF14B8A6)
            )
        }
    }
}

//componente reutilizable para cada boton de accion
@Composable
fun BotonAccion(
    icono: androidx.compose.ui.graphics.vector.ImageVector, //ucono del boton
    texto: String, //texto para la accion
    color: Color // color para el boton
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = icono,
            contentDescription = texto,
            tint = color,
            modifier = Modifier.size(24.dp)
        )

        Spacer(Modifier.height(6.dp))

        Text(
            text = texto,
            color = color,
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.labelMedium
        )
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 800)
@Composable
fun VistaPreviaPerfil() {
    PantallaPerfilUsuario(
        perfil = PerfilUsuario(
            nombre = "Elizabeth Bennet",
            usuario = "lizzy.bennet",
            biografia = "Observadora aguda, amante de los paseos largos, los libros y las conversaciones inteligentes. Ingenio, libertad y un poco de terquedad.",
            publicaciones = 55,
            seguidores = "10M",
            siguiendo = 6
        ),

        imagenPortada = R.drawable.portada,
        imagenAvatar = R.drawable.avatar
    )
}

