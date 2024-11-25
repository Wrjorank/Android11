/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package android.model;

import android.entity.Produk;
import android.entity.data;
import android.util.DBUtil;
import com.sun.jdi.connect.spi.Connection;
import java.beans.Statement;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Legion
 */
public class ProdukModel {

    public static int addProduk(String namaBarang, int harga, String deskripsi, int stokBarang) {
    String query = "INSERT INTO produk (namaBarang, harga, deskripsi, stokBarang) VALUES (?, ?, ?, ?)";
    
    try (java.sql.Connection conn = DBUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query, java.sql.Statement.RETURN_GENERATED_KEYS)) {


        // Validasi input
        if (harga < 0 || stokBarang < 0) {
            throw new IllegalArgumentException("Harga dan stok barang tidak boleh negatif.");
        }

        // Set parameter untuk query
        stmt.setString(1, namaBarang);
        stmt.setInt(2, harga);
        stmt.setString(3, deskripsi);
        stmt.setInt(4, stokBarang);

        // Eksekusi query dan cek jumlah baris yang terpengaruh
        int affectedRows = stmt.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("Gagal menambahkan produk, tidak ada baris yang terpengaruh.");
        }

        // Ambil ID yang dihasilkan
        try (ResultSet rs = stmt.getGeneratedKeys()) {
            if (rs.next()) {
                return rs.getInt(1); // Mengembalikan ID produk yang baru
            } else {
                throw new SQLException("Gagal mendapatkan ID produk yang baru.");
            }
        }

    } catch (SQLException e) {
        // Log error untuk debugging
        System.err.println("Error saat menambahkan produk: " + e.getMessage());
        e.printStackTrace();
    } catch (IllegalArgumentException e) {
        // Log untuk kesalahan validasi
        System.err.println("Input tidak valid: " + e.getMessage());
    }

    // Return -1 jika terjadi error
    return -1;
}

    
    public static Produk getProdukById(int idBarang) {
    // Query SQL untuk mendapatkan data produk berdasarkan ID
    String query = "SELECT p.ID_produk, p.namaBarang, p.harga, p.deskripsi, " +
                   "p.stokBarang, p.barangTerjual, r.username " +
                   "FROM produk p " +
                   "LEFT JOIN register r ON p.ID = r.id " +
                   "WHERE p.ID_produk = ?";

    try (java.sql.Connection conn = DBUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        // Set parameter ID produk
        stmt.setInt(1, idBarang);

        // Eksekusi query
        ResultSet rs = stmt.executeQuery();

        // Jika data ditemukan
        if (rs.next()) {
            return new Produk(
                rs.getInt("ID_produk"),
                rs.getString("namaBarang"),
                rs.getBigDecimal("harga").intValue(), // Konversi DECIMAL ke int
                rs.getString("deskripsi"),
                rs.getInt("stokBarang"),
                rs.getString("username"),
                rs.getInt("barangTerjual")
            );
        }
    } catch (SQLException e) {
        // Cetak pesan kesalahan jika terjadi
        System.err.println("Error saat mengambil data produk dengan ID " + idBarang + ": " + e.getMessage());
        e.printStackTrace();
    }

    // Kembalikan null jika produk tidak ditemukan
    return null;
}



    public static ArrayList<Produk> getAllProduk(String keyword) {
    ArrayList<Produk> produkList = new ArrayList<>();
    String query = "SELECT p.ID_produk, p.namaBarang, p.harga, p.deskripsi, " +
                   "p.stokBarang, p.barangTerjual, r.username " +
                   "FROM produk p " +
                   "LEFT JOIN register r ON p.ID = r.id";

    // Tambahkan filter jika keyword diberikan
    if (keyword != null && !keyword.isEmpty()) {
        query += " WHERE p.namaBarang LIKE ? ";
    }
    query += " ORDER BY p.ID_produk ASC";

    try (java.sql.Connection conn = DBUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        // Set parameter jika ada keyword
        if (keyword != null && !keyword.isEmpty()) {
            stmt.setString(1, "%" + keyword + "%");
        }

        // Eksekusi query dan proses hasil
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Produk produk = new Produk(
                rs.getInt("ID_produk"),
                rs.getString("namaBarang"),
                rs.getBigDecimal("harga").intValue(), // Konversi DECIMAL ke int
                rs.getString("deskripsi"),
                rs.getInt("stokBarang"),
                rs.getString("username"),
                rs.getInt("barangTerjual")
            );
            produkList.add(produk);
        }
    } catch (SQLException e) {
        // Log error untuk debugging
        System.err.println("Error saat mengambil data produk: " + e.getMessage());
        e.printStackTrace();
    }

    return produkList;
}


    // Update - Update a register entry by ID and return boolean
    public static boolean updateProduk(int id, String namaBarang, double harga, String deskripsi, int stokBarang, int barangTerjual) {
    String query = "UPDATE produk SET namaBarang = ?, harga = ?, deskripsi = ?, stokBarang = ?, WHERE ID_produk = ?";
    try (java.sql.Connection conn = DBUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        // Set parameter untuk query
        stmt.setString(1, namaBarang);
        stmt.setBigDecimal(2, BigDecimal.valueOf(harga)); // Konversi double ke BigDecimal
        stmt.setString(3, deskripsi);
        stmt.setInt(4, stokBarang);
        stmt.setInt(5, id);

        // Eksekusi query
        int rowsAffected = stmt.executeUpdate();
        return rowsAffected > 0; // True jika ada baris yang diperbarui
    } catch (SQLException e) {
        // Log error
        System.err.println("Error saat memperbarui produk dengan ID " + id + ": " + e.getMessage());
        e.printStackTrace();
    }

    return false; // False jika terjadi error
}

    // Delete - Menghapus produk berdasarkan ID dan mengembalikan boolean
public static boolean deleteProduk(int id) {
    String query = "DELETE FROM produk WHERE ID_produk = ?";
    try (java.sql.Connection conn = DBUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        // Set parameter ID
        stmt.setInt(1, id);

        // Eksekusi query dan periksa hasil
        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Berhasil menghapus produk dengan ID: " + id);
            return true;
        } else {
            System.out.println("Tidak ada produk dengan ID: " + id + " yang ditemukan untuk dihapus.");
        }
    } catch (SQLException e) {
        // Log error
        System.err.println("Error saat menghapus produk dengan ID " + id + ": " + e.getMessage());
        e.printStackTrace();
    }

    return false; // Return false jika gagal atau tidak ada data yang dihapus
}

}