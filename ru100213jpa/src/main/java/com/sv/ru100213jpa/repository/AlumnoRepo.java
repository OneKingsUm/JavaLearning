package com.sv.ru100213jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sv.ru100213jpa.modelos.Alumno;
import java.util.List;


public interface AlumnoRepo extends JpaRepository<Alumno, Integer> {
    Alumno findByCarnet(String carnet);
}
