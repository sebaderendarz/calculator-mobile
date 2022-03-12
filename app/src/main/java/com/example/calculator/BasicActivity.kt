package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_advanced.*
import kotlinx.android.synthetic.main.activity_basic.*
import kotlinx.android.synthetic.main.activity_basic.inputTV
import kotlinx.android.synthetic.main.activity_basic.resultTV
import java.lang.Exception

class BasicActivity : AppCompatActivity() {
    private val calculatorManager = CalculatorManager()
    private val inputTextKey = "INPUT_TV"
    private val resultTextKey = "RESULT_TV"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(inputTextKey, calculatorManager.getExpression())
        outState.putString(resultTextKey, calculatorManager.getResult())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        inputTV.text = savedInstanceState.getString(inputTextKey)
        resultTV.text = savedInstanceState.getString(resultTextKey)
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
