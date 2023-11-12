package com.fayzullayev.word_game_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fayzullayev.word_game_app.core.cache.Cache

class ResultActivity : BaseActivity() {

    override fun setTheme() {
//        when (Cache.getObject().getTheme()) {
//            0 -> {binding.root.setBackgroundResource(R.drawable.bg_4)}
//            1 -> {binding.root.setBackgroundResource(R.drawable.bg_5)}
//            2 -> {binding.root.setBackgroundResource(R.drawable.bg_6)}
//        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
    }

//    override fun setTheme() {
//        when (Cache.getObject().getTheme()) {
//            0 -> {binding.root.setBackgroundResource(R.drawable.bg_4)}
//            1 -> {binding.root.setBackgroundResource(R.drawable.bg_5)}
//            2 -> {binding.root.setBackgroundResource(R.drawable.bg_6)}
//        }
//    }


}