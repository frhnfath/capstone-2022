package com.frhnfath.submssion2.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.frhnfath.submssion2.MainActivity
import com.frhnfath.submssion2.R

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        supportActionBar?.hide()

        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}