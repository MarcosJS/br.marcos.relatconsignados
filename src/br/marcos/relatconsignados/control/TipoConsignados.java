package br.marcos.relatconsignados.control;

public enum TipoConsignados {
	REFERENCIA(0, "CONSIGNADOS DE REFER�NCIA"), 
	AMOSTRA(1, "CONSIGNADOS DA AMOSTRA"), 
	NOVOS(2, "NOVOS CONSIGNADOS"), 
	EXCLUIDOS(3, "CONSIGNADOS EXCLU�DOS"), 
	INALTERADOS(4, "CONSIGNADOS INALTERADOS");
	
	private int valor;
	String descricao;
	
	TipoConsignados(int valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}

	/**
	 * @return the valor
	 */
	public int getValor() {
		return valor;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	
	
}
