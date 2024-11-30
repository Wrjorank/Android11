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


    // Constructor
    public data(
            int id, String namaDepan, String namaBelakang, String username, String password, String alamat, String tanggalLahir, int saldo) {
        this.id = id;
        this.namaDepan = namaDepan;
        this.namaBelakang = namaBelakang;
        this.username = username;
        this.password = password;
        this.alamat = alamat;
        this.tanggalLahir = tanggalLahir;
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

    public Object getSaldo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
