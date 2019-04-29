package br.marcos.relatconsignados.control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;

import br.marcos.relatconsignados.model.Consignado;
import br.marcos.relatconsignados.model.ConsignadoBB;
import br.marcos.relatconsignados.model.ConsignadoBra;
import br.marcos.relatconsignados.model.ConsignadoFolha;

public class ControlDiff {
	public static int BANCO_BRASIL = 0;
	public static int BRADESCO = 1;
	public static int BANCO_BRASIL_FOLHA = 2;
	
	private DiffConsignacoes[] diffConsignacoes = new DiffConsignacoes[3];
	
	public ControlDiff() {
		diffConsignacoes[BANCO_BRASIL] = new DiffConsignacoes(5);
		diffConsignacoes[BRADESCO] = new DiffConsignacoes(5);
		diffConsignacoes[BANCO_BRASIL_FOLHA] = new DiffConsignacoes(5);
	}
	
	public void carregarConsignacoesBB(File[] arquivo, int[] inicioApos, int[] fimAntes) throws InvalidPasswordException, IOException {
		this.convertArqConsigBB(BANCO_BRASIL, 0, arquivo[0], inicioApos[0], fimAntes[0]);
		this.convertArqConsigBB(BANCO_BRASIL, 0, arquivo[1], inicioApos[1], fimAntes[1]);
		this.convertArqConsigBB(BANCO_BRASIL, 1, arquivo[2], inicioApos[2], fimAntes[2]);
		this.convertArqConsigBB(BANCO_BRASIL, 1, arquivo[3], inicioApos[3], fimAntes[3]);
		diffConsignacoes[BANCO_BRASIL].realizarDiff();
	}
	
	public void carregarConsignacoesBra(File[] arquivo, int[] inicioAposPag1, int[] inicioApos, int[] fimAntes) throws InvalidPasswordException, IOException {
		this.convertArqConsigBra(BRADESCO, 0, arquivo[0], inicioAposPag1[0], inicioApos[0], fimAntes[0]);
		this.convertArqConsigBra(BRADESCO, 1,arquivo[1], inicioAposPag1[1], inicioApos[1], fimAntes[1]);
		diffConsignacoes[BRADESCO].realizarDiff();
	}
	
	public void carregarConsignacoesFolBB(File[] arquivo, int[] inicioApos, int[] fimAntes) throws InvalidPasswordException, IOException {
		this.convertArqConsigBB(BANCO_BRASIL_FOLHA, 0, arquivo[0], inicioApos[0], fimAntes[0]);
		this.convertArqConsigBB(BANCO_BRASIL_FOLHA, 0, arquivo[1], inicioApos[1], fimAntes[1]);
		this.convertArqConsigFol(BANCO_BRASIL_FOLHA, 1, arquivo[2]);
		this.convertArqConsigFol(BANCO_BRASIL_FOLHA, 1, arquivo[3]);
		this.convertArqConsigFol(BANCO_BRASIL_FOLHA, 1, arquivo[4]);
		diffConsignacoes[BANCO_BRASIL_FOLHA].realizarDiff();
	}
	
	public String[] obterListaConsignacoes(int tipoDiff, TipoConsignados tipoConsignado) {
		String[] consignacoes = null;
		consignacoes = new String[diffConsignacoes[tipoDiff].getQuantOperacoes(tipoConsignado)];
		int i = 0;
		for(Consignado consig: diffConsignacoes[tipoDiff].obterListaConsignacoes(tipoConsignado)) {
			consignacoes[i] = consig.toStringSimple();
			i++;
		}
		return consignacoes;
	}
	
