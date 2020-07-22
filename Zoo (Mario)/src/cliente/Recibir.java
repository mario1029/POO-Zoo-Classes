package cliente;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JTextArea;

public class Recibir extends Thread{
	DataInputStream in;
	Socket socket;
	BufferedReader br;
	JTextArea consola;
	public Recibir(DataInputStream in,Socket socket,JTextArea consola) {
		this.in=in;
		this.socket=socket;
		this.consola=consola;
	}
	@Override
	public void run() {
		String line = "" ;
		while (!socket.isClosed()){
			try {
				line = in.readUTF();
				consola.append(line);
			}
			catch ( IOException err ){
				System . out . println (err);
			}
		}
	}
}
