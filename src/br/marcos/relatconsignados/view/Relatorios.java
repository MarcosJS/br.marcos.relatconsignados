package br.marcos.relatconsignados.view;

import java.io.IOException;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class Relatorios {
	public static void imprimirConsoleConsignados(String[] relatorio) {
		for(String linha: relatorio) {
			System.out.println(linha);
		}
	}
	
	public static void gerarArquivo(String[] relatorio, String cabecalho, String nomeArquivo) throws IOException {
		PDDocument doc = new PDDocument();
        PDPage page = new PDPage();
 
        doc.addPage(page);
        
        PDFont font = PDType1Font.COURIER;
        PDPageContentStream contents = new PDPageContentStream(doc, page);
        
        contents.beginText();
        contents.setFont(font, 10);
        contents.setLeading(14.5f);
        contents.newLineAtOffset(10, 775);
        contents.showText(cabecalho);
       	contents.newLine();
       	contents.newLineAtOffset(30, 775);
        
        for(String linha: relatorio) {
			contents.showText(linha);
		    contents.newLine();
        }
        contents.endText();
        contents.close();
        doc.save(nomeArquivo);
        doc.close();   
	}
	
	public static StyledDocument obterRelatorioRenderizado(String[] relatorio, String cabecalho) throws BadLocationException {
		StyleContext contexto = new StyleContext();
		StyledDocument documento = new DefaultStyledDocument(contexto);
		SimpleAttributeSet justificado = new SimpleAttributeSet();
		SimpleAttributeSet left = new SimpleAttributeSet();
		int offset = documento.getLength();
		
		StyleConstants.setBold(justificado, true);
		StyleConstants.setAlignment(justificado, StyleConstants.ALIGN_JUSTIFIED);
		documento.insertString(offset, cabecalho+"\n"+"\n", left);
	    documento.setParagraphAttributes(offset, documento.getLength(), justificado, false);
		
	    offset = documento.getLength();
	    
	    StyleConstants.setAlignment(left, StyleConstants.ALIGN_LEFT);
	    StyleConstants.setFontFamily(left, "Consolas");
	    
	    for(String linha: relatorio) {
			System.out.println(linha);
			offset = documento.getLength();
			documento.insertString(offset, "\n"+linha, left);
		}
			
		return documento;
	}
}