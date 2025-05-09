/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

public class Nasabah {
    private int id;
    private String nama;
    private int rekeningId;

    public Nasabah(int id, String nama, int rekeningId) {
        this.id = id;
        this.nama = nama;
        this.rekeningId = rekeningId;
    }

    public String getNama() {
        return nama;
    }

    public int getRekeningId() {
        return rekeningId;
    }
}