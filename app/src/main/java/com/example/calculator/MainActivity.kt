package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

lateinit var txtFormula : TextView
lateinit var txtResult : TextView
lateinit var btnClear : Button
lateinit var btnZero : Button
lateinit var btnOne : Button
lateinit var btnTwo : Button
lateinit var btnThree : Button
lateinit var btnFour : Button
lateinit var btnFive : Button
lateinit var btnSix : Button
lateinit var btnSeven : Button
lateinit var btnEight : Button
lateinit var btnNine : Button
lateinit var btnLeftPar : Button
lateinit var btnRightPar : Button
lateinit var btnDivision : Button
lateinit var btnTimes : Button
lateinit var btnMinus : Button
lateinit var btnPlus : Button
lateinit var btnEquals : Button
lateinit var btnDecimal : Button
lateinit var btnBack : Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtFormula = findViewById(R.id.formula)
        txtResult = findViewById(R.id.result)

        btnClear = findViewById(R.id.btn_clear)
        btnZero = findViewById(R.id.btn_0)
        btnOne = findViewById(R.id.btn_1)
        btnTwo = findViewById(R.id.btn_2)
        btnThree = findViewById(R.id.btn_3)
        btnFour = findViewById(R.id.btn_4)
        btnFive = findViewById(R.id.btn_5)
        btnSix = findViewById(R.id.btn_6)
        btnSeven = findViewById(R.id.btn_7)
        btnEight = findViewById(R.id.btn_8)
        btnNine = findViewById(R.id.btn_9)
        btnRightPar = findViewById(R.id.btn_right_par)
        btnLeftPar = findViewById(R.id.btn_left_par)
        btnDivision = findViewById(R.id.btn_division)
        btnTimes = findViewById(R.id.btn_mult)
        btnMinus = findViewById(R.id.btn_minus)
        btnPlus = findViewById(R.id.btn_plus)
        btnEquals = findViewById(R.id.btn_equals)
        btnDecimal = findViewById(R.id.btn_decimal)
        btnBack = findViewById(R.id.btn_back)

        btnZero.setOnClickListener { appendOnExpression("0", true) }
        btnOne.setOnClickListener { appendOnExpression("1", true) }
        btnTwo.setOnClickListener { appendOnExpression("2", true) }
        btnThree.setOnClickListener { appendOnExpression("3", true) }
        btnFour.setOnClickListener { appendOnExpression("4", true) }
        btnFive.setOnClickListener { appendOnExpression("5", true) }
        btnSix.setOnClickListener { appendOnExpression("6", true) }
        btnSeven.setOnClickListener { appendOnExpression("7", true) }
        btnEight.setOnClickListener { appendOnExpression("8", true) }
        btnNine.setOnClickListener { appendOnExpression("9", true) }

        btnPlus.setOnClickListener {appendOnExpression("+", false)}
        btnMinus.setOnClickListener {appendOnExpression("-", false)}
        btnTimes.setOnClickListener {appendOnExpression("*", false)}
        btnDivision.setOnClickListener {appendOnExpression("/", false)}
        btnLeftPar.setOnClickListener {appendOnExpression("(", false)}
        btnRightPar.setOnClickListener {appendOnExpression(")", false)}
        btnDecimal.setOnClickListener {appendOnExpression(".", false)}

        btnClear.setOnClickListener {
            txtFormula.text = ""
            txtResult.text = ""
        }

        btnBack.setOnClickListener {
            val string = txtFormula.text.toString()
            if(string.isNotEmpty()) {
                txtFormula.text = string.substring(0, string.length - 1)
            }
            txtResult.text = ""
        }

        btnEquals.setOnClickListener {
            try {
                val expression = ExpressionBuilder(txtFormula.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if(result == longResult.toDouble()) {
                    txtResult.text = longResult.toString()
                } else {
                    txtResult.text = result.toString()
                }
            }catch (e:Exception) {

            }
        }
    }

    fun appendOnExpression(string: String, canClear: Boolean ) {
        if(txtResult.text.isNotEmpty()) {
            txtFormula.text = ""
        }

        if(canClear) {
            txtResult.text = ""
            txtFormula.append(string)
        }else{
            txtFormula.append(txtResult.text)
            txtFormula.append(string)
            txtResult.text = ""
        }
    }
}