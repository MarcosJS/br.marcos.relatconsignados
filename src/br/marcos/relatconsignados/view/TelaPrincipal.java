package br.marcos.relatconsignados.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import br.marcos.relatconsignados.control.ControlDiff;
import javax.swing.JButton;

public class TelaPrincipal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TelaPrincipal() {
		super();
		
		ControlDiff cD = new ControlDiff();
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setSize(1136, 450);
    	this.setTitle("ConsigDiff");
    	this.getContentPane().setLayout(new CardLayout(0, 0));
    	
    	JTabbedPane abas = new JTabbedPane(JTabbedPane.TOP);
    	abas.setBackground(Color.WHITE);
    	this.getContentPane().add(abas, "name_15804303378159");
    	
    	SelArqPanelBB arqBB = new SelArqPanelBB(cD);
    	SelArqPanelBra arqBra = new SelArqPanelBra(cD);
    	/*novo painel de sel*/SelArqPanelFolBB arqFolBB = new SelArqPanelFolBB(cD);
    	
    	AbaSistema abaBB = new AbaSistema(cD, ControlDiff.BANCO_BRASIL, new Color(230, 230, 255), new Color(150,255, 150));
    	AbaSistema abaBra = new AbaSistema(cD, ControlDiff.BRADESCO, new Color(255, 230, 230), new Color(150, 150, 255));
    	/*nova aba*/AbaSistema abaFolBB = new AbaSistema(cD, ControlDiff.BRADESCO, new Color(255, 230, 230), new Color(150, 150, 255));
    	
    	MenuSistema menuBB = new MenuSistema(cD, new Color(100, 149, 237), SystemColor.WHITE, arqBB, abaBB);
    	MenuSistema menuBra = new MenuSistema(cD, SystemColor.RED, SystemColor.WHITE, arqBra, abaBra);
    	/*novo menu*/MenuSistema menuFolBB = new MenuSistema(cD, new Color(255, 255, 255), new Color(0, 0, 0), arqFolBB, abaFolBB);
    	
    	menuBB.setBackground(new Color(255, 255, 102));
    	/*cor de fundo do menu*/menuFolBB.setBackground(new Color(82, 127, 118));
    	
    	abaBB.add(menuBB);
    	abaBra.add(menuBra);
    	/*add menuFolBB*/abaFolBB.add(menuFolBB);
    	
    	abas.addTab("Banco do Brasil", null, abaBB, null);
    	abas.addTab("Bradesco", null, abaBra, null);
    	/*add abaFolBB*/abas.addTab("Folha/Banco do Brasil", null, abaFolBB, null);
    	
    	JButton bSalvar = new JButton("Salvar");
    	bSalvar.setToolTipText("Salva documento em formato pdf");
    	bSalvar.setBackground(new Color(100, 149, 237));
    	bSalvar.setForeground(Color.WHITE);
    	bSalvar.setBounds(690, 0, 89, 23);
    	abaBB.add(bSalvar);
    	
	}
	
	public void renderizar() {
		this.setVisible(true);
	}
}
