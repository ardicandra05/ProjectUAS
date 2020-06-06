package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder>{
    private Context context;
    private ArrayList<Menu> menus;
    private OnItemClickListener mPilih;

    public interface OnItemClickListener{
        void onItemclick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mPilih=listener;
    }

    public MenuAdapter(Context mcontext, ArrayList<Menu> menubarang) {
        context=mcontext;
        menus=menubarang;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(context).inflate(R.layout.item_menu,parent,false);
        return new MenuViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
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

    public class MenuViewHolder extends RecyclerView.ViewHolder{
        public TextView tvnama;
        public TextView tvharga;
        public ImageView gambar;
        public Button btnpesan;

        public MenuViewHolder (@NonNull View view){
            super(view);
            tvnama=view.findViewById(R.id.tv_menu);
            tvharga=view.findViewById(R.id.tv_harga);
            gambar=view.findViewById(R.id.img_menu);
            btnpesan=view.findViewById(R.id.btn_pesan);

            btnpesan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mPilih != null){
                        int position=getAdapterPosition();
                        if (position!=RecyclerView.NO_POSITION){
                            mPilih.onItemclick(position);
                        }
                    }
                }
            });
        }
    }
}
