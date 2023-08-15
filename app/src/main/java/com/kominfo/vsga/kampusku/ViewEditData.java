package com.kominfo.vsga.kampusku;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;


import com.kominfo.vsga.kampusku.adapter.Adapter;
import com.kominfo.vsga.kampusku.helper.Helper;
import com.kominfo.vsga.kampusku.model.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ViewEditData extends AppCompatActivity {
    ListView listView;
    AlertDialog.Builder dialog;
    List<Data> lists = new ArrayList<>();
    Adapter adapter;
    Helper db = new Helper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_edit_data);



        db = new Helper(getApplicationContext());
        listView = findViewById(R.id.list_item);
        adapter = new Adapter(ViewEditData.this, lists);
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                final String id = lists.get(i).getId();
                final String nomor = lists.get(i).getNomor();
                final String nama = lists.get(i).getNama();
                final String tanggal = lists.get(i).getTanggal();
                final String kelamin = lists.get(i).getKelamin();
                final String alamat = lists.get(i).getAlamat();
                final CharSequence[] dialogItem = {"Lihat", "Edit", "Hapus", };
                dialog = new AlertDialog.Builder(ViewEditData.this);
                dialog.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i){
                            case 0:
                                Intent pindahDetailData = new Intent(ViewEditData.this,DetailData.class);
                                startActivity(pindahDetailData);
                            case 1:
                                Intent pindahAddData= new Intent(ViewEditData.this, AddData.class);
                                pindahAddData.putExtra("id", id);
                                pindahAddData.putExtra("nomor", nomor);
                                pindahAddData.putExtra("nama", nama);
                                pindahAddData.putExtra("tanggal", tanggal);
                                pindahAddData.putExtra("kelamin", kelamin);
                                pindahAddData.putExtra("alamat", alamat);
                                startActivity(pindahAddData);
                                break;
                            case 2:
                                db.delete(Integer.parseInt(id));
                                lists.clear();
                                getData();
                                //panggil data ulang
                                break;
                        }
                    }
                }).show();
                return false;
            }
        });


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
    private void getData(){
        ArrayList<HashMap<String, String>> rows = db.getAll();
        for (int i = 0; i<rows.size();i++){
            String id = rows.get(i).get("id");
            String nomor = rows.get(i).get("nomor");
            String nama = rows.get(i).get("nama");
            String tanggal = rows.get(i).get("tanggal");
            String kelamin = rows.get(i).get("kelamin");
            String alamat = rows.get(i).get("alamat");
            Data data = new Data();
            data.setId(id);
            data.setNomor(nomor);
            data.setNama(nama);
            data.setTanggal(tanggal);
            data.setKelamin(kelamin);
            data.setAlamat(alamat);
            lists.add(data);
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
        lists.clear();
        getData();
    }
}