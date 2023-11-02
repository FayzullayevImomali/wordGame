package com.fayzullayev.word_game_app.core

import android.graphics.drawable.Drawable

class GameController(private val data: ArrayList<GameModel>) {

    private val currentLevel = 0;

    fun getImages(): ArrayList<Drawable> {
        return  data[currentLevel].imageList
    }

    private fun getJavob():String {
        return data[currentLevel].answer
    }

    fun getVariant(): String {
        return data[currentLevel].variant
    }

    //TODO : Check qilish logikasi
}