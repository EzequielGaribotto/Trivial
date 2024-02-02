package com.example.trivial.view

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.windowsizeclass.WindowSizeClass
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
fun ResultScreen(navController: NavController, vm: GameViewModel, windowSize: WindowSizeClass) {
    val titulo by remember { mutableStateOf("Your score\n\n\n${vm.getScore()}.") }
    val shareText by remember { mutableStateOf( "Check out my TrivialApp results!\n" +
            "Score: ${vm.getScore()}\n" +
            "Difficulty: ${vm.getDificultad()}\n" +
            "Rounds: ${vm.getRondas()}")}
    val configuration = LocalConfiguration.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextInBox(titulo, 48)
        if (configuration.orientation != Configuration.ORIENTATION_LANDSCAPE) {
            ShareButton(shareText, LocalContext.current,vm,configuration)
            Spacer(modifier = Modifier.height(15.dp))
            NavigationButton("Menú","MenuScreen", navController, vm, configuration)
        } else {
            Row (horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically){
                ShareButton(shareText, LocalContext.current,vm,configuration)
                Spacer(modifier = Modifier.width(15.dp))
                NavigationButton("Menú","MenuScreen", navController, vm, configuration)
            }
        }
    }
}
