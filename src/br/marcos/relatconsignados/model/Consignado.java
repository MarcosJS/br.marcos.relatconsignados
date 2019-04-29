package br.marcos.relatconsignados.model;

public abstract class Consignado {
	private String nome;
	private String matricula;
	private double valorParcela;
	
	Consignado(String nome, double valorParcela, String matricula) {
		this.setNome(nome);
		this.setMatricula(matricula);
		this.setValorParcela(valorParcela);
	}
	
	public String toStringSimple() {
		String nome = String.format("%1$-33s", this.getNome());
		String valorParcela = String.format("%1$8s", String.valueOf(this.getValorParcela()));
		return nome+" "+valorParcela;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Consignado))
			return false;
		Consignado other = (Consignado) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(valorParcela) != Double.doubleToLongBits(other.valorParcela))
			return false;
		/*System.out.println(nome+" =? "+other.nome);
		System.out.println(Double.doubleToLongBits(valorParcela)+" =? "+Double.doubleToLongBits(other.valorParcela));
		System.out.println(valorParcela+" =? "+other.valorParcela);
		System.out.println(this.getClass()+" =? "+other.getClass());*/
		return true;
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

	public double getValorParcela() {
		return valorParcela;
	}

	private void setValorParcela(double valorParcela) {
		this.valorParcela = valorParcela;
	}
}
