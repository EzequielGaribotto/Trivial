package com.example.trivial.view

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.trivial.NavigationButton
import com.example.trivial.ShareButton
import com.example.trivial.TextInBox
import com.example.trivial.viewModel.GameViewModel

@Composable
fun ResultScreen(navController: NavController, vm: GameViewModel) {
    val mensaje by remember { mutableStateOf("¡Fin del juego!\n\n" +
            "Score: ${vm.getScore()}\n" +
            "Acertaste ${vm.getAcertadas()}/${vm.getRondas()} preguntas\n") }
    val shareText by remember { mutableStateOf(
        "Mira mis resultados en TrivialApp!\n" +
                "Score: ${vm.getScore()}\n" +
                "Acertadas: ${vm.getAcertadas()}\n" +
                "Falladas: ${vm.getFalladas()}\n"+
                "Dificultad: ${vm.getDificultad()}\n" +
                "Rondas: ${vm.getRondas()}\n" +
                "---\n" +
                "Preguntas habilitadas:\n" +
                "GEOGRAFIA: ${if (vm.getGeografia().value) "SI" else "NO"}\n" +
                "DEPORTES: ${if (vm.getDeportes().value) "SI" else "NO"}\n" +
                "HISTORIA: ${if (vm.getHistoria().value) "SI" else "NO"}\n" +
                "MATEMATICAS: ${if (vm.getMatematicas().value) "SI" else "NO"}\n" +
                "QUIMICA: ${if (vm.getQuimica().value) "SI" else "NO"}\n" +
                "VIDEOJUEGOS: ${if (vm.getVideojuegos().value) "SI" else "NO"}\n"
    )}

    val configuration = LocalConfiguration.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (configuration.orientation != Configuration.ORIENTATION_LANDSCAPE) {
            TextInBox(mensaje, 48)
            ShareButton(shareText, LocalContext.current,vm,configuration)
            Spacer(modifier = Modifier.height(15.dp))
            NavigationButton("Menú","MenuScreen", navController, vm, configuration)
        } else {
            TextInBox(mensaje, 26)
            Row (horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(0.6f)){
                ShareButton(shareText, LocalContext.current,vm,configuration)
                NavigationButton("Menú","MenuScreen", navController, vm, configuration)
            }
        }
    }
}
