package com.endang.restEvoting.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.endang.restEvoting.helper.BasicAuth;
import com.endang.restEvoting.interfaces.KandidatService;
import com.endang.restEvoting.model.Kandidat;
import com.endang.restEvoting.model.Status;
import com.endang.restEvoting.service.KandidatServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@RestController
public class KandidatController {
	
	private Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
	private KandidatService kandidatService = new KandidatServiceImpl();
	
	@ResponseBody
	@RequestMapping(value="/kandidat",method = RequestMethod.GET)
	public String findAll(HttpServletRequest request){
		List<Kandidat> list = kandidatService.getKandidat();
		if (list == null) {
			Status status = new Status("false", "Data Kandidat Tidak Ditemukan");
			return gson.toJson(status);
		}else
		return gson.toJson(list);
	}
	
	
}
