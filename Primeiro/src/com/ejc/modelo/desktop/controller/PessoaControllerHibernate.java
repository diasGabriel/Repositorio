package com.ejc.modelo.desktop.controller;

import java.util.ArrayList;

import com.ejc.modelo.desktop.resources.HibernateUtilHibernate;
import com.ejc.modelo.pojo.Pessoa;

public class PessoaControllerHibernate {
	
	public static int save(Pessoa pessoa){
		int retorno = 0;
		if(pessoa.getIdPessoa() == 0)
			retorno = HibernateUtilHibernate.inserir(pessoa);
		else
			retorno = HibernateUtilHibernate.atualizar(pessoa);
		return retorno;
	}
	
	public static int remove(Pessoa pessoa){
		int retorno = HibernateUtilHibernate.excluir(pessoa);
		return retorno;
	}
	
	public static ArrayList<Pessoa> list(){
		return (ArrayList)HibernateUtilHibernate.selecionar(Pessoa.class);
	}
	
	public static Pessoa get(int id){
		return (Pessoa) HibernateUtilHibernate.selecionar(Pessoa.class, id);
	}
}
