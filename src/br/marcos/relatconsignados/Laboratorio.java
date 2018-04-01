package br.marcos.relatconsignados;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.File;
import java.io.IOException;
 
/**
 * Classe usada para teste de testes
 */
public final class Laboratorio {
	/*TESTE DA CLASSE ModString
	//Funcao removEspacoIniFim 
    String nome1 = "teste1    ";
    String nome2 = "  teste2   ";
    String nome3 = "   teste3";
    ModString m = new ModString();
    nome1 = m.removEspacoIniFim(nome1);//Teste da funcao removEspacoIniFim
    nome2 = ModString.removEspacoIniFim(nome2);
    nome3 = m.removEspacoIniFim(nome3);
    System.out.println("Teste da funcao removEspacoIniFim da Classe ModString");
    System.out.println("Nome1:"+nome1+",nome2:"+nome2+",nome3:"+nome3+".");
    
    //Funcao formatParaConvertDecimal
    String numero = "1.999.079,35";
    numero = ModString.formatParaConvertDecimal(numero);//teste da funcao formatParaConvertDecimal
    System.out.println(numero);
    */
	
	/*//Leitura do consignado bb
	document = PDDocument.load(new File(fileName));
    PDFTextStripper stripper = new PDFTextStripper();
    String pdfText = stripper.getText(document).toString();
    String pdfLinhas[] = pdfText.split("\n");
    int cont = 0;
    
    //System.out.println(pdfText);
    
    for(int i = 0; i < pdfLinhas.length; i++) {
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
            
          //System.out.print(contratante+" "+matricula+" "+operacao+" "+sequencia+" "+cpf+" "+valor+" "+consignado);
            
            //TESTE DA CLASSE ConsignadoBB
            ConsignadoBB consig = new ConsignadoBB(contratante, matricula, operacao, valor, consignado, parcelas, sequencia, cpf);
            System.out.println("Parcelas restante: "+consig.obterRestoParcelas()+" "+consig.getNome()+" "+consig.getMatricula()+" "+consig.getIdConsignado()+" "+consig.getSeqOperacao()+" "+consig.getCpf()+" "+consig.getValorParcela()+" "+consig.getValorConsignado());
     
        }
    }*/
	
    public static void main(String[] args) throws IOException {
        //String fileName = "/home/marcos/eclipse-workspace/br.marcos.relatconsignados/testepdfbox/consignadobb-jan/TO0326012018.pdf";
        String fileName = "/home/marcos/eclipse-workspace/br.marcos.relatconsignados/testepdfbox/consignadobra/jan.pdf";
        PDDocument document = null;
        
        //try {
            //Leitura do consignado bra
        	document = PDDocument.load(new File(fileName));
            PDFTextStripper stripper = new PDFTextStripper();
            String pdfText = stripper.getText(document).toString();
            String pdfLinhas[] = pdfText.split("\n");
            int cont = 0;
            int linhasPuladasIni = 10;
            
            //System.out.println(pdfText);
            
            for(int i = 0; i < pdfLinhas.length; i++) {//Define o intervalo de linhas lidas
            	String pdfDados[] = pdfLinhas[i].split(" ");
            	
            	if((i >= linhasPuladasIni) && ((!pdfDados[0].equals("Gerado")) && (!pdfDados[0].equals("Página")) && (!pdfDados[0].equals("Ag.")))) {//Define as linhas que serao puladas
            		//Gravacao dos dados da linha de tras pra frente
            		String ctCliente = pdfDados[pdfDados.length - 1];
            		String agCliente = pdfDados[pdfDados.length - 2];
            		String parcelas = pdfDados[pdfDados.length - 4];
            		String cpf = pdfDados[pdfDados.length - 5];
	            	String contrato = pdfDados[pdfDados.length - 6];
	            	String motivo = "";
	            	String valorConsignado = "";
	            	String consignacao = "";
	            	String valorParcela = "";
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
	            			//System.out.println("Tamando do valor nao consignado: "+contendoMotivo.length);
	            			for(int j = 2; j < (contendoMotivo.length - 6); j++) {
				            	motivo = motivo.concat(" "+contendoMotivo[j]);
				            }
		            		
		            		valorConsignado = contendoMotivo[1];
			            	consignacao = "Não";
			            	String semMotivo[] = pdfDadosE[0].split(" ");
			            	valorParcela = semMotivo[semMotivo.length - 1];
			            	
			            	for(int j = 3; j < (semMotivo.length - 2); j++) {
			            		nome = nome.concat(" "+semMotivo[j]);
			            	}
			            	matricula = semMotivo[2];
	            		} catch(Exception e) {
	            			System.out.println(pdfDadosE);
	            			document.close();
	            			System.exit(0);
	            		}
	            		
	            	} else {
	            		//Continuação do fluxo caso haja consignacao
	            		valorConsignado = pdfDados[pdfDados.length - 7];
	            		consignacao = pdfDados[pdfDados.length - 9];
	            		valorParcela = pdfDados[pdfDados.length - 10];
	            		
			            for(int j = 3; j < (pdfDados.length - 11); j++) {
			            	nome = nome.concat(" "+pdfDados[j]);
			            }
			            
			            matricula = pdfDados[2];
	            	}
	            	
		            cont++;
		            
		          //System.out.println(nome+" "+matricula+" "+contrato+" "+valorParcela+" "+valorConsignado+" "+parcelas+" "+consignacao+" "+motivo+" "+agCliente+" "+ctCliente+" "+cpf);
		            
		            //TESTE DA CLASSE ConsignadoBra
		            ConsignadoBra consig = new ConsignadoBra(nome, matricula, contrato, valorParcela, valorConsignado, parcelas, consignacao, motivo, agCliente, ctCliente, cpf);
		            System.out.println("Parcelas restante: "+
		            consig.obterRestoParcelas()+" "+
		            	consig.getNome()+" "+
		            consig.getMatricula()+" "+
		            	consig.getIdConsignado()+" "+
		            consig.getValorParcela()+" "+
		            	consig.getValorConsignado()+" "+
		            consig.getParcelaAtual()+" "+
		            	consig.getTotalParcelas()+" "+
		            consig.getConsig()+" "+
		            	consig.getMotivo()+" "+
		            consig.getAgCliente()+" "+
		            	consig.getCtCliente()+" "+
		            consig.getCpf());
		            
	            }
            }
            System.out.println("Operacoes: "+cont);
            
        //finally {
            if(document != null) {
            	document.close();
            }
        //}
       
    }
}
