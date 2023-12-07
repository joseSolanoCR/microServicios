package com.academia.modelo;

import org.springframework.boot.context.properties.bind.Name;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String descripcion;
	private String tiempo;
	private String usuario;
	
	
	public Curso(Integer id, String nombre, String descripcion, String tiempo, String usuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tiempo = tiempo;
		this.usuario = usuario;
	}
	
	
	public Curso( String nombre, String descripcion, String tiempo, String usuario) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tiempo = tiempo;
		this.usuario = usuario;
	}
	
	public Curso() {
		super();

	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getTiempo() {
		return tiempo;
	}


	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
		

}
