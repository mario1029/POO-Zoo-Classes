package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import db.DB;

import javax.swing.*;
public class Server implements Runnable{
	private JPanel panel;
	private JButton salir;
	private JTextArea consola;
	private JScrollPane scroll;
	private ServerSocket server = null ;
	private Socket socket = null ;
	private DataOutputStream out = null ;
	private DataInputStream in = null ;
	private DB db;
	public Server(JFrame cuadro, JPanel menu) {
		
		consola = new JTextArea();
		consola.setDisabledTextColor(Color.BLACK);
		consola.setEnabled(false);
		scroll=new JScrollPane(consola);
		
		salir=new JButton("Salir y Cerrar Server");
		salir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cuadro.setContentPane(menu);
			}
			
		});
		
		
		panel=new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(scroll,BorderLayout.CENTER);
		panel.add(salir,BorderLayout.SOUTH);
		db=new DB();
		Thread t = new Thread(this);
		t.start();
	}
	
	public JPanel getPanel() {
	return this.panel;
	}

	@Override
	public void run() {
		try {
			server = new ServerSocket ( 3000 );
			consola.append("Servidor Inicio");
			consola.append("\nEsperando por un cliente ...");
			socket = server . accept ();
			consola.append("\nCliente con la dirección: " +socket.getRemoteSocketAddress().toString()+" Se ha conectado" );
			in = new DataInputStream ( new	BufferedInputStream ( socket . getInputStream ()));
			out = new DataOutputStream ( socket.getOutputStream ());
		}catch(IOException err) {
			System.out.println(err);
		}
		String line = "" ;
		while (!line.equalsIgnoreCase("/OVER")){
			try {
				// Lee el mensaje enviado
				line = in.readUTF ();
				consola.append("\nCliente:"+line);
				if(line.startsWith("/")) {
					line=line.substring(1);
					if(db.existe(line)) {
						consola.append("\nExiste");
						ArrayList<Object[]> Animales = new ArrayList<Object[]>();
						db.dbStatement("SELECT * FROM animales where descripcion='"+line+"'", Animales);
						for(int i=0;i<Animales.size();i++) {
							consola.append("\nDescripcion: "+Animales.get(i)[0]);
							out.writeUTF("\nDescripcion: "+Animales.get(i)[0]);
							
							consola.append("\nCirculacion: "+Animales.get(i)[1]);
							out.writeUTF("\nCirculacion: "+Animales.get(i)[1]);
							
							consola.append("\nAlimentacion: "+Animales.get(i)[2]);
							out.writeUTF("\nAlimentacion: "+Animales.get(i)[2]);
							
							consola.append("\nAltura: "+Animales.get(i)[3]);
							out.writeUTF("\nAltura: "+Animales.get(i)[3]);
							
							consola.append("\nPeso: "+Animales.get(i)[4]);
							out.writeUTF("\nPeso: "+Animales.get(i)[4]);
							
							consola.append("\nEdad: "+Animales.get(i)[5]);
							out.writeUTF("\nEdad: "+Animales.get(i)[5]);
							
							consola.append("\nAtributo: "+Animales.get(i)[6]);
							out.writeUTF("\nAtributo: "+Animales.get(i)[6]);
							
							consola.append("\nEspecie:"+Animales.get(i)[7]+"\n");
							out.writeUTF("\nEspecie:"+Animales.get(i)[7]+"\n");
						}
					}
				}
			}
			catch ( IOException err ) {
				System.out.println(err);
			}
		}
		// Cierra las conexiones
		consola.append("\nServer:Cerrando Conexion" );
		try {
			socket.close();
			in . close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
}
