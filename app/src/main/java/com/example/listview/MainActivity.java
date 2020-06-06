package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MenuAdapter.OnItemClickListener{
    public static final String dtgambar="gambar";
    public static final String dtnama="nama";
    public static final String dtharga="harga";
    public static final String dtdesk="deskripsi";
    public static final String dtspek="spek";

    // private String [] dataList={"Intel Core i3 9100F","Intel Pentium G5400","Intel Core i3 8100","Intel Core i9 9900K","Intel Core i5 9400F"};
    private MenuAdapter menuAdapter;
    private RecyclerView recyclerView;
    int jumdata;
    private RequestQueue requestQueue;
    private ArrayList<Menu> menus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        menus = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(this);
        parseJSON();
    }

    private void parseJSON(){
        String url="https://uassemesterpendek.000webhostapp.com/koneksi.php";
        JsonArrayRequest request=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                jumdata = response.length();
                try {
                    for (int i = 0; i < jumdata; i++) {
                        JSONObject data = response.getJSONObject(i);
                        String gambarmenu = data.getString("gambar");
                        String namamenu = data.getString("nama");
                        String hargamenu = data.getString("harga");
                        String desmenu = data.getString("deskripsi");
                        String spekmenu = data.getString("spek");
                        menus.add(new Menu(gambarmenu, namamenu, hargamenu, desmenu, spekmenu));
                    }
                    menuAdapter = new MenuAdapter(MainActivity.this, menus);
                    recyclerView.setAdapter(menuAdapter);
                    menuAdapter.setOnItemClickListener(MainActivity.this);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(request);
    }

    @Override
    public void onItemclick(int position) {
        Intent pindah=new Intent(this,DetailActivity.class);
        Menu itemClick=menus.get(position);
        pindah.putExtra(dtgambar,itemClick.getGambar());
        pindah.putExtra(dtnama,itemClick.getNama());
        pindah.putExtra(dtdesk,itemClick.getDeskripsi());
        pindah.putExtra(dtharga,itemClick.getHarga());
        pindah.putExtra(dtspek,itemClick.getSpesifikasi());

        startActivity(pindah);
    }
}

