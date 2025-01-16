package com.mpusling;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginSelectedActivity extends AppCompatActivity {

    Button btnAdmin, btnSekolah, btnSiswa;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_select);

        btnAdmin = findViewById(R.id.btn_admin);
        btnSekolah = findViewById(R.id.btn_sekolah);
        btnSiswa = findViewById(R.id.btn_siswa);

        btnAdmin.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            intent.putExtra("type", "admin");
            startActivity(intent);
        });

        btnSekolah.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            intent.putExtra("type", "sekolah");
            startActivity(intent);
        });

        btnSiswa.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            intent.putExtra("type", "siswa");
            startActivity(intent);
        });
    }
}
