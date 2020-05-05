package br.com.fiap.NightPassSpr.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.fiap.NightPassSpr.Dao.AgendaDAO;
import br.com.fiap.NightPassSpr.Dao.EstabelecimentoDAO;
import br.com.fiap.NightPassSpr.Dao.PFisicaDAO;
import br.com.fiap.NightPassSpr.Dao.PresencaDAO;
import br.com.fiap.NightPassSpr.Entity.Agenda;
import br.com.fiap.NightPassSpr.Entity.Estabelecimento;
import br.com.fiap.NightPassSpr.Entity.PessoaAgenda;
import br.com.fiap.NightPassSpr.Entity.PessoaFisica;
import br.com.fiap.NightPassSpr.Entity.Presenca;

@Controller
@RequestMapping("/agenda")

public class AgendaController {
	
	
	@Autowired
	private AgendaDAO agendaDao;
	
	@Autowired
	private EstabelecimentoDAO estabelecimentoDAO;
	
	@Autowired
	private HttpSession session;

	@Autowired
	private PresencaDAO presencaDao;
	
	
	List<Presenca> ListaPresenca; 
	
	PessoaFisica usuarioLog;
	
	@GetMapping("/{estCodigo}")
	public String abrirAgendaEst(@PathVariable("estCodigo") long estCodigo, Model model,
			@RequestParam(required=false) Presenca presenca){

	
		usuarioLog = (PessoaFisica) session.getAttribute("usuarioLog");
		
		//ListaPresenca = usuarioLog.getPsaPresenca();
		
		//System.out.println(ListaPresenca.size());
		
		//model.addAttribute("ListaPresenca", ListaPresenca);
		
		Estabelecimento est = estabelecimentoDAO.buscar(estCodigo);
		
		model.addAttribute("EstabelecimentoAtu", est);
		
		List <Agenda> AgendaAtu = agendaDao.listarAgendaEst(est.getEstcodigo());
		
		//model.addAttribute("AgendaAtu", AgendaAtu);
		
		List <PessoaAgenda> ListaPessoaAgenda = new ArrayList<PessoaAgenda>();

			for (Agenda agenda : AgendaAtu) {
			
				Presenca presencaPessoa = presencaDao.ListarporPessoaAgenda(agenda, usuarioLog);

				PessoaAgenda pessoaAgenda = new PessoaAgenda();
				
				pessoaAgenda.agenda = agenda;
				
					if (presencaPessoa == null) {
						
						pessoaAgenda.presenca = new Presenca();
						pessoaAgenda.presenca.setStatus("NÃO SEI");
						pessoaAgenda.presenca.setPreAgenda(agenda);
						pessoaAgenda.presenca.setPrePessoaFisica(usuarioLog);
						
					}else {
							
						pessoaAgenda.presenca = presencaPessoa;
						
					}
				
				ListaPessoaAgenda.add(pessoaAgenda);
				
			}
		
		
		model.addAttribute("ListaPessoaAgenda", ListaPessoaAgenda);
		
		presenca = new Presenca();
	
		model.addAttribute("Presenca", presenca);
		
		return "base/PainelAgenda";
		
		
	}
	

}
