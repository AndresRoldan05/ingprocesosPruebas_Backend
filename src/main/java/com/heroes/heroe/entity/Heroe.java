package com.heroes.heroe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="heroes")
public class Heroe {
	
	@Id
	@GeneratedValue(generator="system-uuid")//esto es necesario ya que es tipo String
	@GenericGenerator(name="system-uuid", strategy = "uuid") //Por ser un autogenerado de string
	@Column(name="id")
	private String id;
	
	@Column(name="nombre", unique=true)
	private String nombre;
	
	@Column(name="poder")
	private String poder;
	
	@Column(name="vivo")
	private boolean vivo;

	public Heroe(String id, String nombre, String poder, boolean vivo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.poder = poder;
		this.vivo = vivo;
	} 
		
	public Heroe() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPoder() {
		return poder;
	}

	public void setPoder(String poder) {
		this.poder = poder;
	}

	public boolean isVivo() {
		return vivo;
	}

	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}
	
	
	

}
