/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package android.view.panel;

import android.entity.Produk;
import android.model.ProdukModel;
import android.model.sessionModel;
import android.repository.IRepoProduk;
import android.view.KonfirmasiPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Window;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Iky
 */
public class BuyingPanel extends javax.swing.JPanel {
    
        private final IRepoProduk repo;
        private final Runnable callback;

    /**
     * Creates new form BuyingPanel
     */
    public BuyingPanel(IRepoProduk repo, Runnable callback) {
        System.out.println("BuyingPanel");
        this.repo = repo;
        this.callback = callback;
        
        
        initComponents();
          this.setFocusable(true);
        this.requestFocusInWindow();
        
         
        // Menambahkan JScrollPane ke contentPanel
        jScrollPane = new JScrollPane(contentPanel);
        jScrollPane.setPreferredSize(new Dimension(400, 408)); // Ukuran default scrollable area
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);  // Atur kebijakan scroll vertikal
        
        // Menambahkan JScrollPane ke layout utama
        setLayout(new BorderLayout());
        add(jPanel4, BorderLayout.NORTH);
        add(jScrollPane, BorderLayout.CENTER);
        
        displayProducts(repo.repoGetAllProduk());
    }
    
     private void displayProducts(ArrayList<Produk> produk) {
    contentPanel.removeAll(); // Menghapus semua komponen sebelumnya dari contentPanel

    if (produk.isEmpty()) {
        JPanel produkPanel = new JPanel(new BorderLayout());
        produkPanel.setBackground(Color.WHITE);
        produkPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        produkPanel.setPreferredSize(new Dimension(365, 110));

        JLabel lblMessage = new JLabel("Tidak ada data tersedia!", SwingConstants.CENTER);
        lblMessage.setFont(new Font("Arial", Font.BOLD, 12));
        produkPanel.add(lblMessage, BorderLayout.CENTER);
        
        contentPanel.setLayout(new BorderLayout());
        contentPanel.add(produkPanel, BorderLayout.NORTH);
    } else {
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setOpaque(false);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        for (Produk produk1 : produk) {
            JPanel produkPanel = new JPanel(new BorderLayout());
            produkPanel.setBackground(Color.WHITE);
            produkPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            produkPanel.setPreferredSize(new Dimension(365, 110));
            produkPanel.setMaximumSize(new Dimension(365, 110));

            JLabel lblproduk = new JLabel("#" + produk1.getidBarang() + " " + produk1.getnamaBarang());
            lblproduk.setFont(new Font("Georgia", Font.BOLD, 12));
            lblproduk.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));

            JLabel lbldeskripsi = new JLabel(produk1.getdeskripsi());
            lbldeskripsi.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 12));
            lbldeskripsi.setBorder(BorderFactory.createEmptyBorder(5, 10, 0, 0));

            JLabel lblharga = new JLabel(String.valueOf(produk1.getharga())); // Konversi double ke String
            lblharga.setFont(new Font("Times New Roman", Font.BOLD, 14)); // Mengatur font: Arial, Bold, ukuran 14
            lblharga.setForeground(Color.RED); // Mengatur warna teks menjadi biru
            lblharga.setBorder(BorderFactory.createEmptyBorder(5, 10, 0, 0));

            JPanel panelStokDanTerjual = new JPanel();
            panelStokDanTerjual.setBorder(BorderFactory.createEmptyBorder(5, 10, 0, 10));
            panelStokDanTerjual.setBackground(Color.WHITE);
            // Label untuk stok
            JLabel lblstok = new JLabel("Stok: " + produk1.getstokBarang());
            lblstok.setBorder(BorderFactory.createEmptyBorder(5, 10, 0, 10));
            lblstok.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 12));
            
            // Label untuk barang terjual
            JLabel lblterjual = new JLabel("Terjual: " + produk1.getbarangTerjual());
            lblterjual.setBorder(BorderFactory.createEmptyBorder(5, 50, 0, 10));
            lblterjual.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 12));
            
            // Tambahkan label ke panel
            panelStokDanTerjual.add(lblstok);
            panelStokDanTerjual.add(lblterjual);
            
             
            int ID_produk = produk1.getidBarang();
            JLabel lblusername = new JLabel("@" + ProdukModel.getUsernameByUserIDproduk(ID_produk)); // Pastikan produk1 memiliki getUsername()
            lblusername.setFont(new Font("Arial", Font.BOLD, 12));
            lblusername.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
            lblusername.setForeground(Color.GRAY);
            
             // Panel untuk menampilkan produk dan username secara horizontal
            JPanel panelProdukUsername = new JPanel();
            panelProdukUsername.setLayout(new FlowLayout(FlowLayout.LEFT));
            panelProdukUsername.setBackground(Color.WHITE);
            panelProdukUsername.add(lblproduk);
            panelProdukUsername.add(lblusername); 
            
            JPanel infoPanel = new JPanel();
            infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
            infoPanel.setBackground(Color.WHITE);
            infoPanel.add(lbldeskripsi);
            infoPanel.add(lblharga);
          
            JPanel actionPanel = new JPanel();
            actionPanel.setLayout(new GridBagLayout());
            actionPanel.setLayout(new BoxLayout(actionPanel, BoxLayout.Y_AXIS));
            actionPanel.setBackground(Color.WHITE);
            actionPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));

            JButton btnBeli = new JButton("Beli");
           
            btnBeli.addActionListener(e -> handleBeli(produk1));
           
            btnBeli.setPreferredSize(new Dimension(70, 26));
            btnBeli.setMaximumSize(new Dimension(70, 26));
            
            actionPanel.add(btnBeli);
           
            produkPanel.add(panelProdukUsername, BorderLayout.NORTH);
            produkPanel.add(infoPanel, BorderLayout.CENTER);
            produkPanel.add(panelStokDanTerjual, BorderLayout.SOUTH);
            produkPanel.add(actionPanel, BorderLayout.EAST);
            contentPanel.add(produkPanel);
            contentPanel.add(Box.createVerticalStrut(5));
        }
    }

    contentPanel.revalidate();
    contentPanel.repaint();
}
     
     private void handleBeli(Produk produk) {
     
        KonfirmasiPanel konfirPanel = new KonfirmasiPanel(repo, callback);
        konfirPanel.setNamaBarang(produk.getnamaBarang());
        konfirPanel.setDeskripsiBarang(produk.getdeskripsi());
        konfirPanel.setHargaBarang(produk.getharga());
        
        konfirPanel.setVisible(true);
        Window window = SwingUtilities.getWindowAncestor(this);
        if (window instanceof JFrame) {
        ((JFrame) window).dispose(); // Menutup JFrame yang berisi JPanel ini
    }
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        searchTxt = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        pilihkategori = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        jScrollPane = new javax.swing.JScrollPane();

        jPanel4.setBackground(new java.awt.Color(51, 153, 255));

        searchTxt.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        searchTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTxtActionPerformed(evt);
            }
        });

        searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/android/assets/search_icon.png"))); // NOI18N
        searchBtn.setBorderPainted(false);
        searchBtn.setContentAreaFilled(false);
        searchBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        pilihkategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih", "Semua", "Elektronik", "Fashion", "Kecantikan", "Perawatan Diri", "Peralatan Masak", "Perabot Rumah Tangga", "Dekorasi Rumah", "Alat Kebersihan", "Peralatan Penyimpanan", "Makanan dan Minuman", "Kesehatan", "Olahraga", "Otomotif", "Perlengkapan Sekolah", "Mainan dan Hobi", "Produk Digital", "Perlengkapan Bayi", "Peralatan dan Perbaikan Rumah", "Hewan dan Peliharaan", "Tiket dan Perjalanan" }));
        pilihkategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihkategoriActionPerformed(evt);
            }
        });

        jLabel1.setText("Kategori:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(22, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pilihkategori, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(searchTxt)
                        .addGap(18, 18, 18)
                        .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchTxt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pilihkategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane)
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTxtActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
    String searchText = searchTxt.getText().trim();

    if (searchText.isEmpty()) {
        displayProducts(repo.repoGetAllProduk());
        return;
    }

    // Lakukan pencarian case-insensitive berdasarkan awal kata
    ArrayList<Produk> filteredTodos = repo.repoSearchProduk(searchText);
    displayProducts(filteredTodos);

      
    }//GEN-LAST:event_searchBtnActionPerformed

    private void pilihkategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihkategoriActionPerformed
        String kategori1 = (String)pilihkategori.getSelectedItem();
        
        if(kategori1 == "Semua"){
            displayProducts(repo.repoGetAllProduk());
            return;
        }
        ArrayList<Produk> filteredTodos = repo.repoSearchProdukbyKategori(kategori1);
        displayProducts(filteredTodos);

    }//GEN-LAST:event_pilihkategoriActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JComboBox<String> pilihkategori;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchTxt;
    // End of variables declaration//GEN-END:variables
}
