package com.endang.restEvoting.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.endang.restEvoting.interfaces.SuaraService;
import com.endang.restEvoting.model.Status;
import com.endang.restEvoting.model.Suara;
import com.endang.restEvoting.service.SuaraServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
public class SuaraController {

	private Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
	private SuaraService suaraService = new SuaraServiceImpl();

	@ResponseBody
	@RequestMapping(value = "/suara", method = RequestMethod.GET)
	public String findAll() {
		if (suaraService.getOptionRekapitulasi().equals("true")) {
			List<Suara> list = suaraService.findAll();
			return gson.toJson(list);
		} else {
			Status status = new Status("false",
					"Rekap belum diizinkan ditayangkan");
			return gson.toJson(status);
		}

	}
}
