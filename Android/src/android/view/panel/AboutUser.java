package android.view.panel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */


import android.model.sessionModel;
import android.repository.IRepoProduk;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;





/**
 *
 * @author Iky
 */
public class AboutUser extends javax.swing.JPanel {
    
        private final IRepoProduk repo;
        private final Runnable callback;
        private final int userId; // Tambahkan variabel ini


    /**
     * Creates new form AboutUser
     */
    public AboutUser(IRepoProduk repo, Runnable callback, int userId) {
    System.out.println("AboutUser");
    this.repo = repo;
    this.callback = callback;
    this.userId = userId;

    initComponents();
    loadUserDetails();

    if (userId != -1) {
        fetchSaldo(); // Hanya panggil fetchSaldo jika userId valid
    } else {
        jLabel3_saldo.setText("Login untuk melihat saldo"); // Pesan default
    }
}
    
// Tambahkan di class AboutUser
private void loadUserDetails() {
    String url = "jdbc:mariadb://localhost:3306/proyek_register";
    String user = "root"; // Ganti dengan user database Anda
    String pass = ""; // Ganti dengan password database Anda

    int userID = sessionModel.getUserID(); // Ambil userID dari sessionModel

    try (Connection conn = DriverManager.getConnection(url, user, pass)) {
        // Query untuk mengambil data user dan saldo berdasarkan userID
        String query = """
            SELECT r.username, r.namaDepan, r.namaBelakang, r.tanggalLahir, r.alamat, IFNULL(s.saldo, 0) AS saldo
            FROM register r
            LEFT JOIN saldo s ON r.id = s.id
            WHERE r.id = ?
        """;

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Ambil data dari result set
                    String username = rs.getString("username");
                    String namaDepan = rs.getString("namaDepan");
                    String namaBelakang = rs.getString("namaBelakang");
                    String tanggalLahir = rs.getString("tanggalLahir");
                    String alamat = rs.getString("alamat");
                    double saldo = rs.getDouble("saldo");

                    // Log untuk debug
                    System.out.println("Data ditemukan: Username = " + username + ", Saldo = " + saldo);

                    // Tampilkan data di label
                    LblakunUsername.setText(username);
                    LblakunDepan.setText(namaDepan);
                    LblakunBelakang.setText(namaBelakang);
                    LblakunTanggal.setText(tanggalLahir);
                    LblakunAlamat.setText(alamat);
                    jLabel3_saldo.setText("" + saldo);
                } else {
                    // Log untuk debug
                    System.out.println("Data tidak ditemukan untuk userID: " + userID);

                    // Jika data tidak ditemukan
                    LblakunUsername.setText("Tidak ditemukan.");
                    LblakunDepan.setText("Tidak ditemukan.");
                    LblakunBelakang.setText("Tidak ditemukan.");
                    LblakunTanggal.setText("Tidak ditemukan.");
                    LblakunAlamat.setText("Tidak ditemukan.");
                    jLabel3_saldo.setText("Tidak ditemukan.");
                }
            }
        }
    } catch (Exception e) {
        // Jika ada error, tampilkan pesan error
        System.out.println("Error saat memuat data: " + e.getMessage());
        LblakunUsername.setText("Error: Gagal memuat data.");
        LblakunDepan.setText("");
        LblakunBelakang.setText("");
        LblakunTanggal.setText("");
        LblakunAlamat.setText("");
        jLabel3_saldo.setText("Error: Tidak dapat memuat saldo.");
        e.printStackTrace();
    }
}

        
     
    
    private void fetchSaldo() {
    try {
        // Koneksi ke database
        String url = "jdbc:mariadb://localhost:3306/proyek_register"; // Ganti sesuai konfigurasi
        String user = "root"; // Ganti dengan username database Anda
        String pass = "";     // Ganti dengan password database Anda
        
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            // Query untuk mengambil saldo berdasarkan userId
            String query = "SELECT saldo FROM saldo WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, userId); // Menggunakan userId untuk filter

                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        // Ambil nilai saldo dari database
                       // double saldo = rs.getDouble("saldo");

                        // Tampilkan saldo di label
                        //jLabel3_saldo.setText(String.valueOf(saldo));
                    } else {
                        // Jika saldo tidak ditemukan
                       // jLabel3_saldo.setText("0");
                    }
                }
            }
        }
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Gagal mengambil data saldo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtJumlahSaldo = new javax.swing.JTextField();
        txtVerifikasiPassword = new javax.swing.JPasswordField();
        btnTopUp = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();
        lblSaldo = new javax.swing.JLabel();
        lblTopUp = new javax.swing.JLabel();
        lblVerifikasiPassword = new javax.swing.JLabel();
        jLabel3_saldo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1_user = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        LblakunUsername = new javax.swing.JLabel();
        LblakunDepan = new javax.swing.JLabel();
        LblakunBelakang = new javax.swing.JLabel();
        LblakunTanggal = new javax.swing.JLabel();
        LblakunAlamat = new javax.swing.JLabel();

        jPanel3.setBackground(new java.awt.Color(51, 153, 255));

        jPanel4.setBackground(new java.awt.Color(51, 153, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Informasi Akun");

        jLabel2.setForeground(new java.awt.Color(242, 242, 242));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/android/assets/info_icon.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        btnTopUp.setText("Top Up");
        btnTopUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTopUpActionPerformed(evt);
            }
        });

        lblStatus.setText("Status : ");

        lblSaldo.setText("Saldo Anda : ");

        lblTopUp.setText("Nominal Top UP");

        lblVerifikasiPassword.setText("Verifikasi Pasword");

        jLabel3_saldo.setText("0");

        jLabel3.setText("Verifikasi User");

        jLabel4.setText("Nama Depan      :");

        jLabel5.setText("Nama Belakang  :");

        jLabel6.setText("Alamat              :");

        jLabel7.setText("Username          :");

        jLabel8.setText("Tanggal Lahir     :");

        LblakunUsername.setText("-");

        LblakunDepan.setText("-");

        LblakunBelakang.setText("-");

        LblakunTanggal.setText("-");

        LblakunAlamat.setText("-");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblTopUp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblVerifikasiPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblSaldo)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblStatus)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3_saldo, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LblakunAlamat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LblakunTanggal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LblakunBelakang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LblakunDepan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1_user, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtJumlahSaldo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtVerifikasiPassword)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(LblakunUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnTopUp)
                                .addGap(51, 51, 51))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(LblakunUsername))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(LblakunDepan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(LblakunBelakang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(LblakunTanggal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(LblakunAlamat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtJumlahSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTopUp)
                    .addComponent(btnTopUp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVerifikasiPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVerifikasiPassword))
                .addGap(23, 23, 23)
                .addComponent(lblStatus)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3_saldo)
                    .addComponent(lblSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTopUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTopUpActionPerformed
         // Koneksi ke database
    
    String url = "jdbc:mariadb://localhost:3306/proyek_register";
    String user = "root";
    String pass = "";
    
    // Ambil input dari kolom teks
    String username = jTextField1_user.getText();
    String verifikasiPassword = new String(txtVerifikasiPassword.getPassword());
    int jumlahTopUp = Integer.parseInt(txtJumlahSaldo.getText());

    try (Connection conn = DriverManager.getConnection(url, user, pass)) {
        // 1. Verifikasi username dan password
        String queryVerifikasi = "SELECT id, password FROM register WHERE username = ?";
        try (PreparedStatement stmtVerifikasi = conn.prepareStatement(queryVerifikasi)) {
            stmtVerifikasi.setString(1, username);
            try (ResultSet rs = stmtVerifikasi.executeQuery()) {
                if (rs.next()) {
                    String passwordDb = rs.getString("password");
                    int userId = rs.getInt("id");
                    if (!passwordDb.equals(verifikasiPassword)) {
                        lblStatus.setText("Status: Password salah!");
                        return;
                    }

                    // 2. Ambil saldo lama dari tabel saldo
                    String querySaldo = "SELECT saldo FROM saldo WHERE id = ?";
                    try (PreparedStatement stmtSaldo = conn.prepareStatement(querySaldo)) {
                        stmtSaldo.setInt(1, userId);
                        try (ResultSet rsSaldo = stmtSaldo.executeQuery()) {
                            if (rsSaldo.next()) {
                                int saldoLama = rsSaldo.getInt("saldo");

                                // 3. Hitung saldo baru
                                int saldoBaru = saldoLama + jumlahTopUp;

                                // 4. Update saldo di database
                                String queryUpdate = "UPDATE saldo SET saldo = ? WHERE id = ?";
                                try (PreparedStatement stmtUpdate = conn.prepareStatement(queryUpdate)) {
                                    stmtUpdate.setInt(1, saldoBaru);
                                    stmtUpdate.setInt(2, userId);
                                    int rowsUpdated = stmtUpdate.executeUpdate();

                                    if (rowsUpdated > 0) {
                                        lblStatus.setText("Status: Top Up berhasil!");
                                        jLabel3_saldo.setText(String.valueOf(saldoBaru)); // Tampilkan saldo baru
                                    } else {
                                        lblStatus.setText("Status: Gagal memperbarui saldo.");
                                    }
                                }
                            } else {
                                lblStatus.setText("Status: Data saldo tidak ditemukan!");
                            }
                        }
                    }
                } else {
                    lblStatus.setText("Status: Username tidak ditemukan!");
                }
            }
        }
    } catch (Exception e) {
        lblStatus.setText("Status: Terjadi kesalahan!");
        e.printStackTrace();
    }
    }//GEN-LAST:event_btnTopUpActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LblakunAlamat;
    private javax.swing.JLabel LblakunBelakang;
    private javax.swing.JLabel LblakunDepan;
    private javax.swing.JLabel LblakunTanggal;
    private javax.swing.JLabel LblakunUsername;
    private javax.swing.JButton btnTopUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel3_saldo;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextField1_user;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTopUp;
    private javax.swing.JLabel lblVerifikasiPassword;
    private javax.swing.JTextField txtJumlahSaldo;
    private javax.swing.JPasswordField txtVerifikasiPassword;
    // End of variables declaration//GEN-END:variables

}
