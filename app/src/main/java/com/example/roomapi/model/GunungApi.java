package com.example.roomapi.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class GunungApi{

	@SerializedName("GunungApi")
	private List<GunungApiItem> gunungApi;

	public void setGunungApi(List<GunungApiItem> gunungApi){
		this.gunungApi = gunungApi;
	}

	public List<GunungApiItem> getGunungApi(){
		return gunungApi;
	}

	@Override
 	public String toString(){
		return 
			"GunungApi{" + 
			"gunungApi = '" + gunungApi + '\'' + 
			"}";
		}
}