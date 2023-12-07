package com.academia.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.academia.modelo.Curso;
import com.academia.repositorio.CursoRepositorio;

@Service
public class CursoServicio {
	@Autowired
	private CursoRepositorio repositorio;
	
	
	public List<Curso> listarCurso(){
		return repositorio.findAll();
		
	}
	
	public Curso obtenerCursoById(Integer id){
		Optional<Curso> cursoOptional = repositorio.findById(id);
		
		if(cursoOptional.isPresent()) {
			return cursoOptional.get();
		} else {
			return null;
		}
		//return repositorio.findById(id).get();	
	}
	
	//public void guardarCurso(Curso datosCurso) {
	//	repositorio.save(datosCurso);
	//}
	public Curso guardarCurso(Curso datosCurso) {
		return repositorio.save(datosCurso);
	}

	public List<Curso> obtenerCursoByName(String descripcion){
		return repositorio.findByNombreEquals(descripcion);
	}
	
	public void borrarCursoById(Integer id){
		 repositorio.deleteById(id);
	}
}
