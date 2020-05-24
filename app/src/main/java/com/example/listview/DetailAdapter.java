//package com.example.listview;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//
//public class DetailAdapter extends BaseAdapter {
//    private Context context;
//    private ArrayList<Detail> details=new ArrayList<>();
//
//    public void setDetails(ArrayList<Detail> details) {
//        this.details = details;
//    }
//    public DetailAdapter(Context context) {
//        this.context = context;
//    }
//
//    @Override
//    public int getCount() {
//        return details.size();
//    }
//
//    @Override
//    public Object getItem(int i) {
//        return details.get(i);
//    }
//
//    @Override
//    public long getItemId(int i) {
//        return i;
//    }
//
//    @Override
//    public View getView(int i, View view, ViewGroup viewGroup) {
//        View itemView = view;
//        if (itemView==null){
//            itemView= LayoutInflater.from(context).inflate(R.layout.activity_detail,viewGroup,false);
//        }
//        ViewHolder viewHolder = new ViewHolder(itemView);
//        Detail detail = (Detail) getItem(i);
//        viewHolder.bind(detail);
//        return itemView;
//    }
//    private class ViewHolder{
//        private TextView tvDes;
//        private TextView tvspek;
//        private TextView tvharga;
//        ViewHolder (View view){
//            tvDes=view.findViewById(R.id.tv_des);
//            tvspek=view.findViewById(R.id.tv_spek);
//            tvharga=view.findViewById(R.id.tv_harga);
//        }
//        void bind(Detail detail){
//            tvDes.setText(detail.getDeskripsi());
//            tvspek.setText(detail.getSpesifikasi());
//            tvharga.setText(detail.getHarga());
//        }
//    }
//}
