package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {

    public static final String datagambar="datagambar";
    public static final String dataDeskripsi="dataDeskripsi";
    public static final String dataSpesifikasi="dataSpesifikasi";
    public static final String dataHarga="dataHarga";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imgMenu=findViewById(R.id.lv_menu);
        TextView tvDeskripsi=findViewById(R.id.tv_des);
        TextView tvSpek=findViewById(R.id.tv_spek);
        TextView tvHarga=findViewById(R.id.tv_harga);

        imgMenu.setImageResource(getIntent().getIntExtra(datagambar,0));
        tvDeskripsi.setText(getIntent().getStringExtra(dataDeskripsi));
        tvSpek.setText(getIntent().getStringExtra(dataSpesifikasi));
        tvHarga.setText(getIntent().getStringExtra(dataHarga));
    }
}
