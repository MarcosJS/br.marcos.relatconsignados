package br.marcos.relatconsignados.control;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;

import br.marcos.relatconsignados.model.Consignado;
import br.marcos.relatconsignados.model.ConsignadoBB;

public class ControlDiff {
	public static int CONSIG_ATUAL = DiffConsignacoes.CONSIG_ATUAL;
	public static int CONSIG_ANTERIOR = DiffConsignacoes.CONSIG_ANTERIOR;
	public static int BANCO_BRASIL = 1;
	public static int BRADESCO = 2;
	private DiffConsignacoes bancoBrasil;
	private DiffConsignacoes bradesco;
	
	public void carregarConsignacoesBB(File[] arquivo, int[] inicioApos, int[] fimAntes) throws InvalidPasswordException, IOException {
		ConsignadoBB[][] vetorConsignados1 = {this.convertArqConsigBB(arquivo[0], inicioApos[0], fimAntes[0]), this.convertArqConsigBB(arquivo[1], inicioApos[1], fimAntes[1])};
		ConsignadoBB[][] vetorConsignados2 = {this.convertArqConsigBB(arquivo[2], inicioApos[2], fimAntes[2]), this.convertArqConsigBB(arquivo[3], inicioApos[3], fimAntes[3])};
		this.bancoBrasil.carregarConsignacoesBB(this.concatVetores(vetorConsignados1), this.concatVetores(vetorConsignados2));
	}
	
	public String[] obterListaConsignacoes(int tipoConsignado, int ordem) {
		String[] consignacoes = null;
		if(tipoConsignado == ControlDiff.BANCO_BRASIL) {
			consignacoes = new String[bancoBrasil.getQuantOperacoes(ordem)];
			int i = 0;
			for(Consignado cB: this.bancoBrasil.obterListConsignacoes(ordem)) {
				String linha = new String();
				consignacoes[i] = linha.concat(String.format("%1$-30s", cB.getNome())+" "+String.format("%1$11s", cB.getMatricula())+" "+cB.getIdConsignado()+" "+((ConsignadoBB) cB).getSeqOperacao()+" "+((ConsignadoBB) cB).getCpf()+" "+String.format("%1$10s", String.valueOf(cB.getValorParcela()))+" "+String.format("%1$10s", String.valueOf(cB.getValorConsignado())));
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
				String linha = new String();
				consignacoes[i] = linha.concat(String.format("%1$-30s", cB.getNome())+" "+String.format("%1$11s", cB.getMatricula())+" "+cB.getIdConsignado()+" "+((ConsignadoBB) cB).getSeqOperacao()+" "+((ConsignadoBB) cB).getCpf()+" "+String.format("%1$10s", String.valueOf(cB.getValorParcela()))+" "+String.format("%1$10s", String.valueOf(cB.getValorConsignado())));
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
				String linha = new String();
				consignacoes[i] = linha.concat(String.format("%1$-30s", cB.getNome())+" "+String.format("%1$11s", cB.getMatricula())+" "+cB.getIdConsignado()+" "+((ConsignadoBB) cB).getSeqOperacao()+" "+((ConsignadoBB) cB).getCpf()+" "+String.format("%1$10s", String.valueOf(cB.getValorParcela()))+" "+String.format("%1$10s", String.valueOf(cB.getValorConsignado())));
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
				String linha = new String();
				consignacoes[i] = linha.concat(String.format("%1$-30s", cB.getNome())+" "+String.format("%1$11s", cB.getMatricula())+" "+cB.getIdConsignado()+" "+((ConsignadoBB) cB).getSeqOperacao()+" "+((ConsignadoBB) cB).getCpf()+" "+String.format("%1$10s", String.valueOf(cB.getValorParcela()))+" "+String.format("%1$10s", String.valueOf(cB.getValorConsignado())));
				i++;
			}
		}
		return consignacoes;
	}
	
	//Funções auxiliares
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
	
	public static String capturarParcelaAtual(String string) {
		string = removEspacoIniFim(string);
		return string.split("/")[0];
		
	}
	
	public static String capturarTotalParcelas(String string) {
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
