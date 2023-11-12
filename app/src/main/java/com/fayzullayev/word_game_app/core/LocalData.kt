package com.fayzullayev.word_game_app.core

import android.content.Context
import android.graphics.drawable.Drawable
//import org.junit.runner.manipulation.Ordering.Context

object LocalData  {

    private val data = ArrayList<GameModel>();

    fun getAllData(context: Context): ArrayList<GameModel> {

        var loadImage = loadImage(context = context)


       data.add(GameModel(1, arrayListOf<Drawable>(loadImage[0], loadImage[1], loadImage[2], loadImage[3]), "happy", "hspdaspdsydc"))
//       data.add(GameModel(2, arrayListOf<Drawable>(loadImage[4], loadImage[5], loadImage[6], loadImage[7]), "key", "daksepdysydc"))
//       data.add(GameModel(3, arrayListOf<Drawable>(loadImage[8], loadImage[9], loadImage[10], loadImage[11]), "boring", "dbaokrsienpg"))
//       data.add(GameModel(4, arrayListOf<Drawable>(loadImage[12], loadImage[13], loadImage[14], loadImage[15]), "sad", "oksrdsiaenpg"))
//       data.add(GameModel(5, arrayListOf<Drawable>(loadImage[16], loadImage[17], loadImage[18], loadImage[19]), "gift", "okfsgaientpg"))
//       data.add(GameModel(6, arrayListOf<Drawable>(loadImage[20], loadImage[21], loadImage[22], loadImage[23]), "look", "oklsgaoenopk"))
//       data.add(GameModel(6, arrayListOf<Drawable>(loadImage[24], loadImage[25], loadImage[26], loadImage[27]), "afraid", "oalsfadrnaik"))

       return data
    }

    fun loadImage(context: Context): ArrayList<Drawable> {
        val dList = ArrayList<Drawable>()
        val images = context.assets.list("images")!!

        images.forEach {

            if(it.startsWith("image_", 0)) {
                val iStream = context.assets.open("images/$it")
                val drawable = Drawable.createFromStream(iStream, null)
                drawable?.let { d -> dList.add(d) }
            }
        }

        return dList;
    }


}