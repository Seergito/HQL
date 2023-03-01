package Hql;



import java.math.BigDecimal;
import java.util.ArrayList;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Ej01 {
	
	static Configuration cfg=null;
	static SessionFactory factoria=null;
	static Session sesion=null;
	
	
	public static void ej01() {
		Query consulta=sesion.createQuery("SELECT x FROM Empleados x WHERE x.puesto='ADMINISTRATIVO' ORDER BY x.nombreEmpleado");
		ArrayList<Empleados> lista=(ArrayList<Empleados>) consulta.list();
		
		for (Empleados empleados : lista) {
			System.out.println(empleados);
		}
	}
	
	public static void ej02() {
		Query consulta=sesion.createQuery("SELECT x FROM Departamentos x ORDER BY x.localidad DESC ");
		ArrayList<Departamentos> lista=(ArrayList<Departamentos>) consulta.list();
		for (Departamentos departamentos : lista) {
			System.out.println(departamentos);
		}
		
	}
	
	public static void ej03() {
		Query consulta=sesion.createQuery("SELECT x.nombreEmpleado,x.puesto,x.salario FROM Empleados x ORDER BY x.puesto,x.salario");
		ArrayList<Object[]> lista=(ArrayList<Object[]>) consulta.list();
		for (Object[] objects : lista) {
			String n=(String) objects[0];
			String p=(String) objects[1];
			BigDecimal s=(BigDecimal) objects[2];
			System.out.println("Nombre: "+n+" puesto: "+p+" salario: "+s);
		}
	}
	
	public static void ej04() {
		Query consulta=sesion.createQuery("SELECT x.nombreEmpleado,x.puesto,x.salario FROM Empleados x ORDER BY x.salario DESC,x.puesto DESC");
		ArrayList<Object[]>lista =(ArrayList<Object[]>) consulta.list();
		for (Object[] object : lista) {
			String n=(String) object[0];
			String p=(String) object[1];
			BigDecimal s=(BigDecimal) object[2];
			System.out.println("Nombre: "+n+" puesto: "+p+" salario: "+s);
		}
	}
	
	public static void ej05() {
		Query consulta=sesion.createQuery("SELECT x.salario,x.comision FROM Empleados x WHERE x.departamentos=30");
		ArrayList<Object[]>lista =(ArrayList<Object[]>) consulta.list();
		for (Object[] objects : lista) {
			BigDecimal s=(BigDecimal) objects[0];
			BigDecimal c=(BigDecimal) objects[1];
			System.out.println("Salario : "+s+" Comision :"+c);
		}
			
	}
	
	public static void ej06(){
		Query consulta=sesion.createQuery("SELECT x.salario+1000 FROM Empleados x WHERE x.departamentos=30"); //DUDA JOSE; ES NECESARIO COGER 2 ELEMENTOS?
		ArrayList<BigDecimal> lista=(ArrayList<BigDecimal>) consulta.list();
		for (BigDecimal salario : lista) {
			System.out.println(salario); 
		}	
	}
	
	public static void ej07() {
		Query consulta=sesion.createQuery("SELECT x.salario,x.salario+1000 FROM Empleados x WHERE x.departamentos=30");
		ArrayList<Object[]> lista=(ArrayList<Object[]>) consulta.list();
		for (Object[] objects : lista) {
			
			BigDecimal original=(BigDecimal) objects[0];
			BigDecimal suma=(BigDecimal) objects[1];
			
			System.out.println(original+" : "+suma);	
		}
	}
	
	public static void ej08() {
		
		Query consulta=sesion.createQuery("SELECT x FROM Empleados x WHERE x.comision>(x.salario/2)");
		ArrayList<Empleados> lista=(ArrayList<Empleados>) consulta.list();
		for (Empleados empleados : lista) {
			System.out.println(empleados);
		}
		
	}
	public static void ej09() {
		
		Query consulta=sesion.createQuery("SELECT x.salario,x.comision FROM Empleados x WHERE x.numEmpleado>7500");
		ArrayList<Object[]> lista=(ArrayList<Object[]>) consulta.list();
		for (Object[] objects : lista) {
			BigDecimal s=(BigDecimal) objects[0];
			BigDecimal c=(BigDecimal) objects[1];
			System.out.println("Salario: "+s+" Comision "+c);
		}
		
	}
	
	public static void ej10() {
		Query consulta=sesion.createQuery("SELECT x.salario,x.comision FROM Empleados x WHERE x.numEmpleado>7500");
		ArrayList<Object[]> lista=(ArrayList<Object[]>) consulta.list();
		for (Object[] objects : lista) {
			BigDecimal s=(BigDecimal) objects[0];
			BigDecimal c=(BigDecimal) objects[1];
			
			System.out.println("Salario: "+s+" Comision "+c);
		}
	}
	public static void ej11() {
		Query consulta=sesion.createQuery("SELECT x.nombreEmpleado,x.puesto FROM Empleados x WHERE x.nombreEmpleado >='J%' ORDER BY x.nombreEmpleado ASC, x.puesto ASC");
		ArrayList<Object[]> lista=(ArrayList<Object[]>) consulta.list();
		for (Object[] objects : lista) {
			String n=(String) objects[0];
			String p=(String) objects [1];
			System.out.println(n+" : "+p);
		}
	}
	public static void ej12() {
		Query consulta=sesion.createQuery("SELECT x.salario,x.comision,x.salario+x.comision FROM Empleados x WHERE x.comision IS NOT NULL");
		ArrayList<Object[]> lista=(ArrayList<Object[]>) consulta.list();
		for (Object[] objects : lista) {
			BigDecimal s=(BigDecimal) objects[0];
			BigDecimal c=(BigDecimal) objects[1];
			BigDecimal r=(BigDecimal) objects[2];
			
			System.out.println(s+" + "+c+" ="+r);
		
		}
	}
	
	public static void ej13() {
		Query consulta=sesion.createQuery("SELECT x.salario,x.comision,x.salario+x.comision FROM Empleados x WHERE x.comision IS NULL");
		ArrayList<Object[]> lista=(ArrayList<Object[]>) consulta.list();
		for (Object[] objects : lista) {
			BigDecimal s=(BigDecimal) objects[0];
			BigDecimal c=(BigDecimal) objects[1];
			BigDecimal r=(BigDecimal) objects[2];
			
			System.out.println(s+" + "+c+" ="+s);
		
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
		ej01(); //EMPLEADOS ADMINISTRATIVOS ORDENADOS POR NOMBRE
		System.out.println("\n");
		System.out.println("---------------EJ02-----------------");
		ej02(); //Hallar los nombres de los departamentos ordenados por su ciudad, pero en orden descendente.
		System.out.println("\n");
		System.out.println("---------------EJ03-----------------");
		ej03();//Obtener el nombre, puesto y salario de los empleados, ordenado por puesto y salario.
		System.out.println("\n");
		System.out.println("---------------EJ04-----------------");
		ej04();//Obtener el nombre, puesto y salario de los empleados, ordenado por puesto y salario.
		System.out.println("\n");
		System.out.println("---------------EJ05-----------------");
		ej05();//Obtén los salarios y las comisiones de los empleados del departamento 30
		System.out.println("\n");
		System.out.println("---------------EJ06-----------------");
		ej06();//Obtenga los nuevos salarios que resultarían de sumar a los empleados del departamento 30 una gratificación de 1000 unidades monetarias.
		System.out.println("\n");
		System.out.println("---------------EJ07-----------------");
		ej07();//ídem. pero obteniendo también el salario original.
		System.out.println("\n");
		System.out.println("---------------EJ08-----------------");
		ej08();//Hallar los empleados que tienen una comisión superior a la mitad de su salario.
		System.out.println("\n");
		System.out.println("---------------EJ09-----------------");
		ej09();//Hallar los empleados que tienen una comisión superior a la mitad de su salario.
		System.out.println("\n");
		System.out.println("---------------EJ10-----------------");
		ej10();//Hallar el salario y la comisión de los empleados cuyo número de empleado supera a 7500
		System.out.println("\n");
		System.out.println("---------------EJ11-----------------");
		ej11();//Si dividimos los empleados en dos grupos, A y B, empezando los nombres del grupo B en la letra J, obtén los nombres y puestos de los del grupo B, por orden alfabético de ambos campos.
		System.out.println("\n");
		System.out.println("---------------EJ12-----------------");
		ej12();//Obtener el salario, la comisión y el salario total (salario + comisión) de los empleados con comisión, ordenado por número de empleado.
		System.out.println("\n");
		System.out.println("---------------EJ13-----------------");
		ej13();//ídem. pero para los que no tienen comisión

		
		
		
						
		
		
		
	}

}
