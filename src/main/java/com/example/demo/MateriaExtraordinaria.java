package com.example.demo;

public class MateriaExtraordinaria {
	private String nombre;
	private Integer cantidadCreditos;
	
	
	
	
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getCantidadCreditos() {
		return cantidadCreditos;
	}
	public void setCantidadCreditos(Integer cantidadCreditos) {
		this.cantidadCreditos = cantidadCreditos;
	}
	@Override
	public String toString() {
		return "MateriaExtraordinaria [nombre=" + nombre + ", cantidadCreditos=" + cantidadCreditos + "]";
	}
	

}
