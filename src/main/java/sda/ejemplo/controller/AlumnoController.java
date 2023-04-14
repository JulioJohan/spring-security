package sda.ejemplo.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import sda.ejemplo.entity.Alumno;
import sda.ejemplo.services.IAlumnoService;

@RestController
@CrossOrigin("*")
@RequestMapping("/alumno")
public class AlumnoController {

	@Autowired
	private IAlumnoService alumnoService;
	
	@GetMapping(value ="/todos",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <List<Alumno>> consultarTodos(){
		List<Alumno> response = alumnoService.findAll();
		return new ResponseEntity<List<Alumno>>(response,HttpStatus.OK);	
	}
	
	@PostMapping(value = "/guardarAlumno",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> guardarAlumno(@Valid @RequestBody Alumno alumno, BindingResult resultado){
		Map<String, Object> map = new HashMap<String, Object>();
		if(resultado.hasErrors()) {
			List<String> errores = resultado.getFieldErrors()
					.stream()
					.map(error -> "El Campo " + error.getField() + " " + error.getDefaultMessage())
					.collect(Collectors.toList());
			map.put("Errores", errores);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);
		}
		
		Alumno response = null;
		try {
			 response = alumnoService.guardarAlumno(alumno);
		} catch (DataAccessException excepcion) {	
			map.put("Mensaje", "Fallo al guardar el alumno");
			map.put("Error", excepcion.getMostSpecificCause() + " : " + excepcion.getMessage());
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);

		}		
		map.put("mensaje", "El Alumno se guardo con exito");
		map.put("alumno", response);
				
		return ResponseEntity.ok(map);
	}
	
	@PutMapping(value = "/actualizarAlumno/{idAlumno}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> actualizarAlumno(@PathVariable Integer idAlumno, @RequestBody Alumno alumno, BindingResult errores){
		Map<String, Object> mapErrores = new HashMap<String, Object>();
		if(errores.hasErrors()) {
			List<String> erroresLista = errores.getFieldErrors()
					.stream()
					.map(error -> "El campo " + error.getField() + " " + error.getDefaultMessage())
					.collect(Collectors.toList());
			mapErrores.put("Errores ", erroresLista);
			return new ResponseEntity<Map<String, Object>>(mapErrores,HttpStatus.BAD_REQUEST);
		}
		
	
		
		mapErrores.put("mensaje","se editi con exito");
		Alumno response = alumnoService.actualizarAlumno(idAlumno,alumno);
		mapErrores.put("Alumno", response);
		return new ResponseEntity<Alumno>(response,HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/eliminarAlumno")
	public ResponseEntity<?> eliminarAlumno(@RequestParam Integer idAlumno) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			alumnoService.eliminarAlumno(idAlumno);
		} catch (DataAccessException excepcion) {
			map.put("mensaje", "Error al eliminar");
			map.put("Error", excepcion.getLocalizedMessage() + "" + excepcion.getMessage());
			return new ResponseEntity<Map<String, Object>>(map,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		map.put("mensaje", "Error al eliminar");
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		
	}
	
	@GetMapping("/alumnoId/{idAlumno}")
	public ResponseEntity<Alumno> buscarPorId(@PathVariable("idAlumno")Integer idAlumno) {
		Alumno response = alumnoService.buscarPorId(idAlumno);
		return new ResponseEntity<Alumno>(response,HttpStatus.OK);
	}
	
}
