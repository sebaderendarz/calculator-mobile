package com.example.calculator

import net.objecthunter.exp4j.ExpressionBuilder

class CalculatorManager {
    private var expression: String = ""
    private var result: String = ""

    fun appendOnExpression(string: String, canClear: Boolean) {
        if (result.isNotEmpty()) {
            expression = ""
        }

        var stringVal = string
        when (string) {
            "sin" -> stringVal = "sin("
            "cos" -> stringVal = "cos("
            "tan" -> stringVal = "tan("
            "sqrt" -> stringVal = "sqrt("
            "x^2" -> stringVal = "^2"
            "x^y" -> stringVal = "^"
            "ln" -> stringVal = "ln("
            "log" -> stringVal = "log("
        }

        if (canClear) {
            result = ""
            expression += stringVal
        } else {
            expression += result
            expression += stringVal
            result = ""
        }
    }

    fun calculateExpression() {
        val convertedExpression = expression.replace("log", "log10").replace("ln", "log")
        val mathExpression = ExpressionBuilder(convertedExpression).build()
        val expResult = mathExpression.evaluate()
        val longResult = expResult.toLong()
        result = if (expResult == longResult.toDouble()) {
            longResult.toString()
        } else {
            expResult.toString()
        }
    }

    fun clearALl() {
        expression = ""
        result = ""
    }

    fun getExpression(): String {
        return expression
    }

    fun getResult(): String {
        return result
    }

    fun removeLastInputValue() {
        if (expression.isNotEmpty())
            expression = expression.subSequence(0, expression.length - 1).toString()
        result = ""
    }

    fun setExpression(string: String) {
        expression = string
    }

    fun setResult(string: String) {
        result = string
    }
}
