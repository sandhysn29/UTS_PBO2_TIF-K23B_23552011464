/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

public class Tabungan extends Rekening {
    public Tabungan(int id, double saldo) {
        super(id, "Tabungan", saldo);
    }

    @Override
    public double hitungBunga() {
        return getSaldo() * 0.02;
    }
}