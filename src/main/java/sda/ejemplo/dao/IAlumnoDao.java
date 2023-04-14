package sda.ejemplo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import sda.ejemplo.entity.Alumno;

public interface IAlumnoDao extends JpaRepository<Alumno, Integer> {

}
