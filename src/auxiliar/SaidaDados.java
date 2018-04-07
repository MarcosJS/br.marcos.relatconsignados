package auxiliar;

import consignado.Consignado;
import consignado.ConsignadoBB;

public class SaidaDados {
	public static void imprimirConsignados(Consignado[] consignados) {
		for(Consignado cB: consignados) {
			if(cB instanceof ConsignadoBB) {
				System.out.printf("%-30s %s %s %d %s %10s %10s\n\n", cB.getNome(), cB.getMatricula(), cB.getIdConsignado(), ((ConsignadoBB) cB).getSeqOperacao(), ((ConsignadoBB) cB).getCpf(), String.valueOf(cB.getValorParcela()), String.valueOf(cB.getValorConsignado()));
			} else {
				System.out.println("Não é ConsignadoBB "+consignados.getClass());
			}
		}
	}
}