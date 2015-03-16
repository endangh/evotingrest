package com.endang.restEvoting.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.endang.restEvoting.interfaces.PemilihService;
import com.endang.restEvoting.model.Pemilih;
import com.endang.restEvoting.model.Status;
import com.endang.restEvoting.service.PemilihServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
public class PemilihController {

	private Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
	private PemilihService pemilihService = new PemilihServiceImpl();

	@ResponseBody
	@RequestMapping(value = "/pemilih/{id_pemilih}", method = RequestMethod.GET)
	public String find(HttpServletRequest servletRequest,
			@PathVariable("id_pemilih") String id_pemilih) {
		Pemilih p = pemilihService.getPemilih(id_pemilih);
		if (p == null) {
			Status status = new Status("false", "Pemilih Tidak Ditemukan");
			return gson.toJson(status);
		}else
		return gson.toJson(p);

	}
	
	@ResponseBody
	@RequestMapping(value = "/pemilih/pass/{id_pemilih}",method = RequestMethod.POST)
	public String findPass(HttpServletRequest servletRequest,@PathVariable("id_pemilih") String id_pemilih){
		
		return  null;
	}
	
	
}
