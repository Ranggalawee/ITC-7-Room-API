package com.example.roomapi.database;


import androidx.room.ColumnInfo;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@androidx.room.Entity(tableName = "GunungApi")
public class Entity {
    public final static String TABLE_NAME = "GunungApi";

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "nama")
    private String nama;

    @ColumnInfo(name = "bentuk")
    private String bentuk;

    @ColumnInfo(name = "tinggi")
    private String tinggi;

    @ColumnInfo(name = "estimasi")
    private String estimasi;

    public Entity(int id, String nama, String bentuk, String tinggi, String estimasi) {
        this.id = id;
        this.nama = nama;
        this.bentuk = bentuk;
        this.tinggi = tinggi;
        this.estimasi = estimasi;
    }

    @Ignore
    public Entity(String nama, String bentuk, String tinggi, String estimasi) {
        this.nama = nama;
        this.bentuk = bentuk;
        this.tinggi = tinggi;
        this.estimasi = estimasi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getBentuk() {
        return bentuk;
    }

    public void setBentuk(String bentuk) {
        this.bentuk = bentuk;
    }

    public String getTinggi() {
        return tinggi;
    }

    public void setTinggi(String tinggi) {
        this.tinggi = tinggi;
    }

    public String getEstimasi() {
        return estimasi;
    }

    public void setEstimasi(String estimasi) {
        this.estimasi = estimasi;
    }
}
