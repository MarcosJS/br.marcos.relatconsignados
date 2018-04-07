package consignado;

import auxiliar.EntradaDados;

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
	String parcelas,
	boolean consig,
	String motivo,
	String agCliente,
	String ctCliente,
	String cpf) {
		super(nome, matricula, idConsignado, valorParcela, valorConsignado, parcelas);
		this.setConsig(consig);
		this.setMotivo(EntradaDados.removEspacoIniFim(motivo));
		this.setAgCliente(agCliente);
		this.setCtCliente(ctCliente);
		this.setCpf(cpf);
	}
	
	public ConsignadoBra(
	String nome, 
	String matricula, 
	String idConsignado, 
	String valorParcela, 
	String valorConsignado,
	String parcelas,
	String consig,
	String motivo,
	String agCliente,
	String ctCliente,
	String cpf) {
		super(nome, matricula, idConsignado, valorParcela, valorConsignado, parcelas);
		this.setConsig(EntradaDados.convertParaBoolean(consig));
		this.setMotivo(EntradaDados.removEspacoIniFim(motivo));
		this.setAgCliente(agCliente);
		this.setCtCliente(ctCliente);
		this.setCpf(cpf);
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
