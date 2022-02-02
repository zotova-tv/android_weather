package ru.gb.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text
import ru.gb.weather.R

class MainActivity : AppCompatActivity() {

    private val TAG = "lalala "

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val testButton = findViewById<Button>(R.id.test_button)
        val testText = findViewById<TextView>(R.id.test_text)
        val weatherText = findViewById<TextView>(R.id.weather_text)

        val weatherMoscow = Weather("Moscow", -2)
        val weatherSochi = weatherMoscow.copy(town = "Sochi", temperature = 15)
        weatherText.setText(
                weatherMoscow.town + " " + weatherMoscow.temperature + "\n"
                        + weatherSochi.town + " " + weatherSochi.temperature,
        )

        Log.d(TAG, "onCreate() called with: savedInstanceState = $savedInstanceState")

        var weatherList = Repository.getWeatherList()
        weatherList = weatherList.plus(weatherMoscow)
        weatherList = weatherList.plus(weatherSochi)
        println("WEATHER LIST$weatherList")
        for(weather in weatherList){
            println("${weather.town} ${weather.temperature}")
        }
        for(i in 1..10) {
            print("loop $i ")
        }

        for(i in 10 downTo 1 step 2){
            println(i)
        }

        for(i in 0 until weatherList.size){
            println(weatherList[i])
        }

        var counter: Int = 0
        testButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val someData = SomeData("Title " + counter, "Text " + counter)
                testText.setText(someData.title + " " + someData.text)
                counter++
            }
        })
    }
}