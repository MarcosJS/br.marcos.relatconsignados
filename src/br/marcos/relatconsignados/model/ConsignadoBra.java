package br.marcos.relatconsignados.model;

public class ConsignadoBra extends Consignado{
	private boolean consig;
	private String motivo;
	private String agCliente;
	private String ctCliente;
	private String cpf;
	
	public ConsignadoBra(
	String nome, 
	String matricula, 
	String idConsignado, 
	double valorParcela, 
	double valorConsignado,
	int parcelaAtual,
	int totalParcelas,
	boolean consig,
	String motivo,
	String agCliente,
	String ctCliente,
	String cpf) {
		super(nome, matricula, idConsignado, valorParcela, valorConsignado, parcelaAtual, totalParcelas);
		this.setConsig(consig);
		this.setMotivo(motivo);
		this.setAgCliente(agCliente);
		this.setCtCliente(ctCliente);
		this.setCpf(cpf);
	}
	
	@Override
	public String toStringSimple() {
		String motivo = String.format("%1$20s", String.valueOf(this.getMotivo()));
		return "["+super.toStringSimple()+" "+this.getCpf()+" "+convertParaString(this.getConsig())+" "+motivo+"]";
	}

	private String convertParaString(boolean b) {
		String resultado = null;
		if(b) {
			resultado = "sim";
		} else if(!b){
			resultado = "não";
		}
		return resultado;
	}

	public String getCpf() {
		return cpf;
	}

	private void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public boolean getConsig() {
		return consig;
	}

	private void setConsig(boolean consig) {
		this.consig = consig;
	}

	public String getMotivo() {
		return motivo;
	}

	private void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getAgCliente() {
		return agCliente;
	}

	private void setAgCliente(String agCliente) {
		this.agCliente = agCliente;
	}

	public String getCtCliente() {
		return ctCliente;
	}

	private void setCtCliente(String ctCliente) {
		this.ctCliente = ctCliente;
	}	
}
