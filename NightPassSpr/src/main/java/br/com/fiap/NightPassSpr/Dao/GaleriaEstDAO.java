package br.com.fiap.NightPassSpr.Dao;

import java.util.List;

import br.com.fiap.NightPassSpr.Entity.Estabelecimento;
import br.com.fiap.NightPassSpr.Entity.GaleriaEst;
import br.com.fiap.NightPassSpr.Entity.TipoGaleria;

public interface GaleriaEstDAO extends GenericDAO<GaleriaEst, Long> {
	
	public List<GaleriaEst> listarPorTipo(Estabelecimento defEstabelecimento,
			TipoGaleria tipoGaleria);
	
}


