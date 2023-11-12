package com.fayzullayev.word_game_app

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.fayzullayev.word_game_app.core.cache.Cache
import com.fayzullayev.word_game_app.databinding.ActivityStartBinding

class StartActivity : BaseActivity() {

    private lateinit var binding: ActivityStartBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater);
        setContentView(binding.root)

        binding.start.setOnClickListener{
            startActivity(Intent(this, SettingsActivity::class.java));
        }

        binding.play.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java));
        }

        binding.quiteGame.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("Quite")
            dialog.setMessage("Do you want to exit?")
            dialog.setCancelable(false)
            dialog.setPositiveButton("Yes", {_ , _ -> finish()})
            dialog.setNegativeButton("No", {dialog , _ -> dialog.cancel() })
            dialog.show()
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