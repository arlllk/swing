/*
  Implemente un programa que le permita ingresar en una caja de texto una cadena de caracteres y en otra caja un caracter
  Al hacer click en el boton ejecutar, se debera mostrar en una tercera caja de texto cuantas veces se encuentra el caracter
  en la cadena,
  Y en una cuarta caja de texto las posiciones en las que se encontro dicho caracter, separado por ','
 */

package VentPrincipal;

import Strings.VenMostrarVocales;
import Strings.VentUbCaracteres;
import array.venArray;
import array.venWordsArray;
import numerico.VenFactorial;
import numerico.venPrimo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

class VetMenu extends JFrame implements ActionListener {
	private final JMenuBar barra = new JMenuBar();

	private final JMenu numerico = new JMenu("Numerico");
	private final JMenuItem Factorial = new JMenuItem("Factorial");
	private final JMenuItem Primo = new JMenuItem("Primo");

	private final JMenu Strings = new JMenu("Palabras");
	private final JMenuItem UbCaracteres = new JMenuItem("Ubicar Caracter");
	private final JMenuItem mostrarVocales = new JMenuItem("Mostrar Vocales");

	private final JMenu Array = new JMenu("Arreglos");
	private final JMenuItem Primer = new JMenuItem("Primer Problema");
	private final JMenuItem Palabras = new JMenuItem("Palabras");

	private VetMenu() {
		configurarMenu();
		configurarVentana();
		listener();
	}

	public static void main(String[] args) {
		VetMenu ventana = new VetMenu();
		ventana.setVisible(true);
	}

	private void configurarVentana() {
		this.setTitle("Menu principal");
		this.setLayout(null);
		this.setExtendedState(6);
		this.getContentPane().setBackground(Color.PINK);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void configurarMenu() {
		this.barra.setBackground(Color.WHITE);
		this.barra.setBounds(0, 0, 1700, 35);

		this.Strings.setMnemonic(KeyEvent.VK_P);
		this.Strings.setBackground(new Color(161, 192, 228));
		this.Strings.setForeground(Color.RED);

		this.numerico.setMnemonic(KeyEvent.VK_N);
		this.numerico.setBackground(new Color(161, 192, 228));
		this.numerico.setForeground(Color.RED);

		this.Array.setMnemonic(KeyEvent.VK_A);
		this.Array.setBackground(new Color(161, 192, 228));
		this.Array.setForeground(Color.RED);

		this.Factorial.setBackground(new Color(161, 192, 228));
		this.Factorial.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK));

		this.Primo.setBackground(new Color(161, 192, 228));
		this.Primo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));

		this.UbCaracteres.setBackground(new Color(161, 192, 228));
		this.UbCaracteres.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));

		this.mostrarVocales.setBackground(new Color(161, 192, 228));
		this.mostrarVocales.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK));

		this.Primer.setBackground(new Color(161, 192, 228));
		this.Primer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));

		this.Palabras.setBackground(new Color(161, 192, 228));
		this.Palabras.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));

		Strings.add(UbCaracteres);
		Strings.add(mostrarVocales);

		numerico.add(Factorial);
		numerico.add(Primo);

		Array.add(Primer);
		Array.add(Palabras);

		barra.add(Strings);
		barra.add(numerico);
		barra.add(Array);


		this.add(barra);
	}

	private void listener() {
		this.Factorial.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new VenFactorial().setVisible(true);
			}
		});
		this.UbCaracteres.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentUbCaracteres().setVisible(true);
			}
		});
		this.mostrarVocales.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new VenMostrarVocales().setVisible(true);
			}
		});
		this.Primo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new venPrimo().setVisible(true);
			}
		});
		this.Primer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new venArray().setVisible(true);
			}
		});
		this.Palabras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new venWordsArray().setVisible(true);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
