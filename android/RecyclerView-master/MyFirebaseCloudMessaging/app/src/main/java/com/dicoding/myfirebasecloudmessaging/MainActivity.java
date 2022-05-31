package com.dicoding.myfirebasecloudmessaging;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button logTokenButton = findViewById(R.id.btn_token);
        logTokenButton.setOnClickListener(v ->
                FirebaseMessaging.getInstance().getToken().addOnSuccessListener(deviceToken -> {
                    String msg = getString(R.string.msg_token_fmt, deviceToken);
                    Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "Refreshed token: " + deviceToken);
                })
        );
    }
}