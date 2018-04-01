package com.example.android.intangantira_1202154351_modul6;

/**
 * Created by Intan Gantira on 4/1/2018.
 */

public class databasedua {
    String gmbr, judul, deskripsi, usr, key;

    //method kosong yang diperlukan untuk melakukan pengecekan
    public databasedua(){

    }

    //konstruktor
    public databasedua(String gmbr, String judul, String deskripsi,String usr){
        this.gmbr=gmbr;
        this.judul=judul;
        this.deskripsi=deskripsi;
        this.usr=usr;
    }

    //method getter
    public String getKey(){
        return key;
    }

    public void setKey(String key){
        key = key;
    }

    public String getGmbr() {
        return gmbr;
    }

    public String getJudul() {
        return judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getUsr() {
        return usr;
    }
}
