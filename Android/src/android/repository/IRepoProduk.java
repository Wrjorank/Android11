/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package android.repository;

import android.entity.Produk;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public interface IRepoProduk {
    ArrayList<Produk> repoGetAllProduk();
    
    int repoAddProduk(String namaBarang, double harga, String deskripsi, int stokBarang, int userID);
    
    boolean repoRemoveProduk(int id);
    
    boolean repoUpdateProduk(int id, String namaBarang, double harga, String deskripsi, int stokBarang, int barangTerjual);
    
    Produk repoGetProdukById(int id);
    
    ArrayList<Produk> repoSearchProduk (String keywords);
    
    int repoGetUserIDByUsername (String username);
}
