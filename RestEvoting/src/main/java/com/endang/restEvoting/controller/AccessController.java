package com.endang.restEvoting.controller;

import javax.servlet.http.HttpServletRequest;

import com.endang.restEvoting.helper.BasicAuth;

public class AccessController {
		
	public static AccessController getInstance(){
		return new AccessController();
	}
	
	public boolean checkAccess(HttpServletRequest servletRequest){
		String username = "endang";
		String password = "12345";
		
		BasicAuth basicAuth = new BasicAuth(servletRequest);
		
		return username.equals(basicAuth.getUsername())&& password.equals(basicAuth.getPassword());
	}

}
