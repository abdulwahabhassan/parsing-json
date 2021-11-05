package com.hassan.parsingjson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.hassan.parsingjson.model.LatestRates
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("jsonTesting", loadJsonFromAsset().toString())

    }

    private fun loadJsonFromAsset(): LatestRates? {
        val json: LatestRates?

        try {
            //use InputStream to open the file and stream the data into it.
            val stream = assets.open("test_json_file.json")
            //create a variable to store the size of the file.
            val size = stream.available()
            //create a buffer of the size of the file.
            val buffer = ByteArray(size)
            //read the inputStream file into the buffer.
            stream.read(buffer)
            //close the inputStream file.
            stream.close()
            //convert the buffer file to the format in which you need your data.
            val stringJson = String(buffer, charset("UTF-8"))
            val gson = Gson()
            json = gson.fromJson(stringJson, LatestRates::class.java)

        } catch (e: IOException) {
            e.printStackTrace()
            return null
        }
        return json
    }
}