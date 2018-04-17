package br.marcos.relatconsignados;

import consignacoes.ConsignacoesBB;
import consignado.ConsignadoBra;
import view.HighlightLineTextPane;

import java.io.IOException;
import java.awt.BorderLayout;
import java.io.File;

import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;

import auxiliar.SaidaDados;
 
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileSystemView;
import javax.swing.text.BadLocationException;
/**
 * Classe usada para testes
 */
public final class Laboratorio {
	public static void main(String[] args) throws InvalidPasswordException, IOException, BadLocationException {
		
		File[] arquivo = new File[4];
		//arquivo[0] = new File("c:/workspace/br.marcos.relatconsignados/testepdfbox/consignadobb/bbmar1.pdf");
		//arquivo[1] = new File("c:/workspace/br.marcos.relatconsignados/testepdfbox/consignadobb/bbmar2.pdf");
		//arquivo[2] = new File("c:/workspace/br.marcos.relatconsignados/testepdfbox/consignadobb/bbfev1.pdf");
		//arquivo[3] = new File("c:/workspace/br.marcos.relatconsignados/testepdfbox/consignadobb/bbfev2.pdf");
		JFileChooser explorador = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		
		for(int i = 0; i < 4; i++) {
			explorador.setDialogTitle("Escolha o "+i+"° relatório consignado a ser carregado");
			int selecao = explorador.showOpenDialog(null);
			if (selecao == JFileChooser.APPROVE_OPTION) {
				arquivo[i] = explorador.getSelectedFile();
				System.out.println(arquivo[i].getAbsolutePath());
			}
		}
		
    	ConsignacoesBB consi = new ConsignacoesBB(arquivo[0], 7, 6, arquivo[1], 7, 5);
        ConsignacoesBB consi2 = new ConsignacoesBB(arquivo[2], 7, 6, arquivo[3], 7, 5);
        
        System.out.println("Novos consignados: ");
        //SaidaDados.imprimirConsignados(consi.obterNovos(consi2).getListConsignacoes());
        //SaidaDados.gerarArquivo(consi.obterNovos(consi2).getListConsignacoes(), "Novos Consignados", "novosConsignados.pdf");
        
        JFrame frame = new JFrame("Teste Frame ConsigDiff");
        //JTextPane text = new JTextPane(SaidaDados.obterRelatorioRenderizado(consi.getListConsignacoes(), "TODOS OS CONSIGNADOS"));
        JTextPane text = new HighlightLineTextPane(SaidaDados.obterRelatorioRenderizado(consi.getListConsignacoes(), "TODOS OS CONSIGNADOS"));
        text.setEditable(false);
        JScrollPane scroll = new JScrollPane(text);
        frame.add(scroll, BorderLayout.CENTER);

        frame.setSize(600, 450);
        frame.setVisible(true);
                    
      }
}
