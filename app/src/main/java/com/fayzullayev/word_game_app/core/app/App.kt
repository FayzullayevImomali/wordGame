package com.fayzullayev.word_game_app.core.app

import android.app.Application
import com.fayzullayev.word_game_app.core.LocalData
import com.fayzullayev.word_game_app.core.cache.Cache

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        LocalData.loadImage(this)
        Cache.init(this);
    }
}