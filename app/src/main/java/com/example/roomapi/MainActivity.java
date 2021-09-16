package com.example.roomapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.roomapi.database.Dao;
import com.example.roomapi.database.Database;
import com.example.roomapi.database.Entity;
import com.example.roomapi.model.GunungApiItem;
import com.example.roomapi.service.GunungListener;
import com.example.roomapi.service.GunungServices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tvtampilNama, tvtampilBentuk, tvtampilTinggi, tvtampilEstimasi;
    Button btnTampil;

    Database database;
    Dao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvtampilNama = findViewById(R.id.tv_tampilNama);
        tvtampilBentuk = findViewById(R.id.tv_tampilBentuk);
        tvtampilTinggi = findViewById(R.id.tv_tampilTinggi);
        tvtampilEstimasi = findViewById(R.id.tv_tampilEstimasi);
        btnTampil = findViewById(R.id.btn_Tampil);

        new GunungServices().getGunungApi(GunungListener);

        database = Database.getInstance(this);
        dao = database.dao();

    }

    GunungListener<List<GunungApiItem>> GunungListener = new GunungListener<List<GunungApiItem>>() {
        @Override
        public void onSuccess(List<GunungApiItem> items) {

            for(int i = 0; i < items.size(); i++){
                Entity data = new Entity(items.get(i).getNama(), items.get(i).getBentuk(), items.get(i).getTinggiMeter(), items.get(i).getEstimasiLetusanTerakhir());
                dao.insert(data);
            }

            List<Entity> dataAll = dao.getAllData();
            ArrayList<String> dataGunung = new ArrayList<>(
                    Arrays.asList(
                            dataAll.get(0).getNama(),
                            dataAll.get(0).getBentuk(),
                            dataAll.get(0).getTinggi(),
                            dataAll.get(0).getEstimasi()
                    )
            );

            btnTampil.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                tvtampilNama.setText("Nama Gunung : " + dataGunung.get(0));
                tvtampilBentuk.setText("Bentuk Gunung : " + dataGunung.get(1));
                tvtampilTinggi.setText("Tinggi Gunung : " + dataGunung.get(2));
                tvtampilEstimasi.setText("Estimasi Meledak : " + dataGunung.get(3));
                }
            });
        }

        @Override
        public void onFailed(String msg) {
            Log.d("ISI ERROR", msg);
        }
    };
}
