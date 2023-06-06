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

import com.example.demo.banco.repository.modelo.Cajero;
import com.example.demo.banco.repository.modelo.Cuenta;
import com.example.demo.banco.repository.modelo.Impuesto;
import com.example.demo.banco.repository.modelo.Presidente;
import com.example.demo.banco.repository.modelo.Transferencia;
import com.example.demo.banco.service.CargaSistemaService;
import com.example.demo.banco.service.CuentaService;
import com.example.demo.banco.service.TransferenciaService;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.EstudianteService;

@SpringBootApplication
public class Pa2U1P4RaAqApplication implements CommandLineRunner {

	@Autowired
	private Cajero cajero;
	
	@Autowired
	private Cajero cajero2;
	
	@Autowired
	private Presidente presidente;
	
	@Autowired
	private Presidente presidente2;
	
	@Autowired
	private Impuesto impuesto;
	
	@Autowired
	private TransferenciaService transferenciaService;
	
	@Autowired
	private CargaSistemaService cargaSistemaService;
	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P4RaAqApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		this.cajero.setApellido("Ramos");
		this.cajero.setNombre("John");
		this.cajero.setSalario(new BigDecimal(100));
		
		this.cajero2.setApellido("Quisilema");
		this.cajero2.setNombre("Anddy");
		this.cajero2.setSalario(new BigDecimal(100));
		
		this.presidente.setApellido("Porras");
		this.presidente.setNombre("Andrea");
		this.presidente.setCedula("1147");
		
		this.presidente2.setApellido("Taco");
		
		System.out.println(this.cajero);
		System.out.println(this.cajero2);
		System.out.println(this.presidente);
		System.out.println(this.presidente2);
		///////////////////////////////////////////////////////////
		System.out.println("♣♥M♣ıSegunda parte del taller ♥");
		
		this.cargaSistemaService.cargar();
		System.out.println(this.impuesto);
		
		Transferencia t = new Transferencia();
		t.setCuentaDestino(null);
		t.setCuentaOrigen(null);
		t.setFecha(LocalDateTime.now());
		t.setMonto(new BigDecimal(100));
		t.setNumero("1234");
		
		this.transferenciaService.guardar(t);
		
		
	}

}
