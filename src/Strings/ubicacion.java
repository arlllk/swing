package Strings;

class ubicacion {

	static String posiciones(String str, char ch) {
		StringBuilder pos = new StringBuilder();
		for(int i = 0; i < str.length(); i++) {
			if(isChar(str.toLowerCase().charAt(i), ch))
				if(pos.length() == 0)
					pos.append(i);
				else
					pos.append(',').append(i);
		}
		if(pos.length() == 0)
			return "No esta en la lista";
		return pos.toString();
	}

	static int veces(String str, char ch) {
		int cantidad = 0;
		for(int i = 0; i < str.length(); i++) {
			if(isChar(str.toLowerCase().charAt(i), ch))
				cantidad++;
		}
		return cantidad;
	}

	static int vecesVocales(String str) {
		int cantidad = 0;
		for(int i = 0; i < str.length(); i++) {
			if(isChar(str.toLowerCase().charAt(i), 'a'))
				cantidad++;
			if(isChar(str.toLowerCase().charAt(i), 'e'))
				cantidad++;
			if(isChar(str.toLowerCase().charAt(i), 'i'))
				cantidad++;
			if(isChar(str.toLowerCase().charAt(i), 'o'))
				cantidad++;
			if(isChar(str.toLowerCase().charAt(i), 'u'))
				cantidad++;
		}
		return cantidad;
	}

	static String vocalesObtenidas(String str) {
		StringBuilder listaVocales = new StringBuilder();
		for(int i = 0; i < str.length(); i++) {
			if(isChar(str.toLowerCase().charAt(i), 'a'))
				listaVocales.append('a');
			if(isChar(str.toLowerCase().charAt(i), 'e'))
				listaVocales.append('e');
			if(isChar(str.toLowerCase().charAt(i), 'i'))
				listaVocales.append('i');
			if(isChar(str.toLowerCase().charAt(i), 'o'))
				listaVocales.append('o');
			if(isChar(str.toLowerCase().charAt(i), 'u'))
				listaVocales.append('u');

			if(listaVocales.length() > 0) {
				if(listaVocales.charAt(listaVocales.length() - 1) != ',') {
					listaVocales.append(',');
				}
			}
		}
		return listaVocales.substring(0, listaVocales.length() - 1);
	}

	private static boolean isChar(char obtenida, char deseada) {
		return obtenida == deseada;
	}
}
