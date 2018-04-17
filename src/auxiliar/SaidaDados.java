package auxiliar;

import java.awt.Color;
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

import consignado.Consignado;
import consignado.ConsignadoBB;

public class SaidaDados {
	public static void imprimirConsignados(Consignado[] consignados) {
		for(Consignado cB: consignados) {
			if(cB instanceof ConsignadoBB) {
				System.out.printf("%-30s %s %s %d %s %10s %10s\n\n", cB.getNome(), cB.getMatricula(), cB.getIdConsignado(), ((ConsignadoBB) cB).getSeqOperacao(), ((ConsignadoBB) cB).getCpf(), String.valueOf(cB.getValorParcela()), String.valueOf(cB.getValorConsignado()));
			} else {
				System.out.println("Não é ConsignadoBB "+consignados.getClass());
			}
		}
	}
	
	public static void gerarArquivo(Consignado[] consignados, String cabecalho, String nomeArquivo) throws IOException {
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
        
        for(Consignado cB: consignados) {
			if(cB instanceof ConsignadoBB) {
				String linha = new String();
		        linha = linha.concat(String.format("%1$-30s", cB.getNome())+" "+cB.getMatricula()+" "+cB.getIdConsignado()+" "+((ConsignadoBB) cB).getSeqOperacao()+" "+((ConsignadoBB) cB).getCpf()+" "+String.format("%1$10s", String.valueOf(cB.getValorParcela()))+" "+String.format("%1$10s", String.valueOf(cB.getValorConsignado())));
				contents.showText(linha);
		       	contents.newLine();
			}
        }
        contents.endText();
        contents.close();
        doc.save(nomeArquivo);
        doc.close();   
	}
	
	public static StyledDocument obterRelatorioRenderizado(Consignado[] consignados, String cabecalho) throws BadLocationException {
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
	    
	    boolean color = true;
		for(Consignado cB: consignados) {
			if(cB instanceof ConsignadoBB) {
				String linha = new String();
				if(color) {
					StyleConstants.setBackground(left, new Color(135, 206, 235));
				} else {
					StyleConstants.setBackground(left, new Color(255, 255, 153));
				}
				linha = linha.concat(String.format("%1$-30s", cB.getNome())+" "+String.format("%1$11s", cB.getMatricula())+" "+cB.getIdConsignado()+" "+((ConsignadoBB) cB).getSeqOperacao()+" "+((ConsignadoBB) cB).getCpf()+" "+String.format("%1$10s", String.valueOf(cB.getValorParcela()))+" "+String.format("%1$10s", String.valueOf(cB.getValorConsignado())));
				System.out.println(linha);
				offset = documento.getLength();
				documento.insertString(offset, "\n"+linha, left);
				color = !color;
			}
		}
		
		return documento;
	}
}