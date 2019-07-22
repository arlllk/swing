package login.access;

import login.database.database;
import login.database.databaseAsMatrix;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class secureLogin extends loginAbstract {
	private static final String HASH_POR_DEFECTO = "SHA-1";
	private final String hashUsed;

	public secureLogin() {
		this(TAMANNO_POR_DEFECTO, HASH_POR_DEFECTO);
	}

	public secureLogin(database dataBZ) {
		super(dataBZ);
		this.hashUsed = HASH_POR_DEFECTO;
	}

	public secureLogin(int sizeDataBZ) {
		super(sizeDataBZ);
		this.hashUsed = HASH_POR_DEFECTO;
	}

	public secureLogin(String hashName) {
		this(TAMANNO_POR_DEFECTO, hashName);
	}

	public secureLogin(database dataBZ, String hashName) {
		baseDeDatos = dataBZ;
		hashUsed = hashName;
		sizeDatabase = this.baseDeDatos.cantidadMaximaDeUsuarios();
	}

	private secureLogin(int sizeDataBZ, String hashName) {
		this.sizeDatabase = sizeDataBZ;
		this.hashUsed = hashName;
		this.baseDeDatos = new databaseAsMatrix(sizeDatabase);
	}

	private String hashPassword(String password) {
		MessageDigest hasher = null;
		//No deja hacerlo sin el try :(
		try {
			hasher = MessageDigest.getInstance(this.hashUsed);
		} catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		byte[] bytePassword = password.getBytes(StandardCharsets.UTF_8);
		assert hasher != null;
		byte[] byteHash = hasher.digest(bytePassword);
		return Base64.getEncoder().encodeToString(byteHash);
	}

	@Override
	protected boolean isPassword(int usuarioIndex, String password) {
		if(usuarioIndex < 0) {
			lastFail = ERROR.INDEX_LESS_THAN_0;
			return false;
		}
		if(baseDeDatos.obtenerPassword(usuarioIndex).equals(hashPassword(password))) {
			ingresoExitoso();
			return true;
		}
		ingresoFallido();
		return false;
	}

	@Override
	public boolean agregarUsuario(String user, String password) {
		return baseDeDatos.agregarUsuario(user, hashPassword(password));
	}

}
