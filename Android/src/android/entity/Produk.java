/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package android.entity;

import java.sql.Timestamp;

/**
 *
 * @author Legion
 */
public class Produk {    
    private final int idBarang;
    private final String namaBarang;
    private final double harga;
    private final String deskripsi;
    private final int stokBarang;
    private final String username;
    private final int barangTerjual;

    
    public Produk(int idBarang, String namaBarang, double harga, String deskripsi, int stokBarang, String username, int barangTerjual) {
        this.idBarang = idBarang;
        this.namaBarang = namaBarang;
        this.harga = harga;
        this.deskripsi = deskripsi;
        this.stokBarang = stokBarang;
        this.username = username;
        this.barangTerjual = barangTerjual;

}
    public int getidBarang() {
        return idBarang; 
    }
    
    public String namaBarang() { 
        return namaBarang; 
    }
    
    public double harga() { 
        return harga; 
    }
    
    public String deskripsi() { 
        return deskripsi; 
    }
    
    public int stokBarang() { 
        return stokBarang; 
    }
    
    public String username() { 
        return username; 
    }
    
    public int barangTerjual() { 
        return barangTerjual; 
    }
         
}
