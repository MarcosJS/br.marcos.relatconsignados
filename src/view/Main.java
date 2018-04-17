package view;

import java.awt.Color;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.JTabbedPane;
import java.awt.SystemColor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.JDesktopPane;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.UIManager;

public class Main {
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JTextField textField_3;
    public static void main(String[] args) throws IOException {
    	JFrame principal = new JFrame();
    	principal.getContentPane().setBackground(Color.DARK_GRAY);
    	principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	principal.setSize(800, 450);
    	principal.setTitle("Consig Diff");
    	principal.getContentPane().setLayout(new CardLayout(0, 0));
    	
    	JTabbedPane tabelaDeSelecao = new JTabbedPane(JTabbedPane.TOP);
    	tabelaDeSelecao.setBackground(Color.WHITE);
    	principal.getContentPane().add(tabelaDeSelecao, "name_15804303378159");
    	
    	JPanel panelBB = new JPanel();
    	panelBB.setBackground(Color.WHITE);
    	tabelaDeSelecao.addTab("Banco do Brasil", null, panelBB, null);
    	panelBB.setLayout(null);
    	
    	JPanel menu = new JPanel();
    	menu.setForeground(Color.WHITE);
    	menu.setBounds(0, 0, 319, 398);
    	panelBB.add(menu);
    	menu.setBackground(new Color(255, 255, 102));
    	menu.setLayout(null);
    	
    	JLabel lblNewLabel = new JLabel("1\u00BA Arquivo");
    	lblNewLabel.setBounds(10, 39, 59, 14);
    	menu.add(lblNewLabel);
    	
    	JLabel lblNewLabel_1 = new JLabel("2\u00BA Arquivo");
    	lblNewLabel_1.setBounds(10, 67, 59, 14);
    	menu.add(lblNewLabel_1);
    	
    	JLabel lblNewLabel_2 = new JLabel("1\u00BA Arquivo");
    	lblNewLabel_2.setBounds(10, 120, 59, 14);
    	menu.add(lblNewLabel_2);
    	
    	JLabel lblNewLabel_3 = new JLabel("2\u00BA Arquivo");
    	lblNewLabel_3.setBounds(10, 151, 59, 14);
    	menu.add(lblNewLabel_3);
    	
    	textField = new JTextField();
    	textField.setBounds(72, 33, 154, 20);
    	menu.add(textField);
    	textField.setColumns(10);
    	
    	textField_1 = new JTextField();
    	textField_1.setBounds(72, 61, 154, 20);
    	menu.add(textField_1);
    	textField_1.setColumns(10);
    	
    	textField_2 = new JTextField();
    	textField_2.setBounds(72, 114, 154, 20);
    	menu.add(textField_2);
    	textField_2.setColumns(10);
    	
    	textField_3 = new JTextField();
    	textField_3.setBounds(72, 145, 154, 20);
    	menu.add(textField_3);
    	textField_3.setColumns(10);
    	
    	JSeparator separator = new JSeparator();
    	separator.setForeground(Color.BLUE);
    	separator.setBounds(10, 214, 294, 1);
    	menu.add(separator);
    	
    	JLabel lblConsignadoDoMs = new JLabel("Consignado do M\u00EAs Atual:");
    	lblConsignadoDoMs.setBounds(10, 11, 154, 14);
    	menu.add(lblConsignadoDoMs);
    	
    	JLabel lblConsignadoDoMs_1 = new JLabel("Consignado do M\u00EAs Anterior:");
    	lblConsignadoDoMs_1.setBounds(10, 92, 166, 14);
    	menu.add(lblConsignadoDoMs_1);
    	
    	JButton btnBroser = new JButton("Browser");
    	btnBroser.setForeground(Color.WHITE);
    	btnBroser.setBackground(SystemColor.desktop);
    	btnBroser.setFont(new Font("Tahoma", Font.PLAIN, 10));
    	btnBroser.setBounds(226, 30, 78, 23);
    	menu.add(btnBroser);
    	
    	JButton btnBrowser_2 = new JButton("Browser");
    	btnBrowser_2.setForeground(Color.WHITE);
    	btnBrowser_2.setBackground(SystemColor.desktop);
    	btnBrowser_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
    	btnBrowser_2.setBounds(226, 58, 78, 23);
    	menu.add(btnBrowser_2);
    	
    	JButton btnBrowser_1 = new JButton("Browser");
    	btnBrowser_1.setForeground(Color.WHITE);
    	btnBrowser_1.setBackground(SystemColor.desktop);
    	btnBrowser_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
    	btnBrowser_1.setBounds(226, 111, 78, 23);
    	menu.add(btnBrowser_1);
    	
    	JButton btnBrowser = new JButton("Browser");
    	btnBrowser.setForeground(Color.WHITE);
    	btnBrowser.setBackground(SystemColor.desktop);
    	btnBrowser.setFont(new Font("Tahoma", Font.PLAIN, 10));
    	btnBrowser.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    		}
    	});
    	btnBrowser.setBounds(226, 142, 78, 23);
    	menu.add(btnBrowser);
    	
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
    	scrollPane.setBounds(0, 0, 4, 4);
    	saida.add(scrollPane);
    	
    	JTextPane textPane = new JTextPane();
    	textPane.setEditable(false);
    	textPane.setBackground(Color.WHITE);
    	textPane.setBounds(0, 0, 468, 398);
    	saida.add(textPane);
    	tabelaDeSelecao.setBackgroundAt(0, Color.YELLOW);
    	
    	JPanel panelBradesco = new JPanel();
    	panelBradesco.setBackground(new Color(255, 0, 0));
    	tabelaDeSelecao.addTab("Bradesco", null, panelBradesco, null);
    	
    	
    	principal.setVisible(true);
    }
}
