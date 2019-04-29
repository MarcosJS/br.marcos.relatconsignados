package br.marcos.relatconsignados.model;

import java.util.ArrayList;

public class Consignacoes {
	private String dataRepasse;
	private double valorRepasse;
	private ArrayList<Consignado> consignados;
	
	public Consignacoes() {
		this.consignados = new ArrayList<Consignado>();
		this.setDataRepasse(null);
		this.setValorRepasse(0);
	}
	
	public void adicionarConsignado(Consignado novoConsignado) {
		if((consignados != null) && (!this.existeConsignado(novoConsignado))) {
			this.consignados.add(novoConsignado);
		}
	}
	
	public void removerConsignado(Consignado consignadoAlvo) {
		if(!this.consignados.remove(consignadoAlvo)) {
			System.out.println("!!!!!!!!!! ERRO Consignacoes: linha 20!!!!!!!!!");
		}
	}
	
	public Consignado obterConsignado(Consignado consignadoProcurado) {
		Consignado consig = null;
		for(Consignado c: this.getVetorConsignacoes()) {
			if(c.equals(consignadoProcurado)) {
				consig = c;
				break;
			}
		}
		return consig;
	}
	
	public boolean existeConsignado(Consignado consignado) {
		return consignados.contains(consignado);
	}
	
	public Consignado[]  getVetorConsignacoes() {
		Consignado[] consigs = new Consignado[this.consignados.size()];
		for(int i = 0; i < this.consignados.size(); i++) {
			consigs[i] = this.consignados.get(i);
		}
		return consigs;
	}
	
	public int getQuantOperacoes() {
		return consignados.size();
	}
	public String getDataRepasse() {
		return dataRepasse;
	}
	public void setDataRepasse(String dataRepasse) {
		this.dataRepasse = dataRepasse;
	}
	public double getValorRepasse() {
		return valorRepasse;
	}
	public void setValorRepasse(double valorRepasse) {
		this.valorRepasse = valorRepasse;
	}
		
}
