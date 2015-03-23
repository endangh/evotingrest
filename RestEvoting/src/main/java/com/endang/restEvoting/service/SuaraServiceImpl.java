package com.endang.restEvoting.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.endang.restEvoting.interfaces.SuaraService;
import com.endang.restEvoting.model.Suara;

public class SuaraServiceImpl implements SuaraService {

	@Override
	public List<Suara> findAll() {
		// TODO Auto-generated method stub
		List<Suara> list = new ArrayList<Suara>();
		String query = "select s.*,k.nama_kandidat from suara s inner join kandidat k on s.id_kandidat = k.id_kandidat";
		
		try {
			ResultSet rs = Koneksi.getInstance().getKoneksi().createStatement()
					.executeQuery(query);
			while (rs.next()) {
				list.add(new Suara(rs.getInt("id_suara"), rs
						.getInt("id_kandidat"), rs
						.getString("nama_kandidat"), rs.getInt("jumlah_suara"),
						"true"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error load suara "+e.getMessage());
		}
		return list;
	}

	@Override
	public boolean insertVote(int idKandidat, String id_pemilih) {
		// TODO Auto-generated method stub
		boolean toReturn = false;
		int totalSuara = getSuara(idKandidat);

		String query = "update suara SET jumlah_suara = '" + (totalSuara + 1)
				+ "' where id_kandidat = '" + idKandidat + "'";

		try {
			toReturn = Koneksi.getInstance().getKoneksi().createStatement()
					.execute(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error pada insert " + e.getMessage());
		}
		updateStatusPemilih(id_pemilih);
		updateLog(idKandidat);

		return toReturn;

	}

	private void updateLog(int idKandidat) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd h:m:s");
		String query_log = "insert into logvote (id_kandidat,waktu_pemilihan) values ('"
				+ idKandidat + "','" + sdf.format(new Date())+ "')";
		System.out.println(query_log);
		try {
			Koneksi.getInstance().getKoneksi().createStatement()
					.execute(query_log);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error update log : " + e.getMessage());
		}
	}

	private void updateStatusPemilih(String id_pemilih) {
		String query_update_pemilih = "update pemilih set status_vote_pemilih = 'sudah' where id_pemilih = '"
				+ id_pemilih + "'";
		try {
			Koneksi.getInstance().getKoneksi().createStatement()
					.execute(query_update_pemilih);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error status pemilih : " + e.getMessage());
		}
	}

	@Override
	public int getSuara(int idKandidat) {
		// TODO Auto-generated method stub
		int total = 0;
		String query = "select jumlah_suara from suara where id_kandidat = '"
				+ idKandidat + "'";
		try {
			ResultSet rs = Koneksi.getInstance().getKoneksi().createStatement()
					.executeQuery(query);
			while (rs.next()) {
				total = rs.getInt("jumlah_suara");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return total;
	}

	@Override
	public String getOptionRekapitulasi() {
		// TODO Auto-generated method stub
		String status = null;
		String query = "Select value_option from options where id_option = 1";
		try {
			ResultSet rs = Koneksi.getInstance().getKoneksi().createStatement()
					.executeQuery(query);
			while (rs.next()) {
				status = rs.getString("value_option");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;
	}

}
