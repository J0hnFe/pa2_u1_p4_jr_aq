package com.example.demo;

public class MatriculaCalculo {
	public void realizarMatricula(String tipo) {
		if(tipo.equals("1")) {
			Materia mat = new Materia();
			mat.setNombre("P. Web");
			//insertar en la base
			System.out.println("Se inserto materia");
		} else {
			MateriaExtraordinaria matX = new MateriaExtraordinaria();
			matX.setNombre("P. Web");
			matX.setCantidadCreditos(10);
			//insertar en la base
			System.out.println("Se inserto materia extraordinaria");
		}
	}
}
