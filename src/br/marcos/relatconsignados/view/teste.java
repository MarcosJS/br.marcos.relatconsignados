package br.marcos.relatconsignados.view;

import java.awt.Color;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JTabbedPane;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class teste {
	private static JTextField textField_4;
	private static JTextField textField_5;
	private static JTextField textField_6;
	private static JTextField textField_7;
	private static JTextField textField_8;
	private static JTextField textField_9;
    public static void main(String[] args) throws IOException {
    	JFrame principal = new JFrame();
    	principal.getContentPane().setBackground(Color.DARK_GRAY);
    	principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	principal.setSize(800, 450);
    	principal.setTitle("Consig Diff");
    	principal.getContentPane().setLayout(new CardLayout(0, 0));
    	
    	JTabbedPane abas = new JTabbedPane(JTabbedPane.TOP);
    	abas.setBackground(Color.WHITE);
    	principal.getContentPane().add(abas, "name_15804303378159");
    	
    	JPanel panelBB = new JPanel();
    	panelBB.setBackground(Color.WHITE);
    	//tabelaDeSelecao.addTab("Banco do Brasil", null, panelBB, null);
    	panelBB.setLayout(null);
    	
    	JPanel menu = new JPanel();
    	menu.setForeground(Color.WHITE);
    	menu.setBounds(0, 0, 319, 398);
    	panelBB.add(menu);
    	menu.setBackground(new Color(255, 255, 102));
    	menu.setLayout(null);
    	
    	JPanel selArqPanel = new JPanel();
    	selArqPanel.setOpaque(false);
    	selArqPanel.setBounds(10, 11, 294, 154);
    	menu.add(selArqPanel);
    	selArqPanel.setBackground(Color.ORANGE);
    	selArqPanel.setLayout(null);
    	
    	JLabel label = new JLabel("Consignado do M\u00EAs Atual:");
    	label.setBounds(0, 0, 125, 14);
    	selArqPanel.add(label);
    	
    	JButton button = new JButton("Browser");
    	button.setForeground(Color.WHITE);
    	button.setFont(new Font("Tahoma", Font.PLAIN, 10));
    	button.setBackground(SystemColor.desktop);
    	button.setBounds(216, 16, 78, 23);
    	selArqPanel.add(button);
    	
    	textField_4 = new JTextField();
    	textField_4.setColumns(10);
    	textField_4.setBounds(64, 19, 154, 20);
    	selArqPanel.add(textField_4);
    	
    	JButton button_1 = new JButton("Browser");
    	button_1.setForeground(Color.WHITE);
    	button_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
    	button_1.setBackground(SystemColor.desktop);
    	button_1.setBounds(216, 100, 78, 23);
    	selArqPanel.add(button_1);
    	
    	textField_5 = new JTextField();
    	textField_5.setColumns(10);
    	textField_5.setBounds(64, 103, 154, 20);
    	selArqPanel.add(textField_5);
    	
    	JLabel label_2 = new JLabel("Consignado do M\u00EAs Anterior:");
    	label_2.setBounds(0, 81, 166, 14);
    	selArqPanel.add(label_2);
    	
    	JLabel label_1 = new JLabel("1\u00BA Arquivo");
    	label_1.setBounds(0, 25, 59, 14);
    	selArqPanel.add(label_1);
    	
    	JLabel label_7 = new JLabel("2\u00BA Arquivo");
    	label_7.setBounds(0, 58, 59, 14);
    	selArqPanel.add(label_7);
    	
    	textField_8 = new JTextField();
    	textField_8.setColumns(10);
    	textField_8.setBounds(64, 52, 154, 20);
    	selArqPanel.add(textField_8);
    	
    	JButton button_6 = new JButton("Browser");
    	button_6.setForeground(Color.WHITE);
    	button_6.setFont(new Font("Tahoma", Font.PLAIN, 10));
    	button_6.setBackground(SystemColor.desktop);
    	button_6.setBounds(216, 49, 78, 23);
    	selArqPanel.add(button_6);
    	
    	JLabel label_8 = new JLabel("1\u00BA Arquivo");
    	label_8.setBounds(0, 109, 59, 14);
    	selArqPanel.add(label_8);
    	
    	JLabel label_9 = new JLabel("2\u00BA Arquivo");
    	label_9.setBounds(0, 140, 59, 14);
    	selArqPanel.add(label_9);
    	
    	JButton button_7 = new JButton("Browser");
    	button_7.setForeground(Color.WHITE);
    	button_7.setFont(new Font("Tahoma", Font.PLAIN, 10));
    	button_7.setBackground(SystemColor.desktop);
    	button_7.setBounds(216, 131, 78, 23);
    	selArqPanel.add(button_7);
    	
    	textField_9 = new JTextField();
    	textField_9.setColumns(10);
    	textField_9.setBounds(64, 134, 154, 20);
    	selArqPanel.add(textField_9);
    	
    	JSeparator separator = new JSeparator();
    	separator.setForeground(Color.BLUE);
    	separator.setBounds(10, 214, 294, 1);
    	menu.add(separator);
    	
    	JButton btnNewButton = new JButton("CARREGAR");
    	btnNewButton.setForeground(Color.WHITE);
    	btnNewButton.setBackground(SystemColor.desktop);
    	btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
    	btnNewButton.setToolTipText("Clique \"CARREGAR\" para carregar os consignados selecionados.");
    	btnNewButton.setBounds(10, 176, 91, 23);
    	menu.add(btnNewButton);
    	
    	JButton btnMostrarAtual = new JButton("MOSTRAR ATUAL");
    	btnMostrarAtual.setForeground(Color.WHITE);
    	btnMostrarAtual.setBackground(SystemColor.desktop);
    	btnMostrarAtual.setToolTipText("Clique para exibir consignados do m\u00EAs atual.");
    	btnMostrarAtual.setFont(new Font("Tahoma", Font.BOLD, 10));
    	btnMostrarAtual.setBounds(66, 226, 182, 23);
    	menu.add(btnMostrarAtual);
    	
    	JButton btnMostrarMsAnterior = new JButton("MOSTRAR M\u00CAS ANTERIOR");
    	btnMostrarMsAnterior.setForeground(Color.WHITE);
    	btnMostrarMsAnterior.setBackground(SystemColor.desktop);
    	btnMostrarMsAnterior.setToolTipText("Clique para exibir consignados do m\u00EAs anterior.");
    	btnMostrarMsAnterior.setFont(new Font("Tahoma", Font.BOLD, 10));
    	btnMostrarMsAnterior.setBounds(66, 260, 182, 23);
    	menu.add(btnMostrarMsAnterior);
    	
    	JButton btnNovos = new JButton("NOVOS");
    	btnNovos.setForeground(Color.WHITE);
    	btnNovos.setBackground(SystemColor.desktop);
    	btnNovos.setToolTipText("Clique para exibir os novos consignados.");
    	btnNovos.setFont(new Font("Tahoma", Font.BOLD, 10));
    	btnNovos.setBounds(66, 294, 182, 23);
    	menu.add(btnNovos);
    	
    	JButton btnExcludos = new JButton("EXCLU\u00CDDOS");
    	btnExcludos.setForeground(Color.WHITE);
    	btnExcludos.setBackground(SystemColor.desktop);
    	btnExcludos.setToolTipText("Clique para exibir os consignados exclu\u00EDdos.");
    	btnExcludos.setFont(new Font("Tahoma", Font.BOLD, 10));
    	btnExcludos.setBounds(66, 328, 182, 23);
    	menu.add(btnExcludos);
    	
    	JButton btnInalterado = new JButton("INALTERADOS");
    	btnInalterado.setForeground(Color.WHITE);
    	btnInalterado.setBackground(SystemColor.desktop);
    	btnInalterado.setToolTipText("Clique para exibir consignados inalterados.");
    	btnInalterado.setFont(new Font("Tahoma", Font.BOLD, 10));
    	btnInalterado.setBounds(66, 362, 182, 23);
    	menu.add(btnInalterado);
    	
    	JPanel saida = new JPanel();
    	saida.setBounds(318, 0, 468, 398);
    	saida.setBackground(Color.WHITE);
    	panelBB.add(saida);
    	saida.setLayout(null);
    	
    	JScrollPane scrollPane = new JScrollPane();
    	scrollPane.setBounds(0, 0, 468, 398);
    	saida.add(scrollPane);
    	
    	JTextPane textPane = new JTextPane();
    	scrollPane.setViewportView(textPane);
    	abas.addTab("Banco do Brasil", null, panelBB, null);
    	abas.setBackgroundAt(0, new Color(255, 255, 102));
    	
    	JPanel panelBradesco = new JPanel();
    	panelBradesco.setBackground(Color.WHITE);
    	abas.addTab("Bradesco", null, panelBradesco, null);
    	abas.setBackgroundAt(1, Color.RED);
    	panelBradesco.setLayout(null);
    	
    	JPanel panel_1 = new JPanel();
    	panel_1.setOpaque(false);
    	panel_1.setLayout(null);
    	panel_1.setBackground(Color.ORANGE);
    	panel_1.setBounds(10, 11, 294, 154);
    	panelBradesco.add(panel_1);
    	
    	JLabel label_3 = new JLabel("Consignado do M\u00EAs Atual:");
    	label_3.setBounds(0, 0, 125, 14);
    	panel_1.add(label_3);
    	
    	JButton button_3 = new JButton("Browser");
    	button_3.setForeground(Color.BLACK);
    	button_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
    	button_3.setBackground(Color.RED);
    	button_3.setBounds(216, 21, 78, 23);
    	panel_1.add(button_3);
    	
    	textField_6 = new JTextField();
    	textField_6.setColumns(10);
    	textField_6.setBounds(64, 24, 154, 20);
    	panel_1.add(textField_6);
    	
    	JLabel label_4 = new JLabel("Arquivo");
    	label_4.setBounds(0, 30, 59, 14);
    	panel_1.add(label_4);
    	
    	JButton button_4 = new JButton("Browser");
    	button_4.setForeground(Color.BLACK);
    	button_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
    	button_4.setBackground(Color.WHITE);
    	button_4.setBounds(216, 100, 78, 23);
    	panel_1.add(button_4);
    	
    	textField_7 = new JTextField();
    	textField_7.setColumns(10);
    	textField_7.setBounds(64, 103, 154, 20);
    	panel_1.add(textField_7);
    	
    	JLabel label_5 = new JLabel("Arquivo");
    	label_5.setBounds(0, 109, 59, 14);
    	panel_1.add(label_5);
    	
    	JLabel label_6 = new JLabel("Consignado do M\u00EAs Anterior:");
    	label_6.setBounds(0, 81, 166, 14);
    	panel_1.add(label_6);
    	
    	JButton button_5 = new JButton("Browser");
    	button_5.setForeground(Color.WHITE);
    	button_5.setFont(new Font("Tahoma", Font.PLAIN, 10));
    	button_5.setBackground(Color.BLACK);
    	button_5.setBounds(216, 21, 78, 23);
    	panel_1.add(button_5);
    	
    	
    	principal.setVisible(true);
    }
}
