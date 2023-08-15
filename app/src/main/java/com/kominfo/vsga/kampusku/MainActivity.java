package com.kominfo.vsga.kampusku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private Button btnLogin;

    private String email = "muhyi@gmail.com";
    private String password = "admin234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
    }

    public void btn_Login(View view) {
        if (etEmail.getText().toString().equalsIgnoreCase(email) && etPassword.getText().toString().equalsIgnoreCase(password)){
            Intent pindahDashboard = new Intent(MainActivity.this, Dashboard.class);
            startActivity(pindahDashboard);
            finish();
        }else {
            Toast.makeText(this, "Gagal Login", Toast.LENGTH_SHORT).show();
        }

    }
}