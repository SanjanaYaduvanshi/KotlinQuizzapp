package com.example.kotlinquizzapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class GameLevels : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_levels)
        val imageView=findViewById<ImageView>(R.id.bgview)
        val textView = findViewById<TextView>(R.id.gamelevel)
        val imageView2=findViewById<ImageView>(R.id.star1)
        imageView2.setOnClickListener {
            val intent = Intent(this,Level1::class.java)
            startActivity(intent)

        }
        val imageView3=findViewById<ImageView>(R.id.star2)
        imageView3.setOnClickListener {
            val intent = Intent(this,Level2::class.java)
            startActivity(intent)

        }
        val imageView4=findViewById<ImageView>(R.id.star3)
        imageView4.setOnClickListener {
            val intent = Intent(this,Level3::class.java)
            startActivity(intent)

        }
        val imageView5=findViewById<ImageView>(R.id.star4)
        imageView5.setOnClickListener {
            val intent = Intent(this,Level4::class.java)
            startActivity(intent)

        }

    }
}