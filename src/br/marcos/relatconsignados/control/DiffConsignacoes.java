package br.marcos.relatconsignados.control;

import br.marcos.relatconsignados.model.Consignacoes;
import br.marcos.relatconsignados.model.Consignado;

public class DiffConsignacoes {
	private Consignacoes[] consignados;
	
	/**
	 * @param quantidade define a quantidade de consignacoes a serem comparadas
	 * */
	public DiffConsignacoes(int quantidade) {
		this.consignados = new Consignacoes[quantidade];
		for(int i = 0; i < quantidade; i++) {
			this.consignados[i] = new Consignacoes();
		}
	}
	
	public void adicionarConsignado(Consignado consignado, int prioridade) {
		consignados[prioridade].adicionarConsignado(consignado);
	}
	
	public void realizarDiff() {
		this.obterNovos();
		this.obterExcluidos();
		this.obterInalterados();
	}
	
	public Consignado[] obterListaConsignacoes(TipoConsignados tipoConsignado) {
		Consignado[] consig = null;
		if(this.consignados[tipoConsignado.getValor()].getQuantOperacoes() > 0) {
			consig = this.consignados[tipoConsignado.getValor()].getVetorConsignacoes();
		} else {
			System.out.println("!!!!!!!!!!!!!!!!!!!! erro na linha 58 - DiffConsignacoes !!!!!!!!!!!!!!!!!!");
		}
		return consig;
	}
	
	//public Consignado[] obterNovosConsignados() {
	public void obterNovos() {
		Consignacoes consigs = new Consignacoes();
		for(Consignado atualC: this.consignados[TipoConsignados.REFERENCIA.getValor()].getVetorConsignacoes()) {
			boolean existe = false;
			for(Consignado c: this.consignados[TipoConsignados.AMOSTRA.getValor()].getVetorConsignacoes()) {
				/*if(c.getIdConsignado().equals(atualC.getIdConsignado())) {
					existe = true;
				}*/
				if(c.equals(atualC)) {
					existe = true;
					System.out.println("existe: "+existe);
				}
			}
			if(!existe) {
				//System.out.println("existe: "+existe+" ->"+atualC.toStringSimple());
				consigs.adicionarConsignado(atualC);
			}
		}
		this.consignados[TipoConsignados.NOVOS.getValor()] = consigs;
		//return consigs.getVetorConsignacoes();
	}
	
	//public Consignado[] obterConsignadosExcluidos() {
	public void obterExcluidos() {
		Consignacoes consigs = new Consignacoes();
		for(Consignado c: consignados[TipoConsignados.AMOSTRA.getValor()].getVetorConsignacoes()) {
			boolean existe = false;
			for(Consignado thisConsignado: this.consignados[TipoConsignados.REFERENCIA.getValor()].getVetorConsignacoes()) {
				if(c.equals(thisConsignado)) {
					existe = true;
				}
			}
			if(!existe) {
				consigs.adicionarConsignado(c);
			}
		}
		this.consignados[TipoConsignados.EXCLUIDOS.getValor()] = consigs;
		//return consigs.getVetorConsignacoes();
	}
	
	//public Consignado[] obterInalterados() {
	public void obterInalterados() {
		Consignacoes consigsInalterados = new Consignacoes();
		for(Consignado c: this.consignados[TipoConsignados.REFERENCIA.getValor()].getVetorConsignacoes()) {
			consigsInalterados.adicionarConsignado(c);
		}
		
		//for(Consignado consignado: this.obterNovosConsignados()) {
		for(Consignado consignado: this.consignados[TipoConsignados.NOVOS.getValor()].getVetorConsignacoes()) {
			consigsInalterados.removerConsignado(consignado);
		}
		
		//for(Consignado consignado: this.obterConsignadosExcluidos()) {
		for(Consignado consignado: this.consignados[TipoConsignados.NOVOS.getValor()].getVetorConsignacoes()) {
			consigsInalterados.removerConsignado(consignado);
		}
		
		this.consignados[TipoConsignados.INALTERADOS.getValor()] = consigsInalterados;
		//return consigsInalterados.getVetorConsignacoes();
	}
	
	public int getQuantOperacoes(TipoConsignados tipoConsignados) {
		return consignados[tipoConsignados.getValor()].getQuantOperacoes();
	}
}
