package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_basic.*
import java.lang.Exception

class BasicActivity : AppCompatActivity() {

    private val calculatorManager = CalculatorManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic)
    }

    private fun updateView() {
        inputTV.text = calculatorManager.getExpression()
        resultTV.text = calculatorManager.getResult()
    }

    fun numberAction(view: View) {
        if (view is Button) {
            calculatorManager.appendOnExpression(view.text.toString(), false)
            updateView()
        }
    }

    fun operationAction(view: View) {
        if (view is Button) {
            calculatorManager.appendOnExpression(view.text.toString(), false)
            updateView()
        }
    }

    fun clearAllAction(view: View) {
        calculatorManager.clearALl()
        updateView()
    }

    fun backspaceAction(view: View) {
        calculatorManager.removeLastInputValue()
        updateView()
    }

    fun equalsAction(view: View) {
        try {
            calculatorManager.calculateExpression()
            updateView()
        } catch (e: Exception) {
            if (e.message.isNullOrEmpty()) {
                Toast.makeText(applicationContext, "Invalid expression!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(applicationContext, e.message, Toast.LENGTH_LONG).show()
            }
        }
    }
}
