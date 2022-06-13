package com.frhnfath.ambuhelp.layout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.frhnfath.ambuhelp.R
import com.frhnfath.ambuhelp.data.response.UserResponse
import com.frhnfath.ambuhelp.data.retrofit.ApiConfig
import com.frhnfath.ambuhelp.databinding.ActivityRegisterBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // function to change activity
        binding.btnRegister.setOnClickListener {
            val user = userRegister()
            Log.d(TAG, "onCreate: user" + Arrays.toString(user))
            if (user[0] != "empty")  {
                postUser(user[0], user[1], user[2], user[3])
                Toast.makeText(applicationContext, "You are registered. Sign in!", Toast.LENGTH_LONG).show()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        binding.loginTv.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun userRegister(): Array<String> {
        var name = binding.edtName.text.toString()
        if (name.isEmpty()) {
            binding.edtName.error = "Name is required"
            binding.edtName.requestFocus()
        }
        val email = binding.edtEmail.text.toString()
        if (email.isEmpty()) {
            binding.edtEmail.error = "Email is required"
            binding.edtEmail.requestFocus()
        }
        val password = binding.edtPassword.text.toString()
        if (password.isEmpty()) {
            binding.edtPassword.error = "Password is required"
            binding.edtPassword.requestFocus()
        }
        else if (password.length < 7) {
            binding.edtPassword.error = "Minimum 8 Characters"
            binding.edtPassword.requestFocus()
        }
        val telepon = binding.edtTelephone.text.toString()
        if (telepon.isEmpty()) {
            binding.edtTelephone.error = "Phone Number is required"
            binding.edtTelephone.requestFocus()
        }
        val tnc = binding.tcCheckbox
        if (!tnc.isChecked) {
            tnc.error = "Please read and checked the T&C"
            tnc.requestFocus()
        }
        if (name.isEmpty() or email.isEmpty() or password.isEmpty() or telepon.isEmpty()) {
            name = "empty"
        }
        return arrayOf(name, email, password, telepon)
    }

    private fun postUser(name: String, email: String, password: String, telepon: String) : Boolean {
        showLoading(true)
        val client = ApiConfig.getApiService().registerUser(name, email, password, telepon.toBigInteger())
        client.enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                showLoading(false)
                val responseBody = response.body()
                if (response.isSuccessful && responseBody != null) {
                    Log.e(TAG, "onResponse: Success", )
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                showLoading(false)
                Log.e(TAG, "onFailure: ${t.message}")
            }
        })
        return(true)
    }

    private fun showLoading(state: Boolean) {
        if (state) binding.progressBarRegister.visibility = View.VISIBLE
        else binding.progressBarRegister.visibility = View.GONE
    }

    companion object {
        private const val TAG = "RegisterActivity"
    }
}