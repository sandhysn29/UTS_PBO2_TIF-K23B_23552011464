/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import java.util.Date;

public class Transaksi {
    private int id;
    private int rekeningId;
    private String tipe;
    private double jumlah;
    private Date tanggal;

    public Transaksi(int id, int rekeningId, String tipe, double jumlah, Date tanggal) {
        this.id = id;
        this.rekeningId = rekeningId;
        this.tipe = tipe;
        this.jumlah = jumlah;
        this.tanggal = tanggal;
    }

    public int getId() {
        return id;
    }

    public int getRekeningId() {
        return rekeningId;
    }

    public String getTipe() {
        return tipe;
    }

    public double getJumlah() {
        return jumlah;
    }

    public Date getTanggal() {
        return tanggal;
    }
}