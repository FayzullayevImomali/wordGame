package com.fayzullayev.word_game_app
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowId
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import java.util.Objects

class SettingsActivity : AppCompatActivity() {

    private lateinit var spinner: Spinner;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        spinner = findViewById(R.id.spinner);
        val listItem = listOf("Ocean", "GreenNature", "Mountains")

    }

}