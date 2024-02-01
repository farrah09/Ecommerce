package com.fandroid.weather_domain.di

import android.content.Context
import com.fandroid.weather_domain.repository.LocationRepository
import com.fandroid.weather_domain.repository.WeatherRepository
import com.fandroid.weather_domain.use_case.GetCurrentLocationUseCase
import com.fandroid.weather_domain.use_case.GetWeatherForLocationUseCase
import com.fandroid.weather_domain.use_case.WeatherUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
object WeatherDomainModule {

    @ViewModelScoped
    @Provides
    fun provideWeatherUseCases(
        weatherRepository: WeatherRepository,
        locationRepository: LocationRepository
    ): WeatherUseCases {
        return WeatherUseCases(
            GetCurrentLocationUseCase(locationRepository),
            GetWeatherForLocationUseCase(weatherRepository)
        )
    }

}