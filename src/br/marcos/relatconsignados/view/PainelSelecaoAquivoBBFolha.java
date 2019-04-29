package br.marcos.relatconsignados.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;

import br.marcos.relatconsignados.control.ControlDiff;

import java.io.File;


public class PainelSelecaoAquivoBBFolha extends PainelSelecaoArquivo{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File[] arquivo = new File[5];
	JFileChooser explorador = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
	private ControlDiff sessaoDiff;

	public PainelSelecaoAquivoBBFolha(ControlDiff contrlDiff) {
		super();
		
		//this.setOpaque(false);
		this.setBounds(10, 11, 294, 156);
		this.setBackground(Color.ORANGE);
		this.setLayout(null);
		
		/*------------------------LABELS---------------------------------*/
		JLabel label = new JLabel("Consignado:");
		label.setBounds(64, 0, 130, 20);
		this.add(label);
		
		JLabel label_1 = new JLabel("1\u00BA Arquivo");
		label_1.setBounds(0, 20, 59, 20);
		this.add(label_1);
		
		JLabel label_2 = new JLabel("2\u00BA Arquivo");
		label_2.setBounds(0, 45, 59, 20);
		this.add(label_2);
		
		//novo label
		JLabel label_3 = new JLabel("Arquivos da Folha:");
		label_3.setBounds(64, 65, 154, 20);
		this.add(label_3);
		
		JLabel label_4 = new JLabel("1\u00BA Arquivo");
		label_4.setBounds(0, 85, 59, 20);
		this.add(label_4);
		
		JLabel label_5 = new JLabel("2\u00BA Arquivo");
		label_5.setBounds(0, 110, 59, 20);
		this.add(label_5);
		
		JLabel label_6 = new JLabel("3\u00BA Arquivo");
		label_6.setBounds(0, 135, 59, 20);
		this.add(label_6);
		
		/*------------------------TEXTFIELDS-----------------------------*/
		JTextField campo1 = new JTextField();
		campo1.setColumns(10);
		campo1.setBounds(64, 20, 154, 20);
		this.add(campo1);
		
		JTextField campo2 = new JTextField();
		campo2.setColumns(10);
		campo2.setBounds(64, 45, 154, 20);
		this.add(campo2);
				
		JTextField campo3 = new JTextField();
		campo3.setColumns(10);
		campo3.setBounds(64, 85, 154, 20);
		this.add(campo3);
		
		JTextField campo4 = new JTextField();
		campo4.setColumns(10);
		campo4.setBounds(64, 110, 154, 20);
		this.add(campo4);
		
		
		JTextField campo5 = new JTextField();
		campo5.setColumns(10);
		campo5.setBounds(64, 135, 154, 20);
		this.add(campo5);
		
		/*------------------------BUTTONS--------------------------------*/
		JButton button = new JButton("Browser");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button.setBackground(new Color(100, 149, 237));
		button.setBounds(216, 20, 78, 20);
		this.add(button);
		
		JButton button_2 = new JButton("Browse2");
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_2.setBackground(new Color(100, 149, 237));
		button_2.setBounds(216, 45, 78, 20);
		this.add(button_2);
		
		JButton button_3 = new JButton("Browse3");
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_3.setBackground(new Color(100, 149, 237));
		button_3.setBounds(216, 85, 78, 20);
		this.add(button_3);
		
		JButton button_4 = new JButton("Browse4");
		button_4.setForeground(Color.WHITE);
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_4.setBackground(new Color(100, 149, 237));
		button_4.setBounds(216, 110, 78, 20);
		this.add(button_4);
		
		JButton button_5 = new JButton("Browse5");
		button_5.setForeground(Color.WHITE);
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_5.setBackground(new Color(100, 149, 237));
		button_5.setBounds(216, 135, 78, 20);
		this.add(button_5);
		
		/*------------------------ACTIONS--------------------------------*/
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				explorador.setDialogTitle("Escolha o arquivo a ser carregado");
				int selecao = explorador.showOpenDialog(null);
				if (selecao == JFileChooser.APPROVE_OPTION) {
					arquivo[0] = explorador.getSelectedFile();
					campo1.setText(arquivo[0].getAbsolutePath());
					System.out.println(arquivo[0].getAbsolutePath());
				}
			}
		});
		
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				explorador.setDialogTitle("Escolha o arquivo a ser carregado");
				int selecao = explorador.showOpenDialog(null);
				if (selecao == JFileChooser.APPROVE_OPTION) {
					arquivo[1] = explorador.getSelectedFile();
					campo2.setText(arquivo[1].getAbsolutePath());
					System.out.println(arquivo[1].getAbsolutePath());
				}
			}
		});
		
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				explorador.setDialogTitle("Escolha o arquivo a ser carregado");
				int selecao = explorador.showOpenDialog(null);
				if (selecao == JFileChooser.APPROVE_OPTION) {
					arquivo[2] = explorador.getSelectedFile();
					campo3.setText(arquivo[2].getAbsolutePath());
					System.out.println(arquivo[2].getAbsolutePath());
				}
			}
		});
		
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				explorador.setDialogTitle("Escolha o arquivo a ser carregado");
				int selecao = explorador.showOpenDialog(null);
				if (selecao == JFileChooser.APPROVE_OPTION) {
					arquivo[3] = explorador.getSelectedFile();
					campo4.setText(arquivo[3].getAbsolutePath());
					System.out.println(arquivo[3].getAbsolutePath());
				}
			}
		});
		
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				explorador.setDialogTitle("Escolha o arquivo a ser carregado");
				int selecao = explorador.showOpenDialog(null);
				if (selecao == JFileChooser.APPROVE_OPTION) {
					arquivo[4] = explorador.getSelectedFile();
					campo5.setText(arquivo[4].getAbsolutePath());
					System.out.println(arquivo[4].getAbsolutePath());
				}
			}
		});

		this.setSessaoD(contrlDiff);
	}
	
	@Override
	public boolean estaPronto() {
		boolean resultado = false;
		int quantidade = 0;
		for(File f: arquivo) {
			if(f != null) {
				quantidade++;
			}
		}
		if(quantidade == 5) {
			resultado = true;
		}
		return resultado;
	}
	
	@Override
	public boolean carregarArquivos() {
		boolean resultado = true;
		if(this.estaPronto()) {
//			int[] inicioApos = {7, 7, 7, 7};
//			int[] fimAntes = {6, 5, 6, 5};
//			try {
//				sessaoD.carregarConsignacoesBB(arquivo, inicioApos, fimAntes);
//			} catch (Exception e) {
//				resultado = false;
//				JOptionPane.showMessageDialog(null, "Erro no carregamento dos arquivos!", "Erro", JOptionPane.ERROR_MESSAGE);
//				e.printStackTrace();
//			}
			int[] inicioApos = {7, 7};
			int[] fimAntes = {6, 5};
			try {
				sessaoDiff.carregarConsignacoesFolBB(arquivo, inicioApos, fimAntes);
			} catch (Exception e) {
				resultado = false;
				JOptionPane.showMessageDialog(null, "Erro no carregamento dos arquivos!", "Erro", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		} else {
			resultado = false;
			JOptionPane.showMessageDialog(null, "Os arquivos não foram carregados completamente!", "Alerta", JOptionPane.WARNING_MESSAGE);
		}
		return resultado;
	}
	
	public void setSessaoD(ControlDiff sessaoD) {
		this.sessaoDiff = sessaoD;
	}

	/**
	 * @return the explorador
	 */
	public JFileChooser getExplorador() {
		return explorador;
	}

	/**
	 * @param explorador the explorador to set
	 */
	public void setExplorador(JFileChooser explorador) {
		this.explorador = explorador;
	}
}