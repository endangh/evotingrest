package com.endang.restEvoting.controller;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.endang.restEvoting.helper.EmailSender;
import com.endang.restEvoting.helper.SmsSender;
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
		} else
			return gson.toJson(p);

	}

	@ResponseBody
	@RequestMapping(value = "/pemilih/pass/{id_pemilih}", method = RequestMethod.GET)
	public String findPass(HttpServletRequest servletRequest,
			@PathVariable("id_pemilih") String id_pemilih) {
		String username = pemilihService.getOptionSmsUsername();
		String password = pemilihService.getOptionSmsPassword();
		String apiKey = pemilihService.getOptionSmsApi();
		String password_login = pemilihService.getPassword(id_pemilih);
		String noHP = pemilihService.getNoHP(id_pemilih);
		String email = pemilihService.getEmail(id_pemilih);
		String pesan = "EVOTING HMTIF - User : " + id_pemilih + " Password : "
				+ password_login;
		String pesan_URL = URLEncoder.encode(pesan).replace("+", "%20");
		String api = pemilihService.getOptionSmsLink()+"username="
				+ username + "&password=" + password + "&key=" + apiKey
				+ "&number=" + noHP + "&message=" + pesan_URL;
		
		SmsSender.getInstance().excute(api, "");
		EmailSender.getInstance().sendEmail(email, pesan);
		return gson.toJson(new Status("true", "password telah dikirim"));
	}

	@ResponseBody
	@RequestMapping(value = "/pemilih/login", method = RequestMethod.GET)
	public String login(HttpServletRequest servletRequest) {
		Status status = new Status();
		if (AccessController.getInstance().checkAccess(servletRequest)) {
			status.setResponse("true");
			status.setError("Sukses Login");
		} else {
			status.setResponse("false");
			status.setError("Username dan Password Tidak Sesuai");
		}

		return gson.toJson(status);
	}
	
	

}
