package br.marcos.relatconsignados.view;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.StyledDocument;

public class AbaSistema extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	
	public AbaSistema() {
		super();
			
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		
		JPanel saida = new JPanel();
		saida.setBounds(318, 0, 800, 398);
		saida.setBackground(Color.WHITE);
		this.add(saida);
		saida.setLayout(null);
		
		this.scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(0, 0, 800, 398);
		saida.add(scrollPane);
}
	
	public void renderizar(StyledDocument documento) {
		JTextPane textPane = new JTextPane(documento);
		textPane.setEditable(false);
    	scrollPane.setViewportView(textPane);
	
	}
}
