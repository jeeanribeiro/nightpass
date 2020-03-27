package br.com.fiap.NightPassEjb.Servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.NightPassEjb.Entity.PFGestor;
import br.com.fiap.NightPassEjb.Entity.PessoaFisica;
import br.com.fiap.NightPassEjb.dao.PFisicaDAO;

public class GestorPJServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	PFisicaDAO pfDao;
	
	public GestorPJServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PessoaFisica cPFisicaGestor;
		
		HttpSession session = request.getSession();
				
		String Acao;
		
		Acao = request.getParameter("acao");
		
		switch(Acao) {
		
		case "listarPJdoGestor":

		cPFisicaGestor = (PessoaFisica) session.getAttribute("PFisicalog");
		
		cPFisicaGestor = pfDao.buscar(cPFisicaGestor.getCodigo());
		
		session.setAttribute("PFisicalog", cPFisicaGestor);
				
		request.getRequestDispatcher("PainelGestorPJ.jsp").include(request, response);
			
			//proc

		break;
		
		}
			
		
	}

}
