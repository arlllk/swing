package Strings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Implemente un programa que le permite ingresar una cadena de caracteres en una caja de texto de un formulario
 * Y luego al presionar un boton calcular se deben visualizar en minusculas todas las vocales que se encuentren en esa caderna
 * Separada por ',' en otra caja de texto
 * En la caja de texto del texto solo se debe poder ingresar letras
 */
public class VenMostrarVocales extends JFrame implements ActionListener {
	private final JTextField Palabra = new JTextField(30);
	private final JButton calcular = new JButton("Calcular");
	private final JTextField resultado = new JTextField(30);


	public VenMostrarVocales() {
		super("Mostrar vocales");
		this.setSize(390, 190);
		this.setResizable(false);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		Palabra.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isAlphabetic(e.getKeyChar())) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});

		calcular.setMnemonic(KeyEvent.VK_ENTER);
		calcular.addActionListener(this);

		resultado.setEditable(false);

		gbc.gridy = 0;
		gbc.gridx = 0;
		JLabel texto = new JLabel("Ingrese texto");
		this.add(texto, gbc);
		gbc.gridy = 1;
		this.add(Palabra, gbc);
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(calcular, gbc);

		gbc.insets = new Insets(20, 0, 0, 0);
		gbc.gridy = 3;
		this.add(new JLabel("Resultado", JLabel.CENTER), gbc);
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.gridy = 4;
		this.add(resultado, gbc);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.calcular) {
			if(this.Palabra.getText().isEmpty()) {
				this.resultado.setText("Ingrese texto");
			} else {
				System.out.println(this.getSize());
				this.resultado.setText(ubicacion.vocalesObtenidas(this.Palabra.getText()));
			}
		}
	}
}
