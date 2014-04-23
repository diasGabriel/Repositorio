package com.ejc.modelo.desktop.controller;

import java.util.ArrayList;

import com.ejc.modelo.desktop.resources.HibernateUtilHibernate;
import com.ejc.modelo.desktop.resources.HibernateUtilJPA;
import com.ejc.modelo.pojo.Pessoa;

public class PessoaControllerJPA {
	
	public static int save(Pessoa pessoa){
		if(pessoa.getIdPessoa() == 0)
			HibernateUtilJPA.inserir(pessoa);
		else
			HibernateUtilJPA.atualizar(pessoa);
		return 1;
	}
	
	public static int remove(Pessoa pessoa){
		int retorno = HibernateUtilJPA.excluir(pessoa);
		return retorno;
	}
	
	public static ArrayList<Pessoa> list(){
		return (ArrayList)HibernateUtilJPA.selecionar(Pessoa.class);
	}
	
	public static Pessoa get(int id){
		return (Pessoa) HibernateUtilJPA.selecionar(Pessoa.class, id);
	}
}

