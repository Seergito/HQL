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
	public static void ej14() {
		Query consulta=sesion.createQuery("SELECT x.nombreEmpleado FROM Empleados x WHERE x.numJefe=7698 AND x.salario>1000");
		ArrayList<String> lista=(ArrayList<String>) consulta.list();
		for (String nombre : lista) {
			System.out.println(nombre);
		}
	}
	
	//"SELECT x.nombreEmpleado FROM Empleados x WHERE NOT (x.numJefe=7698 AND x.salario>1000)
	public static void ej15() {
		Query consulta=sesion.createQuery("SELECT x.nombreEmpleado FROM Empleados x WHERE NOT (x.numJefe=7698 AND x.salario>1000)");
		ArrayList<String> lista=(ArrayList<String>) consulta.list();
		for (String nombre : lista) {
			System.out.println(nombre);
		}
	}
	
	public static void ej16() {
		Query consulta=sesion.createQuery("SELECT x.nombreEmpleado,(x.comision/(x.salario+x.comision))*100 FROM Empleados x WHERE x.comision IS NOT NULL "); //DUDAS JOSE
		ArrayList<Object[]> lista=(ArrayList<Object[]>) consulta.list();
		for (Object[] objects : lista) {
			String n=(String) objects[0];
			BigDecimal r=(BigDecimal) objects[1];
			System.out.println(n+" - "+r);
		}
	}
	
	public static void ej17() {
		Query consulta=sesion.createQuery("SELECT x FROM Empleados x WHERE x.departamentos.numDepartamento=10 AND x.nombreEmpleado LIKE '%LA%'");
		
		//(SELECT y.nombre FROM Departamentos y WHERE y.nombre LIKE '%LA%'");
		ArrayList<Empleados> lista =(ArrayList<Empleados>) consulta.list();
		for (Empleados empleados : lista) {
			System.out.println(empleados);
		}
	}
	public static void ej18() {
		Query consulta=sesion.createQuery("SELECT x FROM Empleados x WHERE x.numJefe IS NULL");
		ArrayList<Empleados> lista=(ArrayList<Empleados>) consulta.list();
		for (Empleados empleados : lista) {
			System.out.println(empleados);
		}
	}
	
	//Deseamos conocer el nombre de empleado y número de departamento de los administrativos que no trabajan en el departamento 10 y cuyo salario es superior a 800, ordenados por la fecha de alta.
	public static void ej19() {
		Query consulta=sesion.createQuery("SELECT x.nombreEmpleado,x.departamentos.numDepartamento FROM Empleados x WHERE x.puesto LIKE 'ADMINISTRATIVO' AND x.departamentos.numDepartamento<>10 AND x.salario>800 ORDER BY x.fechaAlta");
		ArrayList<Object[]> lista=(ArrayList<Object[]>) consulta.list();
		for (Object[] objects : lista) {
			String n=(String) objects[0];
			int d=(Integer) objects[1];
			
			System.out.println("Nombre: "+n+ " Numero departamento "+d);
		}
		
	}
	
	public static void ej20() {
		Query consulta=sesion.createQuery("SELECT x FROM Empleados x WHERE x.nombreEmpleado LIKE 'A%' AND (x.salario>1000 OR COMISION IS NOT NULL) AND x.departamentos=30");
		ArrayList<Empleados> lista=(ArrayList<Empleados>) consulta.list();
		for (Empleados empleados : lista) {
			System.out.println(empleados);
		}
	}
	
	//Halla el nombre y salario total de todos los empleados ordenado por este último valor, de los empleados con comisión.
	public static void ej21() {
		Query consulta=sesion.createQuery("SELECT x.nombreEmpleado,x.salario+x.comision FROM Empleados x WHERE x.comision IS NOT NULL");
		ArrayList<Object[]> lista=(ArrayList<Object[]>) consulta.list();
		for (Object[] objects : lista) {
			String n=(String) objects[0];
			BigDecimal st=(BigDecimal) objects[1];
			System.out.println(n+" : "+st);
		}
	}
	//Suponiendo que el año próximo la subida del salario percibido por empleado es del 6%, hallar los nombres y salarios actuales y futuros de todos los empleados, indicando para cada uno si tienen o no comisión.
	public static void ej22() {
		Query consulta=sesion.createQuery("SELECT x.salario,x.salario+(x.salario*0.06),x.comision FROM Empleados x");
		ArrayList<Object[]> lista=(ArrayList<Object[]>) consulta.list();
		for (Object[] objects : lista) {
			BigDecimal s=(BigDecimal) objects[0];
			Double st=(Double) objects[1];
			BigDecimal c=(BigDecimal) objects[2];
			System.out.println("Salario actual = "+s+ " Salario futuro = "+st+ " Comision= "+c);
		}
		
	}
	//Para los empleados que tienen como director a algún otro con número mayor que el suyo, obtener los que reciben de salario más de 1000 y menos de 2000, o están en el departamento 30.
	public static void ej23() {
		Query consulta=sesion.createQuery("SELECT x FROM Empleados x WHERE x.numJefe>x.numEmpleado AND (x.salario>1000 AND x.salario<2000) OR x.departamentos=30");
		ArrayList<Empleados> lista=(ArrayList<Empleados>) consulta.list();
		for (Empleados empleados : lista) {
			System.out.println(empleados);
		}
	}
	//. Obtén el salario más alto de la empresa, el total destinado a comisiones y el número de empleados.
	public static void ej24() {
		Query consulta=sesion.createQuery("SELECT MAX(x.salario),SUM(x.comision),COUNT(x.numEmpleado) FROM Empleados x");
		ArrayList<Object[]> lista=(ArrayList<Object[]>) consulta.list();
		for (Object[] objects : lista) {
			BigDecimal max=(BigDecimal) objects[0];
			BigDecimal min=(BigDecimal) objects[1];
			Long count=(Long) objects[2];
			
			System.out.println("Salario MAX: "+max+ "\n"+ "Salario MIN: "+min+"\n"+"Número empleados: "+count);
		}
	}
	//. Obtén información en la que se reflejen los nombres, puestos y salarios de los que superan o igualan el salario de Allen.
	public static void ej25() {
		Query consulta=sesion.createQuery("SELECT x.nombreEmpleado,x.puesto,x.comision,x.salario FROM Empleados x WHERE x.salario>=(SELECT y.salario FROM Empleados y WHERE y.nombreEmpleado = 'ALLEN')");
		ArrayList<Object[]> lista=(ArrayList<Object[]>) consulta.list();
		for (Object[] objects : lista) {
			String n=(String) objects[0];
			String p=(String) objects[1];
			BigDecimal c=(BigDecimal) objects[2];
			BigDecimal s=(BigDecimal) objects[3];
			
			System.out.println(n+" "+p+" "+c+" "+s);
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
		System.out.println("\n");
		System.out.println("---------------EJ14-----------------");
		ej14();//Hallar el nombre de los empleados que, teniendo un salario superior a 1000, tienen como jefe al empleado de código 7698
		System.out.println("\n");
		System.out.println("---------------EJ15-----------------");
		ej15();//Halla el conjunto complementario (contrario) del resultado del ejercicio anterior.
		System.out.println("\n");
		System.out.println("---------------EJ16-----------------");
		ej16();//Hallar el porcentaje que supone la comisión sobre el salario total ( (comisión/salario_total)*100), ordenando por nombre (ojo con los valores nulos).
		System.out.println("\n");
		System.out.println("---------------EJ17-----------------");
		ej17();//Hallar los empleados del departamento 10 cuyo nombre no contiene la cadena LA.
		System.out.println("\n");
		System.out.println("---------------EJ18-----------------");
		ej18();//Obtén los empleados que no son supervisados por ningún otro.
		System.out.println("\n");
		System.out.println("---------------EJ19-----------------");
		ej19();//Deseamos conocer el nombre de empleado y número de departamento de los administrativos que no trabajan en el departamento 10 y cuyo salario es superior a 800, ordenados por la fecha de alta.
		System.out.println("\n");
		System.out.println("---------------EJ20-----------------");
		ej20();//Halla los datos de los empleados para los que, su nombre comienza por A y su salario es mayor que 1000, o, reciben comisión y trabajan en el departamento 30.
		System.out.println("\n");
		System.out.println("---------------EJ21-----------------");
		ej21();//Halla el nombre y salario total de todos los empleados ordenado por este último valor, de los empleados con comisión.
		System.out.println("\n");
		System.out.println("---------------EJ22-----------------");
		ej22();//Suponiendo que el año próximo la subida del salario percibido por empleado es del 6%, hallar los nombres y salarios actuales y futuros de todos los empleados, indicando para cada uno si tienen o no comisión.
		System.out.println("\n");
		System.out.println("---------------EJ23-----------------");
		ej23();//Para los empleados que tienen como director a algún otro con número mayor que el suyo, obtener los que reciben de salario más de 1000 y menos de 2000, o están en el departamento 30.
		System.out.println("\n");
		System.out.println("---------------EJ24-----------------");
		ej24();//. Obtén el salario más alto de la empresa, el total destinado a comisiones y el número de empleados.
		System.out.println("\n");
		System.out.println("---------------EJ25-----------------");
		System.out.println("\n");
		ej25();//. Obtén información en la que se reflejen los nombres, puestos y salarios de los que superan o igualan el salario de Allen.
		
		
		
		
		
		
		
						
		
		
		
	}

}
