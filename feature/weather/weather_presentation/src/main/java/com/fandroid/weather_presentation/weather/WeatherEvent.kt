package com.fandroid.weather_presentation.weather

import com.fandroid.weather_domain.model.Weather

sealed class TrackerOverviewEvent {
    object OnNextDayClick: TrackerOverviewEvent()
    object OnPreviousDayClick: TrackerOverviewEvent()
   // data class OnToggleMealClick(val meal: Meal): TrackerOverviewEvent()
    data class OnDeleteTrackedFoodClick(val trackedFood: Weather): TrackerOverviewEvent()
}