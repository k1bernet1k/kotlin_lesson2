package com.example.lesson_2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity2 : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var edFinish: EditText
//    private lateinit var finish: Button
    private lateinit var resultTV: TextView
    private lateinit var edMoney: EditText
    private val code = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main2_activity)

        val thisIntent = intent // intent == getIntent/setIntent
        textView = findViewById(R.id.text_view)
        val name = thisIntent.getStringExtra("name")
        val age = thisIntent.getIntExtra("age", 0)
        resultTV = findViewById(R.id.result)

        textView.text =
            "Имя = ${thisIntent.getStringExtra("name")} \nВозраст = $age" // text = "smthg" equals setText("smthg")


        edMoney = findViewById(R.id.edit_text_money)

        findViewById<Button>(R.id.next).setOnClickListener {
            next(edMoney.text.toString())
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && data != null && requestCode == code) {
            val val1 = data.getIntExtra("money", 0)
            val val2 = data.getIntExtra("month", 0)
            val result = val1 * val2
//            resultTV.text = data.getStringExtra("result")
            resultTV.text= "Вы заработали сумму: $result \nза $val2 месяц"
        }
    }
fun next(money: String) {
    if (money.isNotEmpty()) {
        val intent = Intent(
                this,
                MainActivity3::class.java
        ) // переход на активити MainActivity2 явный intent
        intent.putExtra("money", money.toInt())
//        startActivity(intent)
            startActivityForResult(intent, code) // положительное число
    } else {
        Toast.makeText(this, "Заполните все поля", Toast.LENGTH_LONG).show()
    }
}
}