package com.example.listview;

import android.os.Parcel;
import android.os.Parcelable;

class Menu {
    private String gambar;
    private String nama;
    private String Deskripsi;
    private String spesifikasi;
    private String harga;

    public Menu(String datagambar, String datanama, String  datades, String dataspek, String dataharga){
        gambar=datagambar;
        nama=datanama;
        Deskripsi=datades;
        spesifikasi=dataspek;
        harga=dataharga;
    }

    public String getGambar() {
        return gambar;
    }

    public String getNama() {
        return nama;
    }

    public String getDeskripsi() {
        return Deskripsi;
    }

    public String getSpesifikasi() {
        return spesifikasi;
    }

    public String getHarga() {
        return harga;
    }
}