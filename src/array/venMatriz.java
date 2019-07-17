package array;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
 * Formulario nuevo, ventna unica, ingreso de usuario, JPassword field, acceso necesario para abrir el menu,
 * lista de usuarios y contraseña, matris simple, boton de aceptar y cerrar
 * */

public class venMatriz extends JFrame implements ActionListener {
    static final int FILAS = 5;
    static final int COLUMNAS = 2;

    static final int TAMANNO = FILAS * COLUMNAS;

    JLabel lIngresar = new JLabel("Ingrese el dato N° ", SwingConstants.CENTER);
    JLabel lSalida = new JLabel("Salida", SwingConstants.CENTER);
    JLabel lSumMul3 = new JLabel("Suma multiplos de 3: ", SwingConstants.CENTER);
    JLabel lMul3 = new JLabel("Multiplos de 3: ", SwingConstants.CENTER);

    JTextField tfIngresar = new JTextField();
    JTextArea tfSalida = new JTextArea();
    JTextField tfSumaMul3 = new JTextField();
    JTextField tfMul3 = new JTextField();

    JButton bMostrar = new JButton("Mostrar");
    JButton bPregenerado = new JButton("Generar");
    JLabel lLlenados = new JLabel("Llenados : ");
    JLabel lRestantes = new JLabel("Restantes : ");
    String sMatrizCompleta = "";
    String sSumaMul3 = "";
    String sMult3 = "";
    int[][] numeros = new int[5][2];
    int cantidadLLenado = 0;
    int posicionFila = 0;
    int posicionColumna = 0;
    private JButton bAgregar = new JButton("Agregar");
    private JButton bLimpiar = new JButton("Limpiar");


    public venMatriz() {
        super("Matricez");
        setUp();
        createUI();
    }

    private void setUp() {
        bMostrar.addActionListener(this);
        bAgregar.addActionListener(this);
        bPregenerado.addActionListener(this);
        bLimpiar.addActionListener(this);
        tfSalida.setEditable(false);
        tfSalida.setRows(5);

        tfSumaMul3.setEditable(false);
        tfMul3.setEditable(false);
        lLlenados.setText("Llenados : " + cantidadLLenado);
        lRestantes.setText("Restantes : " + (TAMANNO - cantidadLLenado));

        tfIngresar.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar()))
                    e.consume();
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    private void createUI() {
        this.setLayout(new GridBagLayout());
        this.setSize(new Dimension(400, 300));
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 20;
        this.add(lIngresar, gbc);
        gbc.gridx++;
        gbc.weightx = 80;
        gbc.gridwidth = 2;
        this.add(tfIngresar, gbc);
        gbc.gridx = 0;
        gbc.weightx = 20;
        gbc.gridy++;
        gbc.gridwidth = 1;
        this.add(lSalida, gbc);
        gbc.weightx = 80;
        gbc.gridx++;
        gbc.gridheight = 5;
        gbc.gridwidth = 2;
        this.add(tfSalida, gbc);
        gbc.weightx = 20;
        gbc.gridx = 0;
        gbc.gridy += 5;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        this.add(lMul3, gbc);
        gbc.gridx++;
        gbc.weightx = 80;
        gbc.gridwidth = 2;
        this.add(tfMul3, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.weightx = 20;
        gbc.gridwidth = 1;
        this.add(lSumMul3, gbc);
        gbc.gridx++;
        gbc.gridwidth = 2;
        gbc.weightx = 80;
        this.add(tfSumaMul3, gbc);


        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.weightx = 0;
        gbc.insets = new Insets(20, 0, 0, 0);
        this.add(bAgregar, gbc);
        gbc.gridx++;
        this.add(bMostrar, gbc);
        gbc.gridx++;
        this.add(bPregenerado, gbc);
        gbc.gridx++;
        this.add(bLimpiar, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        this.add(lLlenados, gbc);
        gbc.gridx++;
        this.add(lRestantes, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bPregenerado) {
            llenarMatris();
            cantidadLLenado = TAMANNO;
        }
        if (e.getSource() == bMostrar) {
            if (cantidadLLenado != TAMANNO) {
                this.tfSalida.setText("NO HA TERMINADO DE LLENAR");
                this.tfMul3.setText("NO HA TERMINADO DE LLENAR");
                this.tfSumaMul3.setText("NO HA TERMINADO DE LLENAR");

                this.tfSalida.setForeground(Color.RED);
                this.tfMul3.setForeground(Color.RED);
                this.tfSumaMul3.setForeground(Color.RED);
            } else {
                mostrarMatriz();
                mulTres();
                this.tfSalida.setForeground(Color.BLACK);
                this.tfMul3.setForeground(Color.BLACK);
                this.tfSumaMul3.setForeground(Color.BLACK);
                this.tfSalida.setText(sMatrizCompleta);
                this.tfMul3.setText(sMult3);
                this.tfSumaMul3.setText(sSumaMul3);
            }
        }
        if (e.getSource() == this.bAgregar) {
            if (this.tfIngresar.getText().isEmpty()) {
                String texto = "TIENE QUE INGRESAR ALGO";
                Color col = new Color(255, 0, 0);
                mensaje(texto, col);
            } else if (cantidadLLenado == TAMANNO) {
                String texto = "YA NO SE PUEDEN LLENAR MAS";
                Color col = new Color(255, 0, 0);
                mensaje(texto, col);
            } else {
                System.out.println(this.tfIngresar.getText());
                this.numeros[posicionFila][posicionColumna] = Integer.parseInt(this.tfIngresar.getText());
                String texto = "Agregado";
                Color color = new Color(121, 121, 121);
                mensaje(texto, color);
                this.tfIngresar.setText("");

                if (posicionFila == FILAS) {
                    posicionFila = 0;
                    posicionColumna++;
                }
                cantidadLLenado++;
            }

        }
        if (e.getSource() == this.bLimpiar) {
            posicionColumna = 0;
            posicionFila = 0;
            cantidadLLenado = 0;
        }
        lLlenados.setText("Llenados : " + cantidadLLenado);
        lRestantes.setText("Restantes : " + (TAMANNO - cantidadLLenado));

    }

    private void mensaje(String texto, Color col) {
        this.tfSalida.setText(texto);
        this.tfMul3.setText(texto);
        this.tfSumaMul3.setText(texto);

        this.tfSalida.setForeground(col);
        this.tfMul3.setForeground(col);
        this.tfSumaMul3.setForeground(col);
    }

    public void mostrarMatriz() {
        for (int[] fila : numeros) {
            for (int numero : fila) {
                sMatrizCompleta += " " + numero;
            }
            sMatrizCompleta += '\n';
        }
        sMatrizCompleta = sMatrizCompleta.substring(0, sMatrizCompleta.length() - 1);
    }

    private void llenarMatris() {
        int num = 2;
        for (int f = 0; f < 5; f++) {
            for (int c = 0; c < 2; c++, num += 2) {
                numeros[f][c] = num;
            }
        }
    }

    private void mulTres() {
        int suma = 0;
        sMult3 = "";
        for (int[] fila : this.numeros) {
            for (int numero : fila) {
                if (numero % 3 == 0) {
                    suma += numero;
                    sMult3 += numero + ", ";
                }
            }
        }
        sMult3 = sMult3.substring(0, sMult3.length() - 2);
        sSumaMul3 = Integer.toString(suma);
    }
}
