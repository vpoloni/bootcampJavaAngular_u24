package com.empleados.service;

import java.util.List;
import com.empleados.dto.Empleado;

// interface con los métodos CRUD
public interface IEmpleadoService {

	// READ todos empleados
	public List<Empleado> listarEmpleados();

	// CREATE nuevo empleado 
	public Empleado guardarEmpleado(Empleado empleado);

	// READ empleado por id
	public Empleado listarEmpleadoXID(Long id);

	// READ empleado por trabajo
	public List<Empleado> listarEmpleadoTrabajo(String trabajo);

	// UPDATE empleado
	public Empleado actualizarEmpleado(Empleado empleado);

	// DELETE empleado
	public void eliminarEmpleado(Long id);

}
