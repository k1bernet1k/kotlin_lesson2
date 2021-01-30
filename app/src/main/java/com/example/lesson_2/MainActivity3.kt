package com.example.lesson_2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity3 : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var edFinish: EditText
    private lateinit var finish: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main3_activity)

        val thisIntent = intent // intent == getIntent/setIntent
        textView = findViewById(R.id.text_view)
        edFinish = findViewById(R.id.edit_text_month)
        finish = findViewById(R.id.finish)
        val money = thisIntent.getIntExtra("money", 0)
        textView.text =
                "Зарплата = $money" // text = "smthg" equals setText("smthg")


        finish.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra("money", money)
            resultIntent.putExtra("month", if (edFinish.text.toString().isNotEmpty()) edFinish.text.toString().toInt() else "Нет данных")

            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}