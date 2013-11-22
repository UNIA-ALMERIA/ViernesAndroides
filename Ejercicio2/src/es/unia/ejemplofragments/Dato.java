package es.unia.ejemplofragments;

import java.io.Serializable;

public class Dato implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6248120548885123873L;
	private Integer numero;
	private String nombre;
	
	public Dato(Integer numero, String nombre) {
		super();
		this.numero = numero;
		this.nombre = nombre;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
