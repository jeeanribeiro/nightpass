package br.com.fiap.NightPassEjb.Servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.NightPassEjb.Entity.PessoaFisica;
import br.com.fiap.NightPassEjb.dao.PFisicaDAO;
import br.com.fiap.NightPassEjb.dao.PFisicaDAOImpl;

/**
 * Servlet implementation class CadastroUsuarioServlet
 */

@WebServlet("/CadastroUsuarioServlet")
public class CadastroUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroUsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@EJB
	private PFisicaDAO dao;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		List <PessoaFisica> listaPessoaFisica = dao.listarPorNome();
		
//		listaPessoaFisica.get(1).getPSJ_CODIGO().getEstabelecimento().getEst_Descricao();
		
		request.setAttribute("resultado", listaPessoaFisica);
		
		request.getRequestDispatcher("CadastroUsuario.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
