package sda.ejemplo.services;

import java.util.List;

import sda.ejemplo.entity.Alumno;

public interface IAlumnoService {
	 List<Alumno> findAll();
	 Alumno guardarAlumno(Alumno alumno);
	 Alumno actualizarAlumno(Integer idAlumno, Alumno alumno);
	 void eliminarAlumno(Integer idAlumno);
	 Alumno buscarPorId(Integer idAlumno);
	
}