package sda.ejemplo.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sda.ejemplo.dao.IAlumnoDao;
import sda.ejemplo.entity.Alumno;

@Service
public class AlumnoService implements IAlumnoService {

	@Autowired
	private IAlumnoDao alumnoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Alumno> findAll() {
		List<Alumno> listaAlumnos = alumnoDao.findAll();
		return listaAlumnos;
	}

	@Override
	@Transactional
	public Alumno guardarAlumno(Alumno alumno) {

		
		Alumno alumnoGuardar = alumnoDao.save(alumno);				
		return alumnoGuardar;
	}

	@Override
	public Alumno actualizarAlumno(Integer idAlumno ,Alumno alumno) {
		
		Optional<Alumno> alumnoOptional = Optional.empty();
		
		alumnoOptional = alumnoDao.findById(idAlumno);
		Alumno alumnoNuevo = alumnoOptional.get();
		Alumno alumnoActualizado = null;
		try {
			alumnoNuevo.setEmail(alumno.getEmail());
			alumnoNuevo.setNombre(alumno.getNombre());
			alumnoNuevo.setNumeroControl(alumno.getNumeroControl());		
			
			alumnoActualizado = alumnoDao.save(alumnoNuevo);	
		} catch (DataAccessException excepcion) {

		}
		
					
		return alumnoActualizado;
	}

	@Override
	public void eliminarAlumno(Integer idAlumno) {
		alumnoDao.deleteById(idAlumno);
	}

	@Override
	public Alumno buscarPorId(Integer idAlumno) {
		Optional<Alumno> alumnoOptional = Optional.empty();
		
		try {
			alumnoOptional = alumnoDao.findById(idAlumno);
		} catch (DataAccessException excepcion) {
			excepcion.getMessage();
		}
		
		return alumnoOptional.get();
	}
	
	

}
