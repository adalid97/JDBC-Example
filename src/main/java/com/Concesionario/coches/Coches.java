package com.Concesionario.coches;

import java.util.Date;

public class Coches {
	private int id;
	private String marca;
	private String modelo;
	private String matricula;
	private String motor;
	private Date fechaMatriculacion;
	private float precio;

	public Coches(int id, String marca, String modelo, String matricula, String motor, Date fechaMatriculacion,
			float precio) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.matricula = matricula;
		this.motor = motor;
		this.fechaMatriculacion = fechaMatriculacion;
		this.precio = precio;
	}

	public Coches() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public Date getFechaMatriculacion() {
		return fechaMatriculacion;
	}

	public void setFechaMatriculacion(Date fechaMatriculacion) {
		this.fechaMatriculacion = fechaMatriculacion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

}
