package consignado;

import auxiliar.EntradaDados;

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
	String parcelas) {
		this.setNome(EntradaDados.removEspacoIniFim(nome));
		this.setMatricula(EntradaDados.removEspacoIniFim(matricula));
		this.setIdConsignado(EntradaDados.removEspacoIniFim(idConsignado));
		this.setValorParcela(valorParcela);
		this.setValorConsignado(valorConsignado);
		this.setParcelaAtual(Integer.parseInt(EntradaDados.capturarParcelaAtual(parcelas)));
		this.setTotalParcelas(Integer.parseInt(EntradaDados.capturarTotalParcelas(parcelas)));
	}
	
	public Consignado(
	String nome, 
	String matricula, 
	String idConsignado, 
	String valorParcela, 
	String valorConsignado,
	String parcelas) {
		this.setNome(EntradaDados.removEspacoIniFim(nome));
		this.setMatricula(EntradaDados.removEspacoIniFim(matricula));
		this.setIdConsignado(EntradaDados.removEspacoIniFim(idConsignado));
		this.setValorParcela(Double.parseDouble(EntradaDados.formatParaConversDecimal(valorParcela)));
		this.setValorConsignado(Double.parseDouble(EntradaDados.formatParaConversDecimal(valorParcela)));
		this.setParcelaAtual(Integer.parseInt(EntradaDados.capturarParcelaAtual(parcelas)));
		this.setTotalParcelas(Integer.parseInt(EntradaDados.capturarTotalParcelas(parcelas)));
	}
	
	public int obterRestoParcelas() {
		return totalParcelas - (parcelaAtual - 1);
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
