package com.mpusling;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddSchoolActivity extends AppCompatActivity {
    EditText nama_sekolah, email_sekolah, kepala_sekolah, input_kontak, jumlah_siswa;
    Button btnBatal, btnSimpan;
    ImageView backPage;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_school);

        nama_sekolah = findViewById(R.id.input_nama_sekolah);
        email_sekolah = findViewById(R.id.input_email_sekolah);
        kepala_sekolah = findViewById(R.id.input_kepala_sekolah);
        input_kontak = findViewById(R.id.input_kontak);
        jumlah_siswa = findViewById(R.id.input_jumlah_siswa);

        backPage = findViewById(R.id.back_page);
        backPage.setOnClickListener(v -> finish());

        btnBatal = findViewById(R.id.btn_batal);
        btnBatal.setOnClickListener(v -> finish());

        btnSimpan = findViewById(R.id.btn_simpan);
        btnSimpan.setOnClickListener(v -> saveData());

    }

    private void saveData() {
        String nama = nama_sekolah.getText().toString();
        String email = email_sekolah.getText().toString();
        String kepala = kepala_sekolah.getText().toString();
        String kontak = input_kontak.getText().toString();
        String siswa = jumlah_siswa.getText().toString();

        if(nama.isEmpty()){
            nama_sekolah.setError("Nama Sekolah Tidak Boleh Kosong");
        }
        if(email.isEmpty()){
            email_sekolah.setError("Email Sekolah Tidak Boleh Kosong");
        }
        if(kepala.isEmpty()){
            kepala_sekolah.setError("Nama Kepsek Tidak Boleh Kosong");
        }
        if(kontak.isEmpty()) {
            input_kontak.setError("Kontak Tidak Boleh Kosong");
        }

        if(siswa.isEmpty()){
            jumlah_siswa.setError("Jumlah Siswa Tidak Boleh Kosong");
        }

        if(!nama.isEmpty() && !email.isEmpty() && !kepala.isEmpty() && !kontak.isEmpty() && !siswa.isEmpty()){

        }


    }
}
