package com.frhnfath.storyapp.ui

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import com.frhnfath.storyapp.R
import com.frhnfath.storyapp.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setMyButtonEnabled()
        playAnimation()

        binding.edtPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                setMyButtonEnabled()
            }

            override fun onTextChanged(s: CharSequence?, p1: Int, before: Int, count: Int) {
                setMyButtonEnabled()
            }

            override fun afterTextChanged(p0: Editable?) {
                // Do nothing
            }
        })

        binding.signInButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun playAnimation() {
        ObjectAnimator.ofFloat(binding.logo, View.TRANSLATION_X, -30f, 30f).apply {
            duration = 6000
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }.start()

        val title = ObjectAnimator.ofFloat(binding.tvRegister, View.ALPHA, 1f).setDuration(500)
        val tvUsername = ObjectAnimator.ofFloat(binding.tvUsername, View.ALPHA, 1f).setDuration(500)
        val edtUsername = ObjectAnimator.ofFloat(binding.edtUsername, View.ALPHA, 1f).setDuration(500)
        val tvEmail = ObjectAnimator.ofFloat(binding.tvEmail, View.ALPHA, 1f).setDuration(500)
        val edtEmail = ObjectAnimator.ofFloat(binding.edtEmail, View.ALPHA, 1f).setDuration(500)
        val tvPassword = ObjectAnimator.ofFloat(binding.tvPassword, View.ALPHA, 1f).setDuration(500)
        val edtPassword = ObjectAnimator.ofFloat(binding.edtPassword, View.ALPHA, 1f).setDuration(500)
        val registerButton = ObjectAnimator.ofFloat(binding.registerButton, View.ALPHA, 1f).setDuration(500)
        val tvLogin = ObjectAnimator.ofFloat(binding.tvLogin, View.ALPHA, 1f).setDuration(500)
        val loginButton = ObjectAnimator.ofFloat(binding.signInButton, View.ALPHA, 1f).setDuration(500)

        val togetherUsername = AnimatorSet().apply {
            playTogether(tvUsername, edtUsername)
        }

        val togetherEmail = AnimatorSet().apply {
            playTogether(tvEmail, edtEmail)
        }

        val togetherPassword = AnimatorSet().apply {
            playTogether(tvPassword, edtPassword)
        }

        AnimatorSet().apply {
            playSequentially(title, togetherUsername, togetherEmail, togetherPassword, registerButton, tvLogin, loginButton)
            start()
        }
    }

    private fun setMyButtonEnabled() {
        val result = binding.edtPassword.text
        binding.registerButton.isEnabled = result != null && result.toString().length > 5
        if (result.toString().length < 6) {
            binding.registerButton.setOnClickListener { Toast.makeText(this@RegisterActivity, "Password Must Have 6 Character Minimum", Toast.LENGTH_SHORT).show()}
        } else {
            binding.registerButton.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}