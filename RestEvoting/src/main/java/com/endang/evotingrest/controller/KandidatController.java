package com.endang.evotingrest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.endang.evotingrest.helper.BasicAuth;
import com.endang.evotingrest.interfaces.KandidatService;
import com.endang.evotingrest.model.Kandidat;
import com.endang.evotingrest.model.Status;
import com.endang.evotingrest.service.KandidatServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@RestController
public class KandidatController {
	
	private Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
	private KandidatService kandidatService = new KandidatServiceImpl();
	
	@ResponseBody
	@RequestMapping(value="/kandidat/{periode}",method = RequestMethod.GET)
	public String findAll(HttpServletRequest request,@PathVariable("periode") String periode){
		List<Kandidat> list = kandidatService.getKandidat(periode);
		if (list == null || list.size() == 0) {
			Status status = new Status("false", "Data Kandidat Tidak Ditemukan");
			return gson.toJson(status);
		}else
		return gson.toJson(list);
	}
	
	
}
