package com.example.demo;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;
@Component
public class Profesor {

	private String nombre;
	private String apellido;
	private LocalDateTime fechaNacimiento;
	private String cedula;
	
	
	

	//to String
	@Override
	public String toString() {
		return "Profesor [nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento=" + fechaNacimiento
				+ ", cedula=" + cedula + "]";
	}
	//getters y setter
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	
}
