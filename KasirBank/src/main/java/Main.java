/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Scanner;
import model.LoginService;
import model.TransaksiService;
import model.CekSaldoService;
import model.Rekening;
import model.Tabungan;
import model.Giro;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Selamat Datang =====");
        System.out.print("Masukkan ID Rekening: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan PIN: ");
        String pin = scanner.nextLine();

        if (LoginService.login(id, pin)) {
            String nama = LoginService.getNamaNasabah(id);
            String jenis = LoginService.getJenisRekening(id);
            double saldo = CekSaldoService.getSaldo(id);
            Rekening rekening;

            if ("Tabungan".equalsIgnoreCase(jenis)) {
                rekening = new Tabungan(id, saldo);
            } else {
                rekening = new Giro(id, saldo);
            }

            System.out.println("Login berhasil! Selamat datang, " + nama + ". Ini rekening " + rekening.getJenis() + " kamu.");

            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1. Cek Saldo");
                System.out.println("2. Setor Tunai");
                System.out.println("3. Tarik Tunai");
                System.out.println("4. Hitung Bunga");
                System.out.println("0. Keluar");
                System.out.print("Pilih: ");
                int pilihan = scanner.nextInt();

                if (pilihan == 0) break;

                switch (pilihan) {
                    case 1 -> System.out.println("Saldo anda: Rp " + rekening.getSaldo());
                    case 2 -> {
                        System.out.print("Jumlah setor: ");
                        double setor = scanner.nextDouble();
                        rekening.setor(setor);
                        if (TransaksiService.setorTunai(id, setor)) {
                            System.out.println("Setor berhasil!");
                        }
                    }
                    case 3 -> {
                        System.out.print("Jumlah tarik: ");
                        double tarik = scanner.nextDouble();
                        if (rekening.getSaldo() >= tarik) {
                            rekening.tarik(tarik);
                            if (TransaksiService.tarikTunai(id, tarik)) {
                                System.out.println("Tarik berhasil!");
                            }
                        } else {
                            System.out.println("Saldo tidak cukup!");
                        }
                    }
                    case 4 -> System.out.println("Perkiraan bunga bulan ini: Rp " + rekening.hitungBunga());
                    default -> System.out.println("Pilihan tidak valid.");
                }
            }

        } else {
            System.out.println("Login gagal! ID atau PIN salah.");
        }
    }
}