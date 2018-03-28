package br.marcos.relatconsigados;

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
		this.setContratante(contratante.substring(1));
		this.setMatricula(matricula);
		this.setOperacao(operacao);
		this.setSequencia(sequencia);
		this.setCpf(cpf);
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
		if(contratante.charAt(0) == ' ') {
			contratante = contratante.substring(1);
		}
		if(contratante.charAt(contratante.length() - 1) == ' ')
		this.setContratante(contratante.substring(1));
		this.setMatricula(matricula);
		this.setOperacao(operacao);
		this.setSequencia(Integer.parseInt(sequencia));
		this.setCpf(cpf);
		this.setValorParcela(Double.parseDouble(valorParcela.replaceFirst(",", ".")));
		this.setValorConsignado(Double.parseDouble(valorConsignado.replaceFirst(",", ".")));
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
