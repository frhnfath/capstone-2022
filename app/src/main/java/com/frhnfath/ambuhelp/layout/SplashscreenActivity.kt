package com.frhnfath.ambuhelp.layout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.frhnfath.ambuhelp.data.preferences.SessionManager
import com.frhnfath.ambuhelp.databinding.ActivitySplashscreenBinding

class SplashscreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashscreenBinding
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        sessionManager = SessionManager(this)
        Log.d("isLogin", "islogin: ${sessionManager.getSession()}")


        Handler().postDelayed({
            if (sessionManager.getSession()) {
                val intent = Intent(this, MapsActivity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
            finish()
        }, 1000)
    }
}