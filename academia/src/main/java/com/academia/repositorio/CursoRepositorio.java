package com.academia.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academia.modelo.Curso;

public interface CursoRepositorio extends JpaRepository<Curso, Integer>{
	List<Curso> findByNombreEquals(String nombre);

}
