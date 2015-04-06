package com.endang.evotingrest.interfaces;

import java.util.List;

import com.endang.evotingrest.model.Kandidat;

public interface KandidatService {
	
	List<Kandidat> getKandidat(String periode);

}
