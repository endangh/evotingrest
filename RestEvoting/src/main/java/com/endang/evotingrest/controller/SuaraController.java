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
import com.endang.evotingrest.interfaces.SuaraService;
import com.endang.evotingrest.model.Status;
import com.endang.evotingrest.model.Suara;
import com.endang.evotingrest.service.PemilihServiceImpl;
import com.endang.evotingrest.service.SuaraServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
public class SuaraController {

	private Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
	private SuaraService suaraService = new SuaraServiceImpl();

	@ResponseBody
	@RequestMapping(value = "/suara/{periode}", method = RequestMethod.GET)
	public String findAll(HttpServletRequest servletRequest, @PathVariable("periode") String periode) {
		if (suaraService.getOptionRekapitulasi().equals("true")) {
			List<Suara> list = suaraService.findAll(periode);
			if (list.size()==0) {
				return gson.toJson(new Status("false", "Data Tidak Ditemukan"));
			}
			return gson.toJson(list);
		} else {
			Status status = new Status("false",
					"Rekap belum diizinkan ditayangkan");
			return gson.toJson(status);
		}
	}

	@ResponseBody
	@RequestMapping(value = "/suara", method = RequestMethod.POST)
	public String vote(HttpServletRequest servletRequest,
			@RequestBody String json) {
		if (!AccessController.getInstance().checkAccess(servletRequest)) {
			Status status = new Status("false",
					"Username dan Password Tidak Sesuai");
			return gson.toJson(status);
		}

		if (new PemilihServiceImpl().getStatusPemilih(
				new BasicAuth(servletRequest).getUsername()).equals("sudah")) {
			Status status2 = new Status("false", "Pemilih Sudah Memilih");
			return gson.toJson(status2);
		}

		Suara suara = gson.fromJson(json, Suara.class);
		System.out.println(suara.getNamaKandidat());
		suaraService.insertVote(suara.getIdKandidat(), new BasicAuth(
				servletRequest).getUsername());
		return gson.toJson(new Status("true", "Sukses simpan suara"));
	}
}
