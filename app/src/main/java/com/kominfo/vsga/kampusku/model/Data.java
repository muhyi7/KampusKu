package com.kominfo.vsga.kampusku.model;

public class Data {
    private String id, nomor, nama, tanggal, kelamin, alamat;

    public Data(){

    }

    public Data(String id, String nomor, String nama, String tanggal, String kelamin, String alamat){
        this.id = id;
        this.nomor = nomor;
        this.nama = nama;
        this.tanggal = tanggal;
        this.kelamin = kelamin;
        this.alamat = alamat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getKelamin() {
        return kelamin;
    }

    public void setKelamin(String kelamin) {
        this.kelamin = kelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
