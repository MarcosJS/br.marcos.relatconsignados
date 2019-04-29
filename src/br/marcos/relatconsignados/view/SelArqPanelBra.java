package br.marcos.relatconsignados.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;

import br.marcos.relatconsignados.control.ControlDiff;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelArqPanelBra extends PainelSelecaoArquivo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File[] arquivo = new File[2];
	JFileChooser explorador = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
	private ControlDiff sessaoD;
	
	public SelArqPanelBra(ControlDiff cD) {
		super();
		
		this.setOpaque(false);
    	this.setLayout(null);
    	this.setBackground(Color.ORANGE);
    	this.setBounds(10, 11, 294, 154);
    	
    	JLabel label_3 = new JLabel("Consignado do M\u00EAs Atual:");
    	label_3.setBounds(0, 0, 125, 14);
    	this.add(label_3);

    	JTextField textField_1 = new JTextField();
    	textField_1.setColumns(10);
    	textField_1.setBounds(64, 24, 154, 20);
    	this.add(textField_1);
    	
    	JButton button_3 = new JButton("Browser");
    	button_3.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			explorador.setDialogTitle("Escolha o arquivo a ser carregado");
				int selecao = explorador.showOpenDialog(null);
				if (selecao == JFileChooser.APPROVE_OPTION) {
					arquivo[0] = explorador.getSelectedFile();
					textField_1.setText(arquivo[0].getAbsolutePath());
					System.out.println(arquivo[0].getAbsolutePath());
				}
    		}
    	});
    	
    	button_3.setForeground(Color.WHITE);
    	button_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
    	button_3.setBackground(SystemColor.RED);
    	button_3.setBounds(216, 21, 78, 23);
    	this.add(button_3);
    	
    	JLabel label_4 = new JLabel("Arquivo");
    	label_4.setBounds(0, 30, 59, 14);
    	this.add(label_4);
    	
    	JTextField textField_2 = new JTextField();
    	textField_2.setColumns(10);
    	textField_2.setBounds(64, 103, 154, 20);
    	this.add(textField_2);
    	
    	JButton button_4 = new JButton("Browser");
    	button_4.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			explorador.setDialogTitle("Escolha o arquivo a ser carregado");
				int selecao = explorador.showOpenDialog(null);
				if (selecao == JFileChooser.APPROVE_OPTION) {
					arquivo[1] = explorador.getSelectedFile();
					textField_2.setText(arquivo[1].getAbsolutePath());
					System.out.println(arquivo[1].getAbsolutePath());
				}
    		}
    	});
    	
    	button_4.setForeground(Color.WHITE);
    	button_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
    	button_4.setBackground(SystemColor.RED);
    	button_4.setBounds(216, 100, 78, 23);
    	this.add(button_4);
    	    	
    	JLabel label_6 = new JLabel("Consignado do M\u00EAs Anterior:");
    	label_6.setBounds(0, 81, 166, 14);
    	this.add(label_6);
    	
    	JLabel label_5 = new JLabel("Arquivo");
    	label_5.setBounds(0, 109, 59, 14);
    	this.add(label_5);
    	
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
		if(quantidade == 2) {
			resultado = true;
		}
		return resultado;
	}
	
	@Override
	public boolean carregarArquivos() {
		boolean resultado = true;
		if(this.estaPronto()) {
			
			int[] inicioAposPag1 = {10, 10};
			int[] inicioApos = {2, 2};
			int[] fimAntes = {1, 1};
			try {
				if(sessaoD == null) {
					System.out.println("sessao nao esta pronto");
				}
				sessaoD.carregarConsignacoesBra(arquivo, inicioAposPag1, inicioApos, fimAntes);
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
