package br.marcos.relatconsignados.control;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;

import br.marcos.relatconsignados.model.Consignado;
import br.marcos.relatconsignados.model.ConsignadoBB;
import br.marcos.relatconsignados.model.ConsignadoBra;

public class ControlDiff {
	public static int CONSIG_ATUAL = DiffConsignacoes.CONSIG_ATUAL;
	public static int CONSIG_ANTERIOR = DiffConsignacoes.CONSIG_ANTERIOR;
	public static int BANCO_BRASIL = 1;
	public static int BRADESCO = 2;
	private DiffConsignacoes bancoBrasil;
	private DiffConsignacoes bradesco;
	
	public ControlDiff() {
		this.bancoBrasil = new DiffConsignacoes();
		this.bradesco = new DiffConsignacoes();
	}
	
	public void carregarConsignacoesBB(File[] arquivo, int[] inicioApos, int[] fimAntes) throws InvalidPasswordException, IOException {
		ConsignadoBB[][] vetorConsignados1 = {this.convertArqConsigBB(arquivo[0], inicioApos[0], fimAntes[0]), this.convertArqConsigBB(arquivo[1], inicioApos[1], fimAntes[1])};
		ConsignadoBB[][] vetorConsignados2 = {this.convertArqConsigBB(arquivo[2], inicioApos[2], fimAntes[2]), this.convertArqConsigBB(arquivo[3], inicioApos[3], fimAntes[3])};
		this.bancoBrasil.carregarConsignacoesBB(this.concatVetores(vetorConsignados1), this.concatVetores(vetorConsignados2));
	}
	
	public void carregarConsignacoesBra(File[] arquivo, int[] inicioAposPag1, int[] inicioApos, int[] fimAntes) throws InvalidPasswordException, IOException {
		ConsignadoBra[] vetorConsignados1 = this.convertArqConsigBra(arquivo[0], inicioAposPag1[0], inicioApos[0], fimAntes[0]);
		ConsignadoBra[] vetorConsignados2 = this.convertArqConsigBra(arquivo[1], inicioAposPag1[1], inicioApos[1], fimAntes[1]);
		this.bradesco.carregarConsignacoesBra(vetorConsignados1, vetorConsignados2);
	}
	
	public String[] obterListaConsignacoes(int tipoConsignado, int ordem) {
		String[] consignacoes = null;
		if(tipoConsignado == ControlDiff.BANCO_BRASIL) {
			consignacoes = new String[bancoBrasil.getQuantOperacoes(ordem)];
			int i = 0;
			for(Consignado cB: this.bancoBrasil.obterListConsignacoes(ordem)) {
				consignacoes[i] = ((ConsignadoBB) cB).toStringSimple();
				i++;
			}
		} else if(tipoConsignado == ControlDiff.BRADESCO) {
			consignacoes = new String[bradesco.getQuantOperacoes(ordem)];
			int i = 0;
			for(Consignado cB: this.bradesco.obterListConsignacoes(ordem)) {
				consignacoes[i] = ((ConsignadoBra) cB).toStringSimple();
				i++;
			}
		}
		return consignacoes;
	}
	
	public String[] obterListaNovos(int tipoConsignado) {
		String[] consignacoes = null;
		if(tipoConsignado == ControlDiff.BANCO_BRASIL) {
			Consignado[] novosVetor = this.bancoBrasil.obterNovosConsignados();
			consignacoes = new String[novosVetor.length];
			int i = 0;
			for(Consignado cB: novosVetor) {
				consignacoes[i] = ((ConsignadoBB) cB).toStringSimple();
				i++;
			}
		} else if(tipoConsignado == ControlDiff.BRADESCO) {
			Consignado[] novosVetor = this.bradesco.obterNovosConsignados();
			consignacoes = new String[novosVetor.length];
			int i = 0;
			for(Consignado cB: novosVetor) {
				consignacoes[i] = ((ConsignadoBra) cB).toStringSimple();
				i++;
			}
		}
		return consignacoes;
	}
	
