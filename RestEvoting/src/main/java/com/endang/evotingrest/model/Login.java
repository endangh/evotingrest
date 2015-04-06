package com.endang.evotingrest.model;

// default package
// Generated 07-Nov-2014 10:39:09 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;


public class Login {

	private Integer idLogin;
	private String usernameLogin;
	private String passwordLogin;
	private String grupLogin;
	private boolean statusLogin;
	private Set<Pemilih> pemilihs = new HashSet<Pemilih>(0);

	public Login() {
	}

	public Login(String usernameLogin, String passwordLogin, String grupLogin,
			boolean statusLogin) {
		this.usernameLogin = usernameLogin;
		this.passwordLogin = passwordLogin;
		this.grupLogin = grupLogin;
		this.statusLogin = statusLogin;
	}

	public Login(String usernameLogin, String passwordLogin, String grupLogin,
			boolean statusLogin, Set<Pemilih> pemilihs) {
		this.usernameLogin = usernameLogin;
		this.passwordLogin = passwordLogin;
		this.grupLogin = grupLogin;
		this.statusLogin = statusLogin;
		this.pemilihs = pemilihs;
	}

	public Integer getIdLogin() {
		return this.idLogin;
	}

	public void setIdLogin(Integer idLogin) {
		this.idLogin = idLogin;
	}

	public String getUsernameLogin() {
		return this.usernameLogin;
	}

	public void setUsernameLogin(String usernameLogin) {
		this.usernameLogin = usernameLogin;
	}

	public String getPasswordLogin() {
		return this.passwordLogin;
	}

	public void setPasswordLogin(String passwordLogin) {
		this.passwordLogin = passwordLogin;
	}

	public String getGrupLogin() {
		return this.grupLogin;
	}

	public void setGrupLogin(String grupLogin) {
		this.grupLogin = grupLogin;
	}

	public boolean isStatusLogin() {
		return this.statusLogin;
	}

	public void setStatusLogin(boolean statusLogin) {
		this.statusLogin = statusLogin;
	}

	public Set<Pemilih> getPemilihs() {
		return this.pemilihs;
	}

	public void setPemilihs(Set<Pemilih> pemilihs) {
		this.pemilihs = pemilihs;
	}

}
