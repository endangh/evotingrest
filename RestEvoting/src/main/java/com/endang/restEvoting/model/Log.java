package com.endang.restEvoting.model;

// default package
// Generated 07-Nov-2014 10:39:09 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

public class Log {

	private Integer idLog;
	private String user;
	private String ipKomputer;
	private String kejadian;
	private Date waktu;

	public Log() {
	}

	public Log(String user, String ipKomputer, String kejadian, Date waktu) {
		this.user = user;
		this.ipKomputer = ipKomputer;
		this.kejadian = kejadian;
		this.waktu = waktu;
	}

	public Integer getIdLog() {
		return this.idLog;
	}

	public void setIdLog(Integer idLog) {
		this.idLog = idLog;
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getIpKomputer() {
		return this.ipKomputer;
	}

	public void setIpKomputer(String ipKomputer) {
		this.ipKomputer = ipKomputer;
	}

	public String getKejadian() {
		return this.kejadian;
	}

	public void setKejadian(String kejadian) {
		this.kejadian = kejadian;
	}

	public Date getWaktu() {
		return this.waktu;
	}

	public void setWaktu(Date waktu) {
		this.waktu = waktu;
	}

}
