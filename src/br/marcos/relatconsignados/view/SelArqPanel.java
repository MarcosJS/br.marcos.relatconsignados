package br.marcos.relatconsignados.view;

import javax.swing.JPanel;

public abstract class SelArqPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	abstract public boolean estaPronto();
	abstract public boolean carregarArquivos();
}
