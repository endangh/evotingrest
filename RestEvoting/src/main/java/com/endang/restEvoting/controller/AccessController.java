package com.endang.restEvoting.controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.endang.restEvoting.helper.BasicAuth;
import com.endang.restEvoting.service.Koneksi;

public class AccessController {

	public static AccessController getInstance() {
		return new AccessController();
	}

	public boolean checkAccess(HttpServletRequest servletRequest) {
		BasicAuth basicAuth = new BasicAuth(servletRequest);
		return getLogin(basicAuth.getUsername(), basicAuth.getPassword());
	}

	private boolean getLogin(String username, String password) {
		boolean toReturn = false;
		int hasil = 0;
		String query = "select COUNT(username_login) as login from login where username_login = '"
				+ username + "' AND password_login = '" + password + "'";
		try {
			ResultSet rs = Koneksi.getInstance().getKoneksi().createStatement()
					.executeQuery(query);
			if (rs.next()) {
				hasil = rs.getInt("login");
			}
		} catch (SQLException ex) {
			System.out.println("error load login " + ex.getMessage());
		}
		if (hasil > 0) {
			toReturn = true;
		}
		return toReturn;
	}

}
