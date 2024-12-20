/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package android.view.panel;

import android.model.ProdukModel;
import android.model.sessionModel;
import android.repository.IRepoProduk;
import android.view.EcommersMain;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

/**
 *
 * @author Legion
 */
public class KonfirmasiPanel extends javax.swing.JFrame {
        private final IRepoProduk repo;
        private final Runnable callback;
        private static int stok1;
    /**
     * Creates new form BuyingPanel
     */
    public KonfirmasiPanel(IRepoProduk repo, Runnable callback) {
        System.out.println("BuyingPanel");
        this.repo = repo;
        this.callback = callback;
        
        
        initComponents();
        jjumlahbrg.setText("1");
      
         this.setLocationRelativeTo(null);
        this.setFocusable(true);
        this.requestFocusInWindow();
    }
    
    public void setStok(int stokmax) {
            stok1 = stokmax;
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jnamabrg = new javax.swing.JTextField();
        jdeskripsibrg = new javax.swing.JTextField();
        jhargabrg = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labelstok = new javax.swing.JLabel();
        totalHarga = new javax.swing.JTextField();
        IDBarang = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jbeli = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jbrgtambah = new javax.swing.JButton();
        jbrgkurang = new javax.swing.JButton();
        jjumlahbrg = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setBackground(new java.awt.Color(51, 153, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("KONFIRMASI PEMBELIAN");

        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jnamabrg.setEditable(false);
        jnamabrg.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jnamabrg.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jnamabrg.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jnamabrgFocusLost(evt);
            }
        });

