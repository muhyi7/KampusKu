package com.kominfo.vsga.kampusku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn_Login(View view) {
        Intent pindahDashboard = new Intent(MainActivity.this, Dashboard.class);
        startActivity(pindahDashboard);

        Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show();

    }
}