package com.fayzullayev.word_game_app.core.app

import android.app.Application
import com.fayzullayev.word_game_app.core.LocalData

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        LocalData.loadImage(this)
    }
}