        jdeskripsibrg.setEditable(false);
        jdeskripsibrg.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        jdeskripsibrg.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jdeskripsibrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdeskripsibrgActionPerformed(evt);
            }
        });

        jhargabrg.setEditable(false);
        jhargabrg.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jhargabrg.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setBackground(new java.awt.Color(51, 153, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Nama Barang");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Harga/Barang (Rp)");

        labelstok.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelstok.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelstok.setText("Harga Total");

        totalHarga.setEditable(false);
        totalHarga.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        totalHarga.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totalHarga.setToolTipText("");

        IDBarang.setEditable(false);
        IDBarang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        IDBarang.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        IDBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDBarangActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Toko");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(142, 142, 142))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jdeskripsibrg, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelstok)
                .addGap(164, 164, 164))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jhargabrg, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                    .addComponent(jnamabrg)
                    .addComponent(totalHarga)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                        .addGap(9, 9, 9)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(IDBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(IDBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jnamabrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jdeskripsibrg, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jhargabrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelstok)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(totalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jPanel2.setBackground(new java.awt.Color(25, 38, 65));

        jButton3.setBackground(new java.awt.Color(255, 0, 0));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setText("Batal");
        jButton3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton3.setBorderPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jbeli.setBackground(new java.awt.Color(51, 255, 51));
        jbeli.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbeli.setText("Beli");
        jbeli.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jbeli.setBorderPainted(false);
        jbeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbeliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbeli, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbeli, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jbrgtambah.setBackground(new java.awt.Color(204, 204, 204));
        jbrgtambah.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbrgtambah.setText("+");
        jbrgtambah.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbrgtambah.setBorderPainted(false);
        jbrgtambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbrgtambahActionPerformed(evt);
            }
        });

        jbrgkurang.setBackground(new java.awt.Color(204, 204, 204));
        jbrgkurang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbrgkurang.setText("-");
        jbrgkurang.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbrgkurang.setBorderPainted(false);
        jbrgkurang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbrgkurangActionPerformed(evt);
            }
        });

        jjumlahbrg.setBackground(new java.awt.Color(242, 242, 242));
        jjumlahbrg.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jjumlahbrg.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jjumlahbrg.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jjumlahbrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jjumlahbrgActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbrgkurang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jjumlahbrg, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbrgtambah, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jjumlahbrg)
                    .addComponent(jbrgtambah, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jbrgkurang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32))
        );

        jPanel5.setBackground(new java.awt.Color(25, 38, 65));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("KONFIRMASI PEMBELIAN");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbrgkurangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbrgkurangActionPerformed
        try {
        // Ambil nilai stok dari JTextField
        int stok = Integer.parseInt(jjumlahbrg.getText());
        
        // Kurangi 1 pada stok
        if (stok > 1) { // Pastikan stok tidak negatif
            stok -= 1;
        } else {
            JOptionPane.showMessageDialog(this, "Jumlah barang tidak boleh kurang dari 1!", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Set nilai baru ke JTextField
        jjumlahbrg.setText(String.valueOf(stok));
         
    } catch (NumberFormatException e) {
        // Jika stok bukan angka valid, tampilkan pesan error
        JOptionPane.showMessageDialog(this, "Nilai stok tidak valid!", "Error", JOptionPane.ERROR_MESSAGE);
    }
     
     double value1 = Double.parseDouble(jhargabrg.getText());
     double value2 = Double.parseDouble(jjumlahbrg.getText());

     totalHarga.setText(String.valueOf(value1 * value2));
    }//GEN-LAST:event_jbrgkurangActionPerformed

    private void jdeskripsibrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdeskripsibrgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jdeskripsibrgActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
        EcommersMain ecommersMain = new EcommersMain();
        ecommersMain.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jbeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbeliActionPerformed
     try {
        String idbarang = IDBarang.getText();
        double value1 = Double.parseDouble(jhargabrg.getText());
        double value2 = Double.parseDouble(jjumlahbrg.getText());
        double totalHarga = value1 * value2;

        int jumlahBarang = Integer.parseInt(jjumlahbrg.getText());
        String namaBarang = jnamabrg.getText();

        // Konfirmasi pembelian
        int pilihan = JOptionPane.showConfirmDialog(
            this, 
            "Apakah Anda yakin ingin membeli? Total harga: " + totalHarga, 
            "Konfirmasi Pembelian", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.QUESTION_MESSAGE
        );

        if (pilihan == JOptionPane.YES_OPTION) {
            // Kurangi saldo pengguna
            double saldoBaru = updateKurangSaldo(totalHarga);
            if (saldoBaru == -1) {
                JOptionPane.showMessageDialog(this, "Saldo Anda tidak cukup. Lakukan Top Up saldo lebih dulu!");
                return;
            }
            
            else{
                // Kurangi stok dan update barang terjual
                boolean berhasil = kurangiStokDanUpdateBarangTerjual(namaBarang, jumlahBarang);
                updateTambahSaldo(idbarang, totalHarga);
                
                if (berhasil) {
                    JOptionPane.showMessageDialog(this, "Pembelian berhasil diproses! Total harga: " + totalHarga);
                } else {
                    JOptionPane.showMessageDialog(this, "Stok barang tidak mencukupi!", "Error", JOptionPane.ERROR_MESSAGE);

                    // Kembalikan saldo jika stok tidak cukup

                }
            }
            } else {
                JOptionPane.showMessageDialog(this, "Pembelian dibatalkan.");
            }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Pastikan jumlah dan harga valid!", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan!", "Error", JOptionPane.ERROR_MESSAGE);
    }
        this.dispose();
    EcommersMain ecommersMain = new EcommersMain();
    ecommersMain.setVisible(true);
    }//GEN-LAST:event_jbeliActionPerformed

    private boolean kurangiStokDanUpdateBarangTerjual(String namaBarang, int jumlahBarangDibeli) {
    String url = "jdbc:mariadb://localhost:3306/proyek_register"; // Ganti dengan nama database Anda
    String username = "root"; // Ganti dengan username database Anda
    String password = ""; // Ganti dengan password database Anda

    String queryCekStok = "SELECT stokBarang, barangTerjual FROM Produk WHERE namaBarang = ?";
    String queryUpdate = "UPDATE Produk SET stokBarang = stokBarang - ?, barangTerjual = barangTerjual + ? WHERE namaBarang = ?";

    try (Connection conn = DriverManager.getConnection(url, username, password)) {
        // Cek stok barang
        try (PreparedStatement cekStokStmt = conn.prepareStatement(queryCekStok)) {
            cekStokStmt.setString(1, namaBarang);
            try (ResultSet rs = cekStokStmt.executeQuery()) {
                if (rs.next()) {
                    int stokTersedia = rs.getInt("stokBarang");

                    if (stokTersedia >= jumlahBarangDibeli) {
                        // Update stok dan barang terjual
                        try (PreparedStatement updateStmt = conn.prepareStatement(queryUpdate)) {
                            updateStmt.setInt(1, jumlahBarangDibeli);
                            updateStmt.setInt(2, jumlahBarangDibeli);
                            updateStmt.setString(3, namaBarang);
                            updateStmt.executeUpdate();
                            return true;
                        }
                    } else {
                        System.out.println("Stok tidak mencukupi.");
                        return false;
                    }
                } else {
                    System.out.println("Barang tidak ditemukan.");
                    return false;
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}
    
    private double updateTambahSaldo(String username1, double upah) {
        
    int userID = repo.repoGetUserIDByUsername(username1);
    String url = "jdbc:mariadb://localhost:3306/proyek_register";
    String username = "root";
    String password = "";

    String queryCekSaldo = "SELECT saldo FROM saldo WHERE id = ?";
    String queryUpdateSaldo = "UPDATE saldo SET saldo = saldo + ? WHERE id = ?";

    try (Connection conn = DriverManager.getConnection(url, username, password)) {
        // Cek saldo
        try (PreparedStatement cekSaldoStmt = conn.prepareStatement(queryCekSaldo)) {
            cekSaldoStmt.setInt(1, userID);
            try (ResultSet rs = cekSaldoStmt.executeQuery()) {
                if (rs.next()) {
                    double saldoLama = rs.getDouble("saldo");

                    // Update saldo
                    try (PreparedStatement updateSaldoStmt = conn.prepareStatement(queryUpdateSaldo)) {
                        updateSaldoStmt.setDouble(1, upah);
                        updateSaldoStmt.setInt(2, userID);
                        updateSaldoStmt.executeUpdate();

                        // Kembalikan saldo baru
                        return saldoLama + upah;
                    }
                } else {
                    System.out.println("Barang tidak ditemukan di tabel saldo.");
                    return -1; // Indikasi error
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
        return -1; // Indikasi error koneksi atau query
    }
}
    
    
    private double updateKurangSaldo(double upah) {
        
    int userID = sessionModel.getUserID();
    String url = "jdbc:mariadb://localhost:3306/proyek_register";
    String username = "root";
    String password = "";

    String queryCekSaldo = "SELECT saldo FROM saldo WHERE id = ?";
    String queryUpdateSaldo = "UPDATE saldo SET saldo = saldo - ? WHERE id = ?";

    try (Connection conn = DriverManager.getConnection(url, username, password)) {
        // Cek saldo
        try (PreparedStatement cekSaldoStmt = conn.prepareStatement(queryCekSaldo)) {
            cekSaldoStmt.setInt(1, userID);
            try (ResultSet rs = cekSaldoStmt.executeQuery()) {
                if (rs.next()) {
                    double saldoLama = rs.getDouble("saldo");
                    
                    if(saldoLama >= upah){
                    // Update saldo
                    try (PreparedStatement updateSaldoStmt = conn.prepareStatement(queryUpdateSaldo)) {
                        updateSaldoStmt.setDouble(1, upah);
                        updateSaldoStmt.setInt(2, userID);
                        updateSaldoStmt.executeUpdate();

                        // Kembalikan saldo baru
                        return saldoLama - upah;
                    }
                } else {
                    System.out.println("Upah tidak cukup.");
                    return -1; // Indikasi error
                    }
                    
                            }
                else {
                            System.out.println("Upah tidak cukup.");
                    return 0; // Indikasi error
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
        return -1; // Indikasi error koneksi atau query
    }
}
    
    
                        
    
    private void jnamabrgFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jnamabrgFocusLost

    }//GEN-LAST:event_jnamabrgFocusLost
    


    private void jbrgtambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbrgtambahActionPerformed
    try {
            int stok = Integer.parseInt(jjumlahbrg.getText());
            if (stok < stok1) {
                stok += 1;
                jjumlahbrg.setText(String.valueOf(stok));
                double value1 = Double.parseDouble(jhargabrg.getText());
                totalHarga.setText(String.valueOf(value1 * stok));
            } else {
                JOptionPane.showMessageDialog(this, "Jumlah barang tidak boleh lebih dari stok yang tersedia!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Nilai stok tidak valid!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbrgtambahActionPerformed

    private void jjumlahbrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jjumlahbrgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jjumlahbrgActionPerformed

    private void IDBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDBarangActionPerformed
        IDBarang.setEditable(false);
    }//GEN-LAST:event_IDBarangActionPerformed
    

    public KonfirmasiPanel() throws HeadlessException {
        this.repo = null;
        this.callback = null;
    }

    public void setUserPenjual (String ID) {
        IDBarang.setText(ID);
       
    }
    
    public void setNamaBarang (String nama) {
        jnamabrg.setText(nama);
       
    }
    
    public void setDeskripsiBarang (String deskripsi) {
        jdeskripsibrg.setText(deskripsi);
    }
    
    public void setHargaBarang (double harga) {
        jhargabrg.setText(String.valueOf(harga));
    }
    
        private void setStokBarangDariDatabase(String namaBarang) {
        String url = "jdbc:mariadb://localhost:3306/proyek_register";
        String username = "root";
        String password = "";

        String query = "SELECT stokBarang FROM Produk WHERE namaBarang = ?";
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, namaBarang);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int stokTersedia = rs.getInt("stokBarang");
                    stok1 = stokTersedia;
                    jjumlahbrg.setText(String.valueOf(stokTersedia));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Gagal mengambil stok dari database.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
        
    private void setBarangTerjualDariDatabase(String namaBarang) {
        String url = "jdbc:mariadb://localhost:3306/proyek_register";
        String username = "root";
        String password = "";

        String query = "SELECT barangTerjual FROM Produk WHERE namaBarang = ?";
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, namaBarang);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int barangTerjual = rs.getInt("barangTerjual");
                    labelstok.setText("Terjual: " + barangTerjual);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Gagal mengambil data barang terjual dari database.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void setJumlah (int jumlah) {
        jjumlahbrg.setText(String.valueOf(jumlah));
    }
    
    
     public int setStokBarang() {
        int jumlahBarang = Integer.parseInt(jjumlahbrg.getText());
        double hargaBarang = Double.parseDouble(jhargabrg.getText());
        int stoksisa = stok1 - jumlahBarang;
        
        return stoksisa;
    }

    public JTextField getstokBarang() {
    return this.jjumlahbrg;
}  
    
    public int getJumlahBarangDibeli() {
    try {
        return Integer.parseInt(jjumlahbrg.getText()); // Ambil dari JTextField atau komponen lainnya
    } catch (NumberFormatException e) {
        return 0; // Default jika input tidak valid
}
    
}


// Fungsi untuk mendapatkan harga barang, misalnya
    /**
     * @param args the command line arguments
     */


   





    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IDBarang;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton jbeli;
    private javax.swing.JButton jbrgkurang;
    private javax.swing.JButton jbrgtambah;
    private javax.swing.JTextField jdeskripsibrg;
    private javax.swing.JTextField jhargabrg;
    private javax.swing.JTextField jjumlahbrg;
    private javax.swing.JTextField jnamabrg;
    private javax.swing.JLabel labelstok;
    private javax.swing.JTextField totalHarga;
    // End of variables declaration//GEN-END:variables
}
