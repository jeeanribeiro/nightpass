package br.com.fiap.NightPassEjb.Servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.NightPassEjb.Entity.PessoaFisica;
import br.com.fiap.NightPassEjb.dao.PFisicaDAO;

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
	
	private PessoaFisica cPFisica = new PessoaFisica();
	private PessoaFisica PFisicaConta = new PessoaFisica();
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append(request.getParameter("acessarConta"));
		
		HttpSession session = request.getSession();
		
		PFisicaConta = (PessoaFisica) session.getAttribute("PFisicalog");
		
		
		
		
		
		
		
		
		
		
		


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
				
		cPFisica.setNome((String) request.getParameter("nome"));
		cPFisica.setSobrenome((String) request.getParameter("sobrenome"));
		
		SimpleDateFormat DtFormat = new SimpleDateFormat("yyyy-MM-dd");

		Calendar CalDtNascimento = Calendar.getInstance();
		
		try {
			CalDtNascimento.setTime((Date) DtFormat.parseObject(request.getParameter("dtNascimento")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cPFisica.setDataNasc(CalDtNascimento);
		
		cPFisica.setRg((String) request.getParameter("rg"));
		
		cPFisica.setRgOrgaoEmissor((String) request.getParameter("rgOrgaoEmissor"));
		
		cPFisica.setRgEstadoEmissor((String) request.getParameter("rgEstado"));
		
		cPFisica.setCpf(Long.parseLong(((String) request.getParameter("cpf"))));
		
		cPFisica.setSexo((String) request.getParameter("sexo"));
		
		cPFisica.setTelCelular(Long.parseLong((String) request.getParameter("telCelular")));
		
		cPFisica.setTipoUsuario((String) request.getParameter("tipoUsuario"));
		
		cPFisica.setEmail((String) request.getParameter("email"));
		
		cPFisica.setSenha((String) request.getParameter("senha"));
		
		cPFisica.setTipoUsuario("consumidor");
		
		
		dao.cadastrar(cPFisica);
		
		request.getRequestDispatcher("CadastroUsuario.jsp").forward(request, response);
		
		
	}

}
