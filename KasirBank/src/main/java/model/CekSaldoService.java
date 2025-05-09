/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import java.sql.*;
import com.mycompany.kasirbank.DatabaseConnection;

public class CekSaldoService {
    public static double getSaldo(int rekeningId) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT saldo FROM rekening WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, rekeningId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) return rs.getDouble("saldo");
        } catch (SQLException e) {
            System.out.println("Error cek saldo: " + e.getMessage());
        }
        return 0;
    }
}