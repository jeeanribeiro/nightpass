package br.com.fiap.NightPassEjb.dao;

import javax.ejb.Remote;

import br.com.fiap.NightPassEjb.Entity.PFGestor;

@Remote
public interface PFGestorDAO  extends GenericDAO<PFGestor, Integer> { 

}
