package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.banco.repository.modelo.Cuenta;
import com.example.demo.banco.repository.modelo.Transferencia;
import com.example.demo.banco.service.CuentaService;
import com.example.demo.banco.service.TransferenciaService;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.EstudianteService;

@SpringBootApplication
public class Pa2U1P4RaAqApplication implements CommandLineRunner {

//	@Autowired //Anotacion para inyectar
//	private Profesor profe2; //Delego al contenedor
	@Autowired
	private CuentaService cuentaService;
	@Autowired
	
	private TransferenciaService service;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P4RaAqApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//cta1
		Cuenta cta1= new Cuenta();
		cta1.setCedulaPropietario("1718");
		cta1.setFechaApertura(LocalDate.now());
		cta1.setNumero("12354");
		cta1.setSaldo(new BigDecimal(200));
		cta1.setTipo("A");
		this.cuentaService.guardar(cta1);
		
	//cta 2
	Cuenta cta2= new Cuenta();
	cta2.setCedulaPropietario("1721");
	cta2.setFechaApertura(LocalDate.of(2015, 10, 10));
	cta2.setNumero("321");
	cta2.setSaldo(new BigDecimal(100));
	cta2.setTipo("A");
	this.cuentaService.guardar(cta2);
	
	this.service.realizar(cta1.getNumero(), cta2.getNumero(), new BigDecimal(10));
	
	System.out.println("saldo origen " + this.cuentaService.buscarPorNumero(cta2.getNumero()).getSaldo());
	System.out.println("saldo destino " + this.cuentaService.buscarPorNumero(cta1.getNumero()).getSaldo());
	
	this.service.realizar(cta2.getNumero(), cta1.getNumero(), new BigDecimal(50));
	this.service.realizar(cta1.getNumero(), cta2.getNumero(), new BigDecimal(50));
	this.service.buscarTodos().stream().forEach(System.out::println);
	//System.out.println(this.service.buscarTodos()+ "\n");
	
	}

}
