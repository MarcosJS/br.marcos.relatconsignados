package br.marcos.relatconsignados.model.colaborador;

import java.util.Arrays;

public class Colaborador {
	
	private String[] dados = new String[6];
	
	public Colaborador(
	String matricula, 
	String nome, 
	String dataAdmissao, 
	String cargo, 
	String ctps, 
	String cpf) {
		dados[Campo.MATRICULA.getValor()] = matricula;
		dados[Campo.NOME.getValor()] = nome;
		dados[Campo.DATA_ADMISSAO.getValor()] = dataAdmissao;
		dados[Campo.CARGO.getValor()] = cargo;
		dados[Campo.CTPS.getValor()] = ctps;
		dados[Campo.CPF.getValor()] = cpf;
	}
	
	public Colaborador(Campo campo, String dado) {
		dados[campo.getValor()] = dado;
	}

	@Override
	public String toString() {
		return "Colaborador [dados=" + Arrays.toString(dados) + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Colaborador))
			return false;
		Colaborador other = (Colaborador) obj;
		if (dados[Campo.MATRICULA.getValor()] == null) {
			if (other.getDados()[Campo.MATRICULA.getValor()] != null)
				return false;
		} else if (!dados[Campo.MATRICULA.getValor()].equals(other.getDados()[Campo.MATRICULA.getValor()]))
			return false;
		return true;
	}

	/**
	 * @return the dados
	 */
	public String[] getDados() {
		return dados;
	}
}