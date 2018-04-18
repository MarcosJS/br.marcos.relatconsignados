package br.marcos.relatconsignados.control;

import br.marcos.relatconsignados.model.Consignacoes;
import br.marcos.relatconsignados.model.Consignado;
import br.marcos.relatconsignados.model.ConsignadoBB;

public class DiffConsignacoes {
	public static final int CONSIG_ATUAL = 0;
	public static final int CONSIG_ANTERIOR = 1;
	
	private Consignacoes[] consignados;
	
	public DiffConsignacoes() {
		this.consignados = new Consignacoes[2];
	}
	
	public void carregarConsignacoesBB(ConsignadoBB[] consignados1, ConsignadoBB[] consignados2) {
		for(ConsignadoBB cB: consignados1) {
			consignados[DiffConsignacoes.CONSIG_ATUAL].addConsignado(cB);
		}
		for(ConsignadoBB cB: consignados2) {
			consignados[DiffConsignacoes.CONSIG_ANTERIOR].addConsignado(cB);
		}
	}
	
	public Consignado[] obterListConsignacoes(int i) {
		Consignado[] consignados = null;
		if(this.consignados[i].getQuantOperacoes() > 0) {
			consignados = this.consignados[i].getVetorConsignacoes();
		}
		return consignados;
	}
	
	public Consignado[] obterNovosConsignados() {
		Consignacoes consigs = new Consignacoes();
		for(Consignado atualC: this.consignados[DiffConsignacoes.CONSIG_ATUAL].getVetorConsignacoes()) {
			boolean existe = false;
			for(Consignado c: this.consignados[DiffConsignacoes.CONSIG_ANTERIOR].getVetorConsignacoes()) {
				if(c.getIdConsignado().equals(atualC.getIdConsignado())) {
					existe = true;
				}
			}
			if(!existe) {
				consigs.addConsignado(atualC);
			}
		}
		return consigs.getVetorConsignacoes();
	}
	
	public Consignado[] obterConsignadosExcluidos() {
		Consignacoes consigs = new Consignacoes();
		for(Consignado c: consignados[DiffConsignacoes.CONSIG_ANTERIOR].getVetorConsignacoes()) {
			boolean existe = false;
			for(Consignado thisC: this.consignados[DiffConsignacoes.CONSIG_ATUAL].getVetorConsignacoes()) {
				if(c.getIdConsignado().equals(thisC.getIdConsignado())) {
					existe = true;
				}
			}
			if(!existe) {
				consigs.addConsignado(c);
			}
		}
		return consigs.getVetorConsignacoes();
	}
	
	public Consignado[] obterInalterados() {
		Consignacoes consigsInalterados = new Consignacoes();
		for(Consignado c: this.consignados[DiffConsignacoes.CONSIG_ATUAL].getVetorConsignacoes()) {
			consigsInalterados.addConsignado(c);
		}
		
		for(Consignado c: this.obterNovosConsignados()) {
			consigsInalterados.removConsignado(c.getIdConsignado());
		}
		
		for(Consignado c: this.obterConsignadosExcluidos()) {
			consigsInalterados.removConsignado(c.getIdConsignado());
		}
		
		return consigsInalterados.getVetorConsignacoes();
	}
	
	public int getQuantOperacoes(int i) {
		return consignados[i].getQuantOperacoes();
	}
	
	
}
