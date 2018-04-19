package br.marcos.relatconsignados.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.text.BadLocationException;

import br.marcos.relatconsignados.control.ControlDiff;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuSistema extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SelArqPanel selArq;
	
	public MenuSistema(ControlDiff cD, Color corFundoBotoes, Color corFonteBotoes, SelArqPanel selArq, AbaSistema saida) {
		super();
		this.setSelArq(selArq);
		this.setForeground(corFonteBotoes);
    	this.setBounds(0, 0, 319, 398);
    	this.setBackground(new Color(255, 255, 102));
    	this.setLayout(null);
    	
    	JSeparator separator = new JSeparator();
    	separator.setForeground(Color.BLUE);
    	separator.setBounds(10, 214, 294, 1);
    	this.add(separator);
    	
    	JButton btnNewButton = new JButton("CARREGAR");
    	btnNewButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			if(selArq.carregarArquivos()) {
    				JOptionPane.showMessageDialog(null, "Os arquivos foram carregados!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
    			}
    		}
    	});
    	btnNewButton.setForeground(corFonteBotoes);
    	btnNewButton.setBackground(corFundoBotoes);
    	btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
    	btnNewButton.setToolTipText("Clique \"CARREGAR\" para carregar os consignados selecionados.");
    	btnNewButton.setBounds(10, 176, 91, 23);
    	this.add(btnNewButton);
    	
    	JButton btnMostrarAtual = new JButton("MOSTRAR ATUAL");
    	btnMostrarAtual.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			try {
					saida.renderizar(Relatorios.obterRelatorioRenderizado(cD.obterListaConsignacoes(ControlDiff.BANCO_BRASIL, ControlDiff.CONSIG_ATUAL), "CONSINADOS ATUAIS"));
				} catch (BadLocationException e1) {
					JOptionPane.showMessageDialog(null, "Erro na renderização do relatório!", "Erro", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
    		}
    	});
    	btnMostrarAtual.setForeground(corFonteBotoes);
    	btnMostrarAtual.setBackground(corFundoBotoes);
    	btnMostrarAtual.setToolTipText("Clique para exibir consignados do m\u00EAs atual.");
    	btnMostrarAtual.setFont(new Font("Tahoma", Font.BOLD, 10));
    	btnMostrarAtual.setBounds(66, 226, 182, 23);
    	this.add(btnMostrarAtual);
    	
    	JButton btnMostrarMsAnterior = new JButton("MOSTRAR M\u00CAS ANTERIOR");
    	btnMostrarMsAnterior.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			try {
					saida.renderizar(Relatorios.obterRelatorioRenderizado(cD.obterListaConsignacoes(ControlDiff.BANCO_BRASIL, ControlDiff.CONSIG_ANTERIOR), "CONSIGNADOS ANTERIORES"));
				} catch (BadLocationException e1) {
					JOptionPane.showMessageDialog(null, "Erro na renderização do relatório!", "Erro", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
    		}
    	});
    	btnMostrarMsAnterior.setForeground(corFonteBotoes);
    	btnMostrarMsAnterior.setBackground(corFundoBotoes);
    	btnMostrarMsAnterior.setToolTipText("Clique para exibir consignados do m\u00EAs anterior.");
    	btnMostrarMsAnterior.setFont(new Font("Tahoma", Font.BOLD, 10));
    	btnMostrarMsAnterior.setBounds(66, 260, 182, 23);
    	this.add(btnMostrarMsAnterior);
    	
    	JButton btnNovos = new JButton("NOVOS");
    	btnNovos.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			try {
					saida.renderizar(Relatorios.obterRelatorioRenderizado(cD.obterListaNovos(ControlDiff.BANCO_BRASIL), "NOVOS CONSIGNADOS"));
				} catch (BadLocationException e1) {
					JOptionPane.showMessageDialog(null, "Erro na renderização do relatório!", "Erro", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
    		}
    	});
    	btnNovos.setForeground(corFonteBotoes);
    	btnNovos.setBackground(corFundoBotoes);
    	btnNovos.setToolTipText("Clique para exibir os novos consignados.");
    	btnNovos.setFont(new Font("Tahoma", Font.BOLD, 10));
    	btnNovos.setBounds(66, 294, 182, 23);
    	this.add(btnNovos);
    	
    	JButton btnExcludos = new JButton("EXCLU\u00CDDOS");
    	btnExcludos.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			try {
					saida.renderizar(Relatorios.obterRelatorioRenderizado(cD.obterListaExcluidos(ControlDiff.BANCO_BRASIL), "CONSIGNADOS EXCLUÍDOS"));
				} catch (BadLocationException e1) {
					JOptionPane.showMessageDialog(null, "Erro na renderização do relatório!", "Erro", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
    		}
    	});
    	btnExcludos.setForeground(corFonteBotoes);
    	btnExcludos.setBackground(corFundoBotoes);
    	btnExcludos.setToolTipText("Clique para exibir os consignados exclu\u00EDdos.");
    	btnExcludos.setFont(new Font("Tahoma", Font.BOLD, 10));
    	btnExcludos.setBounds(66, 328, 182, 23);
    	this.add(btnExcludos);
    	
    	JButton btnInalterado = new JButton("INALTERADOS");
    	btnInalterado.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			try {
					saida.renderizar(Relatorios.obterRelatorioRenderizado(cD.obterListaInalterados(ControlDiff.BANCO_BRASIL), "CONSIGNADOS INALTERADOS"));
				} catch (BadLocationException e1) {
					JOptionPane.showMessageDialog(null, "Erro na renderização do relatório!", "Erro", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
    		}
    	});
    	btnInalterado.setForeground(corFonteBotoes);
    	btnInalterado.setBackground(corFundoBotoes);
    	btnInalterado.setToolTipText("Clique para exibir consignados inalterados.");
    	btnInalterado.setFont(new Font("Tahoma", Font.BOLD, 10));
    	btnInalterado.setBounds(66, 362, 182, 23);
    	this.add(btnInalterado);
    	this.add(selArq);
	}
	
	public void setSelArq(SelArqPanel selArq) {
		this.selArq = selArq;
	}
	
}
