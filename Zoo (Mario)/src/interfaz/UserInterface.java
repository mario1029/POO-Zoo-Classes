package interfaz;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

import db.DB;
import interfaz.Ingresar;
public class UserInterface {

	//Atributos
	private JFrame cuadro;
	private JPanel menu;
	private JButton boton1,boton2,boton3,boton4;
	private JLabel etiqueta;
	private final int ancho=600,largo=500;
	ArrayList<Object[]> lista;
	//Constructor
	public UserInterface() {
		
		//Se crean y ubican los elementos de la vista actual
		lista = new ArrayList<Object[]>();
		menu= new JPanel();
		
		cuadro = new JFrame("Zoologico");
		cuadro.setBounds(500, 200, ancho, largo);
		
		etiqueta=new JLabel("Opciones");
		etiqueta.setBounds(ancho/2-40, 0, 100, 50);
		
		boton1=new JButton("1.Ingresar Animales");
		boton1.setBounds(ancho/2-100, 80, 200, 50);
		
		boton2=new JButton("2.Mostrar/Editar animales");
		boton2.setBounds(ancho/2-100, 160, 200, 50);
		
		boton3=new JButton("3.Comportamientos");
		boton3.setBounds(ancho/2-100, 240, 200, 50);
		
		boton4=new JButton("4.Iniciar server");
		boton4.setBounds(ancho/2-100, 320, 200, 50);
		
		//Se añaden los elementos al panel
		
		this.menu.add(etiqueta);
		this.menu.add(boton1);
		this.menu.add(boton2);
		this.menu.add(boton3);
		this.menu.add(boton4);
		this.menu.setLayout(null);
		this.menu.setVisible(true);
		
		cuadro.setContentPane(menu);
		
		//Se añade una accion para cada uno de las 3 posibles opciones asociadas a los botones
		
		this.boton1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent evento) {
	        	Ingresar ingresar1=new Ingresar(lista,menu,cuadro);
	        	cuadro.setContentPane(ingresar1.getPanel());
	        	cuadro.invalidate();
	        	cuadro.validate();
	        }
	    });
		
		this.boton2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent evento) {
	        	lista.clear();
        		DB db = DB.getInstances();
        		db.dbStatement("SELECT * FROM animales", lista);
	        	if(lista.size()>0) {
	        		Mostrar mostrar1=new Mostrar(lista,menu,cuadro);
		        	cuadro.setContentPane(mostrar1.getPanel());
		        	cuadro.invalidate();
		        	cuadro.validate();
	        	}else {
	        		JOptionPane.showMessageDialog(cuadro, "No hay animales");
	        	}
	        }
	    });
		
		this.boton3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent evento) {
	        	Comportamiento comp1=new Comportamiento(menu,cuadro);
	        	cuadro.setContentPane(comp1.getPanel());
	        	cuadro.invalidate();
	        	cuadro.validate();
	        }
	    });
		
		this.boton4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Server serv = new Server(cuadro,menu);
				cuadro.setContentPane(serv.getPanel());
				cuadro.invalidate();
				cuadro.validate();
				
			}
			
		});
		
		this.cuadro.setResizable(false);
		this.cuadro.setResizable(true);
		this.cuadro.setLayout(null);
		this.cuadro.setVisible(true);
		
		
		
	}
	public void cerrar() {
		this.cuadro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
