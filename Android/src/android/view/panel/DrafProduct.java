/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package android.view.panel;

import android.entity.Produk;
import android.model.ProdukModel;
import android.repository.IRepoProduk;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Iky
 */
public class DrafProduct extends javax.swing.JPanel {
    
        private final IRepoProduk repo1;
        private final Runnable callback;

    /**
     * Creates new form DrafProduct
     */
    public DrafProduct(IRepoProduk repo1, Runnable callback) {
        System.out.println("DrafProduk");
        this.repo1 = repo1;
        this.callback = callback;
        initComponents();
        
        jScrollPane = new JScrollPane(contentPanel);
        jScrollPane.setPreferredSize(new Dimension(400, 390)); // Ukuran default scrollable area
        jScrollPane.setVerticalScrollBarPolicy(jScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);  // Atur kebijakan scroll vertikal
        
        // Menambahkan JScrollPane ke layout utama
        setLayout(new BorderLayout());
        add(jPanel4, BorderLayout.NORTH);
        add(jScrollPane, BorderLayout.CENTER);
        
        displayProducts(repo1.repoGetAllUserProduk());

    }
    
    private void displayProducts(ArrayList<Produk> produk) {
    contentPanel.removeAll(); // Menghapus semua komponen sebelumnya dari contentPanel

    if (produk.isEmpty()) {
        JPanel produkPanel = new JPanel(new BorderLayout());
        produkPanel.setBackground(Color.WHITE);
        produkPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        produkPanel.setPreferredSize(new Dimension(365, 130));

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
            produkPanel.setPreferredSize(new Dimension(365, 130));
            produkPanel.setMaximumSize(new Dimension(365, 130));

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

            JButton btnEdit = new JButton("Edit");
            JButton btnDelete = new JButton("Delete");
            
            btnEdit.addActionListener(e -> handleEdit(produk1));
            btnDelete.addActionListener(e -> handleDelete(produk1));

             btnEdit.setPreferredSize(new Dimension(70, 26));
            btnDelete.setMaximumSize(new Dimension(70, 26));
            
            actionPanel.add(btnEdit);
            actionPanel.add(btnDelete);
           
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
    
  private void handleEdit(Produk produk) {
    // Menyiapkan dialog input untuk mengedit produk
    JTextField tfNamaBarang = new JTextField(produk.getnamaBarang());
    JTextField tfHarga = new JTextField(String.valueOf(produk.getharga()));
    JTextField tfDeskripsi = new JTextField(produk.getdeskripsi());
    JTextField tfStok = new JTextField(String.valueOf(produk.getstokBarang()));

    // Membuat JComboBox untuk kategori
    String[] kategoriOptions = { "Pilih", "Elektronik", "Fashion", "Kecantikan", "Perawatan Diri", "Peralatan Masak", 
        "Perabot Rumah Tangga", "Dekorasi Rumah", "Alat Kebersihan", "Peralatan Penyimpanan", "Makanan dan Minuman", 
        "Kesehatan", "Olahraga", "Otomotif", "Perlengkapan Sekolah", "Mainan dan Hobi", "Produk Digital", 
        "Perlengkapan Bayi", "Peralatan dan Perbaikan Rumah", "Hewan dan Peliharaan", "Tiket dan Perjalanan" };

    JComboBox<String> cbKategori = new JComboBox<>(kategoriOptions);
    cbKategori.setSelectedItem(produk.getkategori());  // Mengatur kategori yang ada pada produk ke dalam ComboBox

    JPanel panel = new JPanel(new GridLayout(6, 2));  // Mengurangi satu baris untuk barangTerjual
    panel.add(new JLabel("Nama Barang:"));
    panel.add(tfNamaBarang);
    panel.add(new JLabel("Harga:"));
    panel.add(tfHarga);
    panel.add(new JLabel("Deskripsi:"));
    panel.add(tfDeskripsi);
    panel.add(new JLabel("Stok:"));
    panel.add(tfStok);
    panel.add(new JLabel("Kategori:"));
    panel.add(cbKategori);

    int option = JOptionPane.showConfirmDialog(
            null, panel, "Edit Produk", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

    // Jika pengguna menekan OK
    if (option == JOptionPane.OK_OPTION) {
        String namaBarang = tfNamaBarang.getText();
        double harga = Double.parseDouble(tfHarga.getText());
        String deskripsi = tfDeskripsi.getText();
        int stokBarang = Integer.parseInt(tfStok.getText());
        String kategori = (String) cbKategori.getSelectedItem();  // Mendapatkan kategori yang dipilih

        // Memperbarui produk di repositori tanpa mengupdate barangTerjual
        boolean updated = repo1.repoUpdateProduk(produk.getidBarang(), namaBarang, harga, deskripsi, stokBarang, kategori);

        if (updated) {
            JOptionPane.showMessageDialog(null, "Produk berhasil diperbarui!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            callback.run();  // Memanggil callback untuk memperbarui tampilan
            
        } else {
            JOptionPane.showMessageDialog(null, "Gagal memperbarui produk!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
}



private void handleDelete(Produk produk) {
    // Menampilkan dialog konfirmasi untuk menghapus produk
    int response = JOptionPane.showConfirmDialog(
            null,
            "Apakah Anda yakin ingin menghapus produk: \n" + produk.getnamaBarang() + "?",
            "Konfirmasi Hapus",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
    );

    if (response == JOptionPane.YES_OPTION) {
        // Menghapus produk dari repositori menggunakan ID produk
        boolean deleted = repo1.repoRemoveProduk(produk.getidBarang());

        if (deleted) {
            JOptionPane.showMessageDialog(null, "Produk berhasil dihapus.", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            callback.run();  // Memanggil callback untuk memperbarui tampilan
        } else {
            JOptionPane.showMessageDialog(null, "Gagal menghapus produk!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
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
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        searchBTNActionPerformed = new javax.swing.JButton();
        searchTXT = new javax.swing.JTextField();
        contentPanel = new javax.swing.JPanel();
        jScrollPane = new javax.swing.JScrollPane();

        jPanel4.setBackground(new java.awt.Color(51, 153, 255));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel1.setText("Daftar Produk Pengguna");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/android/assets/add_icon.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        searchBTNActionPerformed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/android/assets/search_icon.png"))); // NOI18N
        searchBTNActionPerformed.setBorderPainted(false);
        searchBTNActionPerformed.setContentAreaFilled(false);
        searchBTNActionPerformed.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchBTNActionPerformed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBTNActionPerformedActionPerformed(evt);
            }
        });

        searchTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTXTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(searchTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchBTNActionPerformed, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(14, 14, 14))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchBTNActionPerformed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchTXT))
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
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 68, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(184, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTXTActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        callback.run();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void searchBTNActionPerformedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBTNActionPerformedActionPerformed
        String searchText = searchTXT.getText().trim();

    if (searchText.isEmpty()) {
        displayProducts(repo1.repoGetAllProduk());
        return;
    }
    
    ArrayList<Produk> filteredTodos = repo1.repoSearchProduk(searchText);
    displayProducts(filteredTodos);
    
    }//GEN-LAST:event_searchBTNActionPerformedActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JButton searchBTNActionPerformed;
    private javax.swing.JTextField searchTXT;
    // End of variables declaration//GEN-END:variables
}