	private void convertArqConsigFol(int diffConsignacao, int prioridade, File arquivo) throws FileNotFoundException {
		
		Scanner in = new Scanner(new FileReader(arquivo.getAbsolutePath()));
		
		while (in.hasNextLine()) {
		    String linha = in.nextLine();
		    String dados[] = linha.split(",");
		    
		    String matricula = dados[0];
		    String contratante = removerCaracterIniFim(dados[1], '"');
		    double valorParcela = Double.parseDouble(removerCaracterIniFim(dados[5].replace(".", "")+'.'+dados[6], '"'));
		    
		    
		    
		    ConsignadoFolha consig = new ConsignadoFolha(contratante, valorParcela, matricula);
            
            diffConsignacoes[diffConsignacao].adicionarConsignado(consig, prioridade);   
		}
		in.close();
	}
	
	private void convertArqConsigBB(int diffConsignacao, int prioridade, File arquivo, int inicioApos, int fimAntes) throws InvalidPasswordException, IOException {
		PDDocument document = null;
        document = PDDocument.load(arquivo);
	    PDFTextStripper stripper = new PDFTextStripper();
	    String pdfText = stripper.getText(document).toString();
	    String pdfLinhas[] = pdfText.split("\n");
	    	    	    
	    for(int i = 0; i <= pdfLinhas.length - fimAntes; i++) {
	    	
	    	String pdfDados[] = pdfLinhas[i].split(" ");
	    	
	    	if(i > inicioApos) {         	
	        	double consignado = Double.parseDouble(formatParaConversDecimal(pdfDados[pdfDados.length - 1]));
	        	double valorParcela = Double.parseDouble(formatParaConversDecimal(pdfDados[pdfDados.length - 2]));
	        	String cpf = removerCaracterIniFim(pdfDados[pdfDados.length - 3], ' ');
	        	int sequencia = Integer.parseInt(removerCaracterIniFim(pdfDados[pdfDados.length - 4], ' '));
	        	String operacao = removerCaracterIniFim(pdfDados[pdfDados.length - 5], ' ');
	        	String matricula = removerCaracterIniFim(pdfDados[pdfDados.length - 6], ' ');
	        	String contratante = "";
	        
	            for(int j = 0; j < (pdfDados.length - 6); j++) {
	            	contratante = contratante.concat(" "+pdfDados[j]);
	            }
	            
	            contratante = removerCaracterIniFim(contratante, ' ');
	            ConsignadoBB consig = new ConsignadoBB(contratante, matricula, operacao, valorParcela, consignado, sequencia, cpf);
	            
	            diffConsignacoes[diffConsignacao].adicionarConsignado(consig, prioridade);
	    	}
	    }
	    document.close();
	}
	
