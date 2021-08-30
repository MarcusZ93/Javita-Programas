package Sockets;
import javax.swing.*;
import javax.net.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;


public class Cliente
{

        public static void main(String[] args)
        {

                FrameClient marco = new FrameClient();



        }

}


class FrameClient extends JFrame
{

        public FrameClient()
        {
                setBounds(800 , 400 , 280 , 350);

                SheetFrame laminaMarco = new SheetFrame();

                add(laminaMarco);

                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                setVisible(true);

                addWindowListener(new EnvioOnline());
                
        }


}

//-----------------------------ENVIO SEÑAL ONLINE------------------------------------

class EnvioOnline extends WindowAdapter
{
	
		public void windowOpened(WindowEvent e)
		{
		
			try
			{
				
				Socket unSocket = new Socket("192.168.0.69" , 9999);
				
				Mensajeria datos = new Mensajeria();
				
				datos.setMensaje("Online");
				
				//FLUJO PARA CREAR LA RED A TRAVES DEL DESTINATARIO
				
				ObjectOutputStream paqueteDatos = new ObjectOutputStream(unSocket.getOutputStream());
				
				paqueteDatos.writeObject(datos);
				
				unSocket.close();
				
				
			}
			catch(Exception exc)
			{
				exc.printStackTrace();
			}
			
			
		}
	
	
}


class SheetFrame extends JPanel implements Runnable
{

        /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public SheetFrame()
        {
        	
				
				String userNick = JOptionPane.showInputDialog("Bienvenido ! Introduce tu nick");

				JLabel nameNick = new JLabel("Nick: ");
				add(nameNick);
			
        		nick = new JLabel();
        		nick.setText(userNick);
    			add(nick);
    		
    			
    			IP = new JComboBox();
        		IP.addItem("Usuario 1");
        		IP.addItem("Usuario 2");
        		IP.addItem("Usuario 3");
    			add(IP);
        	
        	
                JLabel texto = new JLabel("Online: ");
                add(texto);

                
                campoChat = new JTextArea(12 , 20);
                campoChat.enable(false);
                add(campoChat);


                campo = new JTextField(20);
                add(campo);


                boton = new JButton("Enviar");
                boton.addActionListener(new EnviaTexto());
                add(boton);
                
                Thread t = new Thread(this);
                
                t.start();

                
        }


        private class EnviaTexto implements ActionListener
        {


                @Override
                public void actionPerformed(ActionEvent actionEvent)
                {

                        try
                        {
                                Socket miSocket = new Socket("192.168.0.69" , 9999);

                                Mensajeria datosEnviados = new Mensajeria();
                                
                                datosEnviados.setNick(nick.getText());
                                
                                datosEnviados.setIP(IP.getSelectedItem().toString());
                                
                                datosEnviados.setMensaje(campo.getText());
                                
                                ObjectOutputStream paqueteDatos = new ObjectOutputStream(miSocket.getOutputStream());
                                
                                paqueteDatos.writeObject(datosEnviados);
                                
                                miSocket.close();
                                
                                if(campo != null)
                                {
                                        campo.setText("");
                                }

                              
                            	paqueteDatos.close();


                        }
                        catch (IOException e)
                        {
                                System.out.println(e.getMessage());
                        }



                }


        }
        
        
		@Override
		public void run() 
		{

				try
				{
					
					ServerSocket servidorCliente = new ServerSocket(9090);
					
					Socket cliente;
					
					Mensajeria paqueteRecibido;
					
					while(true)
					{
						
						cliente = servidorCliente.accept();
						
						ObjectInputStream flujoEntrada = new ObjectInputStream(cliente.getInputStream()); 
						
						paqueteRecibido = (Mensajeria) flujoEntrada.readObject();
						
						campoChat.append(paqueteRecibido.getNick() + ": " + paqueteRecibido.getMensaje());

						
					}
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			
		}

        private JTextField campo ;
        
        private JComboBox IP;
        
        private JLabel nick;
        
        private JTextArea campoChat;

        private JButton boton;


        
}


class Mensajeria implements Serializable
{
	
		private String nick , IP , mensaje;

		public String getNick() 
		{
			return nick;
		}

		
		public void setNick(String nick) 
		{
			this.nick = nick;
		}

		
		public String getIP() 
		{
			return IP;
		}

		
		public void setIP(String iP) 
		{
			IP = iP;
		}

		
		public String getMensaje() 
		{
			return mensaje;
		}
		

		public void setMensaje(String mensaje) 
		{
			this.mensaje = mensaje;
		}
	
	
	
}