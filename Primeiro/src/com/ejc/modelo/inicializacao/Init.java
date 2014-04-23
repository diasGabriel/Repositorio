package com.ejc.modelo.inicializacao;

import com.ejc.modelo.desktop.resources.HibernateUtilHibernate;
import com.ejc.modelo.desktop.resources.HibernateUtilJPA;
import com.ejc.modelo.desktop.telas.TelaPrincipal;

public class Init {
	public static void main(String[] args){
//		HibernateUtil.iniciarSessao();
		HibernateUtilJPA.iniciarManager();
		new TelaPrincipal();
	}
}
