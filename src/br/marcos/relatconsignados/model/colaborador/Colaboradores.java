package br.marcos.relatconsignados.model.colaborador;

import java.util.ArrayList;

public class Colaboradores {
	private ArrayList<Colaborador> colaboradores;
	
	public Colaboradores() {
		this.colaboradores = new ArrayList<Colaborador>();
	}
	
	public void adicionarColaborador(Colaborador colaborador) {
		if((colaboradores != null) && (!this.existeColaborador(colaborador))) {
			this.colaboradores.add(colaborador);
		}
	}
	
	public void removerColaborador(Colaborador colaborador) {
		if(!this.colaboradores.remove(colaborador)) {
			System.out.println("!!!!!!!!!! ERRO Colaboradores: linha 20!!!!!!!!!");
		}
	}
	
	public Colaborador obterColaborador(Campo campo, String matricula) {
		Colaborador colaborador = new Colaborador(campo, matricula);
		return colaboradores.get(colaboradores.indexOf(colaborador));
	}
	
	public boolean existeColaborador(Colaborador colaborador) {
				return colaboradores.contains(colaborador);
	}

	public int getQuantColaboradores() {
		return colaboradores.size();
	}
}