package math;

public class Factorial {
	public static int entero(int Ingreso) {
		if(Ingreso == 1)
			return 1;
		return entero(Ingreso - 1) * Ingreso;
	}
}
