package cliente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.*;

public class ClienteApp {
	private JFrame cuadro;
	private JPanel panel1,panel2;
	private JButton enviar;
	private JTextArea consola;
	private JTextField entrada;
	private JScrollPane scroll;
	private Socket socket = null ;
	private DataOutputStream out = null ;
	private DataInputStream in = null ;
	
	public ClienteApp() {
		
		try {
			socket = new Socket ( "localhost" , 3000 );
	
			out = new DataOutputStream ( socket.getOutputStream ());
	
			in = new DataInputStream ( new	BufferedInputStream ( socket.getInputStream ()));
		
			
			} catch ( IOException err ) {
			System . out . println (err);
			}
				
		cuadro=new JFrame("Cliente");
		cuadro.setBounds(500, 200, 500, 300);
		cuadro.setResizable(true);
		
		consola = new JTextArea();
		consola.setDisabledTextColor(Color.BLACK);
		consola.setEnabled(false);
		
		entrada = new JTextField(30);
		
		enviar= new JButton("Enviar");
		enviar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!entrada.getText().equals("")) {
					consola.append("\nCliente: "+entrada.getText());
					try {
						out.writeUTF(entrada.getText());
					}
					catch ( IOException err ){
						System.out.println(err);
					}
				}entrada.setText("");
				
			}
			
		});
		
		
		scroll=new JScrollPane(consola);
		
		panel2 = new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel2.add(entrada);
		panel2.add(enviar);

		
		panel1=new JPanel();
		panel1.setLayout(new BorderLayout());
		panel1.add(scroll, BorderLayout.CENTER);
		panel1.add(panel2, BorderLayout.PAGE_END);
		
		cuadro.add(panel1);
		cuadro.setVisible(true);
		cuadro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Recibir reciv = new Recibir(in,socket,consola);
		reciv.start();
		
		
	}

}
