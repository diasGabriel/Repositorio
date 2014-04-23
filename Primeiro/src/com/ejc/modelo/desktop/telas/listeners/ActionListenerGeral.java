package com.ejc.modelo.desktop.telas.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ejc.modelo.desktop.controller.PessoaControllerJPA;
import com.ejc.modelo.desktop.resources.HibernateUtilHibernate;
import com.ejc.modelo.desktop.telas.TelaPrincipal;
import com.ejc.modelo.pojo.Pessoa;

public class ActionListenerGeral implements ActionListener {

	public static final int TP_NOVO    = 0;
	public static final int TP_SALVAR  = 1;
	public static final int TP_EDITAR  = 2;
	public static final int TP_DELETAR = 3;
	
	private TelaPrincipal tela;
	private int tpBotao;
	
	
	public ActionListenerGeral(TelaPrincipal tela, int tpBotao) {
		this.tela = tela;
		this.tpBotao = tpBotao;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Pessoa pessoa = tela.pessoaSelecionada;
		pessoa.setNome(tela.campoNome.getText());
		switch(tpBotao){
			case TP_NOVO:
				tela.campoNome.setText("");
				tela.campoNome.setEditable(true);
				tela.pessoaSelecionada = new Pessoa();
				break;
			case TP_SALVAR:
				PessoaControllerJPA.save(pessoa);
				tela.campoNome.setEditable(false);
				tela.gerarLista();
				break;
			case TP_EDITAR:
				tela.campoNome.setEditable(true);
				break;
			case TP_DELETAR:
				PessoaControllerJPA.remove(pessoa);
				tela.campoNome.setEditable(true);
				tela.campoNome.setText("");
				tela.gerarLista();
				break;
		}
	}

}
