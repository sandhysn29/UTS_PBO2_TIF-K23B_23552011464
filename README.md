# UTS Pemrograman Berorientasi Obyek 2
<ul>
  <li>Mata Kuliah: Pemrograman Berorientasi Obyek 2</li>
  <li>Dosen Pengampu: <a href="https://github.com/Muhammad-Ikhwan-Fathulloh">Muhammad Ikhwan Fathulloh</a></li>
</ul>

## Profil
<ul>
  <li>Nama: Sandhy Safarudin Nurdiansyah</li>
  <li>NIM: 23552011464</li>
  <li>Studi Kasus: Kasir Bank</li>
</ul>

## Aplikasi Kasir Bank
<p>Aplikasi Kasir Bank adalah sebuah aplikasi berbasis Java yang dirancang untuk membantu pengelolaan transaksi perbankan secara sederhana namun efektif. Aplikasi ini memfasilitasi pencatatan dan pemrosesan berbagai jenis rekening seperti tabungan dan giro, memungkinkan pengguna untuk melakukan setor tunai, penarikan, serta melihat histori transaksi.</p>

## Penjelasan Studi Kasus
<p>Dalam kegiatan perbankan, transaksi dasar seperti cek saldo, setor tunai, dan tarik tunai harus dikelola dengan akurat dan efisien. Bank atau lembaga keuangan membutuhkan sistem yang dapat menangani berbagai jenis rekening dan mencatat setiap transaksi secara otomatis agar tidak terjadi kesalahan perhitungan atau pencatatan manual. Namun, banyak aplikasi simulasi yang tidak mencerminkan struktur nyata sistem perbankan dan belum menerapkan prinsip OOP dengan baik, sehingga sulit dikembangkan atau dimodifikasi.

Tidak adanya sistem kasir sederhana yang bisa digunakan untuk simulasi transaksi bank secara objektif dan modular.

Struktur kode yang tidak fleksibel dan sulit dikembangkan karena tidak menerapkan prinsip OOP seperti abstraksi, enkapsulasi, inheritance, dan polimorfisme. Perlu sistem yang bisa menangani lebih dari satu jenis rekening (Tabungan dan Giro) dengan aturan transaksi yang berbeda.

Solusi dari permasalahan ini adalah membangun Aplikasi Kasir Bank menggunakan Java dan MySQL dengan pendekatan OOP:
1. Abstraction: Menggunakan kelas abstract Rekening agar struktur dasar bisa digunakan oleh Tabungan dan Giro.
2. Inheritance: Tabungan dan Giro mewarisi dari Rekening dan memiliki perhitungan bunga masing-masing.
3. Encapsulation: Data penting seperti saldo, jenis rekening, dan informasi nasabah dibuat private dan hanya bisa diakses lewat getter/setter.
4. Polymorphism: Metode hitungBunga() diimplementasikan berbeda di masing-masing jenis rekening sesuai kebutuhannya.
</p>

## Penjelasan 4 Pilar OOP dalam Studi Kasus

### 1. Inheritance
<p>Inheritance artinya class anak mewarisi properti dan method dari class induk. Jadi tidak perlu menulis ulang koding yang sama, cukup diwarisi.
Kalau tidak pakai inheritance, harus tulis ulang semua field dan method yang sudah ada di Rekening. Jadi tidak efisien, dan kode jadi berantakan.

![image](https://github.com/user-attachments/assets/980cbfc0-df86-4403-be74-cd7a983ff243)
  
<strong>class Tabungan extends Rekening</strong><br>
Ini artinya Tabungan adalah anak dari class Rekening, dan otomatis punya semua variabel dan method-nya, seperti id, saldo, getSaldo(), dll.

<strong>super(id, "Tabungan", saldo);</strong><br>
super ini memanggil constructor dari class induk (Rekening). Kita isi parameter seperti id, jenis rekening ("Tabungan"), dan saldo.
</p>

### 2. Encapsulation
<p>Encapsulation artinya menyembunyikan data atau variabel dari luar supaya tidak sembarangan diubah-ubah. Jadi, kita membungkus data dan memberi aksesnya lewat method getter dan setter.

![image](https://github.com/user-attachments/assets/53a572f6-e3e2-4cd9-9a28-f91bea75aedc)
![image](https://github.com/user-attachments/assets/61c4164b-3a60-4184-8333-5830b85b4466)
![image](https://github.com/user-attachments/assets/604182b2-58ff-4ba4-bd06-f6594f818fc6)

<strong>private double saldo;</strong><br>
Artinya variabel saldo hanya bisa diakses dari dalam class itu sendiri (misalnya class Rekening). Jadi kode dari luar class tidak bisa langsung rekening.saldo = 10000;.
Kalau tidak pakai private, maka saldo bisa diubah oleh sembarang class — itu berbahaya, bisa merusak data.

<strong>public double getSaldo()</strong><br>
Ini fungsi (method) untuk mengambil nilai saldo. Kenapa harus pakai method? Karena kita bisa atur: misalnya hanya boleh ditampilkan kalau user sudah login.

<strong>public void setSaldo(double saldo)</strong><br>
Ini untuk mengubah nilai saldo, tapi tetap lewat method. Jadi kita bisa kasih syarat, misalnya: "jika nilai saldo negatif, jangan diterima".
</p>

### 3. Polymorphism
<p>Polymorphism artinya satu method bisa punya banyak bentuk tergantung siapa yang menjalankannya. Di Java, ini bisa lewat method overriding (menimpa method class induk).

![image](https://github.com/user-attachments/assets/a40782d3-916c-49e8-95ee-520a4e9854ed)
![image](https://github.com/user-attachments/assets/8713bec4-38f1-4abd-8f7f-02ae62815f25)

<strong>public abstract double hitungBunga();</strong><br>
Ini deklarasi method abstrak di class Rekening. Artinya, class Rekening tidak punya isi method-nya, tapi anak-anaknya (Tabungan/Giro) harus membuat sendiri versi mereka.

<strong>@Override</strong><br>
Ini menunjukkan bahwa method hitungBunga() di class Tabungan dan Giro adalah menimpa method induknya.

<strong>return getSaldo() * 0.01;</strong><br>
Maksudnya: bunga = saldo × 1% (untuk tabungan), sedangkan untuk giro, cuma 0.5%.
</p>

### 4. Abstract
<p>Abstraction artinya fokus ke fungsi penting saja, dan menyembunyikan detail teknis biar tidak susah dilihat pengguna. Caranya bisa pakai interface atau class abstract.
Abstraction buat program lebih bersih, gampang digunakan, dan gak bikin user pusing sama detail teknis.

![image](https://github.com/user-attachments/assets/24595a0e-0c54-4890-8303-09bee9387f02)
![image](https://github.com/user-attachments/assets/56f08641-0763-4e61-bc76-da9b139d6ee8)

<strong>interface LayananKeuangan</strong><br>
Ini deklarasi fungsinya saja, belum ada isinya. Semua class yang pakai ini wajib buat isi method-nya.

<strong>abstract class Rekening implements LayananKeuangan</strong><br>
Artinya Rekening adalah class abstrak yang juga mengimplementasikan interface. Jadi dia harus bikin isi dari setor() dan tarik().

Kenapa pakai ini? Agar struktur program jelas. Kita tahu bahwa setiap rekening pasti bisa setor dan tarik. Kalau tidak pakai abstraksi, mungkin ada class yang lupa kasih fungsi ini.
</p>

## Demo Proyek
<ul>
  <li>Github: <a href="">Github</a></li>
  <li>Youtube: <a href="https://youtu.be/ShblsOBuLzA?feature=shared">Youtube</a></li>
</ul>
