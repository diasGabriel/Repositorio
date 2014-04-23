package com.ejc.modelo.pojo;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Pessoa implements Serializable{
	
	@Id @GeneratedValue
	private int idPessoa;
	private String nome;
	
	
	public Pessoa() {
	}
	
	public int getIdPessoa() {
		return idPessoa;
	}
	
	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return getNome();
	}
}
