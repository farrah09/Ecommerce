package com.fandroid.weather_data.di

import android.app.Application
import androidx.room.Room
import com.fandroid.weather_data.local.WeatherDatabase
import com.fandroid.weather_data.remote.OpeWeatherApi
import com.fandroid.weather_data.repository.WeatherRepositoryImpl
import com.fandroid.weather_domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WeatherDataModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideOpenWeatherApi(client: OkHttpClient): OpeWeatherApi {
        return Retrofit.Builder()
            .baseUrl(OpeWeatherApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideWeatherDatabase(app: Application): WeatherDatabase {
        return Room.databaseBuilder(
            app,
            WeatherDatabase::class.java,
            "weather_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideWeatherRepository(
        api: OpeWeatherApi,
        db: WeatherDatabase
    ): WeatherRepository {
        return WeatherRepositoryImpl(
            dao = db.dao,
            api = api
        )
    }
}