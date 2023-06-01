package com.sv.ru100213jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sv.ru100213jpa.modelos.Carrera;

public interface CarreraRepo extends JpaRepository<Carrera, Integer> {
    Carrera findByNombre(String nombre);
}
