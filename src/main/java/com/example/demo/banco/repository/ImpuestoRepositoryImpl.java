package com.example.demo.banco.repository;

import java.math.BigDecimal;

import org.springframework.stereotype.Repository;

@Repository
public class ImpuestoRepositoryImpl implements ImpuestoRepository{

	@Override
	public BigDecimal seleccionar(String codigoImpuesto) {
		
		return new BigDecimal(12);
	}

}
