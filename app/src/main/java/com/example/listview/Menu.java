package com.example.listview;

import android.os.Parcel;
import android.os.Parcelable;

class Menu implements Parcelable {
    private String gambar;
    private String nama;
    private String Deskripsi;
    private String spesifikasi;
    private String harga;

    protected Menu(Parcel in) {
        gambar = in.readString();
        nama = in.readString();
        Deskripsi = in.readString();
        spesifikasi = in.readString();
        harga = in.readString();
    }

    public static final Creator<Menu> CREATOR = new Creator<Menu>() {
        @Override
        public Menu createFromParcel(Parcel in) {
            return new Menu(in);
        }

        @Override
        public Menu[] newArray(int size) {
            return new Menu[size];
        }
    };

    public Menu(String gambarmenu, String namamenu, String hargamenu, String desmenu, String spekmenu) {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(gambar);
        dest.writeString(nama);
        dest.writeString(Deskripsi);
        dest.writeString(spesifikasi);
        dest.writeString(harga);
    }
}