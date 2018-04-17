package consignado;

public class ConsignadoBB extends Consignado{
	private int seqOperacao;
	private String cpf;
	
	public ConsignadoBB(
	String nome, 
	String matricula, 
	String idConsignado, 
	double valorParcela, 
	double valorConsignado,
	int parcelaAtual,
	int totalParcelas,
	int seqOperacao,
	String cpf) {
		super(nome, matricula, idConsignado, valorParcela, valorConsignado, parcelaAtual, totalParcelas);
		this.setSeqOperacao(seqOperacao);
		this.setCpf(cpf);
	}
	
	public int obterRestoParcelas() {
		int resto = super.obterRestoParcelas();
		if((super.getParcelaAtual() == 0) || (super.getTotalParcelas() == 0)) {
			resto = 0;
		}
		return resto;
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
}
