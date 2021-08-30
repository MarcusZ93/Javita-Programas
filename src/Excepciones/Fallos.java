package Excepciones;

import javax.swing.*;

public class Fallos 
{
	
	
	public static void main(String args [])
	{
	
		int [] miMatrix = new int[5];

		miMatrix[0] = 20;
		miMatrix[1] = 38;
		miMatrix[2] = 49;
		miMatrix[3] = 56;
		miMatrix[4] = 1623;
		
		for(int i = 0 ; i < miMatrix.length ; i++)
		{
			System.out.println("Posicion " + i + " valor : " + miMatrix[i]);
		}
		
		//Peticion de datos personales
		
		String nombre = JOptionPane.showInputDialog("Ingrese su nombre por favor");
		
		int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su nombre por favor"));
		
		System.out.println("Hola " + nombre + " tu edad es de " + edad + " años");
		
		
	}

	
	
}
