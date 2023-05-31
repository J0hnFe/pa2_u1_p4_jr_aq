package com.example.demo.banco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.banco.repository.CuentaRepository;
import com.example.demo.banco.repository.modelo.Cuenta;
@Service
public class CuentaServiceImpl implements CuentaService{
@Autowired
private CuentaRepository cuentaRepository;
	@Override
	public void guardar(Cuenta cuenta) {
		// TODO Auto-generated method stub
		this.cuentaRepository.insertar(cuenta);
	}

	@Override
	public void actualizar(Cuenta cuenta) {
		// TODO Auto-generated method stub
		this.cuentaRepository.actualizar(cuenta);
	}

	@Override
	public void borrar(String numero) {
		// TODO Auto-generated method stub
		this.cuentaRepository.eliminar(numero);
	}

	@Override
	public Cuenta buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.cuentaRepository.seleccionarNumero(numero); // Esto solo bypasssea, en ese caso no hace falta llamar
																// a SERVICE

	}

}
