package br.marcos.relatconsignados;

import consignacoes.ConsignacoesBB;
import consignado.ConsignadoBra;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;

import auxiliar.SaidaDados;
 
/**
 * Classe usada para testes
 */
public final class Laboratorio {
	public static void main(String[] args) throws InvalidPasswordException, IOException {
    	String arquivo = "c:/workspace/br.marcos.relatconsignados/testepdfbox/consignadobb/bbmar1.pdf";
        String arquivo2 = "c:/workspace/br.marcos.relatconsignados/testepdfbox/consignadobb/bbmar2.pdf";
        String arquivo3 = "c:/workspace/br.marcos.relatconsignados/testepdfbox/consignadobb/bbfev1.pdf";
        String arquivo4 = "c:/workspace/br.marcos.relatconsignados/testepdfbox/consignadobb/bbfev2.pdf";
        ConsignacoesBB consi = new ConsignacoesBB(arquivo, 7, 6, arquivo2, 7, 5);
        ConsignacoesBB consi2 = new ConsignacoesBB(arquivo3, 7, 6, arquivo4, 7, 5);
        
        System.out.println("Novos consignados: ");
        SaidaDados.imprimirConsignados(consi.obterNovos(consi2).getListConsignacoes());
                    
      }
}
