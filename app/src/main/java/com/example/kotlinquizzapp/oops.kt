package com.example.kotlinquizzapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class oops : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oops)
        val s = findViewById<TextView>(R.id.right)

        val i= intent
        val score =i.getIntExtra("Scores",0)
        val wcount = i.getIntExtra("wrong",0)
        s.text="scores:$score"

        val btn= findViewById<Button>(R.id.restart)
        btn.setOnClickListener {
            val intent= Intent(this,GameLevels::class.java)
            startActivity(intent)
        }
    }
}