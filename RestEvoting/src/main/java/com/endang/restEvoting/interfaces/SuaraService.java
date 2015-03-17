package com.endang.restEvoting.interfaces;

import java.util.List;

import com.endang.restEvoting.model.Suara;

public interface SuaraService {
	
	List<Suara> findAll();
	boolean insertVote(String idKandidat,String id_pemilih);
	int getSuara(String idKandidat);
	String getOptionRekapitulasi();
}