	public String[] obterListaExcluidos(int tipoConsignado) {
		String[] consignacoes = null;
		if(tipoConsignado == ControlDiff.BANCO_BRASIL) {
			Consignado[] novosVetor = this.bancoBrasil.obterConsignadosExcluidos();
			consignacoes = new String[novosVetor.length];
			int i = 0;
			for(Consignado cB: novosVetor) {
				consignacoes[i] = ((ConsignadoBB) cB).toStringSimple();
				i++;
			}
		} else if(tipoConsignado == ControlDiff.BRADESCO) {
			Consignado[] novosVetor = this.bradesco.obterConsignadosExcluidos();
			consignacoes = new String[novosVetor.length];
			int i = 0;
			for(Consignado cB: novosVetor) {
				consignacoes[i] = ((ConsignadoBra) cB).toStringSimple();
				i++;
			}
		}
		return consignacoes;
	}
	
	public String[] obterListaInalterados(int tipoConsignado) {
		String[] consignacoes = null;
		if(tipoConsignado == ControlDiff.BANCO_BRASIL) {
			Consignado[] novosVetor = this.bancoBrasil.obterInalterados();
			consignacoes = new String[novosVetor.length];
			int i = 0;
			for(Consignado cB: novosVetor) {
				consignacoes[i] = ((ConsignadoBB) cB).toStringSimple();
				i++;
			}
		} else if(tipoConsignado == ControlDiff.BRADESCO) {
			Consignado[] novosVetor = this.bradesco.obterInalterados();
			consignacoes = new String[novosVetor.length];
			int i = 0;
			for(Consignado cB: novosVetor) {
				consignacoes[i] = ((ConsignadoBra) cB).toStringSimple();
				i++;
			}
		}
		return consignacoes;
	}
	
	private ConsignadoBB[] convertArqConsigBB(File arquivo, int inicioApos, int fimAntes) throws InvalidPasswordException, IOException {
		PDDocument document = null;
        document = PDDocument.load(arquivo);
	    PDFTextStripper stripper = new PDFTextStripper();
	    String pdfText = stripper.getText(document).toString();
	    String pdfLinhas[] = pdfText.split("\n");
	    ArrayList<ConsignadoBB> consignadosA = new ArrayList<ConsignadoBB>();
	    	    	    
	    for(int i = 0; i <= pdfLinhas.length - fimAntes; i++) {
	    	
	    	String pdfDados[] = pdfLinhas[i].split(" ");
	    	
	    	if(i > inicioApos) {         	
	        	double consignado = Double.parseDouble(formatParaConversDecimal(pdfDados[pdfDados.length - 1]));
	        	double valorParcela = Double.parseDouble(formatParaConversDecimal(pdfDados[pdfDados.length - 2]));
	        	String cpf = removEspacoIniFim(pdfDados[pdfDados.length - 3]);
	        	int sequencia = Integer.parseInt(removEspacoIniFim(pdfDados[pdfDados.length - 4]));
	        	String operacao = removEspacoIniFim(pdfDados[pdfDados.length - 5]);
	        	String matricula = removEspacoIniFim(pdfDados[pdfDados.length - 6]);
	        	String contratante = "";
	        
	            for(int j = 0; j < (pdfDados.length - 6); j++) {
	            	contratante = contratante.concat(" "+pdfDados[j]);
	            }
	            
	            contratante = removEspacoIniFim(contratante);
	            ConsignadoBB consig = new ConsignadoBB(contratante, matricula, operacao, valorParcela, consignado, 0, 0, sequencia, cpf);
	            
	            consignadosA.add(consig);
	    	}
	    }
	    
	    document.close();
	    ConsignadoBB[] consignadosV = new ConsignadoBB[consignadosA.size()];
	    return consignadosA.toArray(consignadosV);
	}
	
