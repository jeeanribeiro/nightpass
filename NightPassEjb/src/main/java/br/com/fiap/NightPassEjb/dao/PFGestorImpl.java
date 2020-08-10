package br.com.fiap.NightPassEjb.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.com.fiap.NightPassEjb.Entity.PFGestor;

@Stateless
@Remote
public class PFGestorImpl extends GenericDAOImpl<PFGestor, Integer>
				implements PFGestorDAO{

	public PFGestorImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
