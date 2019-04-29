package br.marcos.relatconsignados.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import br.marcos.relatconsignados.control.ControlDiff;
import br.marcos.relatconsignados.control.TipoConsignados;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuSistema extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private SelArqPanel selArq;
	private boolean estaCarregado = false;
	
	public MenuSistema(ControlDiff cD, Color corFundoBotoes, Color corFonteBotoes, PainelSelecaoArquivo selArq, AbaSaida saida) {
		super();
		//this.setSelArq(selArq);
		this.setForeground(corFonteBotoes);
    	this.setBounds(0, 0, 319, 398);
    	this.setBackground(SystemColor.WHITE);
    	this.setLayout(null);
    	
    	JSeparator separator = new JSeparator();
    	separator.setForeground(Color.BLUE);
    	separator.setBounds(10, 214, 294, 1);
    	this.add(separator);
    	
    	JButton btnNewButton = new JButton("CARREGAR");
    	btnNewButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			setEstaCarregado(selArq.carregarArquivos());
    			if(getEstaCarregado()) {
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
    	
    	JButton btnMostrarAtual = new JButton("M\u00CAS ATUAL");
    	btnMostrarAtual.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			if (getEstaCarregado()) {
					//saida.renderizar(AbaSistema.AbaSaida.ATUAIS);
    				saida.setConsignadoExibido(TipoConsignados.REFERENCIA);
				} else {
					JOptionPane.showMessageDialog(null, "Os arquivos não foram carregados corretamente!", "Alerta", JOptionPane.WARNING_MESSAGE);
				}
    		}
    	});
    	btnMostrarAtual.setForeground(corFonteBotoes);
    	btnMostrarAtual.setBackground(corFundoBotoes);
    	btnMostrarAtual.setToolTipText("Clique para exibir consignados do m\u00EAs atual.");
    	btnMostrarAtual.setFont(new Font("Tahoma", Font.BOLD, 10));
    	btnMostrarAtual.setBounds(66, 226, 182, 23);
    	this.add(btnMostrarAtual);
    	
    	JButton btnMostrarMsAnterior = new JButton("M\u00CAS ANTERIOR");
    	btnMostrarMsAnterior.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			if (getEstaCarregado()) {
					//saida.renderizar(AbaSistema.AbaSaida.ANTERIORES);
    				saida.setConsignadoExibido(TipoConsignados.AMOSTRA);
				} else {
					JOptionPane.showMessageDialog(null, "Os arquivos não foram carregados corretamente!", "Alerta", JOptionPane.WARNING_MESSAGE);
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
    			if (getEstaCarregado()) {
					//saida.renderizar(AbaSistema.AbaSaida.NOVOS);
    				saida.setConsignadoExibido(TipoConsignados.NOVOS);
				} else {
					JOptionPane.showMessageDialog(null, "Os arquivos não foram carregados corretamente!", "Alerta", JOptionPane.WARNING_MESSAGE);
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
    			if (getEstaCarregado()) {
					//saida.renderizar(AbaSistema.AbaSaida.EXCLUIDOS);
    				saida.setConsignadoExibido(TipoConsignados.EXCLUIDOS);
				} else {
					JOptionPane.showMessageDialog(null, "Os arquivos não foram carregados corretamente!", "Alerta", JOptionPane.WARNING_MESSAGE);
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
    			if (getEstaCarregado()) {
					//saida.renderizar(AbaSistema.AbaSaida.INALTERADOS);
    				saida.setConsignadoExibido(TipoConsignados.INALTERADOS);
				} else {
					JOptionPane.showMessageDialog(null, "Os arquivos não foram carregados corretamente!", "Alerta", JOptionPane.WARNING_MESSAGE);
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
	
	public boolean getEstaCarregado() {
		return this.estaCarregado;
	}
	
	public void setEstaCarregado(boolean estaCarregado) {
		this.estaCarregado = estaCarregado;
	}
}
