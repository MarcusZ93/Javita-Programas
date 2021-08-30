package practica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Date;

import javax.swing.*;

public class Marco_Dialogos extends JFrame
{
	
	
		public Marco_Dialogos()
		{
			
				
				setLayout(new BorderLayout());
			
				setTitle("Programa ");
				
				
				setBounds(500 , 300 , 700 , 600);
				
			
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				
				setVisible(true);
				
				
				JPanel Lamina_Cuadricula = new JPanel();
				
				
				Lamina_Cuadricula.setLayout(new GridLayout(2,3));
				
				
				String primero [] = {"Mensaje" , "Confirmar" , "Opcion" , "Entrada"	};
				
				laminaTipo = new Lamina_Botones("Tipo" , primero);
	
				
					
				laminaTipoMsj = new Lamina_Botones("Tipo de mensaje" , new String[] 					//Otra forma de hacerlo
						{
								
								"ERROR_MESSAGE" , "INFORMATION_MESSAGE" , "QUESTION_MESSAGE" , "PLAIN_MESSAGE" , "WARNING_MESSAGE"
						
						});
				
				
				
				String mensajes [] = new String[] {"Cadena" , "Icono" , "Componentes" , "Otros" , "Object []"};
				
				laminaMensaje = new Lamina_Botones("Mensaje" , mensajes);
	
				
				String tOpcion [] = new String [] {"DEFAULT_OPTION" , "YES_NO_OPTION" , "YES_NO_CANCEL_OPTION" , "OK_CANCEL_OPTION"};
				
				laminaTOpcion = new Lamina_Botones ("Confirmar" , tOpcion);
				
				
				String opcion [] = new String [] {"String []" , "Icon []" , "Object []"};
				
				laminaOpciones = new Lamina_Botones ("Opción" , opcion);
				
				
				String entrada [] = new String [] {"Campo de texto" , "Combo"};
				
				laminaEntrada = new Lamina_Botones ("Entrada" , entrada);
				
				
				
				
				Lamina_Cuadricula.add(laminaTipo);
				
				Lamina_Cuadricula.add(laminaTipoMsj);
				
				Lamina_Cuadricula.add(laminaMensaje);
				
				Lamina_Cuadricula.add(laminaTOpcion);
				
				Lamina_Cuadricula.add(laminaOpciones);
				
				Lamina_Cuadricula.add(laminaEntrada);
				
					
				//Construimos la lamina inferior
				
				JPanel Lamina_Mostrar = new JPanel();
				
				JButton mostrar = new JButton("Mostrar");
				
				mostrar.addActionListener(new AccionMostrar());
				
				Lamina_Mostrar.add(mostrar);
				
				add(Lamina_Mostrar , BorderLayout.SOUTH);
				
				add(Lamina_Cuadricula , BorderLayout.CENTER);
				
				
				
			
		}
		
		
		//---------------------------------------------Proporciona el mensaje
		
		
		public Object getMsj()
		{
			
				
				String s = laminaMensaje.getSelection();
				
				if(s.equals("Cadena"))
					
						return cadenaMsj;
					
				
				else if(s.equals("Icono"))
				
					return iconMsj;
				
				
				else if(s.equals("Componente"))
					
					return compMsj;
				
				
				else if(s.equals("Otros"))
				
					return objetoMsj;
				
				
				else if(s.equals("Object []"))
				
						return new Object [] { cadenaMsj , iconMsj , compMsj , objetoMsj  } ;
					
				
				
				else	return null;
			
			
			
		}
		
		
		//Proporciona icono
		
