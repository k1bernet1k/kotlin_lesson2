package com.example.lesson_2
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity() {

    private lateinit var edName: EditText
    private lateinit var edAge: EditText
    private lateinit var resultTV: TextView

    private val code = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        edAge = findViewById(R.id.edit_text_age)
        edName = findViewById(R.id.edit_text_name)



        findViewById<Button>(R.id.next).setOnClickListener {
            next(edName.text.toString(), edAge.text.toString())
        }
    }

    fun next(name: String, age: String) {
        if (name.isNotEmpty() && age.isNotEmpty()) {
            val intent = Intent(
                this,
                MainActivity2::class.java
            ) // переход на активити MainActivity2 явный intent
            intent.putExtra("age", age.toInt())
            intent.putExtra("name", name)
            startActivity(intent)
//            startActivityForResult(intent, code) // положительное число
        } else {
            Toast.makeText(this, "Заполните все поля", Toast.LENGTH_LONG).show()
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}