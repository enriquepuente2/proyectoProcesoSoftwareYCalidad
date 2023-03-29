package es.deusto.spq.server;

public class Armarios extends Producto {
	/**
	 * Atributos de la clase Armario
	 */
	private TipoArmario tipoArmario;
	private int numEstanterias;
	
	/**
	 * Constructor con parametros de la clase Armario
	 * @param cod
	 * @param nombre
	 * @param tipo
	 * @param marca
	 * @param tamanyo
	 * @param precio
	 * @param stock
	 * @param ruta
	 * @param tipoArmario
	 * @param numEstanterias
	 */
	public Armarios(int cod, String nombre, String tipo, String marca, String tamanyo, double precio, int stock, String ruta,
			TipoArmario tipoArmario, int numEstanterias) {
		super(cod, nombre, tipo, marca, tamanyo, precio, stock, ruta);
		this.numEstanterias = numEstanterias;
		this.tipoArmario = tipoArmario;
	}

	/**
	 * Método get del atributo tipoArmario, el tipoArmario es un Enum.
	 * @return el tipoArmario.
	 */
	public TipoArmario getTipoArmario() {
		return tipoArmario;
	}
	
	/**
	 * Método set del atributo tipoArmario, el tipoArmario es un Enum.
	 * @param tipoArmario
	 */
	public void setTipoArmario(TipoArmario tipoArmario) {
		this.tipoArmario = tipoArmario;
	}

	/**
	 * Método get del atributo numEstanterias, el numEstanterias es un int.
	 * @return
	 */
	public int getNumEstanterias() {
		return numEstanterias;
	}
	
	/**
	 * Método set del atributo numEstanterias, el numEstanterias en un int.
	 * @param numEstanterias
	 */
	public void setNumEstanterias(int numEstanterias) {
		this.numEstanterias = numEstanterias;
	}

}
