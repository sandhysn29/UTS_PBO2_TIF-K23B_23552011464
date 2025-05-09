/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

public class Giro extends Rekening {
    public Giro(int id, double saldo) {
        super(id, "Giro", saldo);
    }

    @Override
    public double hitungBunga() {
        return getSaldo() * 0.01;
    }
}