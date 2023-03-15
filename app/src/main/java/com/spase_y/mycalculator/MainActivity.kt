package com.spase_y.mycalculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnCalculate = findViewById<Button>(R.id.buttonCalculate)
        val etFirstNumber = findViewById<EditText>(R.id.firstNumber)
        val etSymbol = findViewById<EditText>(R.id.symbol)
        val etSecondNumber = findViewById<EditText>(R.id.secondNumber)
        val tvResult = findViewById<TextView>(R.id.result)

        btnCalculate.setOnClickListener {
            if (etFirstNumber.text.isNotEmpty() && etSecondNumber.text.isNotEmpty() && etSymbol.text.isNotEmpty()){
                when (etSymbol.text.toString()){
                    "+" -> {
                        var resultText:Any = (etFirstNumber.text.toString().toDouble() + etSecondNumber.text.toString().toDouble()).toString()
                        printer(tvResult,resultText)
                    }
                    "-" -> {
                        var resultText:Any = (etFirstNumber.text.toString().toDouble() - etSecondNumber.text.toString().toDouble()).toString()
                        printer(tvResult,resultText)
                    }
                    "*" -> {
                        var resultText:Any = (etFirstNumber.text.toString().toDouble() * etSecondNumber.text.toString().toDouble()).toString()
                        printer(tvResult,resultText)
                    }
                    "/" -> {
                        if (etSecondNumber.text.toString().toDouble() != 0.0) {
                            var resultText:Any = "${
                                (etFirstNumber.text.toString().toDouble() / etSecondNumber.text.toString()
                                    .toDouble())}"
                            printer(tvResult,resultText)
                        } else {
                            Toast.makeText(applicationContext,"На ноль делить нельзя",Toast.LENGTH_SHORT).show()
                            etSecondNumber.error = "Error"
                        }
                    }
                    "^" -> {
                        val cor: Double = etFirstNumber.text.toString().toDouble()
                        val resultText = cor.pow(etSecondNumber.text.toString().toDouble()).toString()
                        printer(tvResult,resultText)


                    }

                    else -> {
                        Toast.makeText(applicationContext,
                            "          Вы ввели ${etSymbol.text} \nя не знаю такого знака",Toast.LENGTH_SHORT).show()
                        etSymbol.error = "Error"
                    }
                }
            }

            else {

                if (etFirstNumber.text.isEmpty()) {
                    etFirstNumber.error = "Error"
                    Toast.makeText(
                        applicationContext,
                        "Первое поле пустое", Toast.LENGTH_SHORT
                    ).show()
                }
                if (etSecondNumber.text.isEmpty()) {
                    etSecondNumber.error = "Error"
                    Toast.makeText(
                        applicationContext,
                        "Второе поле пустое", Toast.LENGTH_SHORT
                    ).show()
                }
                if (etSymbol.text.isEmpty()) {
                    etSymbol.error = "Error"
                    Toast.makeText(
                        applicationContext,
                        "Вы не ввели знак", Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}
fun printer(result:TextView, resultText:Any){
    var resultText2 = resultText
    if (isInt(resultText.toString().toDouble())){
        resultText2 = resultText.toString().dropLast(2).toInt()
    }
    result.text = resultText2.toString()
}

fun isInt(a:Double):Boolean{
    val aString = a.toString()
    val len = aString.length //3
    val lastS = aString.get(len-1)

    return lastS == '0'
}


