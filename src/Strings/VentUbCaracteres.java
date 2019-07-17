package Strings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * Implemente un programa que le permita ingresar en una caja de texto una cadena de caracteres y en otra caja un caracter
 * Al hacer click en el boton ejecutar, se debera mostrar en una tercera caja de texto cuantas veces se encuentra el caracter
 * en la cadena,
 * Y en una cuarta caja de texto las posiciones en las que se encontro dicho caracter, separado por ','
 **/
public class VentUbCaracteres extends JFrame implements ActionListener {
	private final JTextField ingresar = new JTextField(30);
	private final JTextField charDeseado = new JTextField(1);
	private final JButton ejecutar = new JButton("Ejecutar");
	private final JTextField cantidadDeVeces = new JTextField("Cantidad de veces", 30);
	private final JTextField ubicaciones = new JTextField("Ubicaciones", 30);

	public VentUbCaracteres() {
		super("Cantidad de veces repetido");
		this.setSize(390, 220);
		this.setResizable(false);
		GridBagLayout bag = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();

		this.setLayout(bag);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel inicio = new JLabel("Ingrese una frase y un caracter", JLabel.CENTER);
		this.add(inicio, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(ingresar, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		this.add(charDeseado, gbc);
		charDeseado.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(charDeseado.getText().length() != 0) {
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

		gbc.gridx = 0;
		gbc.gridy = 3;
		this.add(ejecutar, gbc);
		this.ejecutar.addActionListener(this);

		gbc.insets = new Insets(10, 0, 0, 0);
		gbc.gridx = 0;
		gbc.gridy = 4;
		JLabel labelcantidadDeVeces = new JLabel("Cantidad de veces");
		this.add(labelcantidadDeVeces, gbc);
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.gridx = 0;
		gbc.gridy = 5;
		this.add(cantidadDeVeces, gbc);
		cantidadDeVeces.setEditable(false);

		gbc.insets = new Insets(10, 0, 0, 0);
		gbc.gridx = 0;
		gbc.gridy = 6;
		JLabel labelUbicaciones = new JLabel("Ubicaciones");
		this.add(labelUbicaciones, gbc);
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.gridx = 0;
		gbc.gridy = 7;
		this.add(ubicaciones, gbc);
		ubicaciones.setEditable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.ejecutar) {
			if(this.ingresar.getText().isEmpty()) {
				this.cantidadDeVeces.setText("Debe ingresar una palabra");
				this.cantidadDeVeces.setForeground(Color.RED);
				this.ubicaciones.setText("Debe ingresar una palabra");
				this.ubicaciones.setForeground(Color.RED);
			} else if(this.charDeseado.getText().isEmpty()) {
				this.cantidadDeVeces.setText("Debe ingresar un caracter");
				this.cantidadDeVeces.setForeground(Color.RED);
				this.ubicaciones.setText("Debe ingresar un caracter");
				this.ubicaciones.setForeground(Color.RED);
			} else {
				this.ubicaciones.setForeground(Color.BLACK);
				this.ubicaciones.setForeground(Color.BLACK);
				this.cantidadDeVeces.setText(Integer.toString(ubicacion.veces(this.ingresar.getText(), this.charDeseado.getText().charAt(0))));
				this.ubicaciones.setText(ubicacion.posiciones(this.ingresar.getText(), this.charDeseado.getText().charAt(0)));
			}
		}
	}
}
