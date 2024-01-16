package com.example.trivial.View
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trivial.R
import com.example.trivial.viewModel.GameViewModel

@Composable
fun MenuScreen(navController: NavController, viewModel: GameViewModel) {
    // Fondo de pantalla
    Column(
        modifier = Modifier
            .fillMaxSize(0.9f)
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
        Box(
            modifier = Modifier
                .background(Color.Red, shape = RoundedCornerShape(12.dp))
                .fillMaxHeight(0.15f)
                .fillMaxWidth(0.55f)
                .align(alignment = Alignment.CenterHorizontally)
                .clickable {
                    navController.navigate(Routes.GameScreen.route)
                },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Nueva partida",
                modifier = Modifier.align(Alignment.Center),
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 32.sp,
                lineHeight = 32.sp
            )
        }
        Spacer(modifier = Modifier.height(15.dp))

        // BOTÓN "CONFIGURACIÓN"
        Box(
            modifier = Modifier
                .background(Color.Red, shape = RoundedCornerShape(12.dp))
                .fillMaxHeight(0.15f)
                .fillMaxWidth(0.55f)
                .align(alignment = Alignment.CenterHorizontally)
                .clickable {
                    navController.navigate(Routes.SettingsScreen.route)
                },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Configuración",
                modifier = Modifier.align(Alignment.Center),
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 32.sp,
                lineHeight = 32.sp
            )
        }
    }
}

