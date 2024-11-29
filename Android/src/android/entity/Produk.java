package android.entity;

import java.sql.Timestamp;

/**
 *
 * @author Legion
 */
public class Produk {    
    private int idBarang;  // Tidak final
    private String namaBarang;
    private double harga;
    private String deskripsi;
    private int stokBarang;  // Tidak final
    private String kategori;
    private String username;
    private int barangTerjual;

    
    public Produk(int idBarang, String namaBarang, double harga, String deskripsi, int stokBarang, String kategori, String username, int barangTerjual) {
        this.idBarang = idBarang;
        this.namaBarang = namaBarang;
        this.harga = harga;
        this.deskripsi = deskripsi;
        this.stokBarang = stokBarang;
        this.kategori = kategori;
        this.username = username;
        this.barangTerjual = barangTerjual;
    }

    // Getter
    public int getidBarang() { 
        return idBarang; 
    }
    
    public String getnamaBarang() { 
        return namaBarang; 
    }
    
    public double getharga() { 
        return harga; 
    }
    
    public String getdeskripsi() { 
        return deskripsi; 
    }
    
    public int getstokBarang() { 
        return stokBarang; 
    }

    // Setter
    public void setidBarang(int idBarang) { 
        this.idBarang = idBarang; 
    }

    public void setnamaBarang(String namaBarang) { 
        this.namaBarang = namaBarang; 
    }

    public void setharga(double harga) { 
        this.harga = harga; 
    }

    public void setdeskripsi(String deskripsi) { 
        this.deskripsi = deskripsi; 
    }

    public void setstokBarang(int stokBarang) { 
        this.stokBarang = stokBarang; 
    }

    public void setkategori(String kategori) { 
        this.kategori = kategori; 
    }

    public void setusername(String username) { 
        this.username = username; 
    }

    public void setbarangTerjual(int barangTerjual) { 
        this.barangTerjual = barangTerjual; 
    }

    public String getkategori() { 
        return kategori; 
    }
    
    public String getusername() { 
        return username; 
    }
    
    public int getbarangTerjual() { 
        return barangTerjual; 
    }
}
