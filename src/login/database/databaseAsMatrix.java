package login.database;

import java.util.Objects;

public class databaseAsMatrix implements database {
	private final int cantUsuarios;
	private final String[][] listaUsuarios;
	private int cantActualUsuarios;

	public databaseAsMatrix() {
		this(10);
	}

	public databaseAsMatrix(int size) {
		this.cantUsuarios = size;
		this.listaUsuarios = new String[cantUsuarios][2];
		this.cantActualUsuarios = 0;
		this.resetearBaseDeDatos();
	}

	public String obtenerUsuario(int index) {
		return this.listaUsuarios[index][0];
	}

	/**
	 * Obtiene el indice con el nombre de usuario solicitado
	 *
	 * @param nombreUsuario nombre del usuario
	 *
	 * @return indice del Usuario correpondiente al nombre enviado, -1 si no existe
	 */
	public int obtenerIndexUsuario(String nombreUsuario) {
		for(int i = 0; i < cantUsuarios; i++) {
			System.out.print(this.listaUsuarios[i][0] + ' ');
			if(obtenerUsuario(i) != null)
				if(obtenerUsuario(i).equals(nombreUsuario)) {
					return i;
				}

		}
		int i = 0;
		for(String[] user : listaUsuarios) {
			if(Objects.equals(user[0], nombreUsuario)) {
				return i;
			}
			i++;
		}
		return -1;
	}

	public boolean contieneAlUsuario(String nombreUsuario) {
		return obtenerIndexUsuario(nombreUsuario) != -1;
	}

	public String obtenerPassword(int index) {
		return this.listaUsuarios[index][1];
	}

	public boolean borrarUsuario(int index) {
		listaUsuarios[index][0] = null; //Nombre del usuario
		listaUsuarios[index][1] = null; //Contraseña del usuario
		return true;
	}

	public void resetearBaseDeDatos() {
		for(int i = 0; i < cantUsuarios; i++) {
			borrarUsuario(i);
		}
	}

	@Override
	public int cantidadActualDeUsuarios() {
		return cantActualUsuarios;
	}

	@Override
	public int cantidadMaximaDeUsuarios() {
		return cantUsuarios;
	}

	@Override
	public boolean agregarUsuario(String usuario, String password) {

		return agregarUsuario(usuario, password, cantActualUsuarios);
	}

	private boolean agregarUsuario(String usuario, String password, int Index) {
		if(cantActualUsuarios == cantUsuarios)
			return false;
		listaUsuarios[Index][0] = usuario;
		listaUsuarios[Index][1] = password;
		cantActualUsuarios++;
		return true;
	}

	@Override
	public boolean cambiarPassword(String usuario, String password) {
		if(!contieneAlUsuario(usuario))
			return false;
		return agregarUsuario(usuario, password, obtenerIndexUsuario(usuario));
	}

	@Override
	public boolean cambiarPassword(int usuarioIndex, String password) {
		if(usuarioIndex > cantUsuarios)
			return false;
		return agregarUsuario(obtenerUsuario(usuarioIndex), password, usuarioIndex);
	}

	public void printDataBase() {
		for(String[] usr : listaUsuarios) {
			for(String dato : usr) {
				System.out.print(dato + ' ');
			}
			System.out.print('\n');
		}
	}

}
