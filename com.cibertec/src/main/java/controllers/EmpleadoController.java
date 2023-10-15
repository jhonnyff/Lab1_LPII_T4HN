package controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import models.Empleado;


public class EmpleadoController {

	public String createEmpleado(String apellido,String nombre,int edad,String sexo, double salario) {
		SessionFactory sessionFactory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			Empleado empleado = new Empleado(apellido,nombre,edad,sexo,salario);
			session.beginTransaction();
			session.save(empleado);
			session.getTransaction().commit();
			sessionFactory.close();
			
			return "Se ha creado el registro de Empleado correctamente";
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return "Error al registrar el Empleado";
	}
	
	public String readerEmpleado(int id) {
	    SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
	    Session session = sessionFactory.openSession();
	    try {
	        session.beginTransaction();
	        Empleado empleado = session.get(Empleado.class, id);
	        session.getTransaction().commit();
	        sessionFactory.close();

	        return empleado.toString();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	
	public String updateEmpleado(int id,String apellido, String nombre, int edad, String sexo, double salario) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			Empleado empleado = session.get(Empleado.class, id);
			empleado.setApellidos(apellido);
			empleado.setNombres(nombre);
			empleado.setEdad(edad);
			empleado.setSexo(sexo);
			empleado.setSalario(salario);
			session.update(empleado);
			session.getTransaction().commit();
			sessionFactory.close();
			
			return "Se ha actualizado el registro de Empleado correctamente";
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return "Error al actualizar el registro de Empleado";
	}
	
	public String deleteEmpleado(int id) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			Empleado empleado = session.get(Empleado.class, id);
			session.delete(empleado);
			session.getTransaction().commit();
			sessionFactory.close();
			
			return "Se ha eliminado el registro de Empleado correctamente";
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return "Error al eliminar el registro de Empleado";
	}
	
		
	
}
