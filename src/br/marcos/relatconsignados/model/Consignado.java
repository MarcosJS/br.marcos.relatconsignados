package br.marcos.relatconsignados.model;

public class Consignado {
	private String nome;
	private String matricula;
	private String idConsignado;
	private double valorParcela;
	private double valorConsignado;
	private int parcelaAtual;
	private int totalParcelas;
	
	Consignado(
	String nome, 
	String matricula, 
	String idConsignado, 
	double valorParcela, 
	double valorConsignado,
	int parcelaAtual,
	int totalParcelas) {
		this.setNome(nome);
		this.setMatricula(matricula);
		this.setIdConsignado(idConsignado);
		this.setValorParcela(valorParcela);
		this.setValorConsignado(valorConsignado);
		this.setParcelaAtual(parcelaAtual);
		this.setTotalParcelas(totalParcelas);
	}
	
	public int obterRestoParcelas() {
		return totalParcelas - (parcelaAtual - 1);
	}
	
	public String toStringSimple() {
		String nome = String.format("%1$-33s", this.getNome());
		String valorConsignado = String.format("%1$8s", String.valueOf(this.getValorConsignado()));
		String valorParcela = String.format("%1$8s", String.valueOf(this.getValorParcela()));
		String parcelaAtual = String.format("%1$3s", String.valueOf(this.getParcelaAtual()));
		String totalParcelas = String.format("%1$3s", String.valueOf(this.getTotalParcelas()));
		return nome+" "+this.getIdConsignado()+" "+valorParcela+" "+valorConsignado+" "+parcelaAtual+" "+totalParcelas;
	}

	public String getNome() {
		return nome;
	}

	private void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	private void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getIdConsignado() {
		return idConsignado;
	}

	private void setIdConsignado(String idConsignado) {
		this.idConsignado = idConsignado;
	}

	public double getValorParcela() {
		return valorParcela;
	}

	private void setValorParcela(double valorParcela) {
		this.valorParcela = valorParcela;
	}

	public double getValorConsignado() {
		return valorConsignado;
	}

	private void setValorConsignado(double valorConsignado) {
		this.valorConsignado = valorConsignado;
	}

	public int getParcelaAtual() {
		return parcelaAtual;
	}

	private void setParcelaAtual(int parcelaAtual) {
		this.parcelaAtual = parcelaAtual;
	}

	public int getTotalParcelas() {
		return totalParcelas;
	}

	private void setTotalParcelas(int totalParcelas) {
		this.totalParcelas = totalParcelas;
	}
}
