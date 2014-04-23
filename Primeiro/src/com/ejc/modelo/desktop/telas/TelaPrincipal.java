package com.ejc.modelo.desktop.telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.ejc.modelo.desktop.controller.PessoaControllerJPA;
import com.ejc.modelo.desktop.resources.HibernateUtilHibernate;
import com.ejc.modelo.desktop.telas.listeners.ActionListenerGeral;
import com.ejc.modelo.desktop.telas.listeners.MouseListenerLista;
import com.ejc.modelo.pojo.Pessoa;

public class TelaPrincipal extends JFrame{
	
	//Componentes
	public JPanel painel 		= new JPanel();
	public JTextField campoNome = new JTextField();
	public JButton botaoNovo    = new JButton();
	public JButton botaoSalvar  = new JButton();
	public JButton botaoEditar  = new JButton();
	public JButton botaoDeletar = new JButton();
	public JList<Pessoa> lista  = new JList<Pessoa>();
			
	//Atributos
	public Pessoa pessoaSelecionada = new Pessoa();
	
	public TelaPrincipal() {
		//Definicoes da janela
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		
		
		//Definição dos componentes
		//painel
		painel.setSize(this.getWidth(), this.getHeight());
		painel.setLayout(null);
		this.add(painel);
		
		//campoNome
		campoNome.setBounds(10, 10, 160, 30);
		painel.add(campoNome);
		
		//botaoNovo
		botaoNovo.setBounds(180, 10, 100, 30);
		botaoNovo.setText("Novo");
		botaoNovo.addActionListener(new ActionListenerGeral(this, ActionListenerGeral.TP_NOVO));
		painel.add(botaoNovo);
		
		//botaoSalvar
		botaoSalvar.setBounds(290, 10, 100, 30);
		botaoSalvar.setText("Salvar");
		botaoSalvar.addActionListener(new ActionListenerGeral(this, ActionListenerGeral.TP_SALVAR));
		painel.add(botaoSalvar);
		
		//botaoEditar
		botaoEditar.setBounds(180, 50, 100, 30);
		botaoEditar.setText("Editar");
		botaoEditar.addActionListener(new ActionListenerGeral(this, ActionListenerGeral.TP_EDITAR));
		painel.add(botaoEditar);
		
		//botaoDeletar
		botaoDeletar.setBounds(290, 50, 100, 30);
		botaoDeletar.setText("Deletar");
		botaoDeletar.addActionListener(new ActionListenerGeral(this, ActionListenerGeral.TP_DELETAR));
		painel.add(botaoDeletar);
		
		//lista
		lista.setBounds(10, 85, 375, 180);
		lista.addMouseListener(new MouseListenerLista(this));
		painel.add(lista);
		gerarLista();
				
		
		this.setVisible(true);
	}
	
	public void gerarLista(){
//		ArrayList<Pessoa> listaPessoa = PessoaController.list();
//		DefaultListModel modeloLista = new DefaultListModel();
//		modeloLista.removeAllElements();
//		for(int i = 0; i < listaPessoa.size(); i++){
//			modeloLista.addElement(listaPessoa.get(i));
//		}
//		
//		lista.setModel(modeloLista);
	}

}
