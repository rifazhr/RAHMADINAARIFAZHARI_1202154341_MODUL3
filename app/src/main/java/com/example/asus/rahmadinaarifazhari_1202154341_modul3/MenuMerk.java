package com.example.asus.rahmadinaarifazhari_1202154341_modul3;

/**
 * Created by asus on 2/25/2018.
 */

class MenuMerk {
    //deklarasi variable yang akan digunakan
    int gambar;
    String nama;
    String desc;

    //method setter


    public MenuMerk(int gambar, String nama, String desc) {
        this.gambar = gambar;
        this.nama = nama;
        this.desc = desc;
    }

    //method getter untuk get gambar
    public int getGambar() {
        return gambar;
    }

    //method getter untuk get nama
    public String getNama() {
        return nama;
    }

    //method getter untuk get detail
    public String getDesc() {
        return desc;
    }

}