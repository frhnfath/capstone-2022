package com.dicoding.agriinformaticsmad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtName;
    private EditText edtAge;
    private EditText edtGender;
    private EditText edtAddress;
    private Button edtButton;
    private Button btnActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // binding onto variables
        edtName = findViewById(R.id.edtNama);
        edtAge = findViewById(R.id.edtUmur);
        edtGender = findViewById(R.id.edtGender);
        edtAddress = findViewById(R.id.edtAlamat);
        edtButton = findViewById(R.id.btnEnter);

        // add onClick function to enable button
        edtButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // Use toast to show Name as a Toast notification
        Toast.makeText(MainActivity.this, edtName.getText(), Toast.LENGTH_SHORT).show();

        // sending an intent to open Receiving Activity
        Intent intent = new Intent(MainActivity.this, ReceivingActivity.class);

        // sending data as an intent to Receiving Activity
        intent.putExtra("Name", edtName.getText().toString());
        intent.putExtra("Age", edtAge.getText().toString());
        intent.putExtra("Gender", edtGender.getText().toString());
        intent.putExtra("Address", edtAddress.getText().toString());

        // start intent
        startActivity(intent);

    }
}