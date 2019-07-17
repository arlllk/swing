package numerico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class venPrimo extends JFrame implements ActionListener {

	private final JTextField numeric = new JTextField();
	private final JButton computar = new JButton("Computar");
	private final JTextField resultado = new JTextField();


	public venPrimo() {
		super("Es primo?");
		this.setSize(400, 300);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		numeric.addKeyListener(new KeyListener() {
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

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridy = 0;
		gbc.gridx = 0;
		//gbc.fill = GridBagConstraints.HORIZONTAL;
		JLabel mensaje = new JLabel("Ingrese un numero");
		this.add(mensaje, gbc);
		gbc.gridy = 1;
		this.add(numeric, gbc);
		gbc.gridy = 2;
		this.add(computar, gbc);

		gbc.insets = new Insets(10, 0, 0, 0);
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.NONE;
		this.add(resultado, gbc);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.computar) {
			if(this.numeric.getText().isEmpty()) {
				this.resultado.setText("DEBE INGRESAR UN VALOR");
				this.resultado.setForeground(Color.RED);
			} else if(esPrimo(this.numeric.getText())) {
				this.resultado.setText("El numero es primo");
				this.resultado.setForeground(Color.BLACK);
			} else {
				this.resultado.setText("El numero no es primo");
				this.resultado.setForeground(Color.BLACK);
			}
		}
	}

	private boolean esPrimo(String str) {
		int num = Integer.parseInt(str);
		for(int i = 2; i < num; i++)
			if(num % i == 0)
				return false;
		return true;
	}
}
