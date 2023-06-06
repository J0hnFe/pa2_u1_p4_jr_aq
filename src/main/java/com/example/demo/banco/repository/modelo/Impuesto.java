package com.example.demo.banco.repository.modelo;

import java.math.BigDecimal;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
//@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)	//Otra forma
public class Impuesto {

	private BigDecimal iva;

	
	//toString
	@Override
	public String toString() {
		return "Impuesto [iva=" + iva + "]";
	}

	//Getters y Setters
	public BigDecimal getIva() {
		return iva;
	}

	public void setIva(BigDecimal iva) {
		this.iva = iva;
	}
	
	
}
