package views;

import controllers.EmpleadoController;

public class EmpleadoView {
	public static void main(String[] args) {
		String empleado;
		//Create   C
		empleado = new EmpleadoController().createEmpleado("Olivares sapata", "Manuel", 29,"M" , 3300.00);
		System.out.println(empleado);
		
		//Read   R
		//empleado = new EmpleadoController().readerEmpleado(1);
		//System.out.println(empleado);
		
		//Update U
		//empleado = new EmpleadoController().updateEmpleado(1, "Olivares Zapata","Manuel Alejandro", 30, "M", 3800.50);
		//System.out.println(empleado);
		
		//Delete D
		//empleado = new EmpleadoController().deleteEmpleado(1);
		//System.out.println(empleado);
	}
}
