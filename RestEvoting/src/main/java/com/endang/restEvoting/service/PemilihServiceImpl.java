package com.endang.restEvoting.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.endang.restEvoting.interfaces.PemilihService;
import com.endang.restEvoting.model.Pemilih;

@Service
public class PemilihServiceImpl implements PemilihService {

	@Override
	public Pemilih getPemilih(String nrp) {
		// TODO Auto-generated method stub
		Pemilih p = null;
		String query = "select * from pemilih where id_pemilih = '"+nrp+"'";
		try {
			ResultSet rs = Koneksi.getInstance().getKoneksi().createStatement().executeQuery(query);
			while (rs.next()) {
				p = new Pemilih(rs.getString("id_pemilih"), rs.getString("nama_pemilih"), rs.getString("no_hp_pemilih"), rs.getString("email_pemilih"), rs.getString("status_vote_pemilih"),rs.getBoolean("status_pemilih"),"true");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

}
