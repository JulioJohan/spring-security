package sda.ejemplo.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "alumnos")
public class Alumno implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1228126429714547056L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAlumno;
	
	@NotEmpty(message = "no debe estar vacio")
	@Size(min = 4, max = 20,message = "ser minimo de 4 con un mayor de 20 caracteres")
	@Column(nullable = false)
	private String nombre;
	
	@NotEmpty(message = "no debe estar vacio")
	@Size(min = 1, max = 12,message = "debe ser minimo de 1 con un mayor de 12 caracteres")
	@Column(name = "numero_control")
	private String numeroControl;
	
	@NotEmpty(message = "no debe estar vacio")
	@Email(message = "no es valido")
	@Column(nullable = false,unique = true)
	private String email;
	
	@Column(name = "fecha_registro")
	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;
	
	public void prePersist() {
		fechaRegistro = new Date();
	}
}
