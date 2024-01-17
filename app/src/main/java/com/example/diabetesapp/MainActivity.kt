package com.example.diabetesapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editTextNumberDecimal)
        resultTextView = findViewById(R.id.textView)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            performShugarCalculations()
        }
    }

    private fun performShugarCalculations() {
        try {
            val inputValue = editText.text.toString().toFloat()
            val resultSugar = inputValue * 18
            if (resultSugar <= 120){
                resultTextView.text = "Result: 0"
            }else{
                val result = (resultSugar -120 ) / 30
                resultTextView.text = "Result: $result"
            }
        } catch (e: NumberFormatException) {
            e.printStackTrace()
            resultTextView.text = "Invalid input"
        }
    }
}
