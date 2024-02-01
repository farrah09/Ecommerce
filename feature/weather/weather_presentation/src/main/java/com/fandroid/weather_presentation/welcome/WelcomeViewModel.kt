package com.fandroid.weather_presentation.welcome

import android.Manifest
import android.app.Application
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fandroid.core_ui.navigation.AppNavigator
import com.fandroid.core_ui.navigation.Destination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class WelcomeViewModel @Inject constructor(
    private val appNavigator: AppNavigator,
    private val context: Context
) : ViewModel() {
    fun isLocationPermissionGranted(): Boolean {

        val fineLocationGranted = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        val coarseLocationGranted = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        return fineLocationGranted && coarseLocationGranted

    }


    fun onPermissionGranted() {
        viewModelScope.launch {
            try {
                navigateToWeather()
            } catch (e: Exception) {
                navigateToError("Error fetching weather data.")
            }
        }
    }

    fun onPermissionDenied() {
        navigateToError("Location permission is necessary for the app.")
    }

    fun navigateToWeather() {
        viewModelScope.launch {
            appNavigator.navigateTo(Destination.WeatherScreen())
        }
    }

    fun navigateToError(message: String?) {
        viewModelScope.launch {
            appNavigator.navigateTo(Destination.ErrorScreen())
        }
    }

}