/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package android;

/**
 *
 * @author Hp
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class testDatabase {
    public static void main(String[] args) {
        String url = "jdbc:mariadb://localhost:3306/proyek_register";
        String user = "root";
        String pass = "";
        
        try {
            Class.forName("org.mariadb.jdbc.Driver"); // atau com.mysql.cj.jdbc.Driver
            Connection conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Koneksi berhasil!");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
