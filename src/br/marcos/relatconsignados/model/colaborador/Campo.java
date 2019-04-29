package br.marcos.relatconsignados.model.colaborador;

public enum Campo {
	MATRICULA(0), NOME(1), DATA_ADMISSAO(2), CARGO(3), CTPS(4), CPF(5);
	private int valor;
	
	Campo(int valor){
		this.valor = valor;
	}
	
	/**
	 * @return the valor
	 */
	public int getValor() {
		return valor;
	}
}
