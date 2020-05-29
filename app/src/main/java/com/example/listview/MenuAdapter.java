package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
//import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Menu> menus;

    public MenuAdapter(Context mcontext, ArrayList<Menu> menumakanan) {
        context=mcontext;
        menus=menumakanan;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(context).inflate(R.layout.item_menu,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Menu menubaru=menus.get(position);
        String gambar=menubaru.getGambar();
        String harga=menubaru.getHarga();
        String nama=menubaru.getNama();

        holder.tvnama.setText(nama);
        holder.tvharga.setText(harga);
        Glide
                .with(context)
                .load(gambar)
                .centerCrop()
                .into(holder.gambar);
    }

    @Override
    public int getItemCount() {
        return menus.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvnama;
        private TextView tvharga;
        private ImageView gambar;

        public ViewHolder (@NonNull View view){
            super(view);
            tvnama=view.findViewById(R.id.tv_menu);
            tvharga=view.findViewById(R.id.tv_harga);
            gambar=view.findViewById(R.id.img_menu);
        }
    }
}
