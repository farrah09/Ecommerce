package com.fandroid.weather_domain.use_case

import android.location.Location
import com.fandroid.weather_domain.repository.LocationRepository

class GetCurrentLocationUseCase(
    private val locationRepository: LocationRepository,
) {
    suspend operator fun invoke(
    ): Result<Location> {
        return Result.success(locationRepository.getCurrentLocation())
    }


}
