package com.example.trivial.View


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.navigation.NavController

import com.example.trivial.viewModel.GameViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(navController: NavController, viewModel: GameViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val config = viewModel.configuracion
            var expanded by remember { mutableStateOf(false) }

            Row(
                modifier = Modifier.fillMaxWidth(0.80f),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextLeftBox("Dificultad", 24)

                OutlinedTextField(value = viewModel.configuracion.dificultad,
                    onValueChange = { viewModel.modDificultad(it) },
                    enabled = false,
                    readOnly = true,
                    modifier = Modifier
                        .clickable { expanded = true }
                        .width(360.dp))


                // Selección dificultad
                val dificultades by remember {
                    mutableStateOf(
                        arrayOf(
                            "Fácil",
                            "Normal",
                            "Dificil"
                        )
                    )
                }
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier.width(360.dp)
                ) {
                    dificultades.forEach { dificultad ->
                        DropdownMenuItem(text = { Text(text = dificultad) }, onClick = {
                            expanded = false
                            viewModel.modDificultad(dificultad)
                        }, modifier = Modifier.width(360.dp)
                        )
                    }
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(0.80f),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextLeftBox("Rondas", 24)

                var expandedRounds by remember { mutableStateOf(false) }
                OutlinedTextField(value = config.rondas.toString(),
                    onValueChange = { viewModel.modRondas(it.toInt()) },
                    enabled = false,
                    readOnly = true,
                    label = { Text("Rondas") },
                    modifier = Modifier
                        .clickable { expandedRounds = true }
                        .width(360.dp))


                val rondas by remember { mutableStateOf(arrayOf(5, 6, 7, 8, 9, 10)) }
                DropdownMenu(
                    expanded = expandedRounds,
                    onDismissRequest = { expandedRounds = false },
                    modifier = Modifier.fillMaxWidth(0.40f)
                ) {
                    rondas.forEach { ronda ->
                        DropdownMenuItem(text = { Text(text = ronda.toString()) }, onClick = {
                            expandedRounds = false
                            viewModel.modRondas(ronda)
                        }, modifier = Modifier.fillMaxWidth(0.40f)
                        )
                    }
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(0.80f),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextLeftBox("Tiempo", 24)
                var displayValue by remember { mutableStateOf(config.tiempo.toString()) }
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Slider(
                        value = config.tiempo.toFloat(),
                        onValueChange = { config.tiempo = it.toInt() },
                        onValueChangeFinished = { displayValue = config.tiempo.toString() },
                        valueRange = 20f..120f,
                        steps = 20
                    )
                    Text(text = "$displayValue${"s"}")
                }
            }

            Spacer(modifier = Modifier.height(15.dp))

            Row(
                modifier = Modifier.fillMaxWidth(0.80f),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                TextLeftBox("Modo oscuro", 24)
                var state by remember { mutableStateOf(config.modoOscuro) }
                val context = LocalContext.current
                Switch(
                    checked = state,
                    onCheckedChange = {
                        viewModel.modTheme(!config.modoOscuro)
                        state = config.modoOscuro
                    },
                    colors = SwitchDefaults.colors(
                        uncheckedThumbColor = Color.Red,
                        checkedThumbColor = Color.Green,
                        uncheckedTrackColor = Color.Gray, // Customize the unchecked track color
                        checkedTrackColor = Color.DarkGray // Customize the checked track color
                    )
                )
            }
        }
        // BOTÓN "MENÚ"
        Box(
            modifier = Modifier
                .background(Color.Red, shape = RoundedCornerShape(12.dp))
                .height(80.dp)
                .width(160.dp)
                .align(alignment = Alignment.CenterHorizontally)
                .clickable {
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

@Composable
fun TextLeftBox(mensaje: String, size: Int) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .padding(16.dp)
            .fillMaxWidth(0.30f)
    ) {
        Text(
            mensaje,
            modifier = Modifier.align(Alignment.BottomStart),
            color = Color.Black,
            textAlign = TextAlign.Left,
            fontSize = size.sp,
        )
    }
}

@Composable
fun MyProSlider() {

}
