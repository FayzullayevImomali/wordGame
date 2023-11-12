package com.fayzullayev.word_game_app
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowId
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import androidx.core.view.forEachIndexed
import com.fayzullayev.word_game_app.core.cache.Cache
import com.fayzullayev.word_game_app.databinding.ActivitySettingsBinding
import java.util.Objects

class SettingsActivity : BaseActivity() {

    private lateinit var binding: ActivitySettingsBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadAction()


    }
    private fun loadAction() {
        binding.themeGroup.forEachIndexed { index, _ ->

            val backgroundImage = binding.themeGroup.getChildAt(index) as ImageView;
            backgroundImage.setOnClickListener{
                when(index){
                    0 -> {Cache.getObject().saveTheme(0)}
                    1 -> {Cache.getObject().saveTheme(1)}
                    2 -> {Cache.getObject().saveTheme(2)}
                }
                binding.bg.setImageDrawable(backgroundImage.drawable)
            }
        }
    }

    override fun setTheme() {
        when (Cache.getObject().getTheme()) {
            0 -> {binding.root.setBackgroundResource(R.drawable.bg_4)}
            1 -> {binding.root.setBackgroundResource(R.drawable.bg_5)}
            2 -> {binding.root.setBackgroundResource(R.drawable.bg_6)}
        }
    }



}