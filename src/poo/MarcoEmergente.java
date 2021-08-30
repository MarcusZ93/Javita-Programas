package poo;

import javax.swing.*;

public class MarcoEmergente 
{
	
	
	public static void main(String[] args)
	{
		
		Marco frame = new Marco();
		
		
	}
	

}



class Marco extends JFrame
{
	
	public Marco()
	{
		
		setBounds(100,100,400,300);
		
		setTitle("Bienvenidos");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Lamina lamina = new Lamina();
		
		add(lamina);
		
		setVisible(true);
		
		
	}
	

	private class Lamina extends JPanel
	{
		
		public Lamina()
		{
			
			JPopupMenu emergente = new JPopupMenu();
			
			JMenu ver = new JMenu("Ver");
			
			ButtonGroup grupoVer = new ButtonGroup();
			
			JRadioButtonMenuItem iconGrande = new JRadioButtonMenuItem("Iconos grandes");
			
			
			
			ver.add(iconGrande);
			
			JMenuItem ordenar = new JMenuItem("Ordenar por");
			
			JMenuItem actualizar = new JMenuItem("Actualizar");
			
			emergente.add(ver);

			emergente.add(ordenar);
			
			emergente.add(actualizar);
			
			setComponentPopupMenu(emergente);
			
			
		}
		
		
	}
	
}