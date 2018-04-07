package consignacoes;

public class ConsignacoesBra {

	/*PDDocument document = null;
    
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
            	if(pdfLinhas[i].contains("N�O")) {
            		String pdfDadosE[] = pdfLinhas[i].split(" N�O ");
            		/*Trantamento da possibilidade da linha do consignado ter mais
            		 *substrings iguais a "não" exibindo a linha e encerrando o programa.
            		 */
            		/*try {
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
        System.out.println("Operacoes: "+cont);*/
}
