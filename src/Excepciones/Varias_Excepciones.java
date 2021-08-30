package Excepciones;

import javax.swing.JOptionPane;

public class Varias_Excepciones {

	public static void main(String[] args) 
	{
	
		division();
		
	}
	
	
	static void division()
	{
		
		int num1 = Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero"));
		
		int num2 = Integer.parseInt(JOptionPane.showInputDialog("Introduce otro numero"));
		
		System.out.println("El resultado de la division es " + (num1/num2) );
		
		
	}

}