	private ConsignadoBra[] convertArqConsigBra(File arquivo, int inicioAposPag1, int inicioApos, int fimAntes) throws IOException {
        PDDocument document = PDDocument.load(arquivo);
        PDFTextStripper stripper = new PDFTextStripper();
        int inicio = inicioAposPag1;
        ArrayList<ConsignadoBra> consignadosA = new ArrayList<ConsignadoBra>();
            
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
               		String ctCliente = ControlDiff.removEspacoIniFim(pdfDados[pdfDados.length - 1]);
               		String agCliente = ControlDiff.removEspacoIniFim(pdfDados[pdfDados.length - 2]);
               		String parcelas = ControlDiff.removEspacoIniFim(pdfDados[pdfDados.length - 4]);
               		String cpf = ControlDiff.removEspacoIniFim(pdfDados[pdfDados.length - 5]);
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
    	           		/*Trantamento da possibilidade da linha do consignado ter mais
    	           		 *substrings iguais a "não" exibindo a linha e encerrando o programa.
    	           		 */
    	           		try {
    	           			String contendoMotivo[] = pdfDadosE[1].split(" ");
    	           			for(int j = 2; j < (contendoMotivo.length - 6); j++) {
    			            	motivo = ControlDiff.removEspacoIniFim(motivo.concat(" "+contendoMotivo[j]));
    			            }
    	            		
    	            		valorConsignado = Double.parseDouble(formatParaConversDecimal(contendoMotivo[1]));
    		            	consignacao = convertParaBoolean("Não");
    		            	String semMotivo[] = pdfDadosE[0].split(" ");
    		            	valorParcela = Double.parseDouble(formatParaConversDecimal(semMotivo[semMotivo.length - 1]));
    		            	
    		            	for(int j = 3; j < (semMotivo.length - 2); j++) {
    		            		nome = ControlDiff.removEspacoIniFim(nome.concat(" "+semMotivo[j]));
    		            	}
    		            	matricula = ControlDiff.removEspacoIniFim(semMotivo[2]);
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
    		            	nome = ControlDiff.removEspacoIniFim(nome.concat(" "+pdfDados[j]));
    		            }
    		            
    		            matricula = ControlDiff.removEspacoIniFim(pdfDados[2]);
    	           	}
    	           	
    	          ConsignadoBra consig = new ConsignadoBra(nome, matricula, contrato, valorParcela, valorConsignado, Integer.parseInt(capturarParcelaAtual(parcelas)), Integer.parseInt(capturarTotalParcelas(parcelas)), consignacao, motivo, agCliente, ctCliente, cpf);
    	          consignadosA.add(consig);
    	          }
            }
            	
        }
           
        if(document != null) {
           	document.close();
        }
        
        ConsignadoBra[] consignadosV = new ConsignadoBra[consignadosA.size()];
        
        return consignadosA.toArray(consignadosV);
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
		return removEspacoIniFim(string);
	}
	
	public static boolean convertParaBoolean(String string) {
		string = removEspacoIniFim(string);
		boolean resultado = false;
		if(string.equals("Sim")) {
			resultado = true;
		}
		return resultado;
	}
	
	private String capturarParcelaAtual(String string) {
		string = removEspacoIniFim(string);
		return string.split("/")[0];
		
	}
	
	private String capturarTotalParcelas(String string) {
		string = removEspacoIniFim(string);
		return string.split("/")[1];
		
	}
	
	public ConsignadoBB[] concatVetores(ConsignadoBB[][] vetores) {
		int tamanho = 0;
		for(int i = 0; i < vetores.length; i++) {
			tamanho += vetores[i].length; 
		}
		ConsignadoBB[] novoVetor = new ConsignadoBB[tamanho];
		int i = 0;
		for(ConsignadoBB[] vt: vetores) {
			for(ConsignadoBB e: vt) {
				novoVetor[i] = e;
				i++;
			}
		}
		return novoVetor;
	}
}
