package Sockets;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor
{

        public static void main(String[] args)
        {

                FrameServidor miFrame = new FrameServidor();


        }

        
}


class FrameServidor extends JFrame implements Runnable
{

        public FrameServidor()
        {

                setTitle("SERVIDOR");

                setBounds(1200 , 300 , 280 , 350);

                JPanel mySheet = new JPanel();

                mySheet.setLayout(new BorderLayout());

                areaText = new JTextArea();
                mySheet.add(areaText, BorderLayout.CENTER);

                add(mySheet);

                setVisible(true);

                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                Thread t = new Thread(this);

                t.start();

                
        }
        

        @Override
        public void run()
        {

                try
                {

                        ServerSocket servidor = new ServerSocket(9999);
                        
                        String nick , IP , mensaje;
                        
                        Mensajeria paqueteRecibido;

                        
                        while(true)
                        {
                        	
                                Socket mySocket = servidor.accept();
                                
                                //-------------Detecta Online-------------------------
                                
                                
                                InetAddress localizacion = mySocket.getInetAddress();

                                String ipRemota = localizacion.getHostAddress();
                                
                                System.out.println("Online " + ipRemota);
                                
                                //----------------------------------------------------
                                //Leemos el objeto y almacenamos en nuestras variables la información recibida
                                
                                ObjectInputStream paqueteDatos = new ObjectInputStream(mySocket.getInputStream());

                                paqueteRecibido = (Mensajeria) paqueteDatos.readObject();

                                nick = paqueteRecibido.getNick();
                                
                                IP = paqueteRecibido.getIP();
                                
                                mensaje = paqueteRecibido.getMensaje();
                                
                               //El siguiente paso es poner la información almacenada en nuestras variables previamente
                                //Al area de texto donde se comunican ambas personas
                                
                                
                                areaText.append(" " + nick + " dice : " + mensaje + " para " + IP);

                                Socket enviarDestinatario = new Socket(IP , 9090);
                                
                                ObjectOutputStream paqueteReenvio = new ObjectOutputStream(enviarDestinatario.getOutputStream());
                                
                                paqueteReenvio.writeObject(paqueteRecibido);
                                
                                enviarDestinatario.close();
                                
                                mySocket.close();
                                
                                paqueteDatos.close();
                                
                                paqueteReenvio.close();
                         
                        }

                }
                catch (IOException | ClassNotFoundException e)
                {
                        e.printStackTrace();
                }
               
        }


        private JTextArea areaText;


}

