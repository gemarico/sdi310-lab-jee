package com.uniovi.sdi;

public class Comentario {

	private String nombre;
	private String cuerpo;

	public Comentario(String nombre, String cuerpo) {
		this.nombre = nombre;
		this.cuerpo = cuerpo;
	}

	public Comentario() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}
	
	

}
