package com.fayzullayev.word_game_app.core.cache

import android.content.Context
import android.content.SharedPreferences

class Cache private constructor(context: Context) {

    private val KEY_THEME = "THEME_KEY"

    init{
        sharedPreferences = context.getSharedPreferences("cache", Context.MODE_PRIVATE);
    }

    companion object {
        private var appCache: Cache? = null;
        private var sharedPreferences: SharedPreferences? = null;


        fun init (context: Context) {
            if(appCache == null) {
                appCache = Cache(context)
            }
        }

        fun getObject(): Cache
        {
            return appCache!!;
        }

    }

    fun saveTheme(son: Int ) {
        sharedPreferences!!.edit().putInt(KEY_THEME,son ).apply()
    }


    fun getTheme():Int {
        return sharedPreferences!!.getInt(KEY_THEME, 0);
    }

}