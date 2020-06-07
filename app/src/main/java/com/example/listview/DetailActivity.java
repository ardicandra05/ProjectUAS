package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import static com.example.listview.MainActivity.dtdesk;
import static com.example.listview.MainActivity.dtgambar;
import static com.example.listview.MainActivity.dtharga;
import static com.example.listview.MainActivity.dtnama;
import static com.example.listview.MainActivity.dtspek;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent=getIntent();
        String gambar=intent.getStringExtra(dtgambar);
        String harga=intent.getStringExtra(dtharga);
        String desk=intent.getStringExtra(dtdesk);
        String spek=intent.getStringExtra(dtspek);

        ImageView produkimg=findViewById(R.id.lv_menu);
        TextView produkdesk=findViewById(R.id.tv_des);
        TextView produkspek=findViewById(R.id.tv_spek);
        TextView produkharga=findViewById(R.id.tv_harga);

        Glide
                .with(this)
                .load(gambar)
                .into(produkimg);
        produkdesk.setText(desk);
        produkharga.setText(harga);
        produkspek.setText(spek);
    }
}
