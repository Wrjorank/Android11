package android.model;

import java.sql.*;
import java.util.ArrayList;
import android.entity.data;
import android.util.DBUtil;

public class RegisterModel {

    // Create - Add a new register entry and return the generated ID
    public static int addRegister(String namaDepan, String namaBelakang, String username, String password, String tanggalLahir, String alamat) {
        String query = "INSERT INTO register (nama_depan, nama_belakang, username, password, tanggal_lahir, alamat, created_at) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, namaDepan);
            stmt.setString(2, namaBelakang);
            stmt.setString(3, username);
            stmt.setString(4, password);
            stmt.setString(5, tanggalLahir);
            stmt.setString(6, alamat);

            // Automatically assign the current timestamp
            Timestamp createdAt = new Timestamp(System.currentTimeMillis());
            stmt.setTimestamp(7, createdAt);

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Return -1 if the insertion fails
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
                        rs.getString("nama_depan"),
                        rs.getString("nama_belakang"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("alamat"),
                        rs.getString("tanggal_lahir"),
                        rs.getTimestamp("created_at")
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
            query += " WHERE nama_depan LIKE ? OR nama_belakang LIKE ?";
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
                        rs.getString("nama_depan"),
                        rs.getString("nama_belakang"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("alamat"),
                        rs.getString("tanggal_lahir"),
                        rs.getTimestamp("created_at")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registers;
    }

    // Update - Update a register entry by ID and return boolean
    public static boolean updateRegister(int id, String namaDepan, String namaBelakang, String username, String password, String tanggalLahir, String alamat) {
        String query = "UPDATE register SET nama_depan = ?, nama_belakang = ?, username = ?, password = ?, tanggal_lahir = ?, alamat = ? WHERE id = ?";
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
}
