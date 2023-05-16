package com.example.demo;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Pa2U1P4RaAqApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P4RaAqApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Mi primer proyecto");
		Profesor profesor= new Profesor();
		profesor.setNombre("John");
		profesor.setCedula("09785456321");
		profesor.setFechaNacimiento(LocalDateTime.now());
		profesor.setApellido("Ramos");
		
		System.out.println(profesor);
	}

}
