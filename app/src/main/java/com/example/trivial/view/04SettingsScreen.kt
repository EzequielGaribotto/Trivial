package com.example.trivial.view


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch

import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass

import androidx.compose.runtime.Composable

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.navigation.NavController
import com.example.trivial.navigation.Routes

import com.example.trivial.viewModel.GameViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(navController: NavController, viewModel: GameViewModel, windowSize:WindowSizeClass) {
    val config = viewModel.configuracion

    
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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
            val rondas by remember { mutableStateOf(arrayOf(5, 10, 15)) }
            var selected by remember { mutableIntStateOf(config.rondas) }
            rondas.forEach {
                Column {
                    RadioButton(
                        selected = selected == it,
                        onClick = { viewModel.modRondas(it); selected = it })

                    Text(it.toString(), Modifier.align(Alignment.CenterHorizontally))
                }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(0.80f),
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            TextLeftBox("Tiempo", 24)
            var displayValue by remember { mutableStateOf(viewModel.getSliderTiempo().toString()) }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Slider(
                    value = viewModel.getSliderTiempo().toFloat(),
                    onValueChange = {
                        viewModel.modSliderTiempo(it.toInt())
                        displayValue = viewModel.getSliderTiempo().toString()
                                    },
                    valueRange = 20f..120f,
                    steps = 20
                )
                Text(text = "$displayValue${"s"}")
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(0.80f),
            horizontalArrangement = Arrangement.SpaceBetween,

            ) {
            TextLeftBox("Modo oscuro", 24)
            Switch(
                checked = viewModel.darkMode,
                onCheckedChange = {
                    viewModel.switchTheme()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
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
    BoxWithConstraints(
        modifier = Modifier
            .padding(16.dp)
            .width(120.dp)
            .fillMaxWidth(0.30f)
    ) {
        Text(
            mensaje,
            modifier = Modifier.align(Alignment.BottomStart),
            textAlign = TextAlign.Left,
            fontSize = size.sp,
        )
    }
}
