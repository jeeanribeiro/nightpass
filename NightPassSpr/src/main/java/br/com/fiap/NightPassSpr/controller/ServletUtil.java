package br.com.fiap.NightPassSpr.controller;

import java.io.File;

import javax.servlet.http.HttpServlet;

public class ServletUtil extends HttpServlet  {

	private static final long serialVersionUID = 1L;

	public void init() {}

	public String GetPath() {
		return this.getServletContext().getRealPath(File.separator);
	}

}
