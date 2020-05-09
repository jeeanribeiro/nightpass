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
	
	@Autowired
	private PFisicaDAO pfisicaDao;
	
	List<Presenca> ListaPresenca; 
	
	PessoaFisica usuarioLog;
	
	@GetMapping("/{estCodigo}")
	public String abrirAgendaEst(@PathVariable("estCodigo") long estCodigo, Model model,
			@RequestParam(required=false) Presenca presenca){

		usuarioLog = (PessoaFisica) session.getAttribute("usuarioLog");
		
		usuarioLog = pfisicaDao.buscar(usuarioLog.getCodigo());
		
		Estabelecimento est = estabelecimentoDAO.buscar(estCodigo);
		
		model.addAttribute("EstabelecimentoAtu", est);
		
		List <Agenda> AgendaAtu = agendaDao.listarAgendaEst(est.getEstcodigo());

		List<Presenca> PresencaPessoa = usuarioLog.getPsaPresenca();
		
		List<Presenca> PresencaVer = new ArrayList<Presenca>();
		
		boolean AgendaExiste;
		
		for (Agenda agenda : AgendaAtu) {
			
			AgendaExiste = false;
			
			for (Presenca pres : PresencaPessoa) {
				
				if (pres.getPreAgenda().getAgeCodigo() == agenda.getAgeCodigo()) {
					
					PresencaVer.add(pres);
					AgendaExiste = true;
					break;
					
				} else {
					System.out.println("não");
				
				}
				
			}
			
			
			if(AgendaExiste == false) {
				
			Presenca novaPresenca = new Presenca();
			
			novaPresenca.setPreAgenda(agenda);
			novaPresenca.setPrePessoaFisica(usuarioLog);
			novaPresenca.setStatus("NÃO INFORMADO");
			
			PresencaVer.add(novaPresenca);
			
			}
			
		}
		
		for (Presenca presenca2 : PresencaVer) {
			
			System.out.println(presenca2.getPrePessoaFisica().getNome());
			System.out.println(presenca2.getPreAgenda().getAgeDetalhes());
			System.out.println(presenca2.getStatus());
			
		}
		
		
		/*
		 * for (Agenda agenda : AgendaAtu) {
		 * 
		 * Presenca presencaPessoa = presencaDao.ListarporPessoaAgenda(agenda,
		 * usuarioLog);
		 * 
		 * 
		 * PessoaAgenda pessoaAgenda = new PessoaAgenda();
		 * 
		 * pessoaAgenda.agenda = agenda;
		 * 
		 * if (presencaPessoa == null) {
		 * 
		 * pessoaAgenda.presenca = new Presenca();
		 * pessoaAgenda.presenca.setStatus("NÃO SEI");
		 * pessoaAgenda.presenca.setPreAgenda(agenda);
		 * pessoaAgenda.presenca.setPrePessoaFisica(usuarioLog);
		 * 
		 * }else {
		 * 
		 * pessoaAgenda.presenca = presencaPessoa;
		 * 
		 * }
		 * 
		 * ListaPessoaAgenda.add(pessoaAgenda);
		 * 
		 * }
		 * 
		 */	
		
		//model.addAttribute("ListaPessoaAgenda", ListaPessoaAgenda);
		
		model.addAttribute("PresencaVer", PresencaVer);
		
		//PresencaVer.get(1).getPreAgenda().getAgeData()
		
		return "base/PainelAgenda";
		
		
	}
	

}
