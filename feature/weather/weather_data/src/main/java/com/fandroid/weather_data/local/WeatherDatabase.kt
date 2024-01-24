package com.fandroid.weather_data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.fandroid.weather_data.local.entity.WeatherEntity

@Database(
    entities = [WeatherEntity::class],
    version = 1
)
@TypeConverters(WeatherConverter::class)
abstract class WeatherDatabase: RoomDatabase() {
    abstract val dao: WeatherDao
}