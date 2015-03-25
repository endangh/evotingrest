package com.endang.restEvoting.interfaces;

import com.endang.restEvoting.model.Pemilih;

public interface PemilihService {
	
	Pemilih getPemilih(String nrp);
	String getPassword(String id);
	String getNoHP(String id);
	String getStatusPemilih(String id);
	String getEmail(String id);
	String getOptionSmsUsername();
	String getOptionSmsPassword();
	String getOptionSmsApi();
	String getOptionSmsLink();
}
