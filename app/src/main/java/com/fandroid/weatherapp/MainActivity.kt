package com.fandroid.weatherapp

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.fandroid.core_ui.navigation.Destination
import com.fandroid.core_ui.navigation.NavHost
import com.fandroid.core_ui.navigation.NavigationIntent
import com.fandroid.core_ui.navigation.composable
import com.fandroid.weather_data.location.PermissionManager
import com.fandroid.weather_presentation.weather.WeatherScreen
import com.fandroid.weather_presentation.welcome.WelcomeScreen
import com.fandroid.weatherapp.ui.theme.WeatherAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {

                val viewModel: MainViewModel = hiltViewModel()
                Navigator(viewModel.navigationChannel)

            }
        }
    }


    @Composable
    private fun Navigator(navigationChannel: Channel<NavigationIntent>) {
        val navController = rememberNavController()
        NavigationEffects(
            navigationChannel = navigationChannel,
            navHostController = navController
        )
        NavHost(
            navController = navController,
            startDestination = Destination.WelcomeScreen
        ) {
            composable(destination = Destination.WelcomeScreen) {
                WelcomeScreen()
            }

            composable(destination = Destination.WelcomeScreen) {
                WeatherScreen()
            }
        }
    }

    @Composable
    fun NavigationEffects(
        navigationChannel: Channel<NavigationIntent>,
        navHostController: NavHostController
    ) {
        val activity = (LocalContext.current as? Activity)
        LaunchedEffect(activity, navHostController, navigationChannel) {
            navigationChannel.receiveAsFlow().collect { intent ->
                if (activity?.isFinishing == true) {
                    return@collect
                }
                when (intent) {
                    is NavigationIntent.NavigateBack -> {
                        if (intent.route != null) {
                            navHostController.popBackStack(intent.route!!, intent.inclusive)
                        } else {
                            navHostController.popBackStack()
                        }
                    }

                    is NavigationIntent.NavigateTo -> {
                        navHostController.navigate(intent.route) {
                            launchSingleTop = intent.isSingleTop
                            intent.popUpToRoute?.let { popUpToRoute ->
                                popUpTo(popUpToRoute) { inclusive = intent.inclusive }
                            }
                        }
                    }
                }
            }
        }
    }



}


