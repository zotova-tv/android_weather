package ru.gb.weather

object Repository {
    private val weatherList: List<Weather> = listOf()

    fun getWeatherList(): List<Weather> {
        return weatherList
    }
}