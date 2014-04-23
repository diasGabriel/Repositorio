package com.ejc.modelo.web.resources;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

@Component
public class CreateManager implements ComponentFactory<EntityManager> {
	
	private final EntityManagerFactory managerFactory;
	private EntityManager manager;
	
	public CreateManager(EntityManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}
	
	@PostConstruct
	public void abre(){
		this.manager = managerFactory.createEntityManager();
	}
	
	@Override
	public EntityManager getInstance() {
		return manager;
	}
	
	@PreDestroy
	public void fechar(){
		this.manager.close();
	}
	
}
