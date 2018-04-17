package consignacoes;

import java.util.ArrayList;

import consignado.Consignado;

public class Consignacoes {
	private int quantOperacoes;
	private String dataRepasse;
	private double valorRepasse;
	private ArrayList<Consignado> consignados;
	
	public Consignacoes() {
		this.consignados = new ArrayList<Consignado>();
		this.setQuantOperacoes(consignados.size());
		this.setDataRepasse(null);
		this.setValorRepasse(0);
	}
	
	public Consignacoes obterNovos(Consignacoes consignacoes) {
		Consignacoes consigs = new Consignacoes();
		for(Consignado thisC: this.getListConsignacoes()) {
			boolean existe = false;
			for(Consignado c: consignacoes.getListConsignacoes()) {
				if(c.getIdConsignado().equals(thisC.getIdConsignado())) {
					existe = true;
				}
			}
			if(!existe) {
				consigs.addConsignado(thisC);
			}
		}
		return consigs;
	}
	
	public Consignacoes obterExcluidos(Consignacoes consignacoes) {
		Consignacoes consigs = new Consignacoes();
		for(Consignado c: consignacoes.getListConsignacoes()) {
			boolean existe = false;
			for(Consignado thisC: this.getListConsignacoes()) {
				if(c.getIdConsignado().equals(thisC.getIdConsignado())) {
					existe = true;
				}
			}
			if(!existe) {
				consigs.addConsignado(c);
			}
		}
		return consigs;
	}
	
	public Consignacoes obterInalterados(Consignacoes consignacoes) {
		Consignacoes consigsInalterados = new Consignacoes();
		for(Consignado c: this.getListConsignacoes()) {
			consigsInalterados.addConsignado(c);
		}
		Consignacoes consigsNovos = this.obterNovos(consignacoes);
		Consignacoes consigsExcluidos = this.obterExcluidos(consignacoes);
		
		for(Consignado c: consigsNovos.getListConsignacoes()) {
			consigsInalterados.removConsignado(c.getIdConsignado());
		}
		
		for(Consignado c: consigsExcluidos.getListConsignacoes()) {
			consigsInalterados.removConsignado(c.getIdConsignado());
		}
		
		return consigsInalterados;
	}
	
	public void addConsignado(Consignado c) {
		if((consignados != null) && (!this.consultarConsignado(c.getIdConsignado()))) {
			this.consignados.add(c);
			this.setQuantOperacoes(this.getQuantOperacoes() + 1);
			//System.out.println("adicionando: "+c.obterRestoParcelas()+" "+c.getNome()+" "+c.getMatricula()+" "+c.getIdConsignado()+" "+c.getValorParcela()+" "+c.getValorConsignado());
		}
	}
	
	public void removConsignado(String idConsignado) {
		for(Consignado c: this.getListConsignacoes()) {
			if(c.getIdConsignado().equals(idConsignado)) {
				int i = this.consignados.indexOf(c);
				this.consignados.remove(i);
				break;
			}
		}
	}
	
	public Consignado obterConsignado(String idConsignado) {
		Consignado consig = null;
		for(Consignado c: this.getListConsignacoes()) {
			if(c.getIdConsignado().equals(idConsignado)) {
				consig = c;
				break;
			}
		}
		return consig;
	}
	
	public boolean consultarConsignado(String idConsignado) {
		boolean resultado = false;
		if(consignados != null) {
			for(Consignado c: this.getListConsignacoes()) {
				if(c.getIdConsignado().equals(idConsignado)) {
					resultado = true;
					break;
				}
			}
		}
		return resultado;
	}
	
	public Consignado[]  getListConsignacoes() {
		Consignado[] consigs = new Consignado[this.consignados.size()];
		for(int i = 0; i < this.consignados.size(); i++) {
			consigs[i] = this.consignados.get(i);
		}
		return consigs;
	}
	
	public int getQuantOperacoes() {
		return quantOperacoes;
	}
	public void setQuantOperacoes(int quantOperacoes) {
		this.quantOperacoes = quantOperacoes;
	}
	public String getDataRepasse() {
		return dataRepasse;
	}
	public void setDataRepasse(String dataRepasse) {
		this.dataRepasse = dataRepasse;
	}
	public double getValorRepasse() {
		return valorRepasse;
	}
	public void setValorRepasse(double valorRepasse) {
		this.valorRepasse = valorRepasse;
	}
		
}