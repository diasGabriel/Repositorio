package com.ejc.modelo.web.resources;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

@Component
@ApplicationScoped
public class CreateManagerFactory implements ComponentFactory<EntityManagerFactory> {
	
	private EntityManagerFactory managerFactory;
	
	public CreateManagerFactory() {
		
	}
	
	@PostConstruct
	public void abre(){
		this.managerFactory = Persistence.createEntityManagerFactory("bdTeste_pu");
	}
	
	@Override
	public EntityManagerFactory getInstance() {
		return managerFactory;
	}
	
	@PreDestroy
	public void fecha(){
		this.managerFactory.close();
	}
	
}
