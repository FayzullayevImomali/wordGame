package com.fayzullayev.word_game_app.core

import android.graphics.drawable.Drawable

class GameController(private val data: ArrayList<GameModel>) {

    private var currentLevel = 0;

    private var coin = 0;

    fun getCurrentLevelData():GameModel {
        return data[currentLevel]
    }



    fun getImages(): ArrayList<Drawable> {
        return  getCurrentLevelData().imageList
    }

    private fun getJavob():String {
        return getCurrentLevelData().answer
    }

    public fun getVariant(): String {
        return getCurrentLevelData().variant
    }

    fun getAnsSize ():Int{
        return getJavob().length
    }

    fun getCoin(): Int {
        return coin;
    }

    fun getLevel():Int {
        return currentLevel + 1;
    }

    //TODO : Check qilish logikasi


    fun checkAnswer (userAnswer: String):Boolean {
        if(userAnswer.lowercase() == getJavob().lowercase()) {
            currentLevel++;
            coin+=5;
            return true
        }
        return false
    }

    fun isFinish():Boolean {
        return currentLevel + 1 == data.size
    }

}