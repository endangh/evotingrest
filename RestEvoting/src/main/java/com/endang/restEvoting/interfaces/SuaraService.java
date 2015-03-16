package com.endang.restEvoting.interfaces;

import java.util.List;

import com.endang.restEvoting.model.Suara;

public interface SuaraService {
	
	List<Suara> findAll();
	boolean insertSuara(int idKandidat);
	int getSuara(int idKandidat);
	String getOptionRekapitulasi();
}
