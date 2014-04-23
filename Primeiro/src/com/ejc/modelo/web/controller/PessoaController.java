package com.ejc.modelo.web.controller;

import java.util.ArrayList;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;

import com.ejc.modelo.pojo.Pessoa;
import com.ejc.modelo.web.resources.HibernateUtilJPA;


@Resource
public class PessoaController {
	
	//Dependencias
	private final HibernateUtilJPA hibernate;
	private final Result result;
	private final Validator validador;
	
	public PessoaController(HibernateUtilJPA hibernate, Result result, Validator validador) {
		this.hibernate = hibernate;
		this.result = result;
		this.validador = validador;
	}
	
	public void save(Pessoa pessoa){
		if (pessoa.getNome() == null ||
			pessoa.getNome().length() < 3) {
				validador.add(new ValidationMessage(
						"Nome é obrigatório e precisa ter mais de 3 letras",
						"pessoa.nome"));
		}
		
		if(pessoa.getIdPessoa() == 0){
			validador.onErrorUsePageOf(PessoaController.class).formulario();
			hibernate.inserir(pessoa);
		}
		else{
			validador.onErrorUsePageOf(PessoaController.class).get(pessoa.getIdPessoa());
			hibernate.atualizar(pessoa);
		}
		result.redirectTo(this).list();
	}
	
	public void remove(int idPessoa){
		Pessoa pessoa = get(idPessoa);
		hibernate.excluir(pessoa);
		result.redirectTo(this).list();
	}
	
	public ArrayList<Pessoa> list(){
		return (ArrayList)hibernate.selecionar(Pessoa.class, "nome");
	}
	
	public Pessoa get(Integer idPessoa){
		return (Pessoa) hibernate.selecionar(Pessoa.class, idPessoa);
	}
	
	public void formulario() {
	}
}

