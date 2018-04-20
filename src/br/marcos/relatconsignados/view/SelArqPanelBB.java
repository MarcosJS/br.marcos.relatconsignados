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


public class SelArqPanelBB extends SelArqPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File[] arquivo = new File[4];
	JFileChooser explorador = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
	private ControlDiff sessaoD;

	public SelArqPanelBB(ControlDiff cD) {
		super();
		
		this.setOpaque(false);
		this.setBounds(10, 11, 294, 154);
		this.setBackground(Color.ORANGE);
		this.setLayout(null);
		
		JLabel label = new JLabel("Consignado do M\u00EAs Atual:");
		label.setBounds(0, 0, 130, 14);
		this.add(label);
		
		JTextField campo1 = new JTextField();
		campo1.setColumns(10);
		campo1.setBounds(64, 19, 154, 20);
		this.add(campo1);
		
		JButton button = new JButton("Browser");
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
		
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button.setBackground(new Color(100, 149, 237));
		button.setBounds(216, 16, 78, 23);
		this.add(button);
		
		JTextField campo3 = new JTextField();
		campo3.setColumns(10);
		campo3.setBounds(64, 103, 154, 20);
		
		JButton button_1 = new JButton("Browser");
		button_1.addActionListener(new ActionListener() {
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
		
		this.add(campo3);
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_1.setBackground(new Color(100, 149, 237));
		button_1.setBounds(216, 100, 78, 23);
		this.add(button_1);
		
		JLabel label_2 = new JLabel("Consignado do M\u00EAs Anterior:");
		label_2.setBounds(0, 81, 166, 14);
		this.add(label_2);
		
		JLabel label_1 = new JLabel("1\u00BA Arquivo");
		label_1.setBounds(0, 25, 59, 14);
		this.add(label_1);
		
		JLabel label_7 = new JLabel("2\u00BA Arquivo");
		label_7.setBounds(0, 58, 59, 14);
		this.add(label_7);
		
		JTextField campo2 = new JTextField();
		campo2.setColumns(10);
		campo2.setBounds(64, 52, 154, 20);
		this.add(campo2);
		
		JButton button_6 = new JButton("Browser");
		button_6.addActionListener(new ActionListener() {
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
		button_6.setForeground(Color.WHITE);
		button_6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_6.setBackground(new Color(100, 149, 237));
		button_6.setBounds(216, 49, 78, 23);
		this.add(button_6);
		
		JLabel label_8 = new JLabel("1\u00BA Arquivo");
		label_8.setBounds(0, 109, 59, 14);
		this.add(label_8);
		
		JLabel label_9 = new JLabel("2\u00BA Arquivo");
		label_9.setBounds(0, 140, 59, 14);
		this.add(label_9);

		JTextField campo4 = new JTextField();
		campo4.setColumns(10);
		campo4.setBounds(64, 134, 154, 20);
		
		JButton button_7 = new JButton("Browser");
		button_7.addActionListener(new ActionListener() {
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
		
		this.add(campo4);
		button_7.setForeground(Color.WHITE);
		button_7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_7.setBackground(new Color(100, 149, 237));
		button_7.setBounds(216, 131, 78, 23);
		this.add(button_7);
		
		this.setSessaoD(cD);
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
		if(quantidade == 4) {
			resultado = true;
		}
		return resultado;
	}
	
	@Override
	public boolean carregarArquivos() {
		boolean resultado = true;
		if(this.estaPronto()) {
			int[] inicioApos = {7, 7, 7, 7};
			int[] fimAntes = {6, 5, 6, 5};
			try {
				sessaoD.carregarConsignacoesBB(arquivo, inicioApos, fimAntes);
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
		this.sessaoD = sessaoD;
	}
}
