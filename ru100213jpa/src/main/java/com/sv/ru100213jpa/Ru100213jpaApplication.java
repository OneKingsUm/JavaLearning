package com.sv.ru100213jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sv.ru100213jpa.modelos.Alumno;
import com.sv.ru100213jpa.modelos.Carrera;
import com.sv.ru100213jpa.repository.AlumnoRepo;
import com.sv.ru100213jpa.repository.CarreraRepo;

@SpringBootApplication
public class Ru100213jpaApplication implements CommandLineRunner{

	@Autowired
	private AlumnoRepo alumnoRepo;
	@Autowired
	private CarreraRepo carreraRepo;
	public static void main(String[] args) {
		SpringApplication.run(Ru100213jpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//test();
		//guardarCarreras();
		//guardarAlumnos();
		//recuperarAlumnos();
		//modificarAlumno();
		eliminarAlumno();
	}

	private void eliminarAlumno() {
		Alumno alumno = alumnoRepo.findByCarnet("RU123456");
		if(alumno != null){
			alumnoRepo.delete(alumno);
			System.out.println("Alumno eliminado");
		}else{
			System.out.println("No se encontro ningun alumno con ese carnet");
		}
	}

	private void modificarAlumno() {
		Alumno alumno = alumnoRepo.findByCarnet("RU123456");
		if(alumno != null){
			alumno.setNombre("Juan Carlos");
			alumno.setApellido("Reyes");
			alumno.setEstado(0);
			Carrera carrera = carreraRepo.findByNombre("Ingenieria en Sistemas");
			if(carrera != null){
				alumno.getCarrera().setNombre("Ingenieria en Ciencias de la Computacion");
				alumnoRepo.save(alumno);
				System.out.println("Alumno modificado");
			}else{
				System.out.println("No se encontro la carrera");
			}
		}else{
			System.out.println("No se encontro ningun alumno con ese carnet");
		}
	}

	private void recuperarAlumnos() {
		Alumno alumno = alumnoRepo.findByCarnet("RU123456");
		if(alumno != null){
			System.out.println("Nombre: " + alumno.getNombre());
			System.out.println("Apellido: " + alumno.getApellido());
			System.out.println("Carrera: " + alumno.getCarrera().getNombre());
		}else{
			System.out.println("No se encontro ningun alumno con ese carnet");
		}
	}

	private void guardarAlumnos() {
		Alumno estudiante1 = new Alumno();
        estudiante1.setCarnet("RU123456");
        estudiante1.setNombre("Juan");
        estudiante1.setApellido("Reyes");
        estudiante1.setEstado(1);

        Alumno estudiante2 = new Alumno();
        estudiante2.setCarnet("JR234567");
        estudiante2.setNombre("Julia");
        estudiante2.setApellido("Sanchez");
        estudiante2.setEstado(1);

        Alumno estudiante3 = new Alumno();
        estudiante3.setCarnet("JA345678");
        estudiante3.setNombre("Miguel");
        estudiante3.setApellido("Jimenez");
        estudiante3.setEstado(1);

		alumnoRepo.saveAll(List.of(estudiante1, estudiante2, estudiante3));
	}

	private void guardarCarreras() {
		Carrera c1 = new Carrera();
		c1.setNombre("Ingenieria en Sistemas");
		carreraRepo.save(c1);
		Carrera c2 = new Carrera();
		c2.setNombre("Ingenieria Industrial");
		carreraRepo.save(c2);
		Carrera c3 = new Carrera();
		c3.setNombre("Ingenieria en Electronica");
		carreraRepo.save(c3);
	}

	private void test() {
		System.out.println("Conexion exitosa");
		System.out.println(alumnoRepo);
	}
}
