package com.example.kotlinquizzapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast


class Level1 : AppCompatActivity() {

    private val questions = arrayOf(
        "1. What is the orange part of an egg called?",
        "2. How many legs do insects have?",
        "3. What is a baby kangaroo called?",
        "4. What is the closest planet to the Sun?",
        "5. In which country can you find the Eiffel Tower"

    )

    private val choices = arrayOf(
        arrayOf("Yolk", "Gel", "York", "Woke"),
        arrayOf("Six", "Eight", "Ten", "Two"),
        arrayOf("A Cub", "A pup", "A Joey", "A Kitten"),
        arrayOf("Mercury", "Earth", "Venus", "Mars"),
        arrayOf("USA", "France", "Spain", "Italy")

    )

    private val answer = arrayOf(
        "Yolk",
        "Six",
        "A Joey",
        "Mercury",
        "Italy"

    )
    private lateinit var t: TextView
    private lateinit var que: TextView
    private lateinit var rg: RadioGroup
    private lateinit var btn: Button
    private lateinit var a: RadioButton
    private lateinit var b: RadioButton
    private lateinit var c: RadioButton
    private lateinit var d: RadioButton

    private var score = 0
    private var id = -1
    private var wcount = 0
    private lateinit var sAnswer: String
    private var totalQuestion = questions.size
    private var currentQuestion = 0
    private var current = 1
    private lateinit var selectedAnswer: RadioButton

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level1)

        que = findViewById(R.id.text_view_question)
        rg = findViewById(R.id.radio_group)
         a = findViewById(R.id.a)
        b = findViewById(R.id.b)
        c = findViewById(R.id.c)
        d = findViewById(R.id.d)
        btn = findViewById(R.id.button_confirm_next)
        t = findViewById(R.id.text_view_sco)
        t.text = "Total Question :$currentQuestion/$totalQuestion"
        loadNewQuestion()

       btn.setOnClickListener {
            id = rg.checkedRadioButtonId
            if (currentQuestion < questions.size) {
                if (id < 0) {
                    Toast.makeText(this@Level1 , "select one option", Toast.LENGTH_SHORT).show()
                } else {
                    selectedAnswer = findViewById(id)
                    sAnswer = selectedAnswer.text.toString()
                    if (sAnswer == answer[currentQuestion]) {
                        score++
                        rg.clearCheck()
                        currentQuestion++
                    } else {
                        wcount++
                        currentQuestion++
                        rg.clearCheck()

                    }
                    if (currentQuestion < questions.size) {
                        loadNewQuestion()
                    }
                    else {
                        //Toast.makeText(this@Quize , " NO Question are available", Toast.LENGTH_SHORT).show()
                        if(currentQuestion==questions.size){
                            if(score>4){
                                val intent= Intent(this,great::class.java)

                                intent.putExtra("Scores", score)
                                intent.putExtra("Wrong", wcount)
                                startActivity(intent)
                            }else{
                                val intent=Intent(this,oops::class.java)
                                intent.putExtra("Scores", score)
                                intent.putExtra("Wrong", wcount)
                                startActivity(intent)
                            }
                        }
                    }
                }
            } else {
                Toast.makeText(this@Level1 , " NO Question are available", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun loadNewQuestion() {
        que.text = questions[currentQuestion]
        a.text = choices[currentQuestion][0]
        b.text = choices[currentQuestion][1]
        c.text = choices[currentQuestion][2]
        d.text = choices[currentQuestion][3]
        t.text = "Total Question :$current/$totalQuestion"
        current++
    }
    }



