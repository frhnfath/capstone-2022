package com.dicoding.frhnfath.myintentapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tvResult:  TextView

    @SuppressLint("SetTextI18n")
    private val resultLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        result ->
            if (result.resultCode == MoveForResultActivity.RESULT_CODE && result.data != null) {
                val selectedValue = result.data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0)
                tvResult.text = "Hasil : $selectedValue"
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveActivityData: Button = findViewById(R.id.btn_move_activity_data)
        btnMoveActivityData.setOnClickListener(this)

        val btnMoveForResult: Button = findViewById(R.id.btn_move_for_result)
        btnMoveForResult.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity, MainActivity2::class.java)
                startActivity(moveIntent)
            }

            R.id.btn_move_activity_data -> {
                val moveWithDataIntent = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "DicodingAcademy Boy")
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 5)
                startActivity(moveWithDataIntent)
            }

            R.id.btn_move_for_result -> {
                val moveForResultIntent = Intent(this@MainActivity, MoveForResultActivity::class.java)
                resultLauncher.launch(moveForResultIntent)
            }
        }
    }
}