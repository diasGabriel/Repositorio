package com.ejc.modelo.desktop.telas.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.ejc.modelo.desktop.telas.TelaPrincipal;
import com.ejc.modelo.pojo.Pessoa;

public class MouseListenerLista implements MouseListener{

	private TelaPrincipal tela;
	
	public MouseListenerLista(TelaPrincipal tela) {
		this.tela = tela;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount()==2){
			Pessoa pessoa = tela.lista.getSelectedValue();
			tela.campoNome.setText(pessoa.toString());
			tela.campoNome.setEditable(false);
			tela.pessoaSelecionada = pessoa;
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
