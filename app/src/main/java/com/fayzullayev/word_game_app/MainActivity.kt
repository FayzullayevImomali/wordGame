package com.fayzullayev.word_game_app

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.forEachIndexed
import com.fayzullayev.word_game_app.core.GameController
import com.fayzullayev.word_game_app.core.LocalData
import com.fayzullayev.word_game_app.core.cache.Cache
import com.fayzullayev.word_game_app.core.util.gone
import com.fayzullayev.word_game_app.core.util.inVisible
import com.fayzullayev.word_game_app.core.util.visible
import com.fayzullayev.word_game_app.databinding.ActivityMainBinding
import java.lang.StringBuilder

class MainActivity : BaseActivity() {

    private lateinit var binding :ActivityMainBinding
    private lateinit var gameController: GameController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        gameController = GameController(LocalData.getAllData(this))


        loadView()

        loadAction()


    }

//    override fun onDestroy() {
//        super.onDestroy()
//        binding = null;
//    }

    private fun getUserAnswer():String {
        val javob = StringBuilder()
        binding.answerGroup.forEachIndexed{ index, _ ->
            val child = binding.answerGroup.getChildAt(index) as TextView
            javob.append(child.text.toString())
        }
        return javob.toString()
    }

    fun loadView() {
        binding.imageGroup.forEachIndexed {index ,_ ->
            var imageView = binding.imageGroup.getChildAt(index) as ImageView
            var imageData = gameController.getImages()[index]
            imageView.setImageDrawable(imageData)
        }



        val answerSize = gameController.getAnsSize()
        binding.answerGroup.forEachIndexed { index, _ ->
            val childAt = binding.answerGroup.getChildAt(index) as TextView
            if(index < answerSize) {
                childAt.visible()
            } else {
                childAt.gone()
            }
            childAt.text = ""
        }

        binding.variantGroup.forEachIndexed{index , _ ->
            val child = binding.variantGroup.getChildAt(index) as TextView
            val letter = gameController.getVariant()[index]
            child.text = letter.toString().uppercase()
            child.tag = index
            child.visible()
        }
        // Show level and coins
        binding.Level.text = "Level: ${gameController.getLevel().toString()}"
        binding.showCoins.text = "Coins: ${gameController.getCoin().toString()}"

    }

    fun loadAction() {
        var answerState = 0
        var answerControl = 0
        var tempState = 0
        var indexAnswer = 0;

        val answerSize = gameController.getAnsSize()
        for (i in 0 until  binding.variantGroup.childCount) {
            val variant = binding.variantGroup.getChildAt(i) as TextView
            variant.tag = i


            variant.setOnClickListener{
                if(answerState < answerSize ) {
                    if(tempState == 0) answerState = 0
                    variant.inVisible()
                    val letter = variant.text
                    val textView =  binding.answerGroup.getChildAt(answerState) as TextView
                    answerState = tempState
                    textView.text = letter
                    textView.tag = variant.tag
                    answerState++
                    tempState++

                    if(answerState == answerSize) {
                       if(gameController.isFinish()) {
                           binding.dialogWindow.visible()
                           binding.restartYES.setOnClickListener {
                               loadView();
                               loadAction()
                               binding.dialogWindow.gone()
                           }

                           binding.restartNO.setOnClickListener {
                              val intent  = Intent(this, ResultActivity::class.java)
                               startActivity(intent)
                           }
                        } else {
                           val userAnswer = getUserAnswer()
                           if(gameController.checkAnswer(userAnswer)){
                               loadView()
                               loadAction()
                           }   else {
                               Toast.makeText(this, "Incorrect Answer", Toast.LENGTH_SHORT).show()
                           }
                        }
                    }
                }
            }
        }

         //Return letter's to own place
        for (i in 0 until binding.answerGroup.childCount) {
            val answerField = binding.answerGroup.getChildAt(i) as TextView
            answerField.tag = i

            answerField.setOnClickListener {
                if(answerField.text != "") {
                    answerField.text = ""
                    val indicator = answerField.tag.toString().toInt();
                    val variantKeyboard = binding.variantGroup.getChildAt(indicator) as TextView
                    if(variantKeyboard.visibility == View.INVISIBLE) {
                        variantKeyboard.visible()
                        answerControl = answerField.tag.toString().toInt()
                        answerState --;
                        tempState--;
                        if(answerState != answerControl ) {
                            answerState = answerControl
                        }
                        Log.d("taaaag", "loadAction: " + tempState);
                    }
                }
            }

        }



//        for(i in 0 until binding.answerGroup.childCount) {
//            val childAnswer = binding.answerGroup.getChildAt(i) as TextView
//            childAnswer.setOnClickListener {
//                for (j in 0 until binding.variantGroup.childCount) {
//                    val childVariant = binding.variantGroup.getChildAt(j) as TextView
//                    if(childAnswer.tag == childVariant.tag) {
//                        childAnswer.text = "";
//                        childVariant.visible()
//                        answerState--;
//
//                    }
//                }
//            }
//        }
    }



    override fun setTheme() {
        when (Cache.getObject().getTheme()) {
            0 -> {binding.root.setBackgroundResource(R.drawable.bg_4)}
            1 -> {binding.root.setBackgroundResource(R.drawable.bg_5)}
            2 -> {binding.root.setBackgroundResource(R.drawable.bg_6)}
        }
    }

}