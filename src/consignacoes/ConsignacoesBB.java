package consignacoes;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;

import auxiliar.EntradaDados;

import consignado.ConsignadoBB;

public class ConsignacoesBB extends Consignacoes {
	
	public ConsignacoesBB() {
		super();
	}
	
	public ConsignacoesBB(String arquivo1, int inicioApos1, int fimAntes1, String arquivo2, int inicioApos2, int fimAntes2) throws InvalidPasswordException, IOException {
		
		for(ConsignadoBB cB: EntradaDados.carregarConsignacoesBB(arquivo1, inicioApos1, fimAntes1)) {
			super.addConsignado(cB);
		}
			
		for(ConsignadoBB cB: EntradaDados.carregarConsignacoesBB(arquivo2, inicioApos2, fimAntes2)) {
			super.addConsignado(cB);
		}
	}
}
