package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.banco.repository.modelo.Cuenta;
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

		Cuenta cuenta= new Cuenta();
		cuenta.setCedulaPropietario("1718");
		cuenta.setFechaApertura(LocalDate.now());
		cuenta.setNumero("12354");
		cuenta.setSaldo(new BigDecimal(124.4));
		cuenta.setTipo("Ahorros");
		this.cuentaService.guardar(cuenta);
		Cuenta cuentaver=this.cuentaService.buscarPorNumero("12354");
	System.out.println(cuentaver);
	}

}
