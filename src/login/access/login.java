package login.access;

public interface login {
	boolean isPassword(String user, String password);

	boolean existeElUsuario(String usuario);

	int obtenerIndiceUsuario(String usuario);

	String obtenerNombreUsuario(int usuarioIndex);

	boolean agregarUsuario(String user, String password);

	int cantidadActualDeUsuarios();

	int cantidadMaximaDeUsuarios();

	int cantidadDeIntentosRestantes();

	void setCantidadDeIntentos(int cantidad);

	loginAbstract.ERROR getLastFail();

	void printDataBase();
}
