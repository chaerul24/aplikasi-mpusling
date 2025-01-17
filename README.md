# mPusling - Aplikasi Peminjaman Buku Online dan Perpustakaan Keliling

**mPusling** adalah aplikasi berbasis Android yang dirancang untuk mempermudah proses peminjaman buku secara online, khususnya untuk mendukung operasional perpustakaan keliling. Aplikasi ini menggunakan **Android Studio (Java)** dengan integrasi **Firebase** untuk mendukung fitur autentikasi, penyimpanan data real-time, dan notifikasi.

---

## Fitur Utama

### Untuk Admin:
1. **Manajemen Buku**
   - Tambah, edit, dan hapus data buku.
   - Upload cover buku dan deskripsi ke Firebase Storage.
2. **Manajemen Pengguna**
   - Kelola data akun guru dan siswa melalui Firebase Authentication.
   - Pantau aktivitas pengguna.
3. **Laporan Peminjaman**
   - Monitoring data peminjaman melalui Firebase Realtime Database.
   - Unduh laporan dalam format PDF.

### Untuk Guru:
1. **Peminjaman Buku**
   - Cari dan pinjam buku secara online dari katalog Firebase.
2. **Riwayat Peminjaman**
   - Melihat daftar buku yang telah dipinjam sebelumnya.
3. **Rekomendasi Buku**
   - Mengajukan rekomendasi buku kepada siswa tertentu.

### Untuk Siswa:
1. **Peminjaman Buku**
   - Pinjam buku langsung melalui aplikasi.
2. **Favoritkan Buku**
   - Menyimpan daftar buku favorit untuk referensi.
3. **Notifikasi**
   - Menerima pemberitahuan tentang pengembalian buku, rekomendasi, dan promosi buku baru.

---

## Teknologi yang Digunakan

1. **Android Studio (Java):** Platform pengembangan aplikasi Android.
2. **Firebase Authentication:** Untuk login dan pengelolaan akun pengguna.
3. **Firebase Realtime Database:** Penyimpanan data buku, peminjaman, dan aktivitas pengguna.
4. **Firebase Storage:** Penyimpanan file seperti cover buku.
5. **Firebase Cloud Messaging:** Mengirim notifikasi ke pengguna.

---

## Instalasi dan Konfigurasi

1. **Clone repository ini:**
   ```bash
   git clone https://github.com/username/mpusling.git
   ```

2. **Buka proyek di Android Studio:**
   - Pastikan Anda memiliki versi terbaru Android Studio.
   - Tambahkan file `google-services.json` yang diunduh dari Firebase Console ke direktori `app/`.

3. **Konfigurasi Firebase:**
   - Buat proyek Firebase di [Firebase Console](https://console.firebase.google.com/).
   - Aktifkan Firebase Authentication, Realtime Database, Storage, dan Cloud Messaging.

4. **Jalankan aplikasi:**
   - Hubungkan perangkat atau gunakan emulator.
   - Klik **Run** di Android Studio.

---

## Struktur Proyek

```
mpusling-android/
├── app/                   # Folder kode aplikasi utama
│   ├── src/               # Sumber kode
│   │   ├── main/          # Kode utama aplikasi
│   │   └── res/           # Sumber daya seperti layout XML
├── google-services.json   # File konfigurasi Firebase
└── README.md              # Dokumentasi proyek
```

---

## Screenshot

1. **Halaman Login:**
   - Autentikasi pengguna melalui email dan password.
2. **Dashboard Admin:**
   - Tampilan intuitif untuk mengelola buku dan pengguna.
3. **Katalog Buku:**
   - Daftar buku dengan opsi pencarian dan filter.

---

## Lisensi

Aplikasi ini dirilis di bawah lisensi [MIT](https://opensource.org/licenses/MIT). Anda bebas menggunakan dan memodifikasi aplikasi ini dengan tetap menyertakan atribusi kepada pengembang asli.

---

## Catatan Tambahan

- Jika Anda menemukan bug atau memiliki ide untuk pengembangan lebih lanjut, jangan ragu untuk membuat *issue* atau *pull request* di repository ini.
- Dokumentasi lengkap tersedia di dalam repository.

Selamat menggunakan aplikasi **mPusling** untuk mendukung kegiatan perpustakaan keliling Anda!

