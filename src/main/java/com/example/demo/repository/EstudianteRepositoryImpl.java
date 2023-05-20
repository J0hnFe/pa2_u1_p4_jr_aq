package com.example.demo.repository;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Estudiante;
@Repository

public class EstudianteRepositoryImpl implements EstudianteRepository{

	private static List<Estudiante> baseDatos = new ArrayList<>();
	
	@Override
	public void insertar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		baseDatos.add(estudiante); //mockeando insert
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Estudiante seleccionar(String cedula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		
	}

}
