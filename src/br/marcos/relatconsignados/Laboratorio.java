package br.marcos.relatconsignados;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.File;
import java.io.IOException;
 
/**
 * Classe usada para teste de testes
 */
public final class Laboratorio {
 
    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Drivers\\workspace-eclipse\\br.marcos.relatconsignados\\testepdfbox\\consignadobb-jan\\TO0326012018.pdf";
        PDDocument document = null;
        
        //try {
            document = PDDocument.load(new File(fileName));
            PDFTextStripper stripper = new PDFTextStripper();
            String pdfText = stripper.getText(document).toString();
            String pdfLinhas[] = pdfText.split("\n");
            int cont = 0;
            
            /*for(int i = 0; i < pdfLinhas.length; i++) {
            	String pdfDados[] = pdfLinhas[i].split(" ");
            	if(pdfDados[0].equals("Continua")) { break;}
            	if(i > 7) {         	
	            	String consignado = pdfDados[pdfDados.length - 1];
	            	String valor = pdfDados[pdfDados.length - 2];
	            	String cpf = pdfDados[pdfDados.length - 3];
	            	String sequencia = pdfDados[pdfDados.length - 4];
	            	String operacao = pdfDados[pdfDados.length - 5];
	            	String matricula = pdfDados[pdfDados.length - 6];
	            	String contratante = "";
	            
		            for(int j = 0; j < (pdfDados.length - 6); j++) {
		            	contratante = contratante.concat(" "+pdfDados[j]);
		            }
		            cont++;
		            
	            	System.out.println(contratante+" "+matricula+" "+operacao+" "+sequencia+" "+cpf+" "+valor+" "+consignado);
	            }
            }*/
            System.out.println("Operacoes: "+cont);
        //finally {
            if(document != null) {
            	document.close();
            }
        //}
       
     /*TESTE DA CLASSE ModString 
       String nome1 = "teste1    ";
       String nome2 = "  teste2   ";
       String nome3 = "   teste3";
       ModString m = new ModString();
       nome1 = m.removEspacoIniFim(nome1);//Teste funcao removEspacoIniFim
       nome2 = ModString.removEspacoIniFim(nome2);
       nome3 = m.removEspacoIniFim(nome3);
       System.out.println("Teste da função removEspacoIniFim da Classe ModString");
       System.out.println("Nome1:"+nome1+",nome2:"+nome2+",nome3:"+nome3+".");*/
    }
}
