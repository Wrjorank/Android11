/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package android.repository;

import android.entity.Produk;
import android.model.ProdukModel;
import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author Iky
 */
public class RepoProduk implements IRepoProduk{
    
    @Override
    public ArrayList<Produk> repoGetAllProduk() {
        return ProdukModel.getAllProduk("");
    } 
    
    @Override
    public int repoAddProduk (String namaBarang, double harga, String deskripsi, int stokBarang, String kategori, String username, int userID) {
        return ProdukModel.addProduk(namaBarang, harga, deskripsi, stokBarang, kategori, username, userID);
    } 
    
    @Override
    public boolean repoRemoveProduk(int id) {
        return ProdukModel.deleteProduk(id);
    } 
    
    @Override
    public boolean repoUpdateProduk(int id, String namaBarang, double harga, String deskripsi, int stokBarang, int barangTerjual) {
        return ProdukModel.updateProduk(id, namaBarang, harga, deskripsi, stokBarang, barangTerjual);
    }
    
    @Override
    public Produk repoGetProdukById(int id) {
        return ProdukModel.getProdukById(id);
    } 
    
    
    @Override
    public ArrayList<Produk> repoSearchProduk(String keywords) {
        return ProdukModel.getAllProduk(keywords);
    }
    
    @Override
    public ArrayList<Produk> repoSearchProdukbyKategori(String keywords) {
        return ProdukModel.getSearchProduk(keywords);
    }

    @Override
    public int repoGetUserIDByUsername (String username){
        return ProdukModel.getUserIDByUsername(username);
    }
    
    @Override
    public String repoGetUsernameByUserIDproduk (int ID){
        return ProdukModel.getUsernameByUserIDproduk(ID);
    }
    
    @Override
    public ArrayList<Produk> repoGetAllUserProduk() {
        return ProdukModel.getAllUserProduk("");
    } 
    
    
}
