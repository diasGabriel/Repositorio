package com.ejc.modelo.web.resources;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class HibernateUtilJPA {
	private EntityManager manager;
    
    public HibernateUtilJPA(EntityManager manager) {
		this.manager = manager;
	}
    
    public List<Object> selecionar(Class objClass){
    	return selecionar(objClass, (String)null);
    }
    
    public List<Object> selecionar(Class objClass, String campoOrder){
        List<Object> lista = null;
        Query query = null;
        try {
            manager.getTransaction().begin();
            query = manager.createQuery("From "+objClass.getName()+(campoOrder != null ? " ORDER BY " + campoOrder : ""));
            lista = query.getResultList();
            manager.getTransaction().commit();
            return lista;
        } 
        catch (Exception e) {
            e.printStackTrace();
            return null;
        } 
        
    }
    
    public Object selecionar(Class objClass, Integer id){
        Object objGet = null;
        try {
        	manager.getTransaction().begin();
        	objGet = manager.find(objClass, id);
        	manager.getTransaction().commit();
            return objGet;
        } 
        catch (Exception e) {
            e.printStackTrace();
            return null;
        } 

    }
    
    public void inserir(Object obj){
        try{
            manager.getTransaction().begin();
            manager.persist(obj);
            manager.getTransaction().commit();
        } 
        catch (Exception e) {
            manager.getTransaction().rollback();
            e.printStackTrace();
        } 

    }
    
    public void atualizar(Object obj){
        try{
        	manager.getTransaction().begin();
            manager.merge(obj);
            manager.getTransaction().commit();
        } 
        catch (Exception e) {
        	manager.getTransaction().rollback();
            e.printStackTrace();
        } 
        
    }
    
    public void excluir(Object obj){
        try{
        	manager.getTransaction().begin();
            manager.remove(obj);
            manager.getTransaction().commit();
        } 
        catch (Exception e) {
        	manager.getTransaction().rollback();
            e.printStackTrace();
        } 
       
    }
}
