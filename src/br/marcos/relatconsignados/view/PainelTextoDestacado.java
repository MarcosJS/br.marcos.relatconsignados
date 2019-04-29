package br.marcos.relatconsignados.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

public class PainelTextoDestacado extends JTextPane {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private Color corFaixas;
	private Color corSelecao;

	public PainelTextoDestacado(StyledDocument d, Color corFaixas, Color corSelecao) {
		super(d);
		setOpaque(false);
		this.setCorFaixas(corFaixas);
		this.setCorSelecao(corSelecao);
	}
	@SuppressWarnings("deprecation")
	@Override
	protected void paintComponent(Graphics g) {
	    g.setColor(getBackground());
	    g.fillRect(0, 0, getWidth(), getHeight());
	    
	    System.out.println("tamaho da area de texto: "+this.getHeight());
	    
	    int linhasInternas = (this.getHeight() - 32) / 15;
	    
	    System.out.println("posiveis numero de linhas internas"+linhasInternas);
	    
	    int inicio = 19;
	    
	    for(int i = 0; i< linhasInternas; i++) {
	    	Rectangle rect;
			try {
				rect = modelToView(17);
				g.setColor(this.corFaixas);
		        g.fillRect(0, inicio, getWidth(), rect.height);
		        inicio += 30;
		    } catch (BadLocationException e) {
				e.printStackTrace();
			}
	    }

	    
	    try {
	      Rectangle rect = modelToView(getCaretPosition());
	      System.out.println("posicao do cursor: "+rect.getY());
	      if (rect != null) {
	        g.setColor(this.corSelecao);
	        g.fillRect(0, rect.y, getWidth(), rect.height);
	        System.out.println("altura do retangulo: "+rect.height);
	      }
	    } catch (BadLocationException e) {
	      System.out.println(e);	
	    }
	    	    
	    super.paintComponent(g);
	  }

	@Override
	public void repaint(long tm, int x, int y, int width, int height) {
	    super.repaint(tm, 0, 0, getWidth(), getHeight());
	}
	
	public void setCorFaixas(Color corFaixas) {
		this.corFaixas = corFaixas;
	}
	public void setCorSelecao(Color corSelecao) {
		this.corSelecao = corSelecao;
	}
	
}
