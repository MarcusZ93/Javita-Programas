package Excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EntradaDatos {

	public static void main(String[] args) 
	{

		System.out.println("¿Que deseas hacer?");
		
		System.out.println("1: Introducir datos");
		System.out.println("2: Salir del programa");
		
		
		Scanner entrada = new Scanner(System.in);
		
		int decision = entrada.nextInt();
		
		if(decision == 1)
		{
			try {
					pedirDatos();
			}
			
			catch(InputMismatchException e)
			{
				System.out.println("ERROR 404 : Sos un pelotudo");
			}
		}
		else
		{
			System.out.println("Adios programador");
			System.exit(0);
		}
		
		entrada.close();
		
	}
	
	
	static void pedirDatos() throws InputMismatchException
	{
		
		
			Scanner miEntrada = new Scanner(System.in);
		
			System.out.println("Introduce tu nombre , por favor.");
			String nomUser = miEntrada.nextLine();
		
			System.out.println("Introduce tu edad , por favor.");
			int edadUser = miEntrada.nextInt();
		
			System.out.println("Hola " + nomUser + " . El año que viene tendras " + (edadUser+1) + " años" );

			miEntrada.close();
			
			System.out.println("Hemos terminado");
		}
	
		
		
	}


