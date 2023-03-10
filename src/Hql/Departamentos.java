package Hql;
// Generated 28 feb 2023 12:35:48 by Hibernate Tools 6.1.5.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Departamentos generated by hbm2java
 */
public class Departamentos implements java.io.Serializable {

	@Override
	public String toString() {
		return "Departamentos [numDepartamento=" + numDepartamento + ", nombre=" + nombre + ", localidad=" + localidad
				+ "]";
	}

	private int numDepartamento;
	private String nombre;
	private String localidad;
	private Set empleadoses = new HashSet(0);

	public Departamentos() {
	}

	public Departamentos(int numDepartamento, String nombre, String localidad) {
		this.numDepartamento = numDepartamento;
		this.nombre = nombre;
		this.localidad = localidad;
	}

	public Departamentos(int numDepartamento, String nombre, String localidad, Set empleadoses) {
		this.numDepartamento = numDepartamento;
		this.nombre = nombre;
		this.localidad = localidad;
		this.empleadoses = empleadoses;
	}

	public int getNumDepartamento() {
		return this.numDepartamento;
	}

	public void setNumDepartamento(int numDepartamento) {
		this.numDepartamento = numDepartamento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public Set getEmpleadoses() {
		return this.empleadoses;
	}

	public void setEmpleadoses(Set empleadoses) {
		this.empleadoses = empleadoses;
	}

}
