package br.marcos.relatconsignados;

import java.util.ArrayList;

public class Consignacoes {
	private int quantOperacoes;
	private String dataRepasse;
	private double valorRepasse;
	private ArrayList<Consignado> consigados;
	
	Consignacoes(int quantOp, String dataRepasse, double valorRepasse, Consignado[] consig) {
		this.setQuantOperacoes(quantOp);
		this.setDataRepasse(dataRepasse);
		this.setValorRepasse(valorRepasse);
		for(Consignado c: consig) {
			this.consigados.add(c);
		}
	}
	
	public int getQuantOperacoes() {
		return quantOperacoes;
	}
	public void setQuantOperacoes(int quantOperacoes) {
		this.quantOperacoes = quantOperacoes;
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
