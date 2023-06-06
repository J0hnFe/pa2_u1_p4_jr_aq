package com.example.demo.banco.repository;

import java.math.BigDecimal;

public interface ImpuestoRepository {

	public BigDecimal seleccionar(String codigoImpuesto);
	
}
