package Hql;



import java.util.ArrayList;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Ej01 {
	
	static Configuration cfg=null;
	static SessionFactory factoria=null;
	static Session sesion=null;
	
	
	public static void ej1() {
		Query consulta=sesion.createQuery("SELECT x FROM Empleados x WHERE x.puesto='ADMINISTRATIVO' ORDER BY x.nombreEmpleado");
		ArrayList<Empleados> lista=(ArrayList<Empleados>) consulta.list();
		
		for (Empleados empleados : lista) {
			System.out.println(empleados);
		}
	}
	
	public static void ej2() {
		Query consulta=sesion.createQuery("SELECT x FROM Departamentos x ORDER BY x.localidad DESC ");
		ArrayList<Departamentos> lista=(ArrayList<Departamentos>) consulta.list();
		for (Departamentos departamentos : lista) {
			System.out.println(departamentos);
		}
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.OFF);

		
		cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		factoria=cfg.buildSessionFactory();
		sesion=factoria.openSession();
		System.out.println("---------------EJ01-----------------");
		ej1(); //EMPLEADOS ADMINISTRATIVOS ORDENADOS POR NOMBRE
		System.out.println("\n");
		System.out.println("---------------EJ02-----------------");
		ej2(); //Hallar los nombres de los departamentos ordenados por su ciudad, pero en orden descendente.

		
	}

}
