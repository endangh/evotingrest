package com.endang.restEvoting.service;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.Connection;

public class Koneksi {
	
	private Connection koneksi;

	private Koneksi(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String user = "root";
            String pass ="";
            String url = "jdbc:mysql://localhost:3306/ta_evoting";
            
            koneksi = (com.mysql.jdbc.Connection) DriverManager.getConnection(url,user,pass);
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE,null,ex);  
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static Koneksi getInstance(){
        return KoneksiHolder.INSTANCE;
    }
    
    private static class KoneksiHolder{
        private static final Koneksi INSTANCE = new Koneksi();
    }
    public com.mysql.jdbc.Connection getKoneksi(){
        return koneksi;
    }
}
