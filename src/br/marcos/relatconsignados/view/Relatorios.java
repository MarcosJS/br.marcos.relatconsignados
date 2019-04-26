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
		int consigPPag = 59;
		int linhas = relatorio.length;
		System.out.println(linhas);
		int paginas = (linhas/consigPPag) + 1;
		System.out.println(paginas);
		PDDocument doc = new PDDocument();
        PDPage[] page = new PDPage[paginas];
        PDPageContentStream[] contents = new PDPageContentStream[paginas];
        PDFont font = PDType1Font.COURIER;
        
        for(int i = 0; i < paginas; i++) {
        	page[i] = new PDPage();
        	doc.addPage(page[i]);
        	contents[i] = new PDPageContentStream(doc, page[i]);
        }
        
        for(int i = 0; i < paginas; i++) {
       		contents[i].beginText();
            contents[i].setFont(font, 10);
            contents[i].setLeading(12.5f);
            contents[i].newLineAtOffset(10, 775);
            
            String divisorNumPag = "------------------------------------------------------------------------------------------------["+String.valueOf(i + 1)+"]"; 
           
    		contents[i].showText(cabecalho);
           	contents[i].newLine();    		
    		contents[i].showText(divisorNumPag);
           	contents[i].newLine();
           	contents[i].newLineAtOffset(30, 1);
       	}
       	
        int pag = 0;
        
		for(int i = 1; i <= linhas; i++) {
			if(i % consigPPag == 0) {
				pag++;
			}
        	contents[pag].showText(relatorio[i - 1]);
		    contents[pag].newLine();
		}
		
		for(int i = 0; i < paginas; i++) {
			contents[i].endText();
			contents[i].close();
		}
		
        doc.save(nomeArquivo+".pdf");
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
		documento.insertString(offset, cabecalho+"\n", left);
	    documento.setParagraphAttributes(offset, documento.getLength(), justificado, false);
		
	    offset = documento.getLength();
	    
	    StyleConstants.setAlignment(left, StyleConstants.ALIGN_LEFT);
	    StyleConstants.setFontFamily(left, "Consolas");
	    
	    for(String linha: relatorio) {
			offset = documento.getLength();
			documento.insertString(offset, "\n"+linha, left);
		}
			
		return documento;
	}
}