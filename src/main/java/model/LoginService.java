/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import java.sql.*; 
import com.mycompany.kasirbank.DatabaseConnection;

public class LoginService {
    // Fungsi untuk login
    public static boolean login(int rekeningId, String pin) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            // Query untuk mengakses tabel 'nasabah', bukan 'rekening'
            String query = "SELECT * FROM nasabah WHERE rekening_id = ? AND pin = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, rekeningId); // Set rekeningId
            stmt.setString(2, pin); // Set PIN
            ResultSet rs = stmt.executeQuery();

            return rs.next(); // Jika ada data yang cocok, login berhasil
        } catch (SQLException e) {
            System.out.println("Error login: " + e.getMessage());
            return false;
        }
    }

    // Fungsi untuk mendapatkan nama nasabah
    public static String getNamaNasabah(int rekeningId) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT nama FROM nasabah WHERE rekening_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, rekeningId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) return rs.getString("nama"); // Mengembalikan nama nasabah
        } catch (SQLException e) {
            System.out.println("Error get nama: " + e.getMessage());
        }
        return null; // Jika tidak ditemukan, kembalikan null
    }
    
    public static String getJenisRekening(int rekeningId) {
    try (Connection conn = DatabaseConnection.getConnection()) {
        String query = "SELECT jenis FROM rekening WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, rekeningId);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) return rs.getString("jenis");
        } catch (SQLException e) {
           System.out.println("Error get jenis rekening: " + e.getMessage());
        }
        return null;
    }
}