	private void convertArqConsigBra(int diffConsignacao, int prioridade, File arquivo, int inicioAposPag1, int inicioApos, int fimAntes) throws IOException {
        PDDocument document = PDDocument.load(arquivo);
        PDFTextStripper stripper = new PDFTextStripper();
        int inicio = inicioAposPag1;
            
        for(int p = 0; p < document.getNumberOfPages(); p++) {
        	stripper.setStartPage(p + 1);
           	stripper.setEndPage(p + 1);
           	String pdfTextPage  = stripper.getText(document).toString();
           	String pdfLinhas[] = pdfTextPage.split("\n");
            	
           	for(int i = 0; i < pdfLinhas.length - fimAntes; i++) {
               	String pdfDados[] = pdfLinhas[i].split(" ");
               	
               	if(p > 0) {
               		inicio = inicioApos;
               	}
           		
               	if(i >= inicio) {
               		String ctCliente = ControlDiff.removerCaracterIniFim(pdfDados[pdfDados.length - 1], ' ');
               		String agCliente = ControlDiff.removerCaracterIniFim(pdfDados[pdfDados.length - 2], ' ');
               		String parcelas = ControlDiff.removerCaracterIniFim(pdfDados[pdfDados.length - 4], ' ');
               		String cpf = ControlDiff.removerCaracterIniFim(pdfDados[pdfDados.length - 5], ' ');
    	           	String contrato = (pdfDados[pdfDados.length - 6]);
    	           	String motivo = "";
    	           	double valorConsignado = 0;
    	           	boolean consignacao = false;
    	           	double valorParcela = 0;
    	           	String nome = "";
    	           	String matricula = "";
    	            	
    	           	//tramento caso nao haja consignacao
    	           	if(pdfLinhas[i].contains("Não")) {
    	           		String pdfDadosE[] = pdfLinhas[i].split(" Não ");
    	           		//Trantamento da possibilidade da linha do consignado ter mais
    	           		 //substrings iguais a "não" exibindo a linha e encerrando o programa.
    	           		 
    	           		try {
    	           			String contendoMotivo[] = pdfDadosE[1].split(" ");
    	           			for(int j = 2; j < (contendoMotivo.length - 6); j++) {
    			            	motivo = ControlDiff.removerCaracterIniFim(motivo.concat(" "+contendoMotivo[j]), ' ');
    			            }
    	            		
    	            		valorConsignado = Double.parseDouble(formatParaConversDecimal(contendoMotivo[1]));
    		            	consignacao = convertParaBoolean("Não");
    		            	String semMotivo[] = pdfDadosE[0].split(" ");
    		            	valorParcela = Double.parseDouble(formatParaConversDecimal(semMotivo[semMotivo.length - 1]));
    		            	
    		            	for(int j = 3; j < (semMotivo.length - 2); j++) {
    		            		nome = ControlDiff.removerCaracterIniFim(nome.concat(" "+semMotivo[j]), ' ');
    		            	}
    		            	matricula = ControlDiff.removerCaracterIniFim(semMotivo[2], ' ');
    	           		} catch(Exception e) {
    	           			System.out.println(pdfDadosE);
    	           			document.close();
    	           			System.exit(0);
    	           		}
    	            		
    	           	} else {
    	           		//Continuação do fluxo caso haja consignacao
    	           		valorConsignado = Double.parseDouble(formatParaConversDecimal(pdfDados[pdfDados.length - 7]));
    	           		consignacao = convertParaBoolean(pdfDados[pdfDados.length - 9]);
    	           		valorParcela = Double.parseDouble(formatParaConversDecimal(pdfDados[pdfDados.length - 10]));
    	           		
    		            for(int j = 3; j < (pdfDados.length - 11); j++) {
    		            	nome = ControlDiff.removerCaracterIniFim(nome.concat(" "+pdfDados[j]), ' ');
    		            }
    		            
    		            matricula = ControlDiff.removerCaracterIniFim(pdfDados[2], ' ');
    	           	}
    	           	
    	          ConsignadoBra consig = new ConsignadoBra(nome, matricula, contrato, valorParcela, valorConsignado, Integer.parseInt(capturarParcelaAtual(parcelas)), Integer.parseInt(capturarTotalParcelas(parcelas)), consignacao, motivo, agCliente, ctCliente, cpf);
    	          diffConsignacoes[diffConsignacao].adicionarConsignado(consig, prioridade);
    	          }
            }
            	
        }
           
        if(document != null) {
           	document.close();
        }
	}
	
	public static String removerCaracterIniFim(String string, char caracter) {
		if(string.length() > 0) {
			int i = 0;//primeiro indice
			int j = string.length() - 1;//ultimo indice
			int d = 0;//desconto no fim da string
			while((string.charAt(i) == caracter) || (string.charAt(j) == caracter)) {
				if(string.charAt(i) == caracter) {
					i++;//incrementado para percorrer a string
				}
				if(string.charAt(j) == caracter) {
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
		return removerCaracterIniFim(string, ' ');
	}
	
	public static boolean convertParaBoolean(String string) {
		string = removerCaracterIniFim(string, ' ');
		boolean resultado = false;
		if(string.equals("Sim")) {
			resultado = true;
		}
		return resultado;
	}
	
	private String capturarParcelaAtual(String string) {
		string = removerCaracterIniFim(string, ' ');
		return string.split("/")[0];
		
	}
	
	private String capturarTotalParcelas(String string) {
		string = removerCaracterIniFim(string, ' ');
		return string.split("/")[1];
		
	}
}
