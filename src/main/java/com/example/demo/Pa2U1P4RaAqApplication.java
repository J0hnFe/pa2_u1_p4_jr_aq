package com.example.demo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.EstudianteService;

@SpringBootApplication
public class Pa2U1P4RaAqApplication implements CommandLineRunner {

//	@Autowired //Anotacion para inyectar
//	private Profesor profe2; //Delego al contenedor
	@Autowired
	private EstudianteService estudianteService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P4RaAqApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Estudiante estudiante = new Estudiante();
		estudiante.setNombre("John ");
		estudiante.setApellido("Ramos ");
		estudiante.setCedula("1718");
		estudiante.setFechaNacimiento(LocalDateTime.of(2000, 05, 18, 12, 10));

		this.estudianteService.guardar(estudiante);

		Estudiante estudiante2 = new Estudiante();
		estudiante2.setNombre("Anddy");
		estudiante2.setApellido("Quisilema ");
		estudiante2.setCedula("1721");
		estudiante2.setFechaNacimiento(LocalDateTime.of(2000, 07, 19, 12, 10));
		// 1. guardar
		this.estudianteService.guardar(estudiante2);



		// 5.imprimir todo
		List<Estudiante> reporte = this.estudianteService.reporteDeTodos();
		System.out.println("Reporte 1");
		for (Estudiante estu : reporte) {
			System.out.println(estu);
		}

		// 2.Actualizar
		estudiante.setApellido("Tamal");
		this.estudianteService.actualizar(estudiante);
		
		List<Estudiante> reporte2 = this.estudianteService.reporteDeTodos();
		System.out.println("Reporte 2");
		for (Estudiante estu : reporte2) {
			System.out.println(estu);
		}
		
		//3. Eliminar
		this.estudianteService.borrar("1721");
		List<Estudiante> reporte3 = this.estudianteService.reporteDeTodos();
		System.out.println("Reporte 3");
		for (Estudiante estu : reporte3) {
			System.out.println(estu);
		}

		//4. buscar
		Estudiante estudianteEncontrado = this.estudianteService.buscar("1718");
		System.out.println("Estudiante encontrado");
		System.out.println(estudianteEncontrado);
		
		Estudiante estudianteEncontrado2 = this.estudianteService.buscar("1721");
		System.out.println("Estudiante no encontrado");
		System.out.println(estudianteEncontrado2);
	}

}
