package numerico;

import math.Factorial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * Implemente un formulario que le permite ingresar un numero el cual debe estar en el rango del 1 al 12, al hacer click en un boton calcular
 * Se debe mostrar el factorial del numero en otra caja de texto, o en todo caso el mensaje pertinenete, (No esta en el rango mensaje)
 * Todo enlazado en el Strings
 */
public class VenFactorial extends JFrame implements ActionListener {
	private final JTextField ingresar = new JTextField(30);
	private final JButton calcular = new JButton("Calcular");
	private final JTextField Salida = new JTextField("Resultado", 30);

	public VenFactorial() {
		super("Hallar Factorial");
		this.setSize(380, 175);
		this.setResizable(false);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		ingresar.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar()))
					e.consume();
			}

			@Override
			public void keyPressed(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}
		});

		this.calcular.addActionListener(this);

		Salida.setEditable(false);

		gbc.gridy = 0;
		gbc.gridx = 0;
		JLabel inicio = new JLabel("Ingrese un numero entre 1 al 12");
		this.add(inicio, gbc);
		gbc.gridy = 1;
		this.add(ingresar, gbc);
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(calcular, gbc);

		gbc.insets = new Insets(20, 0, 0, 0);
		gbc.gridy = 3;
		this.add(Salida, gbc);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.calcular) {
			if(this.ingresar.getText().isEmpty())
				this.Salida.setText("Debe ingresar algo");
			else {
				int numero = Integer.parseInt(this.ingresar.getText());
				if(numero < 1 || numero > 12)
					this.Salida.setText("El numero esta fuera del margen aceptado");
				else {
					System.out.println(this.getSize());
					this.Salida.setText(Integer.toString(Factorial.entero(numero)));
				}
			}
		}
	}
}
