package br.marcos.relatconsignados.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JButton;

import br.marcos.relatconsignados.control.ControlDiff;
import javax.swing.ImageIcon;

public class TelaPrincipal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TelaPrincipal() {
		super();
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/br/marcos/relatconsignados/images/dif48x48.png")));
		
		ControlDiff cD = new ControlDiff();
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setSize(1136, 450);
    	this.setTitle("Consig Diff");
    	this.getContentPane().setLayout(new CardLayout(0, 0));
    	
    	JTabbedPane abas = new JTabbedPane(JTabbedPane.TOP);
    	abas.setBackground(Color.WHITE);
    	this.getContentPane().add(abas, "name_15804303378159");
    	
    	SelArqPanelBB arqBB = new SelArqPanelBB(cD);
    	SelArqPanelBra arqBra = new SelArqPanelBra(cD);
    	
    	AbaSistema abaBB = new AbaSistema(cD);
    	AbaSistema abaBra = new AbaSistema(cD);
    	
    	MenuSistema menuBB = new MenuSistema(cD, new Color(100, 149, 237), SystemColor.WHITE, arqBB, abaBB);
    	MenuSistema menuBra = new MenuSistema(cD, SystemColor.RED, SystemColor.WHITE, arqBra, abaBra);
    	
    	menuBra.setBackground(SystemColor.WHITE);  	
    	
    	abaBB.add(menuBB);
    	abaBra.add(menuBra);
    	abas.addTab("Banco do Brasil", new ImageIcon(TelaPrincipal.class.getResource("/br/marcos/relatconsignados/images/bb16x16.png")), abaBB, null);
    	
    	JButton bSalvar = new JButton("Salvar");
    	bSalvar.setToolTipText("Salva documento em formato pdf");
    	bSalvar.setBackground(new Color(100, 149, 237));
    	bSalvar.setForeground(Color.WHITE);
    	bSalvar.setBounds(690, 0, 89, 23);
    	abaBB.add(bSalvar);
    	abas.addTab("Bradesco", new ImageIcon(TelaPrincipal.class.getResource("/br/marcos/relatconsignados/images/bra16x16.png")), abaBra, null);
	}
	
	public void renderizar() {
		this.setVisible(true);
	}
}
