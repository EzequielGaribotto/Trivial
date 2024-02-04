package com.example.trivial

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.example.trivial.viewModel.GameViewModel

@Composable
fun NavigationButton(
    text: String,
    route: String,
    navController: NavController,
    vm: GameViewModel,
    configuration: Configuration
) {
    Button(
        enabled = if (route == "GameScreen") {
            vm.getNotAllowedList().size != 6
        } else {
            true
        },
        onClick = { navController.navigate(route); if (route == "GameScreen") vm.resetGame() },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (vm.isDarkMode()) Color.Gray else Color.Red,
            contentColor = if (vm.isDarkMode()) Color.Black else Color.White,
        ),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .border(
                width = 5.dp,
                color = if (!vm.isDarkMode()) Color.Black else Color.White,
                shape = RoundedCornerShape(8.dp),
            )
            .clip(shape = RoundedCornerShape(8.dp))
            .run {
                if (configuration.orientation != Configuration.ORIENTATION_LANDSCAPE) {
                    fillMaxWidth(0.7f)
                } else {
                    fillMaxHeight(0.5f)
                }
            }
    ) {
        Text(
            text = text,
            fontSize = 32.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterVertically),
            lineHeight = 35.sp
        )
    }
}

@Composable
fun TextInBox(mensaje: String, size: Int) {
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
            lineHeight = size * 1.25.sp
        )
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
            textAlign = TextAlign.Left,
            fontSize = size.sp,
        )
    }
}


@Composable
fun ShareButton(text: String, context: Context, vm: GameViewModel, configuration: Configuration) {
    val sendIntent = Intent(Intent.ACTION_SEND).apply {
        putExtra(Intent.EXTRA_TEXT, text)
        type = "text/plain"
    }
    val shareIntent = Intent.createChooser(sendIntent, null)
    Button(
        onClick = { ContextCompat.startActivity(context, shareIntent, null) },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (vm.isDarkMode()) Color.Gray else Color.Red,
            contentColor = if (vm.isDarkMode()) Color.Black else Color.White,
        ),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .border(
                width = 5.dp,
                color = if (!vm.isDarkMode()) Color.Black else Color.White,
                shape = RoundedCornerShape(8.dp),
            )
            .clip(shape = RoundedCornerShape(8.dp))
            .run {
                if (configuration.orientation != Configuration.ORIENTATION_LANDSCAPE) {
                    fillMaxWidth(0.7f)
                } else {
                    fillMaxHeight(0.5f)
                }
            }
    ) {
        Text(
            text = "Compartir",
            fontSize = 32.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterVertically),
            lineHeight = 35.sp
        )
    }
}

