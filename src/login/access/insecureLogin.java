package login.access;

import login.database.database;
import login.database.databaseAsMatrix;

public class insecureLogin extends loginAbstract {
	public insecureLogin() {
		this(TAMANNO_POR_DEFECTO);
	}

	public insecureLogin(database dataBZ) {
		this.baseDeDatos = dataBZ;
		sizeDatabase = baseDeDatos.cantidadMaximaDeUsuarios();
	}

	public insecureLogin(int sizeDataBZ) {
		this.baseDeDatos = new databaseAsMatrix(sizeDataBZ);
	}

	protected boolean isPassword(int usuarioIndex, String password) {
		if(baseDeDatos.obtenerPassword(usuarioIndex).equals(password)) {
			ingresoExitoso();
			return true;
		}
		ingresoFallido();
		return false;
	}

	@Override
	public boolean agregarUsuario(String user, String password) {
		return baseDeDatos.agregarUsuario(user, password);
	}
}
