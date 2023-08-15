package com.kominfo.vsga.kampusku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Toolbar toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });

    }

    public void btn_Tentang(View view) {
        Intent pindahTentang = new Intent(Dashboard.this, Tentang.class);
        startActivity(pindahTentang);
    }

    public void btn_tambah_data(View view) {
        Intent pindahTambahData = new Intent(Dashboard.this, AddData.class);
        startActivity(pindahTambahData);
    }

    public void btn_lihat_data(View view) {
        Intent pindahLihatData = new Intent(Dashboard.this, ViewEditData.class);
        startActivity(pindahLihatData);
    }
}