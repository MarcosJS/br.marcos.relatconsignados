package br.marcos.relatconsignados;

public class ModString {
	
	static String removEspacoIniFim(String string) {
		if(string.length() > 0) {
			int i = 0;//primeiro indice
			int j = string.length() - 1;//ultimo indice
			int d = 0;//desconto no fim da string
			while((string.charAt(i) == ' ') || (string.charAt(j) == ' ')) {
				if(string.charAt(i) == ' ') {
					i++;//incrementado para percorrer a string
				}
				if(string.charAt(j) == ' ') {
					j--;//descrementado para voltar pela string
					d++;//quantidade espacos no fim da string
				}
			}
			string = string.substring(i, string.length() - d);
		} else {
			string = null;
		}
		return string;
	}
	
	static String formatParaConversDecimal(String string) {
		string  = string.replace(".", "");
		string = string.replace(",", ".");
		return string;
	}
	
	static boolean convertParaBoolean(String string) {
		string = removEspacoIniFim(string);
		boolean resultado = false;
		if(string.equals("Sim")) {
			resultado = true;
		}
		return resultado;
	}
	
	static String capturarParcelaAtual(String string) {
		string = removEspacoIniFim(string);
		return string.split("/")[0];
		
	}
	
	static String capturarTotalParcelas(String string) {
		string = removEspacoIniFim(string);
		return string.split("/")[1];
		
	}
}
