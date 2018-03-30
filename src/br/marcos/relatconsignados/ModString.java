package br.marcos.relatconsignados;

public class ModString {
	static String removEspacoIniFim(String string) {
		int i = 0;
		int j = string.length() - 1;//ultimo indice
		while((string.charAt(i) == ' ') || (string.charAt(j) == ' ')) {
			if(string.charAt(i) == ' ') {
				i++;
			}
			if(string.charAt(j) == ' ') {
				j--;
			}
		}
		return string = string.substring(i, j);
	}
}
