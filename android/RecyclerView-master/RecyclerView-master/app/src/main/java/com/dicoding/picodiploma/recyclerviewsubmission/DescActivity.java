package com.dicoding.picodiploma.recyclerviewsubmission;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DescActivity extends AppCompatActivity {

    TextView nama, deskripsi;
    String n_nama, n_deskripsi;
    int n_gambar;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desc);
        Bundle bundle = getIntent().getExtras();
        n_nama = bundle.getString("nama");
        n_deskripsi = bundle.getString("deskripsi");
        n_gambar = bundle.getInt("gambar");

        nama = (TextView) findViewById(R.id.nama);
        deskripsi = (TextView) findViewById(R.id.deskripsi);
        img = (ImageView) findViewById(R.id.gambar);

        nama.setText(""+n_nama);
        deskripsi.setText(""+n_deskripsi);

        Glide.with(DescActivity.this)
                .load(n_gambar)
                .apply(new RequestOptions().override(370,370))
                .into(img);
    }

}
