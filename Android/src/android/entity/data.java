package android.entity;

import java.sql.Timestamp;

public class data {
    private final int id; // ID unik untuk pengguna
    private final String namaDepan;
    private final String namaBelakang;
    private final String username;
    private final String password;
    private final String alamat;
    private final String tanggalLahir;
    private final Timestamp createdAt;


    // Constructor
    public data(
            int id, String namaDepan, String namaBelakang, String username, String password, String alamat, String tanggalLahir, Timestamp createdAt) {
        this.id = id;
        this.namaDepan = namaDepan;
        this.namaBelakang = namaBelakang;
        this.username = username;
        this.password = password;
        this.alamat = alamat;
        this.tanggalLahir = tanggalLahir;
        this.createdAt = createdAt;
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getNamaDepan() {
        return namaDepan;
    }

    public String getNamaBelakang() {
        return namaBelakang;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }
}
