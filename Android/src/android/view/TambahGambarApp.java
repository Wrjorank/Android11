package android.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class TambahGambarApp extends JFrame {

     private JLabel lblImagePreview; // Label untuk menampilkan gambar
    private File selectedFile; // Variabel untuk menyimpan file gambar
    private boolean isImageSelected = false; // Status apakah gambar dipilih

    public TambahGambarApp() {
        this.setLocationRelativeTo(null);
        this.setFocusable(true);
        this.requestFocusInWindow();
        setTitle("Tambah Gambar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(new BorderLayout());

        // Tombol untuk memilih gambar
        JButton btnTambahGambar = new JButton("Tambah Gambar");
        btnTambahGambar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pilihGambar();
            }
        });
        
        // Panel bawah untuk tombol OK dan CANCEL
        JPanel buttonPanel = new JPanel();
        JButton btnOK = new JButton("OK");
        JButton btnCancel = new JButton("Cancel");

        // Listener untuk tombol OK
        btnOK.addActionListener(e -> handleOK());

        // Listener untuk tombol CANCEL
        btnCancel.addActionListener(e -> handleCancel());

        buttonPanel.add(btnOK);
        buttonPanel.add(btnCancel);

        lblImagePreview = new JLabel("Pratinjau Gambar", SwingConstants.CENTER);
        lblImagePreview.setPreferredSize(new Dimension(300, 300));
        lblImagePreview.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lblImagePreview.setHorizontalAlignment(SwingConstants.CENTER);

        // Tambahkan komponen ke frame
        add(btnTambahGambar, BorderLayout.NORTH);
        add(lblImagePreview, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void pilihGambar() {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Gambar", "jpg", "png", "jpeg"));
    int result = fileChooser.showOpenDialog(this);

    if (result == JFileChooser.APPROVE_OPTION) {
        File file = fileChooser.getSelectedFile();
        if (file != null) {
            selectedFile = file; // Menyimpan file yang dipilih ke selectedFile
            isImageSelected = true; // Menandakan bahwa gambar telah dipilih
            
            // Menampilkan gambar di JLabel
            ImageIcon imageIcon = new ImageIcon(file.getAbsolutePath());
            Image scaledImage = imageIcon.getImage().getScaledInstance(
                    lblImagePreview.getWidth(), 
                    lblImagePreview.getHeight(), 
                    Image.SCALE_SMOOTH
            );
            lblImagePreview.setIcon(new ImageIcon(scaledImage));
            lblImagePreview.setText(""); // Hapus teks "Pratinjau Gambar"
        }
    }
}



    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TambahGambarApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TambahGambarApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TambahGambarApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TambahGambarApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TambahGambarApp().setVisible(true);
            }
        });
    }
    
        private void handleTambahGambar(File file) {
        // Validasi file gambar
        if (file == null || !file.exists()) {
            JOptionPane.showMessageDialog(this, "File tidak valid atau tidak ditemukan.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Menampilkan informasi file gambar
        JOptionPane.showMessageDialog(this, 
            "Gambar berhasil dipilih:\n" + file.getName() + 
            "\nUkuran: " + file.length() / 1024 + " KB",
            "Informasi", JOptionPane.INFORMATION_MESSAGE);

        // Anda bisa menambahkan logika untuk menyimpan gambar ke database atau lokasi penyimpanan lain di sini
    }
        
        private void handleOK() {
        if (selectedFile != null) {
            JOptionPane.showMessageDialog(this, 
                "Gambar berhasil dipilih:\n" + selectedFile.getName(), 
                "Informasi", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            // Anda dapat menambahkan logika penyimpanan gambar di sini
        } else {
            JOptionPane.showMessageDialog(this, 
                "Silakan pilih gambar terlebih dahulu.", 
                "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void handleCancel() {
        int response = JOptionPane.showConfirmDialog(
                this,
                "Apakah Anda yakin ingin membatalkan?",
                "Konfirmasi",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );
        if (response == JOptionPane.YES_OPTION) {
            dispose(); // Menutup aplikasi
        }
    }

     public File getSelectedFile() {
        return isImageSelected ? selectedFile : null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
