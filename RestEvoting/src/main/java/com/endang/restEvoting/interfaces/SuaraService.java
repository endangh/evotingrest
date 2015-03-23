package com.endang.restEvoting.interfaces;

import java.util.List;

import com.endang.restEvoting.model.Suara;

public interface SuaraService {
	
	List<Suara> findAll();
	boolean insertVote(int idKandidat,String id_pemilih);
	int getSuara(int idKandidat);
	String getOptionRekapitulasi();
}
