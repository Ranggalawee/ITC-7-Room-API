package com.example.roomapi.service;

import com.example.roomapi.model.GunungApi;
import com.example.roomapi.model.GunungApiItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GunungServices {
    // inisialisasi Retrofit
    private Retrofit retrofit = null;

    // Untuk method getAPI() ini digunakan untuk menghubungkan aplikasi kita dengan url kita tadi dan sekaligus mengubah menjadi jenis GSON.
    public GunungAPI getAPI(){
        if (retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(GunungAPI.URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(GunungAPI.class);
    }

    // Untuk method getCountries untuk mengambil data dari url kita tadi dengan menggunakan method getCorona().

    public void getGunungApi(final GunungListener<List<GunungApiItem>> listener){
        getAPI().getGunung().enqueue(new Callback<List<GunungApiItem>>() {
            @Override
            public void onResponse(Call<List<GunungApiItem>> call, Response<List<GunungApiItem>> response) {
                GunungApi data = new GunungApi();

                data.setGunungApi(response.body());
                listener.onSuccess(data.getGunungApi());
            }

            @Override
            public void onFailure(Call<List<GunungApiItem>> call, Throwable t) {
                listener.onFailed(t.getMessage());
            }
        });
    }

//    public void getGunungApi(final GunungListener<List<GunungApiItem>> listener){ // GAPUNYA LISTNYAAA MESTI GAJALAN!!!!!
//        getAPI().getGunung().enqueue(new Callback<GunungApi>() {
//            @Override
//            public void onResponse(Call<GunungApi> call, Response<GunungApi> response) {
//                // response.body() adalah hasil data yang diperoleh dari API lalu disimpan ke dalam variabel data
//                GunungApi data = response.body();
//
//                listener.onSuccess(data.getGunungApi()); // KARENA MODEL CUMA 2
//            }
//
//            @Override
//            public void onFailure(Call<GunungApi> call, Throwable t) {
//                listener.onFailed(t.getMessage());
//            }
//        });
//    }
}

