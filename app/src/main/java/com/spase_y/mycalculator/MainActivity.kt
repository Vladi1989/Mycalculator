package com.spase_y.mycalculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.buttonCalculate)
        val firstNumber = findViewById<EditText>(R.id.firstNumber)
        val symbol = findViewById<EditText>(R.id.symbol)
        val secondNumber = findViewById<EditText>(R.id.secondNumber)
        val result = findViewById<TextView>(R.id.result)

        button.setOnClickListener {
            if (firstNumber.text.isNotEmpty() && secondNumber.text.isNotEmpty() && symbol.text.isNotEmpty()){
                when (symbol.text.toString()){
                    "+" -> {
                        result.text = (firstNumber.text.toString().toDouble() + secondNumber.text.toString().toDouble()).toString()
                    }
                    "-" -> {
                        result.text = (firstNumber.text.toString().toDouble() - secondNumber.text.toString().toDouble()).toString()
                    }
                    "*" -> {
                        result.text = (firstNumber.text.toString().toDouble() * secondNumber.text.toString().toDouble()).toString()
                    }
                    "/" -> {
                        if (secondNumber.text.toString().toDouble() != 0.0) {
                            result.text = "${
                                (firstNumber.text.toString().toDouble() / secondNumber.text.toString()
                                    .toDouble())}"
                        } else {
                            Toast.makeText(applicationContext,"На ноль делить нельзя",Toast.LENGTH_SHORT).show()
                            secondNumber.error = "Error"
                        }
                    }
                    else -> {
                        Toast.makeText(applicationContext,
                            "          Вы ввели ${symbol.text} \nя не знаю такого знака",Toast.LENGTH_SHORT).show()
                        symbol.error = "Error"
                    }
                }
            }

            else {

                if (firstNumber.text.isEmpty()) {
                    firstNumber.error = "Error"
                    Toast.makeText(
                        applicationContext,
                        "Первое поле пустое", Toast.LENGTH_SHORT
                    ).show()
                }
                if (secondNumber.text.isEmpty()) {
                    secondNumber.error = "Error"
                    Toast.makeText(
                        applicationContext,
                        "Второе поле пустое", Toast.LENGTH_SHORT
                    ).show()
                }
                if (symbol.text.isEmpty()) {
                    symbol.error = "Error"
                    Toast.makeText(
                        applicationContext,
                        "Вы не ввели знак", Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}
