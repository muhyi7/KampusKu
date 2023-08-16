package com.kominfo.vsga.kampusku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kominfo.vsga.kampusku.helper.Helper;

public class AddData extends AppCompatActivity {


    private EditText editNomor, editNama, editTanggal, editKelamin, editAlamat;
    private Button btnSave;
    private Helper db  = new Helper(this);
    private String id, nomor, nama, tanggal, kelamin, alamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

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

        editNomor = findViewById(R.id.edit_nomor);
        editNama = findViewById(R.id.edit_nama);
        editTanggal = findViewById(R.id.edit_tanggal);
        editKelamin = findViewById(R.id.edit_kelamin);
        editAlamat = findViewById(R.id.edit_alamat);
        btnSave = findViewById(R.id.btn_save);

        id = getIntent().getStringExtra("id");
        nomor = getIntent().getStringExtra("nomor");
        nama = getIntent().getStringExtra("nama");
        tanggal = getIntent().getStringExtra("tanggal");
        kelamin = getIntent().getStringExtra("kelamin");
        alamat = getIntent().getStringExtra("alamat");

        if (id == null || id.equals("")){
            setTitle("Tambah Data");
        }else{
            setTitle("Edit Data");
            editNomor.setText(nomor);
            editNama.setText(nama);
            editTanggal.setText(tanggal);
            editKelamin.setText(kelamin);
            editAlamat.setText(alamat);
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (id == null || id.equals("")){
                        save();
                    }else {
                        edit();
                    }
                }catch (Exception e){
                    Log.e("Saving", e.getMessage());
                }
            }
        });

    }
    private void save(){
        if (String.valueOf(editNomor.getText()).equals("") || String.valueOf(editNama.getText()).equals("")){
            Toast.makeText(this, "Silahkan Isi Data Pokok", Toast.LENGTH_SHORT).show();
        }else {
            db.insert(editNomor.getText().toString(), editNama.getText().toString(), editTanggal.getText().toString(), editKelamin.getText().toString(), editAlamat.getText().toString());
            Toast.makeText(this, "Data Berhasil Disimpan", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
    private void edit(){
        if (String.valueOf(editNomor.getText()).equals("") || String.valueOf(editNama.getText()).equals("")){
            Toast.makeText(this, "Silahkan Isi Data Pokok", Toast.LENGTH_SHORT).show();
        }else {
            db.update(Integer.parseInt(id), editNomor.getText().toString(), editNama.getText().toString(), editTanggal.getText().toString(), editKelamin.getText().toString(), editAlamat.getText().toString());
            Toast.makeText(this, "Data Berhasil Diedit", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}