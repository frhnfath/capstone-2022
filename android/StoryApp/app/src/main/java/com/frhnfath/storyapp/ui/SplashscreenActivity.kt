package com.frhnfath.storyapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.frhnfath.storyapp.databinding.ActivitySplashscreenBinding

class SplashscreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashscreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, CameraActivity::class.java)
            startActivity(intent)
            finish()
        }, 1500)
    }
}