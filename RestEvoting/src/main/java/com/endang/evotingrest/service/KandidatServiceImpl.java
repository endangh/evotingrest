package com.endang.evotingrest.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.endang.evotingrest.interfaces.KandidatService;
import com.endang.evotingrest.model.Kandidat;


public class KandidatServiceImpl implements KandidatService{
	@Override
	public List<Kandidat> getKandidat(String periode) {
		// TODO Auto-generated method stub
			String query = "select k.*,p.periode from kandidat k inner join pemilihan p on k.id_pemilihan = p.id_pemilihan where p.periode ='"+periode+"'";
			List<Kandidat> list = new ArrayList<Kandidat>();
			try {
				ResultSet rs = Koneksi.getInstance().getKoneksi().createStatement().executeQuery(query);
				while (rs.next()) {
					list.add(new Kandidat(rs.getInt("id_kandidat"),rs.getString("nama_kandidat"),rs.getString("url_photo_kandidat"),rs.getString("visi_kandidat"),rs.getString("misi_kandidat"),rs.getString("periode"),rs.getBoolean("status_kandidat"),"true"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return list	;
	}

}
