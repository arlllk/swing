package login.access;

import login.database.database;
import login.database.databaseAsMatrix;

public abstract class loginAbstract implements login {
	static final int TAMANNO_POR_DEFECTO = 10;
	private static final int CANTIDAD_DE_INTENTOS = 5;
	private final int cantidadDeIntentos;
	int sizeDatabase;
	database baseDeDatos;
	ERROR lastFail = ERROR.NO_ERROR;
	private int cantidadDeIntentosRestantes;

	loginAbstract() {
		this(TAMANNO_POR_DEFECTO);
	}

	loginAbstract(database dataBZ) {
		this.baseDeDatos = dataBZ;
		sizeDatabase = baseDeDatos.cantidadMaximaDeUsuarios();
		cantidadDeIntentosRestantes = CANTIDAD_DE_INTENTOS;
		cantidadDeIntentos = cantidadDeIntentosRestantes;
	}

	loginAbstract(int sizeDataBZ) {
		this.baseDeDatos = new databaseAsMatrix(sizeDataBZ);
		cantidadDeIntentosRestantes = CANTIDAD_DE_INTENTOS;
		cantidadDeIntentos = cantidadDeIntentosRestantes;
	}

	public ERROR getLastFail() {
		return lastFail;
	}

	@Override
	public boolean isPassword(String user, String password) {
		if(!existeElUsuario(user)) {
			lastFail = ERROR.THE_USER_DONT_EXIST;
			return false;
		}
		if(user.isEmpty()) {
			lastFail = ERROR.NO_USER;
			return false;
		}
		if(password.isEmpty()) {
			lastFail = ERROR.NO_PASSWORD;
			return false;
		}
		if(this.cantidadDeIntentosRestantes == 0) {
			lastFail = ERROR.USE_ALL_TRIES;
			return false;
		}
		return isPassword(baseDeDatos.obtenerIndexUsuario(user), password);
	}

	protected abstract boolean isPassword(int usuarioIndex, String password);

	@Override
	public boolean existeElUsuario(String usuario) {
		if(baseDeDatos.contieneAlUsuario(usuario)) {
			return true;
		}
		lastFail = ERROR.THE_USER_DONT_EXIST;
		return false;
	}

	@Override
	public int obtenerIndiceUsuario(String usuario) {
		if(!existeElUsuario(usuario)) {
			lastFail = ERROR.THE_USER_DONT_EXIST;
			return -1;
		}
		return baseDeDatos.obtenerIndexUsuario(usuario);
	}

	@Override
	public String obtenerNombreUsuario(int usuarioIndex) {
		if(usuarioIndex < 0) {
			lastFail = ERROR.INDEX_LESS_THAN_0;
			return "No existe";
		}
		if(usuarioIndex > sizeDatabase) {
			lastFail = ERROR.INDEX_BIGGER_THAN_SIZE;
			return "No existe";
		}
		return baseDeDatos.obtenerUsuario(usuarioIndex);
	}

	@Override
	public abstract boolean agregarUsuario(String user, String password);

	@Override
	public int cantidadActualDeUsuarios() {
		return baseDeDatos.cantidadActualDeUsuarios();
	}

	@Override
	public int cantidadMaximaDeUsuarios() {
		return sizeDatabase;
	}

	@Override
	public int cantidadDeIntentosRestantes() {
		return cantidadDeIntentosRestantes;
	}

	@Override
	public void setCantidadDeIntentos(int cantidad) {
		cantidadDeIntentosRestantes = cantidad;
	}

	void ingresoFallido() {
		cantidadDeIntentosRestantes--;
		lastFail = ERROR.INCORRECT_PASSWORD;
	}

	void ingresoExitoso() {
		cantidadDeIntentosRestantes = cantidadDeIntentos;
	}

	public void printDataBase() {
		baseDeDatos.printDataBase();
	}

	public enum ERROR {
		NO_ERROR,
		NO_PASSWORD,
		NO_USER,
		USE_ALL_TRIES,
		THE_USER_DONT_EXIST,
		INDEX_LESS_THAN_0,
		INDEX_BIGGER_THAN_SIZE,
		INCORRECT_PASSWORD
	}
}
