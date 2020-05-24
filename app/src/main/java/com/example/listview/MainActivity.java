package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // private String [] dataList={"Intel Core i3 9100F","Intel Pentium G5400","Intel Core i3 8100","Intel Core i9 9900K","Intel Core i5 9400F"};
    private MenuAdapter adapter;
    private String [] dataNama;
    private String [] dataDes;
    private String [] dataSpek;
    private String [] dataHarga;
    private TypedArray dataGambar;
    private ArrayList<Menu> menus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvlist=findViewById(R.id.lv_list);
        adapter=new MenuAdapter(this);
        lvlist.setAdapter(adapter);
        prepare();
        tambahitem();

        lvlist.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, menus.get(i).getNama(), Toast.LENGTH_SHORT).show();
                Intent pindahdata=new Intent(MainActivity.this,DetailActivity.class);
                pindahdata.putExtra(DetailActivity.dataDeskripsi,menus.get(i).getDeskripsi());
                pindahdata.putExtra(DetailActivity.datagambar,menus.get(i).getGambar());
                pindahdata.putExtra(DetailActivity.dataSpesifikasi,menus.get(i).getSpesifikasi());
                pindahdata.putExtra(DetailActivity.dataHarga,menus.get(i).getHarga());
                startActivity(pindahdata);
            }
        });
    }
    private void prepare(){
        dataNama = getResources().getStringArray(R.array.data_menu);
        dataDes = getResources().getStringArray(R.array.data_deskripsi);
        dataSpek = getResources().getStringArray(R.array.data_spesifikasi);
        dataHarga = getResources().getStringArray(R.array.data_harga);
        dataGambar = getResources().obtainTypedArray(R.array.data_gambar);
    }
    private void tambahitem(){
        menus = new ArrayList<>();
        for (int i=0; i<dataNama.length; i++){
            Menu menu = new Menu();
            menu.setGambar(dataGambar.getResourceId(i,-1));
            menu.setNama(dataNama[i]);
            menu.setDeskripsi(dataDes[i]);
            menu.setSpesifikasi(dataSpek[i]);
            menu.setHarga(dataHarga[i]);
            menus.add(menu);
        }
        adapter.setMenus(menus);
    }
}
