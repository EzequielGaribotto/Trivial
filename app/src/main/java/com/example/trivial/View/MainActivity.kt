package com.example.trivial.View

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.trivial.ui.theme.TrivialTheme
import com.example.trivial.viewModel.GameViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val gameViewModel by viewModels<GameViewModel>()
        setContent {
            NavigationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    val navigationController = rememberNavController()
                    NavHost(
                        navController = navigationController,
                        startDestination = Routes.MenuScreen.route
                    ) {
                        composable(
                            Routes.MenuScreen.route
                        ) {
                            MenuScreen(
                                navigationController,
                                gameViewModel
                            )
                        }
                        composable(
                            Routes.GameScreen.route
                        ) {
                            GameScreen(
                                navigationController,
                                gameViewModel
                            )
                        }
                        composable(
                            Routes.ResultScreen.route
                        ) {
                            ResultScreen(
                                navigationController,
                                gameViewModel
                            )
                        }
                    }
                }
            }
        }
    }
}
