package com.example.roomapi.model;

import com.google.gson.annotations.SerializedName;

public class GunungApiItem{

	@SerializedName("bentuk")
	private String bentuk;

	@SerializedName("nama")
	private String nama;

	@SerializedName("estimasi_letusan_terakhir")
	private String estimasiLetusanTerakhir;

	@SerializedName("tinggi_meter")
	private String tinggiMeter;

	@SerializedName("geolokasi")
	private String geolokasi;

	public void setBentuk(String bentuk){
		this.bentuk = bentuk;
	}

	public String getBentuk(){
		return bentuk;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setEstimasiLetusanTerakhir(String estimasiLetusanTerakhir){
		this.estimasiLetusanTerakhir = estimasiLetusanTerakhir;
	}

	public String getEstimasiLetusanTerakhir(){
		return estimasiLetusanTerakhir;
	}

	public void setTinggiMeter(String tinggiMeter){
		this.tinggiMeter = tinggiMeter;
	}

	public String getTinggiMeter(){
		return tinggiMeter;
	}

	public void setGeolokasi(String geolokasi){
		this.geolokasi = geolokasi;
	}

	public String getGeolokasi(){
		return geolokasi;
	}

	@Override
 	public String toString(){
		return 
			"GunungApiItem{" + 
			"bentuk = '" + bentuk + '\'' + 
			",nama = '" + nama + '\'' + 
			",estimasi_letusan_terakhir = '" + estimasiLetusanTerakhir + '\'' + 
			",tinggi_meter = '" + tinggiMeter + '\'' + 
			",geolokasi = '" + geolokasi + '\'' + 
			"}";
		}
}