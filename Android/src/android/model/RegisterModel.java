package android.model;

import java.sql.*;
import java.util.ArrayList;
import android.entity.data;
import android.util.DBUtil;

public class RegisterModel {

    // Create - Add a new register entry and return the generated ID
   public static int addRegister(String namaDepan, String namaBelakang, String username, String password, String tanggalLahir, String alamat) {
    // Modified query without createdAt
    String query = "INSERT INTO register (namaDepan, namaBelakang, username, password, alamat, tanggalLahir) VALUES (?, ?, ?, ?, ?, ?)";
    
    try (Connection conn = DBUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

        // Set parameters
        stmt.setString(1, namaDepan);
        stmt.setString(2, namaBelakang);
        stmt.setString(3, username);
        stmt.setString(4, password);
        stmt.setString(5, alamat);
        stmt.setString(6, tanggalLahir);
        // Execute update and get the generated keys
        int rowsAffected = stmt.executeUpdate();
        System.out.println("Rows inserted: " + rowsAffected);

        // Get generated key (the auto-incremented ID)
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1); // Return the generated ID of the inserted row
        }
    } catch (SQLException e) {
        System.err.println("Error adding register: " + e.getMessage());
        e.printStackTrace();
    }
    return -1;  // Return -1 in case of failure
}



    // Read - Get register details by ID
    public static data getRegisterById(int id) {
        String query = "SELECT * FROM register WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new data(
                        rs.getInt("id"),
                        rs.getString("namaDepan"),
                        rs.getString("namaBelakang"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("alamat"),
                        rs.getString("tanggalLahir")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Read All - Get all register entries or filter by keyword in `nama_depan` or `nama_belakang`
    public static ArrayList<data> getAllRegisters(String keyword) {
        ArrayList<data> registers = new ArrayList<>();
        String query = "SELECT * FROM register";
        if (keyword != null && !keyword.isEmpty()) {
            query += " WHERE namaDepan LIKE ? OR namaBelakang LIKE ?";
        }
        query += " ORDER BY id ASC";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            if (keyword != null && !keyword.isEmpty()) {
                stmt.setString(1, "%" + keyword + "%");
                stmt.setString(2, "%" + keyword + "%");
            }
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                registers.add(new data(
                        rs.getInt("id"),
                         rs.getString("namaDepan"),
                        rs.getString("namaBelakang"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("alamat"),
                        rs.getString("tanggalLahir")
                        
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registers;
    }

    // Update - Update a register entry by ID and return boolean
    public static boolean updateRegister(int id, String namaDepan, String namaBelakang, String username, String password, String tanggalLahir, String alamat) {
        String query = "UPDATE register SET namaDepan = ?, namaBelakang = ?, username = ?, password = ?, tanggalLahir = ?, alamat = ? WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, namaDepan);
            stmt.setString(2, namaBelakang);
            stmt.setString(3, username);
            stmt.setString(4, password);
            stmt.setString(5, tanggalLahir);
            stmt.setString(6, alamat);
            stmt.setInt(7, id);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Delete - Delete a register entry by ID and return boolean
    public static boolean deleteRegister(int id) {
        String query = "DELETE FROM register WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean validateLogin(String username, String password) {
        String query = "SELECT * FROM register WHERE username = ?";
        
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Set the username parameter
            stmt.setString(1, username);

            // Execute the query
            ResultSet rs = stmt.executeQuery();
            
            // Check if a user with this username exists
            if (rs.next()) {
                String storedPassword = rs.getString("password");  // Get the password from the database

                // Compare the entered password with the stored password
                if (storedPassword.equals(password)) {
                    return true;  // Login is successful
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // If username or password does not match, return false
        return false;
    }
}

