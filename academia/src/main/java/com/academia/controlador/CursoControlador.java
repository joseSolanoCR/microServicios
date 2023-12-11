package com.academia.controlador;

import java.util.List;
import java.util.Optional;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.academia.modelo.Curso;
import com.academia.servicio.CursoServicio;



@RestController
public class CursoControlador {
	
	@Autowired
	private CursoServicio servicio;
	
	
	@GetMapping("/cursos")
	public List<Curso> listarCurso(){
		return servicio.listarCurso();
	}
	
	@GetMapping("/curso/{id}")
	public ResponseEntity<Curso> obtenerCursoById(@PathVariable Integer id){
		try {
			Curso cursoDato = servicio.obtenerCursoById(id);
			if (cursoDato !=null) {
			return new ResponseEntity<>(cursoDato, HttpStatus.OK);
			} else {}return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	//@PostMapping("/cursos")
	//public void guardarCurso(@RequestBody Curso datosCurso){
	//	 servicio.guardarCurso(datosCurso);
	//}
	
	@PostMapping("/cursos")
	public ResponseEntity<String> guardarCurso(@RequestBody Curso datosCurso){ 
		try {
			 Curso cursoGuardado = servicio.guardarCurso(datosCurso);
			 Integer idnuevo = cursoGuardado.getId();
			 return new ResponseEntity<>("El curso fue almacenado " + idnuevo, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("Error al crear curso " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/cursos/{id}")
	public ResponseEntity<Curso> borrarCursoById(@PathVariable Integer id){
		try {
			Curso cursoExiste = servicio.obtenerCursoById(id);
			if (cursoExiste != null) {
				servicio.borrarCursoById(id);
				return new ResponseEntity<>(cursoExiste, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		//servicio.borrarCursoById(id);
	}


	@GetMapping("/cursosByName/{nombre}")
	public ResponseEntity<Curso> obtenerCursoById(@PathVariable String nombre){
		try {
			List<Curso> cursoDato = servicio.obtenerCursoByName(nombre);
			if (!cursoDato.isEmpty()) {
			return new ResponseEntity<>(cursoDato.get(0), HttpStatus.OK);
			} else {}return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/cursos/{id}")
	public ResponseEntity<?> actualizarCurso(@RequestBody Curso datosCurso, @PathVariable Integer id){
		try {
			Curso cursoExiste = servicio.obtenerCursoById(id);
			if (cursoExiste != null) {
				datosCurso.setId(id);
				Curso cursoGuardado = servicio.guardarCurso(datosCurso);
				return new ResponseEntity<>(cursoGuardado, HttpStatus.OK);
				}else {
					return new ResponseEntity<>("Curso no existe " + id, HttpStatus.NOT_FOUND);
				}
		} catch (Exception e) {
			return new ResponseEntity<>("Error al actualizar " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	} }
	

