package com.empleados.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.empleados.dto.Empleado;

public interface IEmpleadoDAO extends JpaRepository<Empleado, Long> {

	// petición espacial que busca empleados por el trabajo
	public List<Empleado> findByTrabajo(String trabajo);

}
