package Excepciones;

import javax.swing.JOptionPane;

public class Aleatorios {
	
    

	public static void main(String[] args) 
	{

		
		int elementos = Integer.parseInt(JOptionPane.showInputDialog("Introduce elementos de la matriz"));
		
		int  num_Aleatorio [] = new int[elementos];
		
			
		setAleatoryNumber(num_Aleatorio);
		
		
		
		for(int elem : num_Aleatorio )
		{
			System.out.println(elem);
		}
		
		
	}



	static void setAleatoryNumber(int aVector [])
	{
		for(int i=0 ; i < aVector.length ; i++)
		{
		
			aVector[i] = (int) Math.random() * 100  ;
			
		}
	}

}
