package com.mpusling;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddBookActivity extends AppCompatActivity {

    EditText input_judul_buku, input_nama_penulis, input_nama_penerbit, input_tahun_terbit, input_tahun_kedatangan, input_kode_buku, input_kode_rak;
    ImageView btn_simpan;
    private LinearLayout ll_select_file,ll_select_image;
    private ImageView image_book;
    private TextView text_name_image;
    private TextView text_name_file;
    private static final int REQUEST_CODE_SELECT_IMAGE = 1;
    private static final int REQUEST_CODE_SELECT_FILE = 2;
    private ImageView backPage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        input_judul_buku = findViewById(R.id.input_judul_buku);
        input_nama_penulis = findViewById(R.id.input_nama_penulis);
        input_nama_penerbit = findViewById(R.id.input_nama_penerbit);
        input_tahun_terbit = findViewById(R.id.input_tahun_terbit);
        input_tahun_kedatangan = findViewById(R.id.input_tahun_kedatangan);
        input_kode_buku = findViewById(R.id.input_kode_buku);
        input_kode_rak = findViewById(R.id.input_kode_rak);
        backPage = findViewById(R.id.back_page);
        backPage.setOnClickListener(v -> finish());
        btn_simpan = findViewById(R.id.img_save);

        ll_select_image = findViewById(R.id.ll_select_image);
        ll_select_image.setOnClickListener(v -> selectImage());
        ll_select_file = findViewById(R.id.ll_select_file);
        ll_select_file.setOnClickListener(v -> selectFile());
        image_book = findViewById(R.id.image_book);
        text_name_image = findViewById(R.id.text_name_image);
        text_name_file = findViewById(R.id.text_name_file);
        btn_simpan.setOnClickListener(v -> saveBook());
    }



    private void selectFile() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("application/pdf"); // Hanya file PDF
        startActivityForResult(Intent.createChooser(intent, "Pilih File PDF"), REQUEST_CODE_SELECT_FILE);
    }


    private void selectImage() {
        // Membuka file picker untuk memilih gambar
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*"); // Hanya gambar
        intent.putExtra(Intent.EXTRA_MIME_TYPES, new String[]{"image/png", "image/jpg", "image/jpeg"});
        startActivityForResult(Intent.createChooser(intent, "Pilih Gambar"), REQUEST_CODE_SELECT_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_SELECT_IMAGE && resultCode == RESULT_OK && data != null) {
            // Mendapatkan URI dari gambar yang dipilih
            Uri selectedImageUri = data.getData();
            if (selectedImageUri != null) {
                // Tampilkan gambar di ImageView
                image_book.setImageURI(selectedImageUri);

                // Tampilkan nama file di TextView
                String fileName = getFileName(selectedImageUri);
                text_name_image.setText(fileName);
            }
        }

        if (requestCode == REQUEST_CODE_SELECT_FILE && resultCode == RESULT_OK && data != null) {
            // Mendapatkan URI dari file yang dipilih
            Uri selectedFileUri = data.getData();
            if (selectedFileUri != null) {
                // Tampilkan nama file di TextView
                String fileName = getFileName(selectedFileUri);
                text_name_file.setText(fileName);
            }
        }
    }

    @SuppressLint("Range")
    private String getFileName(Uri uri) {
        String result = null;
        if (uri.getScheme().equals("content")) {
            try (Cursor cursor = getContentResolver().query(uri, null, null, null, null)) {
                if (cursor != null && cursor.moveToFirst()) {
                    result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                }
            }
        }
        if (result == null) {
            result = uri.getPath();
            int cut = result.lastIndexOf('/');
            if (cut != -1) {
                result = result.substring(cut + 1);
            }
        }
        return result;
    }

    private void saveBook() {
        String judulBuku = input_judul_buku.getText().toString();
        String penulis = input_nama_penulis.getText().toString();
        String penerbit = input_nama_penerbit.getText().toString();
        String tahunTerbit = input_tahun_terbit.getText().toString();
        String tahunKedatangan = input_tahun_kedatangan.getText().toString();
        String kodeBuku = input_kode_buku.getText().toString();
        String kodeRak = input_kode_rak.getText().toString();

        if(judulBuku.isEmpty()) {
            input_judul_buku.setError("Judul buku tidak boleh kosong");
        }
        if(penulis.isEmpty()) {
            input_nama_penulis.setError("Nama penulis tidak boleh kosong");
        }
        if(penerbit.isEmpty()) {
            input_nama_penerbit.setError("Nama penerbit tidak boleh kosong");
        }
        if(tahunTerbit.isEmpty()) {
            input_tahun_terbit.setError("Tahun terbit tidak boleh kosong");
        }

        if(tahunKedatangan.isEmpty()) {
            input_tahun_kedatangan.setError("Tahun kedatangan tidak boleh kosong");
        }

        if(kodeBuku.isEmpty()) {
            input_kode_buku.setError("Kode buku tidak boleh kosong");
        }

        if(kodeRak.isEmpty()) {
            input_kode_rak.setError("Kode rak tidak boleh kosong");
        }

        if (judulBuku.isEmpty() || penulis.isEmpty() || penerbit.isEmpty() || tahunTerbit.isEmpty() || tahunKedatangan.isEmpty() || kodeBuku.isEmpty() || kodeRak.isEmpty()) {

        }else{

        }
    }
}
