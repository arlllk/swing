package VentPrincipal;

import login.access.login;
import login.access.loginAbstract;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class VenNuevoUsuario extends JFrame implements ActionListener {
	private final JLabel lUsuario = new JLabel("Usuario: ");
	private final JLabel lPassword = new JLabel("Contraseña: ");


	private final JTextField tfUsuario = new JTextField();

	private final JPasswordField pfPassword = new JPasswordField();

	private final JButton bIngresar = new JButton("Ingresar");
	private final JButton bRegresar = new JButton("Regresar");

	private final JLabel dlError = new JLabel("", JLabel.CENTER);

	private final login login;

	VenNuevoUsuario(login login) {
		super("Nuevo Usuario");
		this.login = login;
		setup();
		createUI();
	}

	private void setup() {
		bIngresar.addActionListener(this);
		bRegresar.addActionListener(this);
		dlError.setForeground(Color.RED);
	}

	private void createUI() {
		this.setSize(400, 300);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 20;
		this.add(lUsuario, gbc);
		gbc.weightx = 80;
		gbc.gridx++;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		this.add(tfUsuario, gbc);
		gbc.weightx = 20;
		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 1;
		this.add(lPassword, gbc);
		gbc.weightx = 80;
		gbc.gridx++;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		this.add(pfPassword, gbc);

		gbc.insets = new Insets(20, 0, 0, 0);
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy++;
		this.add(bIngresar, gbc);
		gbc.gridx++;
		this.add(bRegresar, gbc);

		gbc.insets = new Insets(30, 0, 0, 0);
		gbc.gridy++;
		gbc.gridx = 0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridy++;
		this.add(dlError, gbc);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bIngresar) {
			String error;
			dlError.setForeground(Color.RED);
			String contrasenna = String.valueOf(pfPassword.getPassword());
			if(tfUsuario.getText().isEmpty()) {
				error = "Debe ingresar un Usuario";
			} else if(contrasenna.isEmpty()) {
				error = "Debe ingresar una contraseña";
			} else if(login.existeElUsuario(tfUsuario.getText())) {
				error = "El usuario ya existe";
			} else if(login.agregarUsuario(tfUsuario.getText(), contrasenna)) {
				error = "Agregado Exitosamente";
				dlError.setForeground(Color.BLACK);
			} else {
				if(login.getLastFail() == loginAbstract.ERROR.NO_USER) {
					error = "No se ingreso un usuario";
				} else if(login.getLastFail() == loginAbstract.ERROR.NO_PASSWORD) {
					error = "No se ingreso una contraseña";
				} else error = String.valueOf(login.getLastFail());

			}
			dlError.setEnabled(true);
			dlError.setText(error);
		} else if(e.getSource() == bRegresar) {
			this.dispose();
		}
	}
}
