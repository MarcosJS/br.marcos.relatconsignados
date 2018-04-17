package auxiliar;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;

import consignado.ConsignadoBB;

public class EntradaDados {
	
	public static ConsignadoBB[] carregarConsignacoesBB(File arquivo, int inicioApos, int fimAntes) throws InvalidPasswordException, IOException {
		PDDocument document = null;
        document = PDDocument.load(arquivo);
	    PDFTextStripper stripper = new PDFTextStripper();
	    String pdfText = stripper.getText(document).toString();
	    String pdfLinhas[] = pdfText.split("\n");
	    ArrayList<ConsignadoBB> consignadosA = new ArrayList<ConsignadoBB>();
	    	    	    
	    for(int i = 0; i <= pdfLinhas.length - fimAntes; i++) {
	    	
	    	String pdfDados[] = pdfLinhas[i].split(" ");
	    	
	    	if(i > inicioApos) {         	
	        	String consignado = pdfDados[pdfDados.length - 1];
	        	String valorParcela = pdfDados[pdfDados.length - 2];
	        	String cpf = pdfDados[pdfDados.length - 3];
	        	String sequencia = pdfDados[pdfDados.length - 4];
	        	String operacao = pdfDados[pdfDados.length - 5];
	        	String matricula = pdfDados[pdfDados.length - 6];
	        	String contratante = "";
	        
	            for(int j = 0; j < (pdfDados.length - 6); j++) {
	            	contratante = contratante.concat(" "+pdfDados[j]);
	            }
	            
	            ConsignadoBB consig = new ConsignadoBB(contratante, matricula, operacao, valorParcela, consignado, "0/0", sequencia, cpf);
	            
	            consignadosA.add(consig);
	    	}
	    }
	    
	    document.close();
	    ConsignadoBB[] consignadosV = new ConsignadoBB[consignadosA.size()];
	    consignadosV = consignadosA.toArray(consignadosV);
	    return consignadosV;
	}
	
	public static String removEspacoIniFim(String string) {
		if(string.length() > 0) {
			int i = 0;//primeiro indice
			int j = string.length() - 1;//ultimo indice
			int d = 0;//desconto no fim da string
			while((string.charAt(i) == ' ') || (string.charAt(j) == ' ')) {
				if(string.charAt(i) == ' ') {
					i++;//incrementado para percorrer a string
				}
				if(string.charAt(j) == ' ') {
					j--;//descrementado para voltar pela string
					d++;//quantidade espacos no fim da string
				}
			}
			string = string.substring(i, string.length() - d);
		} else {
			string = null;
		}
		return string;
	}
	
	public static String formatParaConversDecimal(String string) {
		string  = string.replace(".", "");
		string = string.replace(",", ".");
		return string;
	}
	
	public static boolean convertParaBoolean(String string) {
		string = removEspacoIniFim(string);
		boolean resultado = false;
		if(string.equals("Sim")) {
			resultado = true;
		}
		return resultado;
	}
	
	public static String capturarParcelaAtual(String string) {
		string = removEspacoIniFim(string);
		return string.split("/")[0];
		
	}
	
	public static String capturarTotalParcelas(String string) {
		string = removEspacoIniFim(string);
		return string.split("/")[1];
		
	}
}
