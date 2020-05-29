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

public class MainActivity extends AppCompatActivity {

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

//        ListView lvlist=findViewById(R.id.lv_list);
//        adapter=new MenuAdapter(this);
//        lvlist.setAdapter(adapter);
//        prepare();
//        tambahitem();
//
//        lvlist.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(MainActivity.this, menus.get(i).getNama(), Toast.LENGTH_SHORT).show();
//                Intent pindahdata=new Intent(MainActivity.this,DetailActivity.class);
//                pindahdata.putExtra(DetailActivity.dataDeskripsi,menus.get(i).getDeskripsi());
//                pindahdata.putExtra(DetailActivity.datagambar,menus.get(i).getGambar());
//                pindahdata.putExtra(DetailActivity.dataSpesifikasi,menus.get(i).getSpesifikasi());
//                pindahdata.putExtra(DetailActivity.dataHarga,menus.get(i).getHarga());
//                startActivity(pindahdata);
//            }
//        });
//    }

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
}

