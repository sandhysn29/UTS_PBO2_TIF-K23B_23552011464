/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

public abstract class Rekening implements LayananKeuangan {
    private int id;
    private String jenis;
    private double saldo;

    public Rekening(int id, String jenis, double saldo) {
        this.id = id;
        this.jenis = jenis;
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getJenis() {
        return jenis;
    }

    public void setor(double jumlah) {
        this.saldo += jumlah;
    }

    public void tarik(double jumlah) {
        this.saldo -= jumlah;
    }

    public abstract double hitungBunga();
}