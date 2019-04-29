package br.marcos.relatconsignados.model;

/**
 * @author marcos
 *
 */
public abstract class ConsignadoBanco extends Consignado {
	private String idConsignado;
	private double valorConsignado;
	private int parcelaAtual;
	private int totalParcelas;
	
	ConsignadoBanco(
	String nome, 
	double valorParcela, 
	String matricula, 
	String idConsignado, 
	double valorConsignado, 
	int parcelaAtual, 
	int totalParcelas) {
		super(nome, valorParcela, matricula);
		this.setIdConsignado(idConsignado);
		this.setValorConsignado(valorConsignado);
		this.setParcelaAtual(parcelaAtual);
		this.setTotalParcelas(totalParcelas);
	}
	
	public int obterRestoParcelas() {
		return totalParcelas - (parcelaAtual);
	}
	
	@Override
	public String toStringSimple() {
		String nome = String.format("%1$-33s", this.getNome());
		String valorConsignado = String.format("%1$8s", String.valueOf(this.getValorConsignado()));
		String valorParcela = String.format("%1$8s", String.valueOf(this.getValorParcela()));
		String parcelaAtual = String.format("%1$3s", String.valueOf(this.getParcelaAtual()));
		String totalParcelas = String.format("%1$3s", String.valueOf(this.getTotalParcelas()));
		return nome+" "+this.getIdConsignado()+" "+valorParcela+" "+valorConsignado+" "+parcelaAtual+" "+totalParcelas;
	}
	
	public String getIdConsignado() {
		return idConsignado;
	}

	private void setIdConsignado(String idConsignado) {
		this.idConsignado = idConsignado;
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
