package com.empleados.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "empleados")
public class Empleado {

	// atributos de la entidad empleado
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "trabajo")
	private String trabajo;
	
	@Column(name = "salario")
	private int salario;

	// constructores
	public Empleado() {

	}

	public Empleado(Long id, String nombre, String trabajo, int salario) {

		this.id = id;
		this.nombre = nombre;
		this.trabajo = trabajo;
		// asignamos el valor retornado por el método llamado
		this.salario = asignarSalario(this.trabajo);

	}

	// getters y setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(String trabajo) {
		this.trabajo = trabajo;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	
	// método que asigna salario según puesto de trabajo
	public int asignarSalario(String trabajo) {
		int miSalario;
		switch (trabajo) {
		case "ProgramadorSQL":
			miSalario = 2500;
			break;

		case "ProgramadorJava":
			miSalario = 3000;
			break;

		case "ProgramadorJS":
			miSalario = 3500;
			break;

		case "ProgramadorC#":
			miSalario = 2500;
			break;

		case "ProgramadorPHP":
			miSalario = 3500;
			break;

		default:
			miSalario = 1200;
		}
		return miSalario;
	}

	// método toString
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", trabajo=" + trabajo + ", salario=" + salario + "]";
	}

}
