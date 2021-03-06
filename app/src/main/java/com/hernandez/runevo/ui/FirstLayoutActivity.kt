package com.hernandez.runevo.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.hernandez.runevo.R

class FirstLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_layout)

        Handler().postDelayed({
            val intent = Intent(this@FirstLayoutActivity, iniciarSesion::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}