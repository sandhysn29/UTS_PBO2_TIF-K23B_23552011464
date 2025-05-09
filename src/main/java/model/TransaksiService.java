/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import java.sql.*;
import com.mycompany.kasirbank.DatabaseConnection;

public class TransaksiService {
    public static boolean setorTunai(int rekeningId, double jumlah) {
        return updateSaldo(rekeningId, jumlah, "setor");
    }

    public static boolean tarikTunai(int rekeningId, double jumlah) {
        double saldo = CekSaldoService.getSaldo(rekeningId);
        if (jumlah > saldo) return false;
        return updateSaldo(rekeningId, -jumlah, "tarik");
    }

    private static boolean updateSaldo(int rekeningId, double jumlah, String tipe) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false);

            String updateSaldo = "UPDATE rekening SET saldo = saldo + ? WHERE id = ?";
            PreparedStatement stmt1 = conn.prepareStatement(updateSaldo);
            stmt1.setDouble(1, jumlah);
            stmt1.setInt(2, rekeningId);
            stmt1.executeUpdate();

            String insertTransaksi = "INSERT INTO transaksi (rekening_id, tipe, jumlah) VALUES (?, ?, ?)";
            PreparedStatement stmt2 = conn.prepareStatement(insertTransaksi);
            stmt2.setInt(1, rekeningId);
            stmt2.setString(2, tipe);
            stmt2.setDouble(3, Math.abs(jumlah));
            stmt2.executeUpdate();

            conn.commit();
            return true;
        } catch (SQLException e) {
            System.out.println("Error transaksi: " + e.getMessage());
            return false;
        }
    }
}