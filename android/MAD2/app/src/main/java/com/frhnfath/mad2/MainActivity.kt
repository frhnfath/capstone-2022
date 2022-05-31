package com.frhnfath.mad2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var edtName: EditText
    private lateinit var edtAge: EditText
    private lateinit var edtGender: EditText
    private lateinit var edtAddress: EditText
    private lateinit var buttonEnter: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtName = findViewById(R.id.edtTextNama)
        edtAge = findViewById(R.id.edtTextUmur)
        edtGender = findViewById(R.id.edtTextGender)
        edtAddress = findViewById(R.id.edtTextAlamat)
        buttonEnter = findViewById(R.id.btnEnter)

        buttonEnter.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnEnter -> {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                startActivity(intent)
            }
        }
    }
}