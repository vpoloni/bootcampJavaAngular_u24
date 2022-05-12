package com.empleados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.empleados.dto.Empleado;
import com.empleados.service.EmpleadoServiceImpl;

@RestController
@RequestMapping("/api")
public class EmpleadoController {
	
	@Autowired
	EmpleadoServiceImpl empleadoServideImpl;
	
	// listar todos empleados
	@GetMapping("/empleados")
	public List<Empleado> listarEmpleados(){
		return empleadoServideImpl.listarEmpleados();
	}
	
	// listar empleados por trabajo
	@GetMapping("/empleados/trabajo/{trabajo}")
	public List<Empleado> listarEmpleadoTrabajo(@PathVariable(name="trabajo") String trabajo) {
	    return empleadoServideImpl.listarEmpleadoTrabajo(trabajo);
	}
	
	// crear nuevo empleado
	@PostMapping("/empleados")
	public Empleado crearEmpleado(@RequestBody Empleado empleado) {
		
		// asignamos el salario según el trabajo 
		empleado.setSalario(empleado.asignarSalario(empleado.getTrabajo()));
		
		return empleadoServideImpl.guardarEmpleado(empleado);
	}
	
	// listar empleado por id
	@GetMapping("/empleados/{id}")
	public Empleado listarEmpleadoXID(@PathVariable(name="id") Long id) {
		
		Empleado empleadoPorId= new Empleado();
		
		empleadoPorId = empleadoServideImpl.listarEmpleadoXID(id);
		
		System.out.println("Empleado XID: "+ empleadoPorId);
		
		return empleadoPorId;
	}
	
	// actualizar empleado
	@PutMapping("/empleados/{id}")
	public Empleado actualizarEmpleado(@PathVariable(name="id")Long id, @RequestBody Empleado empleado) {
		
		Empleado empleadoSeleccionado = new Empleado();
		Empleado empleadoActualizado = new Empleado();
		
		// obtenemos empleado de la DB
		empleadoSeleccionado = empleadoServideImpl.listarEmpleadoXID(id);
		
		// seteamos nuevos valores
		empleadoSeleccionado.setNombre(empleado.getNombre());
		empleadoSeleccionado.setTrabajo(empleado.getTrabajo());
		empleadoSeleccionado.setSalario(empleado.getSalario());
		
		// actualizamos empleado en la DB
		empleadoActualizado = empleadoServideImpl.actualizarEmpleado(empleadoSeleccionado);
	
		System.out.println("El empleado actualizado es: "+ empleadoActualizado);
		
		return empleadoActualizado;
	}
	
	// eliminamos empleado por id
	@DeleteMapping("/empleados/{id}")
	public void eliminarEmpleado(@PathVariable(name="id")Long id) {
		empleadoServideImpl.eliminarEmpleado(id);
	}

}
