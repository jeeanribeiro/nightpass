package br.com.fiap.NightPassSpr.Dao;

import java.util.List;

import br.com.fiap.NightPassSpr.Entity.GaleriaProduto;


public interface GaleriaProdutoDAO extends GenericDAO<GaleriaProduto, Long> {

	public List<GaleriaProduto> listarGaleriaProduto(long GaleriaProdCod );

}
