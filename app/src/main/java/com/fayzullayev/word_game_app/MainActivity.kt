package com.fayzullayev.word_game_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.forEach
import androidx.core.view.forEachIndexed
import com.fayzullayev.word_game_app.core.GameController
import com.fayzullayev.word_game_app.core.GameModel
import com.fayzullayev.word_game_app.core.LocalData
import com.fayzullayev.word_game_app.core.util.gone
import com.fayzullayev.word_game_app.core.util.inVisible
import com.fayzullayev.word_game_app.core.util.visible
import com.fayzullayev.word_game_app.databinding.ActivityMainBinding
import org.w3c.dom.Text
import java.lang.StringBuilder
import kotlin.math.sign

class MainActivity : AppCompatActivity() {

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
            var childAt = binding.answerGroup.getChildAt(index) as TextView
            if(index < answerSize) {
                childAt.visible()
            } else {
                childAt.gone()
            }
            childAt.text = ""
        }

        binding.variantGroup.forEachIndexed{index , _ ->
            var child = binding.variantGroup.getChildAt(index) as TextView
            val letter = gameController.getVariant()[index]
            child.text = letter.toString().uppercase()
            child.visible()
        }
        // Show level and coins
        binding.Level.text = "Level: ${gameController.getLevel().toString()}"
        binding.showCoins.text = "Coins: ${gameController.getCoin().toString()}"

    }

    fun loadAction() {
        var answerState = 0
        val answerSize = gameController.getAnsSize()
        for (i in 0 until  binding.variantGroup.childCount) {
            val variant = binding.variantGroup.getChildAt(i) as TextView
            variant.id = i

            variant.setOnClickListener{
                if(answerState < answerSize) {
                    variant.inVisible()
                    val letter = variant.text
                    val textView =  binding.answerGroup.getChildAt(answerState) as TextView
                    textView.text = letter
                    textView.id = variant.id
                    answerState++


                    if(answerState == answerSize) {
                        val userAnswer = getUserAnswer()
                        if(gameController.checkAnswer(userAnswer)){
                            loadView()
                        } else {
                            Toast.makeText(this, "Incorrect answer", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
        // Return letter's to own place
        for (i in 0 until binding.answerGroup.childCount) {
            val answerField = binding.answerGroup.getChildAt(i) as TextView
            answerField.setOnClickListener {
                answerField.text = ""
//                answerField.text  = (answerField.id).toString();
                val variantKeyboard = binding.variantGroup.getChildAt(answerField.id) as TextView
                if(variantKeyboard.visibility == View.INVISIBLE) {
                    variantKeyboard.visible()
                    answerState --
                }
            }

        }
    }
}