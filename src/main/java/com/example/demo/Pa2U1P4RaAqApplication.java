package com.example.demo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Pa2U1P4RaAqApplication implements CommandLineRunner {

	@Autowired //Anotacion para inyectar
	private Profesor profe2; //Delego al contenedor

	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P4RaAqApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Mi primer proyecto");
		Profesor profesor = new Profesor();
		profesor.setNombre("John ");
		profesor.setCedula("09785456321");
		profesor.setFechaNacimiento(LocalDateTime.of(2000, 07, 19, 16, 0));
		profesor.setApellido("Ramos");
		System.out.println(profesor);
		
		Profesor profe3 = new Profesor();
		profe3 = profesor;
		System.out.println(profe3);
		profesor.setApellido("Tamal");
		System.out.println(profe3);
		

		profe2.setNombre("Anddy"); //"Pido" el objeto al contenedor
		System.out.println(profe2.getNombre());
		
		MatriculaCalculo mat = new MatriculaCalculo();
		mat.realizarMatricula("1");
		
	}

}