		public int getIcon()
		{
			
				String s = laminaTipoMsj.getSelection();
			
			
				if(s.equals("ERROR_MESSAGE"))
					
						return JOptionPane.ERROR_MESSAGE;
				
				
				else if(s.equals("INFORMATION_MESSAGE"))
						
						return JOptionPane.INFORMATION_MESSAGE;
				
			
				else if(s.equals("QUESTION_MESSAGE"))
					
						return JOptionPane.QUESTION_MESSAGE;

				
				else if(s.equals("PLAIN_MESSAGE"))
	
					return JOptionPane.PLAIN_MESSAGE;

				
				else if(s.equals("WARNING_MESSAGE"))
	
					return JOptionPane.WARNING_MESSAGE;
			
				
				else return (Integer) null;
			
			
		}
		
		
		public int getOption()
		{
			
				String s = laminaTOpcion.getSelection();
				
				if(s.equals("DEFAULT_OPTION"))
					
					return JOptionPane.DEFAULT_OPTION;
			
				
				else if(s.equals("YES_NO_OPTION"))
					
					return JOptionPane.YES_NO_OPTION;

				
				else if(s.equals("YES_NO_CANCEL_OPTION"))
	
					return JOptionPane.YES_NO_CANCEL_OPTION;


				else if(s.equals("OK_CANCEL_OPTION"))
	
					return JOptionPane.OK_CANCEL_OPTION;
			
				else
					
					return 127;
			
		}
		
		
		public Object [] getObject (Lamina_Botones lamina)
		{
			
				String s = lamina.getSelection();
				
				if(s.equals("String []"))
					
					return new String []  {"Amarillo" , "Rojo" , "Azul"};
				
				else if (s.equals("Icon []"))

					return new Object [] {new ImageIcon("D:/Imagenes Java/BLUE.png") , new ImageIcon("D:/Imagenes Java/YELLOW.png") , new ImageIcon("D:/Imagenes Java/RED.png")};
		
				else if (s.equals("Object []"))
					
					return new Object [] {cadenaMsj , iconMsj , objetoMsj , compMsj};
				
				
				else return null;
			
		}
		
		
		
		
		
		//-------------------------------------------------------------------
		
		
		private class AccionMostrar implements ActionListener
		{

			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
	
					//	System.out.println(laminaTipo.getSelection());
				
					
					if(laminaTipo.getSelection().equals("Mensaje"))
		
						
							JOptionPane.showMessageDialog(Marco_Dialogos.this , getMsj(), "Titulo" , getIcon());
				
					
					
					else if(laminaTipo.getSelection().equals("Confirmar"))
							
							JOptionPane.showConfirmDialog(Marco_Dialogos.this , getMsj() , "Titulo", getOption() , getIcon() );
					
					
					
					else if(laminaTipo.getSelection().equals("Opcion"))
						
							JOptionPane.showOptionDialog(Marco_Dialogos.this, getMsj(), "Titulo", 1 , getIcon() , null, getObject(laminaOpciones) , null);
					
					
					
					else if(laminaTipo.getSelection().equals("Entrada"))
						
					{
						
							if(laminaEntrada.getSelection().equals("Campo de texto"))
							{
								JOptionPane.showInputDialog(Marco_Dialogos.this , getMsj(), "Titulo", getIcon() );
							}
							
							else 
							{
								JOptionPane.showInputDialog(Marco_Dialogos.this, getMsj(), "Titulo", getIcon(), null , new String [] {"Amarillo" , "Azul" , "Rojo"} , "Azul");
							}

					}
	
				
			}
			
			
			
		}
		
		
		
		private Lamina_Botones laminaTipo , laminaTipoMsj , laminaMensaje ;
		
		private Lamina_Botones laminaTOpcion , laminaOpciones , laminaEntrada;
		
		private String cadenaMsj = "Soy un mensajee";
		
		private Icon iconMsj = new ImageIcon("C:\\Users\\Marcus\\Downloads\\ImagenJava.png");
	
		private Object objetoMsj = new Date();
		
		private Component compMsj = new LaminaEjemplo();
		
		
	

}


class LaminaEjemplo extends JPanel
{
	

		public void paintComponent(Graphics g)
		{
			
			
				super.paintComponents(g);
				
				Graphics2D g2 = (Graphics2D) g ;
				
				Rectangle2D rect2D = new Rectangle2D.Double(0 , 0 , getWidth( ), getHeight());
			
				g2.setPaint(Color.YELLOW);
			
				g2.fill(rect2D);
				
				
			
		}
	
	
	
	
	
}


