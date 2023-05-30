package com.example.demo.banco.repository;

import com.example.demo.banco.repository.modelo.Cuenta;

public interface CuentaRepository {

	
	public void insertar(Cuenta cuenta);
	public void actualizar(Cuenta cuenta);
	public void eliminar(String numero);
	public Cuenta seleccionarNumero(String numero);
	
	
	
}
