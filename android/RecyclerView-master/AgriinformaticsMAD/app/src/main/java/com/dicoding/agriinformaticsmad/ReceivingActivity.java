package com.dicoding.agriinformaticsmad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ReceivingActivity extends AppCompatActivity {

    private Intent intent;
    private TextView tvNameSub;
    private TextView tvName;
    private TextView tvAge;
    private TextView tvGender;
    private TextView tvAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiving);

        // binding onto variables
        tvNameSub = findViewById(R.id.tvNameSub);
        tvName = findViewById(R.id.tvName);
        tvAge = findViewById(R.id.tvAge);
        tvGender = findViewById(R.id.tvGender);
        tvAddress = findViewById(R.id.tvAdress);

        intent = getIntent();
        tvNameSub.setText(intent.getStringExtra("Name"));
        tvName.setText(intent.getStringExtra("Name"));
        tvAge.setText(intent.getStringExtra("Age"));
        tvGender.setText(intent.getStringExtra("Gender"));
        tvAddress.setText(intent.getStringExtra("Address"));
    }
}