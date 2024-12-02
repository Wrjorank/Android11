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
import static javax.swing.text.html.HTML.Attribute.ID;

/**
 *
 * @author Legion
 */
public class ProdukModel {

    public static int addProduk(String namaBarang, double harga, String deskripsi, int stokBarang, String kategori, String username, byte [] gambar, int ID) {
    String query = "INSERT INTO produk (namaBarang, harga, deskripsi, stokBarang, kategori, username, gambar, ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    
    try (java.sql.Connection conn = DBUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query, java.sql.Statement.RETURN_GENERATED_KEYS)) {

        // Validasi input
        if (harga < 0 || stokBarang < 0) {
            throw new IllegalArgumentException("Harga dan stok barang tidak boleh negatif.");
        }

        // Set parameter untuk query
        stmt.setString(1, namaBarang);
        stmt.setDouble(2, harga);
        stmt.setString(3, deskripsi);
        stmt.setInt(4, stokBarang);
        stmt.setString(5, kategori);
        stmt.setString(6, username);
        stmt.setBytes(7, gambar); // Simpan gambar
        stmt.setInt(8, ID);

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
        System.err.println("Error saat menambahkan produk: " + e.getMessage());
        e.printStackTrace();
    } catch (IllegalArgumentException e) {
        System.err.println("Input tidak valid: " + e.getMessage());
    }

    return -1;
}


    public static int getUserIDByUsername(String username) {
    int userID = -1;
    try (java.sql.Connection conn = DBUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement("SELECT id FROM register WHERE username = ?")) {
        stmt.setString(1, username);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                userID = rs.getInt("id");
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
        return userID;
    }

    public static String getUsernameByUserIDproduk(int ID_produk) {
    String username = null; // Default null jika tidak ditemukan
    try (java.sql.Connection conn = DBUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement("SELECT username FROM produk WHERE ID_produk = ?")) {
        stmt.setInt(1, ID_produk); // Menggunakan userID sebagai parameter pencarian
        
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                username = rs.getString("username"); // Mendapatkan username berdasarkan ID
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return username; // Mengembalikan username, null jika tidak ditemukan
    }


    public static Produk getProdukById(int idBarang) {
    // Query SQL untuk mendapatkan data produk berdasarkan ID
    String query = "SELECT p.ID_produk, p.namaBarang, p.harga, p.deskripsi, " +
                   "p.stokBarang, p.barangTerjual, p.kategori, r.username " +
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
                rs.getString("kategori"),  
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
                   "p.stokBarang, p.barangTerjual, p.kategori, r.username " +
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
                rs.getString("kategori"),
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
    
    public static ArrayList<Produk> getSearchProduk(String keyword) {
    ArrayList<Produk> produkList = new ArrayList<>();
    String query = "SELECT p.ID_produk, p.namaBarang, p.harga, p.deskripsi, " +
                   "p.stokBarang, p.barangTerjual, p.kategori, r.username " +
                   "FROM produk p " +
                   "LEFT JOIN register r ON p.ID = r.id";

    // Tambahkan filter jika keyword diberikan
    if (keyword != null && !keyword.isEmpty()) {
        query += " WHERE p.kategori LIKE ? ";
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
                rs.getString("kategori"),
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


public static boolean updateProduk(int id, String namaBarang, double harga, String deskripsi, int stokBarang, String kategori) {
    String query = "UPDATE produk SET namaBarang = ?, harga = ?, deskripsi = ?, stokBarang = ?, kategori = ? WHERE ID_produk = ?";
    try (java.sql.Connection conn = DBUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setString(1, namaBarang);
        stmt.setDouble(2, harga);
        stmt.setString(3, deskripsi);
        stmt.setInt(4, stokBarang);
        stmt.setString(5, kategori); // Parameter kategori dimasukkan
        stmt.setInt(6, id);          // Parameter ID produk dimasukkan

        int affectedRows = stmt.executeUpdate();
        return affectedRows > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
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
public static ArrayList<Produk> getAllUserProduk(String keyword) {
    ArrayList<Produk> produkList = new ArrayList<>();
    int userID = sessionModel.getUserID();
    String query = "SELECT p.ID_produk, p.namaBarang, p.harga, p.deskripsi, " +
                   "p.stokBarang, p.barangTerjual, p.kategori, r.username " +
                   "FROM produk p " +
                   "LEFT JOIN register r ON p.ID = r.id " +
                   "WHERE p.ID = ?";

    // Tambahkan filter jika keyword diberikan
    if (keyword != null && !keyword.isEmpty()) {
        query += " AND p.namaBarang LIKE ?";
    }

    query += " ORDER BY p.ID_produk ASC";

    try (java.sql.Connection conn = DBUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        // Set parameter userID
        stmt.setInt(1, userID);

        // Set parameter keyword jika ada
        if (keyword != null && !keyword.isEmpty()) {
            stmt.setString(2, "%" + keyword + "%");
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
                rs.getString("kategori"),
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

public static boolean purchaseProduct(int idProduk, int jumlahPembelian) {
    // Ambil data produk berdasarkan ID
    Produk produk = getProdukById(idProduk);
    if (produk == null) {
        System.out.println("Produk tidak ditemukan.");
        return false;
    }

    // Periksa apakah stok cukup
    if (produk.getstokBarang() < jumlahPembelian) {
        System.out.println("Stok tidak mencukupi untuk pembelian.");
        return false;
    }

    // Kurangi stok produk
    int stokBaru = produk.getstokBarang() - jumlahPembelian;

    // Update stok di database
    return updateStok(idProduk, stokBaru);
}

public static boolean updateStok(int idProduk, int stokBaru) {
    String query = "UPDATE produk SET stokBarang = ? WHERE ID_produk = ?";
    try (java.sql.Connection conn = DBUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        // Set parameter untuk query
        stmt.setInt(1, stokBaru);
        stmt.setInt(2, idProduk);

        // Eksekusi query
        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Stok produk berhasil diperbarui.");
            return true;
        } else {
            System.out.println("Gagal memperbarui stok produk.");
        }
    } catch (SQLException e) {
        System.err.println("Error saat memperbarui stok produk: " + e.getMessage());
        e.printStackTrace();
    }
    return false; // Jika gagal memperbarui stok
}

public static String getGambarPathById(int idBarang) {
    String query = "SELECT gambar FROM produk WHERE ID_produk = ?";

    try (java.sql.Connection conn = DBUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setInt(1, idBarang);

        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getString("gambar"); // Ambil path gambar dari kolom
        }
    } catch (SQLException e) {
        System.err.println("Error saat mengambil path gambar untuk ID " + idBarang + ": " + e.getMessage());
        e.printStackTrace();
    }

    return null; // Jika tidak ditemukan, kembalikan null
}


}