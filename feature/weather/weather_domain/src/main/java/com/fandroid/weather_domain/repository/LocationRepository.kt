package com.fandroid.weather_domain.repository

import android.location.Location

interface LocationRepository {
    suspend fun getCurrentLocation(): Location

}