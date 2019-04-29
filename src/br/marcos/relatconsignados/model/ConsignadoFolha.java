package br.marcos.relatconsignados.model;

public class ConsignadoFolha extends Consignado{
	private String cargo;
	
	public ConsignadoFolha(String nome, double valorParcela, String matricula) {
		super(nome, valorParcela, matricula);
	}

	public String getCargo() {
		return cargo;
	}

	@SuppressWarnings("unused")
	private void setCargo(String cargo) {
		this.cargo = cargo;
	}
}
