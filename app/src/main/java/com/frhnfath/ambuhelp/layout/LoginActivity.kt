package com.frhnfath.ambuhelp.layout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.frhnfath.ambuhelp.data.preferences.SessionManager
import com.frhnfath.ambuhelp.data.response.TokenResponse
import com.frhnfath.ambuhelp.data.retrofit.ApiConfig
import com.frhnfath.ambuhelp.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val user = userLogin()
            Log.d(TAG, "onCreate: $user")
            val state = findUser(user)
            Log.d(TAG, "onCreate: $state")
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.registerTv.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun userLogin(): String {
        val email = binding.edtUsername.text.toString()
        if (email.isEmpty()) {
            binding.edtUsername.error = "Email is required"
            binding.edtUsername.requestFocus()
        }
        val password = binding.edtPassword.text.toString()
        if (password.isEmpty()) {
            binding.edtPassword.error = "Password is required"
            binding.edtPassword.requestFocus()
        }
        return email
    }

    private fun findUser(email: String) : Boolean{
        showLoading(true)
        var state = false
        sessionManager = SessionManager(this)
        val client = ApiConfig.getApiService().getUser(email)
        client.enqueue(object : Callback<TokenResponse> {
            override fun onResponse(call: Call<TokenResponse>, response: Response<TokenResponse>) {
                showLoading(false)
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    Log.d(TAG, "ResponseBody: $responseBody")
                    if (responseBody != null) {
                        sessionManager.saveToken(responseBody.data)
                        Log.e(TAG, "Token: ${responseBody.data}")
                    } else {
                        Log.e(TAG, "onResponse: ${response.message()}")
                    }
                }
            }

            override fun onFailure(call: Call<TokenResponse>, t: Throwable) {
                showLoading(false)
                Log.e(TAG, "onFailure: ${t.message}")
                state = false
            }
        })
        return state
    }

    private fun showLoading(state: Boolean) {
        if (state) binding.progressBarLogin.visibility = View.VISIBLE
        else binding.progressBarLogin.visibility = View.GONE
    }

    companion object {
        private const val TAG = "LoginActivity"
    }
}