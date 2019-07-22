package VentPrincipal;

import login.access.insecureLogin;
import login.access.login;
import login.access.loginAbstract;
import login.access.secureLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Formulario nuevo, ventna unica, ingreso de usuario, JPassword field, acceso necesario para abrir el menu,
 * lista de usuarios y contraseña, matris simple, boton de aceptar y cerrar
 * */

class venLogin extends JFrame implements ActionListener {
	private static final int CANT_INTENTOS_MAXIMO = 5;
	private static final int CANT_USUARIOS = 20;
	private static final boolean ES_SEGURO = true;

	private final JLabel lUsuario = new JLabel("Usuario: ");
	private final JLabel lPassword = new JLabel("Contraseña: ");


	private final JTextField tfUsuario = new JTextField();

	private final JPasswordField pfPassword = new JPasswordField();

	private final JButton bIngresar = new JButton("Ingresar");
	private final JButton bSalir = new JButton("Salir");
	private final JButton bNuevoUsuario = new JButton("Crear Usuario");

	private final JLabel dlError = new JLabel("", JLabel.CENTER);

	private final login Ingreso;

	private venLogin() {
		super("Login");
		if(ES_SEGURO)
			Ingreso = new secureLogin(CANT_USUARIOS);
		else
			Ingreso = new insecureLogin(CANT_USUARIOS);
		Ingreso.setCantidadDeIntentos(CANT_INTENTOS_MAXIMO);
		setup();
		createUI();
		defaultUser();
	}

	public static void main(String[] args) {
		new venLogin().setVisible(true);
	}

	private void setup() {
		bIngresar.addActionListener(this);
		bSalir.addActionListener(this);
		bNuevoUsuario.addActionListener(this);
		dlError.setForeground(Color.RED);
	}

	private void defaultUser() {
		Ingreso.agregarUsuario("root", "root");
		Ingreso.agregarUsuario("arley", "arley");
		Ingreso.agregarUsuario("usuario", "hunter1");
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
		this.add(bSalir, gbc);

		gbc.insets = new Insets(30, 0, 0, 0);
		gbc.gridy++;
		gbc.gridx = 0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		this.add(bNuevoUsuario, gbc);
		gbc.gridy++;
		this.add(dlError, gbc);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bIngresar) {
			String error = "??????";
			Color col = Color.RED;
			String contrasenna = String.valueOf(pfPassword.getPassword());
			if(tfUsuario.getText().isEmpty()) {
				error = "Debe Ingresar un usuario";
			} else if(contrasenna.isEmpty()) {
				error = "Debe Ingresar una contraseña";
			} else if(Ingreso.isPassword(tfUsuario.getText(), contrasenna)) {
				loginExitoso();
			} else {

				if(Ingreso.getLastFail() == loginAbstract.ERROR.NO_PASSWORD) {
					error = "No se ingreso una contraseña";
				} else if(Ingreso.getLastFail() == loginAbstract.ERROR.NO_USER) {
					error = "No se ingreso un usuario";
				} else if(Ingreso.getLastFail() == loginAbstract.ERROR.THE_USER_DONT_EXIST) {
					error = "El usuario ingresado no existe";
				} else if(Ingreso.getLastFail() == loginAbstract.ERROR.USE_ALL_TRIES) {
					error = "Ha gastado todos sus intentos";
				} else if(Ingreso.getLastFail() == loginAbstract.ERROR.INCORRECT_PASSWORD) {
					error = "La contraseña Ingresad no es correcta";
				} else if(Ingreso.getLastFail() == loginAbstract.ERROR.INDEX_LESS_THAN_0) {
					error = "El indice es menor a 0";
				}


			}
			dlError.setForeground(col);
			dlError.setText(error);
			dlError.setEnabled(true);
			//JOptionPane.showMessageDialog(null,error,"ERROR",JOptionPane.ERROR_MESSAGE);
		} else if(e.getSource() == bSalir) {
			if(JOptionPane.showConfirmDialog(null, "Desea Salir", "¿SALIR?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION)
				this.dispose();
		} else if(e.getSource() == bNuevoUsuario) {
			new VenNuevoUsuario(Ingreso).setVisible(true);
		}
	}

	private void loginExitoso() {
		new VetMenu().setVisible(true);
		dispose();
	}
}
