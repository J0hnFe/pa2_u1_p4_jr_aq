package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;

public interface EstudianteService {

	
	public void guardar(Estudiante estudiante);

	public void actualizar(Estudiante estudiante);

	// se buscamos por id
	public Estudiante buscar(String cedula);

	//eliminamos por un identificador
	public void borrar(String cedula);
	
	//Buscar todos los elementos
	public List<Estudiante> reporteDeTodos();
	
}
