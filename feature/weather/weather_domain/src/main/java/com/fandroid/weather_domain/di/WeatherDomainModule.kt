package com.fandroid.weather_domain.di

import com.fandroid.weather_domain.repository.WeatherRepository
import com.fandroid.weather_domain.use_case.SearchWeather
import com.fandroid.weather_domain.use_case.WeatherUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object WeatherDomainModule {

    @ViewModelScoped
    @Provides
    fun provideWeatherUseCases(
        repository: WeatherRepository,
    ): WeatherUseCases {
        return WeatherUseCases(
            searchWeather = SearchWeather(repository)
        )
    }
}