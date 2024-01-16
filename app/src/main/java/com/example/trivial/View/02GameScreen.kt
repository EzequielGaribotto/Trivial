package com.example.trivial.View

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trivial.viewModel.GameViewModel
import com.example.trivial.R

@Composable
fun MenuScreen(navController: NavController, viewModel: GameViewModel) {
    // Fondo de pantalla
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Componentes
        Column(
            Modifier.padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Logo
            Box(
                modifier = Modifier.paint(
                    painterResource(id = R.drawable.logo),
                    contentScale = ContentScale.FillBounds
                )
            )
        }
        // BOTÓN "JUGAR"
        Box(modifier = Modifier
            .background(Color.Red, shape = RoundedCornerShape(12.dp))
            .height(80.dp)
            .width(160.dp)
            .clickable {
                navController.navigate(Routes.GameScreen.route)
            }) {
            Text(
                text = "New Game",
                modifier = Modifier.align(Alignment.Center),
                color = Color.White,
                fontSize = 32.sp
            )
        }

        // BOTÓN "AYUDA"
        Spacer(modifier = Modifier.height(15.dp))
        Box(modifier = Modifier
            .background(Color.Red, shape = RoundedCornerShape(12.dp))
            .height(80.dp)
            .width(160.dp)
            .clickable {
                navController.navigate(Routes.SettingsScreen.route)
            }) {
            Text(
                text = "Settings",
                modifier = Modifier.align(Alignment.Center),
                color = Color.White,
                fontSize = 32.sp
            )
        }
    }
}

