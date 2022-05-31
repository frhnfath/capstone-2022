package com.dicoding.barvolume;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // declare variable that will used to do the calculation
    private TextView tvResult;
    private EditText edtLength;
    private EditText edtHeight;
    private EditText edtWidth;
    private Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tv_result);
        edtWidth = findViewById(R.id.edittext_width);
        edtLength = findViewById(R.id.edittext_length);
        edtHeight = findViewById(R.id.edittext_length);

        // set button to work as onClick function
        btnCalculate = findViewById(R.id.btn_calculation);
        btnCalculate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_calculation) {
            // get data from editText and assign to variables
            String inputWidth = edtWidth.getText().toString().trim();
            String inputLength = edtLength.getText().toString().trim();
            String inputHeight = edtHeight.getText().toString().trim();

            // set boolean to check fields availability
            boolean isEmptyFields = false;

            // check if editText is empty
            if (TextUtils.isEmpty(inputLength)) {
                isEmptyFields = true;
                edtLength.setError("This Field Cannot be Empty");
            }

            // check if editText is empty
            if (TextUtils.isEmpty(inputWidth)) {
                isEmptyFields = true;
                edtWidth.setError("This Field Cannot be Empty");
            }

            // check if editText is empty
            if (TextUtils.isEmpty(inputHeight)) {
                isEmptyFields = true;
                edtHeight.setError("This Field Cannot be Empty");
            }

            // if all fields are filled, do the math
            if (!isEmptyFields) {
                double volume = Double.parseDouble(inputWidth) * Double.parseDouble(inputLength) * Double.parseDouble(inputHeight);
                tvResult.setText(String.valueOf(volume));
            }
        }
    }
}