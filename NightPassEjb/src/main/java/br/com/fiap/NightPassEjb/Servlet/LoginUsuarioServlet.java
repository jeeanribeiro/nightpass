package br.com.fiap.NightPassEjb.Servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.NightPassEjb.Entity.PessoaFisica;
import br.com.fiap.NightPassEjb.dao.PFisicaDAO;

@WebServlet("/LoginUsuarioServlet")
public class LoginUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUsuarioServlet() {
        super();
    }

	@EJB
	private PFisicaDAO dao;

	private PessoaFisica cPFisica = new PessoaFisica();
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession usSession;
		boolean senhaValida = false;
		
		usSession = request.getSession();
				
		cPFisica = dao.buscarPorEmail((String) request.getParameter("email"));
		
		if (cPFisica == null) {
			request.setAttribute("resultado", "Usuario Não Encontrado");
			usSession.invalidate();
		} else {
			if (cPFisica.ValidarSenha(request.getParameter("senha")) == true) {
				usSession.setAttribute("PFisicalog", cPFisica);
				senhaValida = true;
				request.getRequestDispatcher("PainelPrincipal.jsp").include(request, response);
			} else {
				request.setAttribute("resultado", "Senha Incorreta");
				usSession.invalidate();
			}
		}
		
		if(senhaValida != true) {
			request.getRequestDispatcher("LoginUsuario.jsp").forward(request, response);
		}
		
	}

}
