package com.endang.evotingrest.interfaces;

import java.util.List;

import com.endang.evotingrest.model.Suara;

public interface SuaraService {
	
	List<Suara> findAll(String periode);
	boolean insertVote(int idKandidat,String id_pemilih);
	int getSuara(int idKandidat);
	String getOptionRekapitulasi();
}
