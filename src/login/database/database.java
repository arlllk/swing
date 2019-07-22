package login.database;

public interface database {
	String obtenerUsuario(int index);

	/**
	 * Obtiene el indice con el nombre de usuario solicitado
	 *
	 * @param nombreUsuario nombre del usuario
	 *
	 * @return indice del Usuario correpondiente al nombre enviado, -1 si no existe
	 */
	int obtenerIndexUsuario(String nombreUsuario);

	boolean contieneAlUsuario(String nombreUsuario);

	String obtenerPassword(int index);

	boolean borrarUsuario(int index);

	void resetearBaseDeDatos();

	int cantidadActualDeUsuarios();

	int cantidadMaximaDeUsuarios();

	boolean agregarUsuario(String usuario, String password);

	boolean cambiarPassword(String usuario, String password);

	boolean cambiarPassword(int usuarioIndex, String password);

	void printDataBase();
}
