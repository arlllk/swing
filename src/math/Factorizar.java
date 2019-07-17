package math;

class Factorizar {
	public static String entero(int Ingreso) {
		StringBuilder Salida = new StringBuilder();
		int Ingreso_original = Ingreso;
		for(int i = 2; i <= Ingreso_original; ) {
			if(Ingreso % i == 0) {
				if(Salida.length() == 0) {
					Salida.append(i);
					Ingreso = Ingreso / i;
				} else {
					Salida.append('x');
					Salida.append(i);
					Ingreso = Ingreso / i;
				}
			} else {
				i++;
			}
		}
		return Salida.toString();
	}
}
