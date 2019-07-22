package array;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Implemente un programa que le permita ingresar 20 cadenas de caracteres a traves de una cajita de texto, por ejemplo la caja cadena, y cada vez que se presione entrer
 * en la caja y habiendo llenado la cadena esta se ingrese en el arreglo, tenga en cuenta que cuando yo se tiene el arreglo debe de salir un mensaje al momento de presionar enter
 * estando lleno el mensaje si hacemos click sobre el boton mostrar se debe visualizar en la caja de texto resultado las cadenas
 * que empiezan con la letra 'm' o que finalizan con la vocal 'o', tenga en cuenta que si no se han llenado todas las cadenas en el arreglo, no se
 * debera mostrar nada en la caja resultado y mas bien debera salir un mensaje en el cual se indique que debe seguir llenando el arreglo y calcular la cantidad de cadenas que aun faltan por llenar
 */

public class venWordsArray extends JFrame implements ActionListener {
	private static final int TAMANNO = 20;
	private final String[] aPalabras = new String[TAMANNO];
	private final JLabel lIngreso = new JLabel("Ingrese palabra", JLabel.CENTER);
	private final JLabel lResultado = new JLabel("Resultado", JLabel.CENTER);
	private final JTextField tfIngresar = new JTextField();
	private final JTextField tfSalida = new JTextField("RESULTADO");
	private final JButton bAgregar = new JButton("AGREGAR");
	private final JButton bLimpiar = new JButton("LIMPIAR");
	private final JButton bDeshacer = new JButton("QUITAR ULTIMO");
	private final JButton bSalir = new JButton("SALIR");
	private final JButton bMostrar = new JButton("MOSTRAR");
	private JLabel dlCantidad;
	private JLabel dlRestantes;
	private int iRestantes;
	private String sRestantes = "<html>Restantes: <font color='red'>" + iRestantes + "</font></html>";
	private int iCantidad;
	private String sCantidad = "<html>Cantidad: <font color='red'>" + iCantidad + "</font></html>";


	public venWordsArray() {
		super("Serie de Palabras");
		setUp();
		buildUI();
	}

	private void setUp() {
		tfSalida.setEditable(false);
		dlCantidad = new JLabel(sCantidad, SwingConstants.CENTER);
		dlRestantes = new JLabel(sRestantes, SwingConstants.CENTER);
		iCantidad = 0;
		iRestantes = TAMANNO;
		actualizarContadoresLabel();
		bSalir.addActionListener(this);
		bLimpiar.addActionListener(this);
		bDeshacer.addActionListener(this);
		bAgregar.addActionListener(this);
		bMostrar.addActionListener(this);
		tfIngresar.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					e.consume();
					procesarAgregar();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}
		});
	}

	private void buildUI() {
		this.setSize(new Dimension(1250, 250));
		this.setPreferredSize(new Dimension(1250, 250));
		this.setMinimumSize(new Dimension(550, 200));
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 20;
		this.add(lIngreso, gbc);
		gbc.gridx++;
		gbc.weightx = 100;
		gbc.gridwidth = 4;
		this.add(tfIngresar, gbc);
		gbc.gridwidth = 1;
		gbc.gridy++;
		gbc.gridx = 0;
		gbc.weightx = 20;
		this.add(lResultado, gbc);
		gbc.gridwidth = 4;
		gbc.gridx++;
		gbc.weightx = 100;
		this.add(tfSalida, gbc);

		gbc.gridwidth = 1;
		gbc.gridy++;
		gbc.gridx = 0;
		gbc.insets = new Insets(20, 0, 0, 0);
		this.add(bAgregar, gbc);
		gbc.gridx++;
		this.add(bDeshacer, gbc);
		gbc.gridx++;
		this.add(bMostrar, gbc);
		gbc.gridx++;
		this.add(bLimpiar, gbc);
		gbc.gridx++;
		this.add(bSalir, gbc);

		gbc.gridy++;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		this.add(this.dlCantidad, gbc);
		gbc.gridx += 2;
		this.add(this.dlRestantes, gbc);

	}

	private void procesarAgregar() {
		if(this.tfIngresar.getText().isEmpty()) {
			this.tfSalida.setText("DEBE INGRESAR TEXTO");
			this.tfSalida.setForeground(Color.RED);
		} else if(this.iRestantes > 0) {
			assert iRestantes + iCantidad == 20;//ALGO QUE HA IDO MUY MAL
			System.out.println(iRestantes + iCantidad);
			this.tfSalida.setText("");
			this.aPalabras[iCantidad] = this.tfIngresar.getText();
			this.tfSalida.setText("AGREGADO");
			this.tfSalida.setForeground(Color.GRAY);
			iRestantes--;
			iCantidad++;
		} else if(this.iRestantes == 0) {
			this.tfSalida.setText("YA SE TERMINO DE LLENAR EL ARREGLO");
			this.tfSalida.setForeground(Color.RED);
			JOptionPane.showMessageDialog(null, "EL ARREGLO ESTA LLENO", "LLENO", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void actualizarContadoresLabel() {
		this.sCantidad = "<html>Cantidad: <font color='red'>" + iCantidad + "</font></html>";
		this.dlCantidad.setText(this.sCantidad);
		this.sRestantes = "<html>Restantes: <font color='red'>" + iRestantes + "</font></html>";
		this.dlRestantes.setText(this.sRestantes);
	}

	private boolean cumpleCondicionesRegex(String str) {
		return str.matches("(\\b[Mm][A-Za-z0-9]*)|([A-Za-z0-9]*[Oo]\\b)");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(this.getSize());
		if(e.getSource() == this.bAgregar) {
			procesarAgregar();
			tfIngresar.setText("");
		}
		if(e.getSource() == this.bDeshacer) {
			if(this.aPalabras[0] == null) {
				this.tfSalida.setText("EL ARREGLO ESTA VACIO");
				this.tfSalida.setForeground(Color.RED);
			} else {
				this.aPalabras[iCantidad - 1] = null;
				iCantidad--;
				iRestantes++;
				this.tfSalida.setText("ELIMINADO");
				this.tfSalida.setForeground(Color.GRAY);
			}
		}
		if(e.getSource() == this.bLimpiar) {
			for(int i = 0; i < 20; i++) {
				this.aPalabras[i] = null;
			}
			this.tfSalida.setText("LIMPIADO");
			this.tfSalida.setForeground(Color.GRAY);
			this.iRestantes = TAMANNO;
			this.iCantidad = 0;
		}
		if(e.getSource() == this.bSalir) {
			if(JOptionPane.showConfirmDialog(null, "Desea Salir", "¿SALIR?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION)
				this.dispose();
		}
		if(e.getSource() == this.bMostrar) {
			if(iRestantes != 0) {
				tfSalida.setText("No se han terminado de Ingresar los datos");
				tfSalida.setForeground(Color.RED);
			}
			StringBuilder resultado = new StringBuilder();
			for(String str : aPalabras) {
				if(str == null)
					continue;
				if(cumpleCondicionesRegex(str))
					resultado.append(str).append(", ");
			}
			if(resultado.length() > 0)
				resultado = new StringBuilder(resultado.substring(0, resultado.length() - 2));
			tfSalida.setText(resultado.toString());
			tfSalida.setForeground(Color.BLACK);
		}
		actualizarContadoresLabel();
	}
}