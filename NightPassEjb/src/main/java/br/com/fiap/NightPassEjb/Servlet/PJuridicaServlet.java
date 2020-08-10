package br.com.fiap.NightPassEjb.Servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.NightPassEjb.Entity.PJuridica;
import br.com.fiap.NightPassEjb.dao.PJuridicaDAO;
import br.com.fiap.NightPassEjb.dao.PJuridicaDAOImpl;

@WebServlet("/pjuridica")
public class PJuridicaServlet extends HttpServlet{
	
	@EJB
	private PJuridicaDAO dao;
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List <PJuridica> pJuridica = dao.listarPorNome();
		
		req.setAttribute("resultado", pJuridica);
		
		req.getRequestDispatcher("BuscaPessoaJuridica.jsp").forward(req, resp);
	}

}
