package com.fayzullayev.word_game_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import android.widget.ImageView
import androidx.core.view.forEachIndexed
import com.fayzullayev.word_game_app.core.GameController
import com.fayzullayev.word_game_app.core.LocalData

class MainActivity : AppCompatActivity() {

    private var gameCollection: GameController? = null

    private var imageGroup : GridLayout? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gameCollection = GameController(LocalData.getAllData(this))

        imageGroup = findViewById(R.id.imageGroup)

        imageGroup?.forEachIndexed {index, _ ->
            val image = imageGroup?.getChildAt(index) as ImageView
            val imageData = gameCollection!!.getImages()[index]
            image.setImageDrawable(imageData)
        }
    }
}