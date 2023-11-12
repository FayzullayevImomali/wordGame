package com.fayzullayev.word_game_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.fayzullayev.word_game_app.core.cache.Cache

abstract class BaseActivity :AppCompatActivity() {

    override fun onResume() {
        super.onResume()
        setTheme()
    }
    abstract fun setTheme();

}