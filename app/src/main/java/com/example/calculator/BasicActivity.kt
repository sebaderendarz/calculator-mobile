package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_basic.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class BasicActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic)
    }

    private fun appendOnExpression(string: String, canClear: Boolean) {

        if (resultTV.text.isNotEmpty()) {
            inputTV.text = ""
        }

        if (canClear) {
            resultTV.text = ""
            inputTV.append(string)
        } else {
            inputTV.append(resultTV.text)
            inputTV.append(string)
            resultTV.text = ""
        }
    }

    fun numberAction(view: View) {
        if (view is Button) {
            appendOnExpression(view.text.toString(), true)
        }
    }

    fun operationAction(view: View) {
        if (view is Button) {
            appendOnExpression(view.text.toString(), false)
        }
    }

    fun clearAllAction(view: View) {
        inputTV.text = ""
        resultTV.text = ""
    }

    fun backspaceAction(view: View) {
        val length = inputTV.length()
        if (length > 0)
            inputTV.text = inputTV.text.subSequence(0, length - 1)
        resultTV.text = ""
    }

    fun equalsAction(view: View) {
        try {
            val expression = ExpressionBuilder(inputTV.text.toString()).build()
            val result = expression.evaluate()
            val longResult = result.toLong()
            if (result == longResult.toDouble())
                resultTV.text = longResult.toString()
            else
                resultTV.text = result.toString()

        } catch (e: Exception) {
            if (e.message.isNullOrEmpty()) {
                Toast.makeText(applicationContext, "Invalid expression!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(applicationContext, e.message, Toast.LENGTH_LONG).show()
            }
        }
    }
}
