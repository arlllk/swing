package array;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class venArray extends JFrame implements ActionListener {
	private final int[] arr = new int[10];
	private final JTextField TxNum = new JTextField(50);
	private final JButton llen = new JButton("Llenar");
	private final JButton mostra = new JButton("Mostrar");
	private final JButton salir = new JButton("Salir");
	private final JButton limpi = new JButton("Limpiar");
	private String resultado = "";

	public venArray() {
		super("resultado");
		this.setSize(400, 300);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		TxNum.setEditable(false);

		this.llen.addActionListener(this);
		this.mostra.addActionListener(this);
		this.salir.addActionListener(this);
		this.limpi.addActionListener(this);

		gbc.gridy = 1;
		gbc.gridx = 0;
		gbc.weightx = 1;
		JLabel res = new JLabel("Resultado");
		this.add(res, gbc);
		gbc.gridx = 1;
		gbc.weightx = 40;
		this.add(TxNum, gbc);
		gbc.gridx = 2;
		gbc.weightx = 2;
		this.add(mostra, gbc);
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.weightx = 0;
		this.add(llen, gbc);
		gbc.gridy = 2;
		this.add(salir, gbc);
		gbc.gridy = 3;
		this.add(limpi, gbc);
	}

	private void llenar() {
		for(int i = 0; i < 10; i++) {
			arr[i] = (i + 1) * 2;
		}
	}

	private void mostrar() {
		resultado = "";
		for(int i : arr) {
			resultado += Integer.toString(i) + ',';
		}
		resultado = resultado.substring(0, resultado.length() - 1);
	}

	private void limpiar() {
		for(int i = 0; i < 10; i++) {
			arr[i] = 0;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.llen) {
			llenar();
		}
		if(e.getSource() == this.mostra) {
			mostrar();
			this.TxNum.setText(resultado);
		}
		if(e.getSource() == this.salir) {
			this.dispose();
		}
		if(e.getSource() == this.limpi) {
			this.limpiar();
			this.TxNum.setText("");
		}
	}
}
