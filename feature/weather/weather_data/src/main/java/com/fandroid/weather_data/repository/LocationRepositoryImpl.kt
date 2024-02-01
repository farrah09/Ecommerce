package com.fandroid.weather_data.repository

import android.location.Location
import com.fandroid.weather_data.location.LocationService
import com.fandroid.weather_domain.repository.LocationRepository
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(
    private val locationService: LocationService
) : LocationRepository {
    override suspend fun getCurrentLocation(): Location {
        return locationService.getCurrentLocation()
    }
}
