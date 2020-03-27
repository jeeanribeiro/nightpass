package br.com.fiap.NightPassEjb.Servlet;

import java.io.IOException;
import java.util.Calendar;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.NightPassEjb.Entity.Estabelecimento;
import br.com.fiap.NightPassEjb.Entity.PJuridica;
import br.com.fiap.NightPassEjb.Entity.TipoEstabelecimento;
import br.com.fiap.NightPassEjb.dao.EstabelecimentoDAO;
import br.com.fiap.NightPassEjb.dao.PJuridicaDAO;
import br.com.fiap.NightPassEjb.dao.TipoEstabelecimentoDAO;
import br.com.fiap.NightPassEjb.util.FormatDate;

public class AdmEstabelecimentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	EstabelecimentoDAO estabelecimentoDao;
	@EJB
	PJuridicaDAO pjuridicaDao;
	
	@EJB
	TipoEstabelecimentoDAO tipoEstabelecimentoDao;
	
    public AdmEstabelecimentoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TipoEstabelecimento tpEstabelecimento = new TipoEstabelecimento();
		
		String acao;
		
		acao = (String) request.getParameter("acao");
		
		HttpSession session = request.getSession();
		
		switch (acao) {
		
		case "buscar":
			
			buscarEstabelecimento(Integer.parseInt(
					request.getParameter("pJuridicaSel")), session,
					request);
			
			request.getRequestDispatcher("PainelEstabelecimento.jsp").include(request, response);

		break;
		
		case "alterar":
			
			PJuridica pjuridicasel = new PJuridica();
			Estabelecimento estabelecimentopj = new Estabelecimento();
			
			pjuridicasel = (PJuridica) session.getAttribute("PjuridicaSel");
			
			//Cadatra um ou altera os dados do estabelecimento

			if (pjuridicasel.getEstabelecimento() == null) {
			
			estabelecimentopj = new Estabelecimento();
			
			}else {
				
			estabelecimentopj = pjuridicasel.getEstabelecimento();
			
			}
			

			Calendar cl;
			
			cl = FormatDate.fmtDateTime("2000/01/01 " + request.getParameter("estabertura"));
			estabelecimentopj.setEstAbertura(cl);
			
			cl = FormatDate.fmtDateTime("2000/01/01 " + request.getParameter("estfechamento"));
			estabelecimentopj.setEstFechamento(cl);
			
			estabelecimentopj.setEstDescricao(request.getParameter("estdescricao"));
			
			tpEstabelecimento = tipoEstabelecimentoDao.buscar(1);
			estabelecimentopj.setTes_codigo(tpEstabelecimento);
			
			
			if (pjuridicasel.getEstabelecimento() == null) {
				
				System.out.println("nao");
				
				estabelecimentopj.setPSJ_CODIGO(pjuridicasel);
				estabelecimentopj = estabelecimentoDao.cadastrarRetEntity(estabelecimentopj);
				
				
			} else {
			
			System.out.println("sim");
			
			estabelecimentoDao.atualizar(estabelecimentopj);
			
			}
			
			session.setAttribute("PjuridicaSel", pjuridicasel);
			
			buscarEstabelecimento(pjuridicasel.getPsjCodigo(), session, request);
			
			request.getRequestDispatcher("PainelEstabelecimento.jsp").include(request, response);
			
		break;
		
		}
		
		//request.getRequestDispatcher("PainelEstabelecimento.jsp").include(request, response);
		
		
	}

	private void buscarEstabelecimento(int ChavePJ, HttpSession session,
			HttpServletRequest request) {
		
		PJuridica pjuridicasel = new PJuridica();
		Estabelecimento estabelecimentopj = new Estabelecimento();
		
		//busca o estabelecimento vinculado a PJ se existir
		
		pjuridicasel = pjuridicaDao.buscar(ChavePJ);
		
		if (pjuridicasel.getEstabelecimento() == null) {
			
			request.setAttribute("statusEstab", "inexiste");
						
			session.removeAttribute("estabelecimentopj");
			session.setAttribute("PjuridicaSel", pjuridicasel);
			
			
		}else {
			
			//busca a pessoa jurídica selecionada pelo gestor
			
			session.setAttribute("PjuridicaSel", pjuridicasel);
			
			estabelecimentopj = pjuridicasel.getEstabelecimento();
			session.setAttribute("estabelecimentopj", estabelecimentopj);
				
		}
		
		
	}

}
