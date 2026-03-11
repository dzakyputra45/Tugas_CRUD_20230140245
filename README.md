# 🪪 Sistem Manajemen Data KTP

# 🖥️ Tampilan Aplikasi

### Dashboard


```
<img width="1919" height="866" alt="Screenshot 2026-03-11 112621" src="https://github.com/user-attachments/assets/d0bfaea1-c0b2-4e84-ba48-1984dd9e5e8f" />


```


# 🗄️ Struktur Database

Database: `spring`

Tabel: `ktp`

| Kolom        | Tipe Data | Keterangan                  |
| ------------ | --------- | --------------------------- |
| id           | INT       | Primary Key, Auto Increment |
| nomorKtp     | VARCHAR   | Unique                      |
| namaLengkap  | VARCHAR   | Nama lengkap                |
| alamat       | VARCHAR   | Alamat                      |
| tanggalLahir | DATE      | Tanggal lahir               |
| jenisKelamin | VARCHAR   | Laki-laki / Perempuan       |

---

# 🔌 API Endpoint

## 1️⃣ Menambahkan Data KTP

**POST**

```
http://localhost:8080/ktp
```

Request Body

```json
{
  "nomorKtp": "123456789",
  "namaLengkap": "Budi Santoso",
  "alamat": "Batam",
  "tanggalLahir": "2000-01-01",
  "jenisKelamin": "Laki-laki"
}
```

Response

```
Data berhasil ditambahkan
```

---

## 2️⃣ Mengambil Semua Data

**GET**

```
http://localhost:8080/ktp
```

Response

```json
[
 {
   "id": 1,
   "nomorKtp": "123456789",
   "namaLengkap": "Budi Santoso",
   "alamat": "Batam",
   "tanggalLahir": "2000-01-01",
   "jenisKelamin": "Laki-laki"
 }
]
```

---

## 3️⃣ Mengambil Data Berdasarkan ID

**GET**

```
http://localhost:8080/ktp/{id}
```

---

## 4️⃣ Update Data

**PUT**

```
http://localhost:8080/ktp/{id}
```

---

## 5️⃣ Hapus Data

**DELETE**

```
http://localhost:8080/ktp/{id}
```

---

# ⚠️ Validasi

Aplikasi memiliki validasi:

```
Nomor KTP tidak boleh sama
```

Jika user mencoba memasukkan nomor KTP yang sudah ada, maka API akan mengembalikan error.

Contoh response:

```json
{
 "error": "Nomor KTP tidak boleh sama"
}
```

---


### 3️⃣ Jalankan Spring Boot

Run:

```
Praktkum2Application
```

Server akan berjalan di:

```
http://localhost:8080
```

---

