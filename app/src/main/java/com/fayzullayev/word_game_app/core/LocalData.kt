package com.fayzullayev.word_game_app.core

import android.content.Context
import android.graphics.drawable.Drawable
//import org.junit.runner.manipulation.Ordering.Context

object LocalData  {

    private val data = ArrayList<GameModel>();

    fun getAllData(context: Context): ArrayList<GameModel> {

        var loadImage = loadImage(context = context)

       data.add(GameModel(1, arrayListOf<Drawable>(loadImage[0], loadImage[1], loadImage[2], loadImage[3]), "happy", "aabscdsssefs"))
       data.add(GameModel(1, arrayListOf<Drawable>(), "boring", "aabboringsefs"))
       return data
    }

    fun loadImage(context: Context): ArrayList<Drawable> {
        val dList = ArrayList<Drawable>()
        val images = context.assets.list("images")!!

        images.forEach {

            if(it.startsWith("happy_")) {
                val iStream = context.assets.open("images/$it")
                val drawable = Drawable.createFromStream(iStream, null)
                drawable?.let { d -> dList.add(d) }
            }
        }

        return dList;
    }


}