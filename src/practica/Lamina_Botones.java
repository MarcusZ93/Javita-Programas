package practica;

import javax.swing.*;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class Lamina_Botones extends JPanel
{
	
	
	public Lamina_Botones(String titulo , String [] options )
	{
		
			
			setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), titulo));
			
		
			setLayout(new BoxLayout( this , BoxLayout.Y_AXIS));
		
		
			 grupo = new ButtonGroup();
			
			
			for(int i = 0 ; i < options.length ; i++)
			{
				
				
					JRadioButton button = new JRadioButton(options[i]);
					
					button.setActionCommand(options[i]);
					
					add(button);
					
					
					grupo.add(button);
					
					
					button.setSelected(i == 0);
				
					
					
				
				
				
			}
			
			
			
			
		
	}
	
	private ButtonGroup grupo;
	
	
	public String getSelection()
	{
		
			/*ButtonModel myBut = grupo.getSelection(); //Obtenemos el JButton seleccionado
			
			String s = myBut.getActionCommand(); //Devolvemos el String con el nombre 
			
			return s ;*/
		
			return grupo.getSelection().getActionCommand(); //Simplificado
		
		
		
	}
	

}
