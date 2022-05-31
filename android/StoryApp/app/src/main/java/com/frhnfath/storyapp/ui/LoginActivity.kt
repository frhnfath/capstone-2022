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
import com.frhnfath.storyapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setMyButtonEnabled()
        playAnimation()

        binding.edtPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                setMyButtonEnabled()
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                setMyButtonEnabled()
            }

            override fun afterTextChanged(s: Editable) {
                // Do Nothing
            }
        })

        binding.registerButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setMyButtonEnabled() {
        val result = binding.edtPassword.text
        binding.loginButton.isEnabled = result != null && result.toString().length > 5
        if (result.toString().length < 6) {
            binding.loginButton.setOnClickListener { Toast.makeText(this@LoginActivity, "Password Must Have At Least 6 Characters", Toast.LENGTH_SHORT).show()}
        } else {
            binding.loginButton.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun playAnimation() {
        ObjectAnimator.ofFloat(binding.logo, View.TRANSLATION_X, -30f, 30f).apply {
            duration = 6000
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }.start()

        val title = ObjectAnimator.ofFloat(binding.tvSignin, View.ALPHA, 1f).setDuration(500)
        val tvEmail = ObjectAnimator.ofFloat(binding.tvEmail, View.ALPHA, 1f).setDuration(500)
        val edtEmail = ObjectAnimator.ofFloat(binding.edtEmail, View.ALPHA, 1f).setDuration(500)
        val tvPassword = ObjectAnimator.ofFloat(binding.tvPassword, View.ALPHA, 1f).setDuration(500)
        val edtPassword = ObjectAnimator.ofFloat(binding.edtPassword, View.ALPHA, 1f).setDuration(500)
        val loginButton = ObjectAnimator.ofFloat(binding.loginButton, View.ALPHA, 1f).setDuration(500)
        val tvRegister = ObjectAnimator.ofFloat(binding.tvRegister, View.ALPHA, 1f).setDuration(500)
        val registerButton = ObjectAnimator.ofFloat(binding.registerButton, View.ALPHA, 1f).setDuration(500)

        val togetherEmail = AnimatorSet().apply {
            playTogether(tvEmail, edtEmail)
        }

        val togetherPassword = AnimatorSet().apply {
            playTogether(tvPassword, edtPassword)
        }

        AnimatorSet().apply {
            playSequentially(title, togetherEmail, togetherPassword, loginButton, tvRegister, registerButton)
            start()
        }
    }


}