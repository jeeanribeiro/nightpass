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

import br.com.fiap.NightPassEjb.Entity.PFGestor;
import br.com.fiap.NightPassEjb.Entity.PJuridica;
import br.com.fiap.NightPassEjb.Entity.PessoaFisica;
import br.com.fiap.NightPassEjb.dao.PFGestorDAO;
import br.com.fiap.NightPassEjb.dao.PFisicaDAO;
import br.com.fiap.NightPassEjb.dao.PJuridicaDAO;

public class CadastroPJServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private PJuridicaDAO dao;
	
	@EJB
	private PFisicaDAO daopf;
	
	@EJB
	private PFGestorDAO daoPFGestor;
	
	
	
    public CadastroPJServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PJuridica cPJuridica = new PJuridica();
		PessoaFisica cPFisica = new PessoaFisica(); 
		
		//Cadastra uma nova Pessoa Jurídica no Banco de Dados
		
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
		
		//Obtem o usuário logado e modifica seu atributo para gestor
		
		HttpSession session = request.getSession();
		cPFisica = (PessoaFisica) session.getAttribute("PFisicalog");
		cPFisica.setTipoUsuario("gestor");
		daopf.atualizar(cPFisica);
		
		//Cria um registro na Tabela PFGestor registrando o usuário como proprietario da 
		//PJ
		
		PFGestor pfGestor = new PFGestor();
		
		pfGestor.setPessoaFisica(cPFisica);
		pfGestor.setpJuridica(cPJuridica);
		pfGestor.setRgePerfil("PROPRIETARIO");
		
		daoPFGestor.cadastrar(pfGestor);
		
		request.setAttribute("PJCadastrada", "Pessoa Jurídica Cadastrada com sucesso!");
		request.getRequestDispatcher("CadastroPJ.jsp").forward(request, response);
		
		
	}

}
