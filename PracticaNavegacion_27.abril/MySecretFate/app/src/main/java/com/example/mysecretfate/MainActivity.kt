package com.example.mysecretfate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mysecretfate.pantallas.PantallaDetalle
import com.example.mysecretfate.pantallas.PantallaInicio
import com.example.mysecretfate.pantallas.PantallaResumen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface(
                color = MaterialTheme.colorScheme.background
            ) {
                //Los argumentos se pasan dentro de la ruta (por ejemplo detalle/puerta)
                //y luego se recuperan con backStackEntry para modificar cada pantalla.

                //Controlador principal de la navegación entre pantallas
                val controladorNavegacion = rememberNavController()

                //'NavHost' es el contenedor donde viven las rutas de navegación de la app
                NavHost(
                    navController = controladorNavegacion,
                    startDestination = "inicio" //Pantalla incial del flujo
                ) {

                    //ruta simple sin parametros
                    composable("inicio") {
                        PantallaInicio(controladorNavegacion)
                    }


                    //ruta dinámica que recibe una desicion:
                    //puerta o alejarse
                    composable(
                        route = "detalle/{decision}",
                        arguments = listOf(
                            navArgument("decision") {
                                type = NavType.StringType //argumento de tipo String
                            }
                        )
                    ) { backStackEntry ->

                        //Recupera el valor recibido por la ruta.
                        //Si no llega valor, usa "puerta" por defecto.
                        val decision =
                            backStackEntry.arguments?.getString("decision") ?: "puerta"

                        PantallaDetalle(
                            navController = controladorNavegacion,
                            decision = decision
                        )
                    }


                    //ruta dinámica para mostrar la pantalla final
                    composable(
                        route = "resumen/{destino}",
                        arguments = listOf(
                            navArgument("destino") {
                                type = NavType.StringType
                            }
                        )
                    ) { backStackEntry ->

                        //Obtiene qué final se desbloqueó:
                        //guardiana o prudente
                        val destino =
                            backStackEntry.arguments?.getString("destino") ?: "guardiana"

                        PantallaResumen(
                            navController = controladorNavegacion,
                            destino = destino
                        )
                    }
                }
        }
    }
}
}

