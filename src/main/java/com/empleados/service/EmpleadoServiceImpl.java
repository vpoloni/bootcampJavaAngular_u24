package com.empleados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empleados.dao.IEmpleadoDAO;
import com.empleados.dto.Empleado;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

	// hacemos uso de los métodos de repositorio CRUD
	@Autowired
	IEmpleadoDAO iEmpleadoDAO;

	@Override
	public List<Empleado> listarEmpleados() {

		return iEmpleadoDAO.findAll();
	}

	@Override
	public Empleado guardarEmpleado(Empleado empleado) {

		return iEmpleadoDAO.save(empleado);
	}

	@Override
	public Empleado listarEmpleadoXID(Long id) {

		return iEmpleadoDAO.findById(id).get();
	}

	@Override
	public List<Empleado> listarEmpleadoTrabajo(String trabajo) {

		return iEmpleadoDAO.findByTrabajo(trabajo);
	}

	@Override
	public Empleado actualizarEmpleado(Empleado empleado) {

		return iEmpleadoDAO.save(empleado);
	}

	@Override
	public void eliminarEmpleado(Long id) {

		iEmpleadoDAO.deleteById(id);

	}

}
