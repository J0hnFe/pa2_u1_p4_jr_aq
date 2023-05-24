package com.example.demo.banco.service;

import com.example.demo.banco.repository.modelo.Transferencia;

public interface TransferenciaService {

	
	public void guardar(Transferencia transferencia);
	public void actualizar(Transferencia transferencia);
	public void borrar(String numero);
	public Transferencia buscarPorNumero(String numero);
	
	
	
	
}
