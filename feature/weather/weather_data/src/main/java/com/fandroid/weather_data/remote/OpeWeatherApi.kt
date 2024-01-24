package com.fandroid.weather_data.remote

import com.fandroid.weather_data.remote.dto.SearchDto
import retrofit2.http.GET
import retrofit2.http.Query

interface OpeWeatherApi {
    @GET("forecast?current=temperature_2m," +
            "relative_humidity_2m," +
            "apparent_temperature," +
            "is_day,precipitation," +
            "weather_code," +
            "wind_speed_10m&" +
            "hourly=temperature_2m," +
            "uv_index," +
            "uv_index_clear_sky&" +
            "daily=temperature_2m_max," +
            "temperature_2m_min," +
            "sunrise," +
            "sunset&" +
            "timezone=Europe%2FLondon&" +
            "past_days=7&" +
            "past_hours=12&" +
            "forecast_hours=12&" +
            "models=icon_seamless")

    suspend fun searchWeather(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
    ): SearchDto

    companion object {
        const val BASE_URL = "https://api.open-meteo.com/v1/"
    }

}


