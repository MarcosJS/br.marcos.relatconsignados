package br.marcos.relatconsignados;

public class ModString {
	
	static String removEspacoIniFim(String string) {
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
		return string = string.substring(i, string.length() - d);
	}
	
	static String formatParaConvertDecimal(String string) {
		string  = string.replace(".", "");
		string = string.replace(",", ".");
		return string;
	}
}
