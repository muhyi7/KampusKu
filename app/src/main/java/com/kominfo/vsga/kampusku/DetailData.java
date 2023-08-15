package com.kominfo.vsga.kampusku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.kominfo.vsga.kampusku.helper.Helper;

public class DetailData extends AppCompatActivity {

    private TextView editNomor, editNama, editTanggal, editKelamin, editAlamat;
    private Helper db  = new Helper(this);
    private String id, nomor, nama, tanggal, kelamin, alamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_data);

        editNomor = findViewById(R.id.tv_nomor);
        editNama = findViewById(R.id.tv_nama);
        editTanggal = findViewById(R.id.tv_tanggal);
        editKelamin = findViewById(R.id.tv_kelamin);
        editAlamat = findViewById(R.id.tv_alamat);

        id = getIntent().getStringExtra("id");
        nomor = getIntent().getStringExtra("nomor");
        nama = getIntent().getStringExtra("nama");
        tanggal = getIntent().getStringExtra("tanggal");
        kelamin = getIntent().getStringExtra("kelamin");
        alamat = getIntent().getStringExtra("alamat");

        editNomor.setText(nomor);
        editNama.setText(nama);
        editTanggal.setText(alamat);
        editKelamin.setText(kelamin);
        editAlamat.setText(alamat);

        //tombol kembali
        Toolbar toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });
        //tombol kembali
    }
}