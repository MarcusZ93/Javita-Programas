package poo;

import java.util.Date;
import java.util.GregorianCalendar;

public class Uso_Empleado 
{
	
	public static void main (String args [])
	{
		
		
		Jefatura Ingeniero_Software = new Jefatura("Marco Arevalo" , 3000000 , 2001 , 01 , 27);
		Ingeniero_Software.estableceIncentivo(40000);
		
		
		
		Empleado [] misEmpleados = new Empleado[5];
		
		misEmpleados[0] = new Empleado("Marcus" , 160000 , 2022 , 6 , 30);
		misEmpleados[1] = new Empleado("Walter" , 80000 , 2020 , 10 , 27);
		misEmpleados[2] = new Empleado("Lourdes" , 199990 , 2001 , 9 , 18);
		misEmpleados[3] = new Empleado("Catalina" , 90000 , 2020 , 3 , 22);
		misEmpleados[4] = Ingeniero_Software; // ES UN , UN JEFE SIEMPRE ES UN EMPLEADO . UN EMPLEADO NO SIEMPRE ES UN JEFE
		
		for(Empleado e: misEmpleados)
		{
			
			e.addAmount(10); //Aumenta porcentaje del salario actual
		
			System.out.println("Nombre " + e.getNombre() 
			+ " Sueldo: " + e.getSalario() + " Fecha: " + e.getCalendar());
		
		}
		
		
		
	}

}


//-----------------------------------------------------------------------------------


class Empleado
{
	
	public Empleado(String name , double salary , int age , int month , int day)
	{
		
		this.name = name;
		this.salary = salary;
		this.age = age;
		this.month = month;
		this.day = day;
		
		GregorianCalendar registroEmpleado = new GregorianCalendar(age , (month-1) , day);
		
		calendario = registroEmpleado.getTime();
		
		++idSiguiente;
		
		id=idSiguiente;
		
	}
	
	
	public Empleado(String name)
	{
		this.name = name;
	}
	
	//---------------------------------------------------------------------------
	
	
	
	
	
	public String getNombre() 
	{
		return name;
	}


	public void setNombre(String name) 
	{
		this.name = name;
	}


	public double getSalario() 
	{
		return salary;
	}


	public void addAmount(double amount) 
	{
		
		double percent = (amount*salary) / 100 ;
		
		salary += percent;
	}


	public Date getCalendar() 
	{
		return calendario;
	}

	
	//-----------------------------------------------------------------------


	protected double salary;
	
	protected int age , month , day;
	
	private Date calendario;
	
	private static int idSiguiente ;
	
	private int id;

	private String name;
	
	
}


//------------------------------------------------------------------------------------------------------------------------------


class Jefatura extends Empleado
{
	
	public Jefatura(String name , double salary , int age , int month , int day)
	{
		super(name,salary,age,month,day); //Llamamos al constructor de la clase padre
	}
	
	
	public Jefatura(String name)
	{
		super(name);
	}
	
	
	//----------------------------------------------------------------------------------------
	
	public void estableceIncentivo(double incentivo) 
	{
		
		this.incentivo = incentivo;
		
	}
	
	
	public double getSalario()		//Sobreescribe al método de la clase padre para darle un uso similar pero diferente
	{
		
		double sueldoJefe = super.getSalario() + incentivo;
		
		return sueldoJefe;
	}
	
	
	private double incentivo;
	

}