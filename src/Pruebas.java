class Pruebas {
    private static final int[][] numeros = new int[5][2];

    public static void main(String[] args) {
        llenarMatris();
        leerMatrix();
        mulTres();
    }

    private static void llenarMatris() {
        int num = 2;
        for (int f = 0; f < 5; f++) {
            for (int c = 0; c < 2; c++, num += 2) {
                numeros[f][c] = num;
            }
        }
    }

    private static void leerMatrix() {
        //venMatriz.mostrarMatriz(numeros);
        //System.out.println(cad);
    }

    private static void mulTres() {
        int suma = 0;
        String lista = "";
        for (int[] fila : numeros) {
            for (int numero : fila) {
                if (numero % 3 == 0) {
                    suma += numero;
                    lista += numero + ", ";
                }
            }
        }
        lista = lista.substring(0, lista.length() - 2);
        System.out.println(suma);
        System.out.println(lista);
    }
}
