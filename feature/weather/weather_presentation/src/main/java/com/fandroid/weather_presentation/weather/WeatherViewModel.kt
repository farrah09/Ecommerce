package com.fandroid.weather_presentation.weather

import android.app.Application
import android.location.Location
import android.util.Log
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModel
import com.fandroid.core_ui.navigation.AppNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.fandroid.core.util.UiEvent
import com.fandroid.core.util.UiText
import com.fandroid.weather_domain.use_case.WeatherUseCases
import com.fandroid.weather_presentation.R
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.receiveAsFlow

@HiltViewModel
class WeatherViewModel @Inject constructor(
   /*private val appNavigator: AppNavigator,
   private val application: Application,
   private val weatherUseCases: WeatherUseCases,*/
): ViewModel() {

   /*var state by mutableStateOf(WeatherState())
      private set

   private val _uiEvent = Channel<UiEvent>()
   val uiEvent = _uiEvent.receiveAsFlow()

   private var getFoodsForDateJob: Job? = null

   init {
      executeSearch()
   }

   private fun executeSearch() {
      viewModelScope.launch {
         weatherUseCases
            .getCurrentLocationUseCase()
            .onSuccess { location ->
               Log.d("",location.latitude.toString())
            }
            .onFailure {
               _uiEvent.send(
                  UiEvent.ShowSnackbar(
                     UiText.StringResource(R.string.error_something_went_wrong)
                  )
               )
            }
      }
   }


   private fun refreshFoods(location: Location) {
      getFoodsForDateJob?.cancel()
      getFoodsForDateJob = weatherUseCases
         .getWeatherForLocationUseCase(location.latitude,location.longitude)
         .launchIn(viewModelScope)
   }*/

}