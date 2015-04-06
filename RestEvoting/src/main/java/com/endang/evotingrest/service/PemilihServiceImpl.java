package com.endang.evotingrest.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.endang.evotingrest.interfaces.PemilihService;
import com.endang.evotingrest.model.Pemilih;

@Service
public class PemilihServiceImpl implements PemilihService {

	@Override
	public Pemilih getPemilih(String nrp) {
		// TODO Auto-generated method stub
		Pemilih p = null;
		String query = "select * from pemilih where id_pemilih = '" + nrp + "'";
		try {
			ResultSet rs = Koneksi.getInstance().getKoneksi().createStatement()
					.executeQuery(query);
			while (rs.next()) {
				p = new Pemilih(rs.getString("id_pemilih"),
						rs.getString("nama_pemilih"),
						rs.getString("no_hp_pemilih"),
						rs.getString("email_pemilih"),
						rs.getString("status_vote_pemilih"),
						rs.getBoolean("status_pemilih"), "true");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public String getPassword(String id) {
		String password = "";
		String query = "select password_login from login where username_login = '"
				+ id + "'";
		try {
			ResultSet rs = Koneksi.getInstance().getKoneksi().createStatement()
					.executeQuery(query);
			while (rs.next()) {
				password = rs.getString("password_login");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return password;
	}

	@Override
	public String getNoHP(String id) {
		String no = "";
		String query = "select no_hp_pemilih from pemilih where id_pemilih = '"
				+ id + "'";
		try {
			ResultSet rs = Koneksi.getInstance().getKoneksi().createStatement()
					.executeQuery(query);
			while (rs.next()) {
				no = rs.getString("no_hp_pemilih");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return no;
	}

	@Override
	public String getStatusPemilih(String id) {
		String status = "_";
		String query = "select status_vote_pemilih from pemilih where id_pemilih = '"
				+ id + "'";
		try {
			ResultSet rs = Koneksi.getInstance().getKoneksi().createStatement()
					.executeQuery(query);
			while (rs.next()) {
				status = rs.getString("status_vote_pemilih");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String getEmail(String id) {
		String email = "_";
		String query = "select email_pemilih from pemilih where id_pemilih = '"
				+ id + "'";
		try {
			ResultSet rs = Koneksi.getInstance().getKoneksi().createStatement()
					.executeQuery(query);
			while (rs.next()) {
				email = rs.getString("email_pemilih");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return email;
	}

	@Override
	public String getOptionSmsUsername() {
		String username = "_";
		String query = "Select value_option from options where id_option = 7";
		try {
			ResultSet rs = Koneksi.getInstance().getKoneksi().createStatement()
					.executeQuery(query);
			while (rs.next()) {
				username = rs.getString("value_option");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return username;
	}

	@Override
	public String getOptionSmsPassword() {
		String password = "_";
		String query = "Select value_option from options where id_option = 8";
		try {
			ResultSet rs = Koneksi.getInstance().getKoneksi().createStatement()
					.executeQuery(query);
			while (rs.next()) {
				password = rs.getString("value_option");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return password;
	}

	@Override
	public String getOptionSmsApi() {
		String apiKey = "_";
		String query = "Select value_option from options where id_option = 9";
		try {
			ResultSet rs = Koneksi.getInstance().getKoneksi().createStatement()
					.executeQuery(query);
			while (rs.next()) {
				apiKey = rs.getString("value_option");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return apiKey;
	}

	@Override
	public String getOptionSmsLink() {
		String link = "_";
		String query = "Select value_option from options where id_option = 10";
		try {
			ResultSet rs = Koneksi.getInstance().getKoneksi().createStatement()
					.executeQuery(query);
			while (rs.next()) {
				link = rs.getString("value_option");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return link;
	}
}
