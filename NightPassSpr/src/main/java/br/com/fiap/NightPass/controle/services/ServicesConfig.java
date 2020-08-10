package br.com.fiap.NightPass.controle.services;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

public class ServicesConfig extends ResourceConfig {

	public ServicesConfig() {
		packages("br.com.fiap.NightPass.controle.services");
		register(RolesAllowedDynamicFeature.class);
	}

}
