# mPusling - Aplikasi Peminjaman Buku Online dan Perpustakaan Keliling

**mPusling** adalah sebuah aplikasi berbasis web yang dirancang untuk mempermudah proses peminjaman buku secara online, khususnya untuk perpustakaan keliling. Aplikasi ini mendukung tiga jenis pengguna dengan peran berbeda: **Admin**, **Guru**, dan **Siswa**.

---

## Fitur Utama

### Untuk Admin:
1. **Manajemen Buku**
   - Tambah, edit, dan hapus data buku.
   - Upload cover buku dan deskripsi.
2. **Manajemen Pengguna**
   - Kelola data guru dan siswa yang terdaftar.
3. **Laporan Peminjaman**
   - Monitoring dan mencetak laporan peminjaman buku.

### Untuk Guru:
1. **Peminjaman Buku**
   - Pinjam buku secara online dari katalog yang tersedia.
2. **Riwayat Peminjaman**
   - Melihat riwayat peminjaman buku yang pernah dilakukan.
3. **Rekomendasi Buku**
   - Memberikan rekomendasi buku kepada siswa.

### Untuk Siswa:
1. **Peminjaman Buku**
   - Pinjam buku dengan mudah melalui aplikasi.
2. **Favoritkan Buku**
   - Menyimpan daftar buku favorit untuk dibaca di kemudian hari.
3. **Notifikasi**
   - Mendapatkan notifikasi terkait pengembalian buku dan rekomendasi baru.

---

## Teknologi yang Digunakan

- **Frontend:** HTML, CSS (Bootstrap), JavaScript (jQuery)
- **Backend:** PHP 8+ (CodeIgniter atau Laravel)
- **Database:** MySQL
- **Library Ikon:** Bootstrap Icons

---

## Instalasi

1. Clone repository ini:

   ```bash
   git clone https://github.com/username/mpusling.git
   ```

2. Konfigurasi database:
   - Impor file `mpusling.sql` ke MySQL.
   - Edit file konfigurasi database di `config/database.php` (untuk CodeIgniter) atau `.env` (untuk Laravel).

3. Jalankan aplikasi:
   - Untuk lokal: buka di browser dengan `http://localhost/mpusling`.
   - Untuk hosting: upload ke server Anda dan sesuaikan konfigurasi.

---

## Struktur Direktori

```
mpusling/
├── app/                   # Folder aplikasi utama
├── public/                # Folder untuk file yang diakses publik
├── resources/             # Template dan view
├── database/              # File migrasi database
└── README.md              # Dokumentasi proyek
```

---

## Tim Pengembang

- **Nama Pengembang 1** - Backend Developer
- **Nama Pengembang 2** - Frontend Developer
- **Nama Pengembang 3** - Database Administrator

---

## Lisensi

Aplikasi ini dirilis di bawah lisensi [MIT](https://opensource.org/licenses/MIT). Anda bebas menggunakan dan memodifikasi aplikasi ini dengan tetap menyertakan atribusi kepada pengembang asli.

---

## Catatan Tambahan

Jika Anda menemukan bug atau memiliki ide untuk pengembangan lebih lanjut, jangan ragu untuk membuat *issue* atau *pull request* di repository ini.

