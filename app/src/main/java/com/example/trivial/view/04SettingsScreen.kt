package com.example.trivial.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.trivial.NavigationButton
import com.example.trivial.R
import com.example.trivial.TextLeftBox
import com.example.trivial.viewModel.GameViewModel
import kotlin.math.roundToInt


@Composable
fun SettingsScreen(navController: NavController, vm: GameViewModel) {
    val configuration = LocalConfiguration.current
    Column(
        modifier = Modifier
            .fillMaxSize(0.8f)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SelectDifficulty(vm)
        SelectRoundAmount(vm)
        SelectRoundDuration(vm)
        SelectQuestionDelay(vm)
        SwitchTheme(vm)
        SwitchCategories(vm)
        NavigationButton("Volver al Menú", "MenuScreen", navController, vm, configuration)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectDifficulty(vm:GameViewModel) {
    var expanded by remember { mutableStateOf(false) }
    val dificultades by remember {
        mutableStateOf(
            arrayOf(
                "Fácil", "Normal", "Dificil", "Random"
            )
        )
    }
    Row(
        modifier = Modifier.fillMaxWidth(0.80f),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextLeftBox("Dificultad", 24)
        Box {
            OutlinedTextField(value = vm.getDificultad(),
                onValueChange = { vm.setDificultad(it) },
                enabled = false,
                readOnly = true,
                modifier = Modifier
                    .clickable { expanded = true }
                    .fillMaxWidth())
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier

            ) {
                dificultades.forEach { dificultad ->
                    DropdownMenuItem(text = { Text(text = dificultad) }, onClick = {
                        expanded = false
                        vm.setDificultad(dificultad)
                    })
                }
            }
        }
    }
}
@Composable
fun SelectRoundAmount(vm:GameViewModel) {
    Row(
        modifier = Modifier.fillMaxWidth(0.80f),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextLeftBox("Rondas", 24)
        val rounds by remember { mutableStateOf(arrayOf(5, 10, 15)) }
        var selected by remember { mutableIntStateOf(vm.getRondas()) }
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            rounds.forEach {
                Column {
                    RadioButton(selected = selected == it,
                        onClick = { vm.setRondas(it); selected = it })
                    Text(it.toString(), Modifier.align(Alignment.CenterHorizontally))
                }
            }
        }
    }
}
@Composable
fun SelectRoundDuration(vm:GameViewModel) {
    Row(
        modifier = Modifier.fillMaxWidth(0.80f),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextLeftBox("Duración de ronda", 24)
        var displayValue by remember { mutableStateOf(vm.getSliderTime().toString()) }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Slider(
                value = vm.getSliderTime().toFloat(), onValueChange = {
                    vm.setSliderTiempo(it.toInt())
                    displayValue = vm.getSliderTime().toString()
                }, valueRange = 5f..30f, steps = 4
            )
            Text(text = "$displayValue${"s"}")
        }
    }
}

@Composable
fun SelectQuestionDelay(vm:GameViewModel) {
    Row(
        modifier = Modifier.fillMaxWidth(0.80f),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextLeftBox("Retraso entre preguntas", 24)
        var delayValue by remember { mutableStateOf(vm.getDelayMillis().toString()) }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Slider(
                value = vm.getDelayMillis().toFloat(),
                onValueChange = {
                    val roundedValue = (it / 500).roundToInt() * 500
                    vm.setDelayMillis(roundedValue)
                    delayValue = roundedValue.toString()
                },
                valueRange = 500f..20000f,
                steps = 39
            )
            Text(text = "${delayValue.toDouble() / 1000}${"s"}")
        }
    }
}
@Composable
fun SwitchTheme(vm:GameViewModel) {
    Row(
        modifier = Modifier.fillMaxWidth(0.80f),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextLeftBox(if (vm.isDarkMode()) "Modo oscuro" else "Modo claro", 24)
        Row(modifier = Modifier.fillMaxWidth()) {
            Column {
                Switch(
                    checked = vm.isDarkMode(), onCheckedChange = {
                        vm.switchTheme()
                    }
                )
            }
        }
    }
}

@Composable
fun SwitchCategories(vm:GameViewModel) {
    Row(
        modifier = Modifier.fillMaxWidth(0.80f),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        SwitchCategory(isChecked = vm.getGeografia(), image = R.drawable.geografia) { vm.switchGeografia() }
        SwitchCategory(isChecked = vm.getDeportes(), image = R.drawable.deportes) { vm.switchDeportes() }
        SwitchCategory(isChecked = vm.getHistoria(), image = R.drawable.historia) { vm.switchHistoria() }
    }
    Spacer(modifier = Modifier.height(25.dp))
    Row(
        modifier = Modifier.fillMaxWidth(0.80f),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        SwitchCategory(isChecked = vm.getMatematicas(), image = R.drawable.matematicas) { vm.switchMatematicas() }
        SwitchCategory(isChecked = vm.getQuimica(), image = R.drawable.quimica) { vm.switchQuimica() }
        SwitchCategory(isChecked = vm.getVideojuegos(), image = R.drawable.videojuegos) { vm.switchVideojuegos() }
    }
    Spacer(modifier = Modifier.height(25.dp))
}

@Composable
fun SwitchCategory(isChecked: MutableState<Boolean>, image: Int, action: () -> Unit) {
    Column(
        modifier = Modifier
            .size(90.dp),  // Adjust the size as needed
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = "",
            modifier = Modifier.fillMaxSize() // Adjust the size of the image
        )
        Switch(
            checked = isChecked.value,
            onCheckedChange = {
                action()
            }
        )
    }
}
