package com.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlin.system.exitProcess

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val buttonBasic:Button = findViewById(R.id.basic)
        buttonBasic.setOnClickListener {
            val intent = Intent(this@HomeActivity, BasicActivity::class.java)
            startActivity(intent)
        }

        val buttonAdvanced:Button = findViewById(R.id.advanced)
        buttonAdvanced.setOnClickListener {
            val intent = Intent(this@HomeActivity, AdvancedActivity::class.java)
            startActivity(intent)
        }

        val buttonAbout:Button = findViewById(R.id.about)
        buttonAbout.setOnClickListener {
            val intent = Intent(this@HomeActivity, AboutActivity::class.java)
            startActivity(intent)
        }
    }

    fun quitApp(view: View) {
        this@HomeActivity.finish()
        exitProcess(0)
    }
}