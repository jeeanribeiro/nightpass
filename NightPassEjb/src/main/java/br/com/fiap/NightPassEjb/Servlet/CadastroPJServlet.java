package br.com.fiap.NightPassEjb.Servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.NightPassEjb.Entity.PJuridica;
import br.com.fiap.NightPassEjb.Entity.PessoaFisica;
import br.com.fiap.NightPassEjb.dao.PFisicaDAO;
import br.com.fiap.NightPassEjb.dao.PJuridicaDAO;

public class CadastroPJServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private PJuridicaDAO dao;
	
	@EJB
	private PFisicaDAO daopf;
	
	private PJuridica cPJuridica = new PJuridica();
	private PessoaFisica cPFisica = new PessoaFisica(); 
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroPJServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cPJuridica.setPsjNome(request.getParameter("nome"));
		cPJuridica.setPsjCnpj(Long.parseLong(request.getParameter("cnpj")));
		cPJuridica.setPsjTelComercial(Long.parseLong(request.getParameter("telefoneCom")));
		cPJuridica.setPsjEnderecoCom(request.getParameter("enderecoCom"));
		cPJuridica.setPsjNumeroCom(Integer.parseInt(request.getParameter("numeroCom")));
		cPJuridica.setPsjCepCom(Integer.parseInt(request.getParameter("CepCom")));
		cPJuridica.setPsjBairroCom((request.getParameter("bairroCom")));
		cPJuridica.setPsjCidadeCom(request.getParameter("cidadeCom"));
		cPJuridica.setPsjEstadoCom(request.getParameter("estadoCom"));
		cPJuridica.setPsjEmail(request.getParameter("email"));
		cPJuridica = dao.cadastrarR(cPJuridica);
		
		HttpSession session = request.getSession();
		cPFisica = (PessoaFisica) session.getAttribute("PFisicalog");
		cPFisica.setTipoUsuario("gestor");
		cPFisica.setPSJ_CODIGO(cPJuridica);
		daopf.atualizar(cPFisica);
		
		request.setAttribute("PJCadastrada", "Pessoa Jurídica Cadastrada com sucesso!");
		request.getRequestDispatcher("CadastroPJ.jsp").forward(request, response);
	}

}
