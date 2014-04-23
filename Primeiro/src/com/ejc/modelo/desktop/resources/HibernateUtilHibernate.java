package com.ejc.modelo.desktop.resources;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration; 
 
public abstract class HibernateUtilHibernate {
    private static SessionFactory fabricaSessao;
    private static Session sessao;
    private static Transaction transacao;
    private static Configuration hibernateConfig;
     
    /**
     * Inicia a SessionFactory
     */
    public static void iniciarSessao(){       
        if(hibernateConfig == null)
            try {
            	hibernateConfig = new Configuration();
                hibernateConfig.configure();
            } 
        	catch (Exception e){
                System.err.println(e.fillInStackTrace());
            }
         
        if(fabricaSessao == null)
            try {
                fabricaSessao = hibernateConfig.buildSessionFactory();
            } 
        	catch (Exception e){
                System.err.println(e.fillInStackTrace());
            }
    }
     
    /**
     * Retorna uma nova sessão
     * @return Session
     */
    private static Session getSessao(){
        return fabricaSessao.openSession();
    }
     
    /**
     * Retorna todos os registros da tabela (classe) informada
     * @param objClass
     * @return List<Object>
     */
    public static List<Object> selecionar(Class objClass){
        List<Object> lista = null;
        Query query = null;
        try {
            sessao = getSessao();
            transacao = sessao.beginTransaction();
            query = sessao.createQuery("From "+objClass.getName());
            lista = query.list();
            return lista;
        } 
        catch (HibernateException e) {
            transacao.rollback();
            System.err.println(e.fillInStackTrace());
            return null;
        } 
        finally {
            sessao.close();
        }
    }
     
    /**
     * Retorna apenas um objeto referente a classe e id informados
     * @param objClass
     * @param id
     * @return Object
     */
    public static Object selecionar(Class objClass, long id){
        Object objGet = null;
        try {
            sessao = getSessao();
            transacao = sessao.beginTransaction();
            objGet = sessao.get(objClass, id);
            return objGet;
        } 
        catch (HibernateException e) {
            transacao.rollback();
            System.err.println(e.fillInStackTrace());
            return null;
        } 
        finally {
            sessao.close();
        }
    }
     
    /**
     * Persiste o objeto passado por parâmetro
     * @param obj
     * @return int - retorna o novo id do objeto no banco se ele tiver sido inserido corretamente
     * e retorn -1 caso contrário
     */
    public static int inserir(Object obj){
        try{
            sessao = getSessao();
            transacao = sessao.beginTransaction();
            Serializable id = sessao.save(obj);
            transacao.commit();
            return (Integer) id;
        } 
        catch (HibernateException e) {
            transacao.rollback();
            System.err.println(e.fillInStackTrace());
            return -1;
        } 
        finally {
            sessao.close();
        }
    }
     
    /**
     * Atualiza o objeto passado por parâmetro
     * @param obj
     * @return int - 0 caso a atualização tenha ocorrido com sucesso, e -1 caso contrario
     */
    public static int atualizar(Object obj){
        try{
            sessao = getSessao();
            transacao = sessao.beginTransaction();
            sessao.update(obj);
            transacao.commit();
            return 0;
        } 
        catch (HibernateException e) {
            transacao.rollback();
            System.err.println(e.fillInStackTrace());
            return -1;
        } 
        finally {
            sessao.close();
        }
    }
     
    /**
     * Exclui o objeto passado por parâmetro
     * @param obj
     */
    public static int excluir(Object obj){
        try{
            sessao = getSessao();
            transacao = sessao.beginTransaction();
            sessao.delete(obj);
            transacao.commit();
            return 1;
        } 
        catch (HibernateException e) {
            transacao.rollback();
            System.err.println(e.fillInStackTrace());
            return -1;
        } 
        finally {
            sessao.close();
        }
    }
}