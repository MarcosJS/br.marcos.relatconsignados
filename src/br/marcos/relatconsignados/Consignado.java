package br.marcos.relatconsignados;

public class Consignado {
	private String contratante;
	private String matricula;
	private String operacao;
	private int sequencia;
	private String cpf;
	private double valorParcela;
	private double valorConsignado;
	
	Consignado(
	String contratante, 
	String matricula, 
	String operacao, 
	int sequencia,
	String cpf, 
	double valorParcela, 
	double valorConsignado) {
		this.setContratante(ModString.removEspacoIniFim(contratante));
		this.setMatricula(ModString.removEspacoIniFim(matricula));
		this.setOperacao(ModString.removEspacoIniFim(operacao));
		this.setSequencia(sequencia);
		this.setCpf(ModString.removEspacoIniFim(cpf));
		this.setValorParcela(valorParcela);
		this.setValorConsignado(valorConsignado);
	}
	
	public Consignado(
	String contratante, 
	String matricula, 
	String operacao, 
	String sequencia,
	String cpf, 
	String valorParcela, 
	String valorConsignado) {
		this.setContratante(ModString.removEspacoIniFim(contratante));
		this.setMatricula(ModString.removEspacoIniFim(matricula));
		this.setOperacao(ModString.removEspacoIniFim(operacao));
		this.setSequencia(Integer.parseInt(sequencia));
		this.setCpf(ModString.removEspacoIniFim(cpf));
		this.setValorParcela(Double.parseDouble(ModString.formatParaConvertDecimal(valorParcela)));
		this.setValorConsignado(Double.parseDouble(ModString.formatParaConvertDecimal(valorParcela)));
	}

	public String getContratante() {
		return contratante;
	}

	public void setContratante(String contratante) {
		this.contratante = contratante;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public int getSequencia() {
		return sequencia;
	}

	public void setSequencia(int sequencia) {
		this.sequencia = sequencia;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(double valorParcela) {
		this.valorParcela = valorParcela;
	}

	public double getValorConsignado() {
		return valorConsignado;
	}

	public void setValorConsignado(double valorConsignado) {
		this.valorConsignado = valorConsignado;
	}
}
