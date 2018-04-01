package br.marcos.relatconsignados;

public class Consignado {
	private String nome;
	private String matricula;
	private String idConsignado;
	private double valorParcela;
	private double valorConsignado;
	private int parcelaAtual;
	private int totalParcelas;
	/*sequencia a ser criada nas subclasse*/
	//private int sequencia;
	/*cpf a ser criado nas subclasses*/
	//private String cpf;
	
	Consignado(
	String nome, 
	String matricula, 
	String idConsignado, 
	double valorParcela, 
	double valorConsignado,
	String parcelas) {
		this.setNome(ModString.removEspacoIniFim(nome));
		this.setMatricula(ModString.removEspacoIniFim(matricula));
		this.setIdConsignado(ModString.removEspacoIniFim(idConsignado));
		this.setValorParcela(valorParcela);
		this.setValorConsignado(valorConsignado);
		this.setParcelaAtual(Integer.parseInt(ModString.capturarParcelaAtual(parcelas)));
		this.setTotalParcelas(Integer.parseInt(ModString.capturarTotalParcelas(parcelas)));
	}
	
	public Consignado(
	String nome, 
	String matricula, 
	String idConsignado, 
	String valorParcela, 
	String valorConsignado,
	String parcelas) {
		this.setNome(ModString.removEspacoIniFim(nome));
		this.setMatricula(ModString.removEspacoIniFim(matricula));
		this.setIdConsignado(ModString.removEspacoIniFim(idConsignado));
		this.setValorParcela(Double.parseDouble(ModString.formatParaConversDecimal(valorParcela)));
		this.setValorConsignado(Double.parseDouble(ModString.formatParaConversDecimal(valorParcela)));
		this.setParcelaAtual(Integer.parseInt(ModString.capturarParcelaAtual(parcelas)));
		this.setTotalParcelas(Integer.parseInt(ModString.capturarTotalParcelas(parcelas)));
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
