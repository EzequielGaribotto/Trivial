package com.example.trivial
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.trivial.ui.theme.TrivialTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.trivial.view.GameScreen
import com.example.trivial.view.MenuScreen
import com.example.trivial.view.ResultScreen
import com.example.trivial.view.SettingsScreen
import com.example.trivial.navigation.Routes
import com.example.trivial.viewModel.*

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        val gameViewModel by viewModels<GameViewModel>()
        super.onCreate(savedInstanceState)
        setContent {
            TrivialTheme(gameViewModel.darkMode) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val windowSize = calculateWindowSizeClass(this)
                    val navigationController = rememberNavController()
                    NavHost(
                        navController = navigationController,
                        startDestination = Routes.MenuScreen.route
                    ) {
                        composable(Routes.MenuScreen.route) {
                            MenuScreen(
                                navigationController,
                                gameViewModel,
                                windowSize
                            )
                        }
                        composable(Routes.GameScreen.route) {
                            GameScreen(
                                navigationController,
                                gameViewModel,
                                windowSize
                            )
                        }
                        composable(Routes.ResultScreen.route) {
                            ResultScreen(
                                navigationController,
                                gameViewModel,
                                windowSize
                            )
                        }
                        composable(Routes.SettingsScreen.route) {
                            SettingsScreen(
                                navigationController,
                                gameViewModel,
                                windowSize
                            )
                        }
                    }

                }
            }
        }
    }
}