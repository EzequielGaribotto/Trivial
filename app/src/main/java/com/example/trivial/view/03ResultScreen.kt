package com.example.trivial.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trivial.navigation.Routes
import com.example.trivial.viewModel.GameViewModel

@Composable
fun ResultScreen(navController: NavController, viewModel: GameViewModel, windowSize: WindowSizeClass) {
    val score by remember { mutableIntStateOf(viewModel.estadoJuego.puntuacion) }
    val titulo by remember { mutableStateOf("Your score\n\n\n${score}.") }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (titulo.isNotBlank()) {
                TextInBox(titulo, 48)
            }
            // BOTON SHARE
            BoxWithConstraints(
                modifier = Modifier
                    .background(Color.Red, shape = RoundedCornerShape(12.dp))
                    .height(80.dp)
                    .width(160.dp)
                    .align(alignment = Alignment.CenterHorizontally)
                    .clickable {
                        viewModel.resetScore()
                        viewModel.modRonda(1)
                        navController.navigate(Routes.MenuScreen.route)
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Share",
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontSize = 32.sp,
                    lineHeight = 32.sp
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            // BOTÓN "MENÚ"
            BoxWithConstraints(
                modifier = Modifier
                    .background(Color.Red, shape = RoundedCornerShape(12.dp))
                    .height(80.dp)
                    .width(160.dp)
                    .align(alignment = Alignment.CenterHorizontally)
                    .clickable {
                        viewModel.resetGame()
                        navController.navigate(Routes.MenuScreen.route)
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Menú",
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontSize = 32.sp,
                    lineHeight = 32.sp
                )
            }
        }
    }
}
@Composable
fun TextInBox(mensaje:String, size:Int) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text(
            mensaje,
            modifier = Modifier.align(Alignment.Center),
            textAlign = TextAlign.Center,
            fontSize = size.sp,
        )
    }
}

