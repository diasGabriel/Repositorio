package com.ejc.modelo.desktop.resources;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class HibernateUtilJPA {
	private static EntityManagerFactory fabricaManager;
    private static EntityManager manager;
    
    public static void iniciarManager(){       
        if(fabricaManager == null)
            try {
            	fabricaManager = Persistence.createEntityManagerFactory("bdTeste_pu");
            } 
        	catch (Exception e){
                System.err.println(e.fillInStackTrace());
            }
    }
    
    
    private static EntityManager getManager(){
        return fabricaManager.createEntityManager();
    }
    
    public static List<Object> selecionar(Class objClass){
        List<Object> lista = null;
        Query query = null;
        try {
            manager = getManager();
            manager.getTransaction().begin();
            query = manager.createQuery("From "+objClass.getName());
            lista = query.getResultList();
            return lista;
        } 
        catch (Exception e) {
            e.printStackTrace();
            return null;
        } 
    }
    
    public static Object selecionar(Class objClass, long id){
        Object objGet = null;
        try {
        	manager = getManager();
        	manager.getTransaction().begin();
            objGet = manager.find(objClass, id);
            return objGet;
        } 
        catch (Exception e) {
            e.printStackTrace();
            return null;
        } 
    }
    
    public static void inserir(Object obj){
        try{
            manager = getManager();
            
            manager.getTransaction().begin();
            manager.persist(obj);
            manager.getTransaction().commit();
        } 
        catch (Exception e) {
            manager.getTransaction().rollback();
            e.printStackTrace();
        } 
        finally {
            manager.close();
        }
    }
    
    public static int atualizar(Object obj){
        try{
        	manager = getManager();
            
            manager.getTransaction().begin();
            manager.merge(obj);
            manager.getTransaction().commit();
            return 0;
        } 
        catch (Exception e) {
        	manager.getTransaction().rollback();
            e.printStackTrace();
            return -1;
        } 
        finally {
            manager.close();
        }
    }
    
    public static int excluir(Object obj){
        try{
            manager.remove(obj);
            manager.getTransaction().commit();
            return 1;
        } 
        catch (Exception e) {
        	manager.getTransaction().rollback();
            e.printStackTrace();
            return -1;
        } 
        finally {
            manager.close();
        }
    }
}
