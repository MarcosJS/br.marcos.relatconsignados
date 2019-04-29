package br.marcos.relatconsignados.model;

public class ConsignadoBB extends ConsignadoBanco{
	private int seqOperacao;
	private String cpf;
	private String idConsignado;
	
	public ConsignadoBB(String nome, String matricula, String idConsignado, double valorParcela, double valorConsignado, int seqOperacao, String cpf) {
		super(nome, valorParcela, matricula, idConsignado, valorConsignado, 0, 0);
		this.setSeqOperacao(seqOperacao);
		this.setCpf(cpf);
		this.setIdConsignado(idConsignado);
	}
	
	@Override
	public String toStringSimple() {
		return "["+super.toStringSimple()+" "+this.getCpf()+"]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Consignado))
			return false;
		if ((obj instanceof ConsignadoBra))
			return false;
		if ((obj instanceof ConsignadoFolha))
			return super.equals(obj);
		ConsignadoBB other = (ConsignadoBB) obj;
		if (idConsignado == null) {
			if (other.idConsignado != null)
				return false;
		} else if (!idConsignado.equals(other.idConsignado))
			return false;
		return true;
	}

	public int getSeqOperacao() {
		return seqOperacao;
	}

	private void setSeqOperacao(int seqOperacao) {
		this.seqOperacao = seqOperacao;
	}

	public String getCpf() {
		return cpf;
	}

	private void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return the idConsignado
	 */
	public String getIdConsignado() {
		return idConsignado;
	}

	/**
	 * @param idConsignado the idConsignado to set
	 */
	private void setIdConsignado(String idConsignado) {
		this.idConsignado = idConsignado;
	}
	
}
