package com.fandroid.weather_presentation

import androidx.lifecycle.ViewModel
import com.fandroid.core_ui.navigation.AppNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class WeatherViewModel @Inject constructor(
   private val appNavigator: AppNavigator
): ViewModel() {

   init {

   }
}