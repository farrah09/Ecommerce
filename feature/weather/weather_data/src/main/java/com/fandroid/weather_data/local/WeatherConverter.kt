package com.fandroid.weather_data.local

import androidx.room.TypeConverter
import com.fandroid.weather_data.remote.dto.Current
import com.fandroid.weather_data.remote.dto.CurrentUnits
import com.fandroid.weather_data.remote.dto.Daily
import com.fandroid.weather_data.remote.dto.DailyUnits
import com.fandroid.weather_data.remote.dto.Hourly
import com.fandroid.weather_data.remote.dto.HourlyUnits
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONObject

class WeatherConverter {

    @TypeConverter
    fun toStringList(listOfString: List<String?>?): String? {
        return Gson().toJson(listOfString)
    }

    @TypeConverter
    fun fromStringList(listOfString: String?): List<String?>? {
        return Gson().fromJson(
            listOfString,
            object : TypeToken<List<String?>?>() {}.type
        )
    }

    @TypeConverter
    fun fromCurrent(current: Current): String {
        return Gson().toJson(current)
    }

    @TypeConverter
    fun toCurrent(current: String): Current {
        return Gson().fromJson(
            current,
            object : TypeToken<List<String?>?>() {}.type
        )
    }

    @TypeConverter
    fun fromCurrentUnits(currentUnits: CurrentUnits): String {
        return Gson().toJson(currentUnits)
    }

    @TypeConverter
    fun toCurrentUnits(currentUnits: String): CurrentUnits {
        return Gson().fromJson(
            currentUnits,
            object : TypeToken<List<String?>?>() {}.type
        )
    }

    @TypeConverter
    fun fromDaily(daily: Daily): String {
        return Gson().toJson(daily)
    }

    @TypeConverter
    fun toDaily(daily: String): Daily {
        return Gson().fromJson(
            daily,
            object : TypeToken<List<String?>?>() {}.type
        )
    }

    @TypeConverter
    fun fromDailyUnits(dailyUnits: DailyUnits): String {
        return Gson().toJson(dailyUnits)
    }

    @TypeConverter
    fun toDailyUnits(dailyUnits: String): DailyUnits {
        return Gson().fromJson(
            dailyUnits,
            object : TypeToken<List<String?>?>() {}.type
        )
    }

    @TypeConverter
    fun fromHourly(hourly: Hourly): String {
        return Gson().toJson(hourly)
    }

    @TypeConverter
    fun toHourly(daily: String): Hourly {
        return Gson().fromJson(
            daily,
            object : TypeToken<List<String?>?>() {}.type
        )
    }

    @TypeConverter
    fun fromHourlyUnits(hourlyUnits: HourlyUnits): String {
        return Gson().toJson(hourlyUnits)
    }

    @TypeConverter
    fun toHourlyUnits(hourlyUnits: String): HourlyUnits {
        return Gson().fromJson(
            hourlyUnits,
            object : TypeToken<List<String?>?>() {}.type
        )
    }

}
