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
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass

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
fun SettingsScreen(navController: NavController, vm: GameViewModel, windowSize:WindowSizeClass) {
    if (windowSize.widthSizeClass <= WindowWidthSizeClass.Medium) {
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

                OutlinedTextField(value = vm.getDificultad(),
                    onValueChange = { vm.setDificultad(it) },
                    enabled = false,
                    readOnly = true,
                    modifier = Modifier
                        .clickable { expanded = true }
                        .width(200.dp)
                )

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
                    modifier = Modifier
                        .width(200.dp)

                ) {
                    dificultades.forEach { dificultad ->
                        DropdownMenuItem(text = { Text(text = dificultad) }, onClick = {
                            expanded = false
                            vm.setDificultad(dificultad)
                        }, modifier = Modifier.width(200.dp)
                            .align(Alignment.End)
                        )
                    }
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(0.80f),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextLeftBox("Rondas", 24)
                val rounds by remember { mutableStateOf(arrayOf(5, 10, 15)) }
                var selected by remember { mutableIntStateOf(vm.getRondas()) }
                rounds.forEach {
                    Column {
                        RadioButton(
                            selected = selected == it,
                            onClick = { vm.setRondas(it); selected = it })

                        Text(it.toString(), Modifier.align(Alignment.CenterHorizontally))
                    }
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(0.80f),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                TextLeftBox("Tiempo por ronda", 24)
                var displayValue by remember { mutableStateOf(vm.getTiempo().toString()) }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Slider(
                        value = vm.getTiempo().toFloat(),
                        onValueChange = {
                            vm.setSliderTiempo(it.toInt())
                            displayValue = vm.getTiempo().toString()
                        },
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
                TextLeftBox("Delay entre preguntas", 24)
                var delayValue by remember { mutableStateOf(vm.getDelayMillis().toString()) }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Slider(
                        value = vm.getDelayMillis().toFloat(),
                        onValueChange = {
                            vm.setDelayMillis(it.toInt())
                            delayValue = vm.getDelayMillis().toString()
                        },
                        valueRange = 250f..5000f,
                        steps = 20
                    )
                    Text(text = "$delayValue${"ms"}")
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
                    checked = vm.darkMode,
                    onCheckedChange = {
                        vm.switchTheme()
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
    } else {

    }
}

@Composable
fun TextLeftBox(mensaje: String, size: Int) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(16.dp)
            .width(120.dp)
            .fillMaxWidth(0.30f),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            mensaje,
            modifier = Modifier.align(Alignment.BottomStart),
            textAlign = TextAlign.Center,
            fontSize = size.sp,

        )
    }
}
