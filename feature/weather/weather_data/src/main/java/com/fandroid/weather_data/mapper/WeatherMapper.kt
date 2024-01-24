package com.fandroid.weather_data.mapper

import com.fandroid.weather_data.remote.dto.Current
import com.fandroid.weather_data.remote.dto.Daily
import com.fandroid.weather_data.remote.dto.Hourly
import com.fandroid.weather_data.remote.dto.SearchDto
import com.fandroid.weather_domain.model.Condition
import com.fandroid.weather_domain.model.Forecast
import com.fandroid.weather_domain.model.Hour
import com.fandroid.weather_domain.model.Weather
import kotlin.math.roundToInt

fun SearchDto.toWeather(): Weather {

    val temperature = current.temperature2m.roundToInt()
    val date = current.time
    val wind = current.windSpeed10m
    val humidity = current.relativeHumidity2m
    val feelsLike = current.apparentTemperature.roundToInt()
    val condition = current.toCondition()
    val uv = 0
    val name = "current.name"
    val forecasts = daily.mapDailyToForecast()
    val hours = hourly.mapHourlyToHour()

    return Weather(
        temperature,
        date,
        wind,
        humidity,
        feelsLike,
        condition,
        uv,
        name,
        forecasts,
        hours
    )

}

fun Current.toCondition(): Condition = Condition(

    code = weather_code,
    icon = "1",
    text = ""

)

fun Daily.mapDailyToForecast(): List<Forecast> {

    val forecastList = mutableListOf<Forecast>()

    val size = minOf(
        time.size,
        temperature_2m_max.size,
        temperature_2m_min.size,
        sunrise.size,
        sunset.size
    )

    for (i in 0 until size) {
        val forecast = Forecast(
            date = time[i],
            maxTemp = temperature_2m_max[i],
            minTemp = temperature_2m_min[i],
            sunrise = sunrise[i],
            sunset = sunset[i],
            icon = "icon_placeholder" // You need to define how to get the icon value
        )
        forecastList.add(forecast)
    }

    return forecastList

}

fun Hourly.mapHourlyToHour(): List<Hour> {

    val hourlyList = mutableListOf<Hour>()

    val size = minOf(
        time.size,
        temperature2m.size,
    )

    for (i in 0 until size) {
        val forecast = Hour(
            time = time[i],
            temperature = temperature2m[i],
            icon = "icon_placeholder" // You need to define how to get the icon value
        )
        hourlyList.add(forecast)
    }

    return hourlyList

}