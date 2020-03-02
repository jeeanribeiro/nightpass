package br.com.fiap.NightPassEjb.Servlet;

import java.applet.Applet;
import java.awt.Component;
import java.awt.Frame;
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
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.taglibs.standard.tag.common.fmt.RequestEncodingSupport;

import br.com.fiap.NightPassEjb.Entity.PessoaFisica;
import br.com.fiap.NightPassEjb.dao.PFisicaDAO;

@WebServlet("/CadastroUsuarioServlet")
public class CadastroUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CadastroUsuarioServlet() {
        super();
    }

        
	@EJB
	private PFisicaDAO dao;
	
	private PessoaFisica cPFisica = new PessoaFisica();
	private PessoaFisica PFisicaConta;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String Acao;
		
		HttpSession session = request.getSession();
		
		PFisicaConta = (PessoaFisica) session.getAttribute("PFisicalog");
		
		SimpleDateFormat DtFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar CalDtNascimento = Calendar.getInstance();

		
		Acao = request.getParameter("acao");
		
		request.setAttribute("CadastroAtu", "");
		
		switch(Acao) {
		
		case "conta":
		
			String atuSexo;
		
			atuSexo = PFisicaConta.getSexo(); 

			session.setAttribute("sexoF", "");
			session.setAttribute("sexoM", "");
			session.setAttribute("sexoO", "");
			
			switch(atuSexo) {
			
			case "F":
				
				session.setAttribute("sexoF", "checked");
				
			break;
						
			case "M":
				
				session.setAttribute("sexoM", "checked");
			
			break;
			
			case "O":
				
				session.setAttribute("sexoO", "checked");
				
			break;
			
			}
		
		request.getRequestDispatcher("DadosContaUsuario.jsp").forward(request, response);
		
		break;
		
		
		case "Atualizar Dados":
			
		//Códigos para atualização do cadastro do usuário logado

			
		PFisicaConta.setNome((String) request.getParameter("nome"));
		PFisicaConta.setSobrenome((String) request.getParameter("sobrenome"));
		
		try {
			CalDtNascimento.setTime((Date) DtFormat.parseObject(request.getParameter("dtNascimento")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PFisicaConta.setDataNasc(CalDtNascimento);
		
		PFisicaConta.setRg((String) request.getParameter("rg"));
		
		PFisicaConta.setRgOrgaoEmissor((String) request.getParameter("rgOrgaoEmissor"));
		
		PFisicaConta.setRgEstadoEmissor((String) request.getParameter("rgEstado"));
		
		PFisicaConta.setSexo((String) request.getParameter("sexo"));
		
		PFisicaConta.setTelCelular(Long.parseLong((String) request.getParameter("telCelular")));
		
		PFisicaConta.setTipoUsuario((String) request.getParameter("tipoUsuario"));
		
		PFisicaConta.setEmail((String) request.getParameter("email"));
		
		PFisicaConta.setSenha((String) request.getParameter("senha"));
		
		PFisicaConta.setTipoUsuario("consumidor");
		
		dao.atualizar(PFisicaConta);
		
		request.setAttribute("CadastroAtu", "Cadastro Atualizado");
		
		request.getRequestDispatcher("DadosContaUsuario.jsp").forward(request, response);
		
		break;
		
		
		case "Remover Conta":
			
			try {
				dao.remover(PFisicaConta.getCodigo());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		request.setAttribute("contaexcluida", "Conta Excluída!");
			
		request.getRequestDispatcher("MsgExcluido.jsp").forward(request, response);
				
			
		break;
		
		default:
		
				
		cPFisica.setNome((String) request.getParameter("nome"));
		cPFisica.setSobrenome((String) request.getParameter("sobrenome"));
		
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
		
		request.setAttribute("cadastroRealizado", "Cadastro Realizado, faça seu login");
		
		request.getRequestDispatcher("LoginUsuario.jsp").forward(request, response);
		
		break;
		
		}
		
	}
		
}
