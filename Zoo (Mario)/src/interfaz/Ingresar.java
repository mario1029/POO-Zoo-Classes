package interfaz;
import javax.swing.*;

import db.DB;

import java.awt.event.*;
import java.util.ArrayList;
public class Ingresar {

	private JPanel panel;
	private JButton agregar,salir;
	private JLabel ingresar,c1,c2,c3,c4,c5,c6;
	private JTextField l1,l2,l3,l4,l5,l6;
	private JRadioButton b1,b2,b3,b4,b5;
	private final int x=500,y=500,ancho=100,alto=20,margen=100;

	public Ingresar(ArrayList<Object[]> list, JPanel anterior, JFrame cuadro) {
		
		ingresar=new JLabel("Ingrese Animal:");
		ingresar.setBounds(200, 50, ancho, 50);
		
		//Boton de agregar animal y de salir
		
		agregar = new JButton("Agregar");
		agregar.setBounds(x-2*ancho, y-5*alto, ancho, alto);
		
		salir=new JButton("Salir");
		salir.setBounds(ancho, y-5*alto, ancho, alto);
		
		//Creando y ubicando etiquetas
		
		c1= new JLabel("Descripcion");
		c1.setBounds(margen,y/5,ancho,alto);
		
		c2= new JLabel("Pelaje");
		c2.setBounds(margen,y/5+2*alto,ancho,alto);
		
		c3= new JLabel("Alimentacion");
		c3.setBounds(margen,y/5+4*alto,ancho,alto);
		
		c4= new JLabel("Altura(cm)");
		c4.setBounds(ancho+margen,y/5,ancho,alto);
		
		c5= new JLabel("Peso(Kg)");
		c5.setBounds(ancho+margen,y/5+2*alto,ancho,alto);
		
		c6= new JLabel("Edad");
		c6.setBounds(ancho+margen,y/5+4*alto,ancho,alto);
		
		
		//Creando entradas de valores
		
		l1= new JTextField();
		l1.setBounds(margen, y/5+alto, ancho-10, alto);

		l2= new JTextField();
		l2.setBounds(margen, y/5+3*alto, ancho-10, alto);
		
		l3= new JTextField();
		l3.setBounds(margen, y/5+5*alto, ancho-10, alto);
		
		l4= new JTextField();
		l4.setBounds(ancho+margen, y/5+alto, ancho-10, alto);
		
		l5= new JTextField();
		l5.setBounds(ancho+margen, y/5+3*alto, ancho-10, alto);
		
		l6= new JTextField();
		l6.setBounds(ancho+margen, y/5+5*alto, ancho-10, alto);
		
		//Creando y ubicando opciones de especie
		
		b1=new JRadioButton("Mamifero",true);
		b1.setBounds(200+margen, y/5+alto, ancho, alto);
		
		b2=new JRadioButton("Anfibio",false);
		b2.setBounds(200+margen, y/5+2*alto, ancho, alto);
		
		b3=new JRadioButton("Reptil",false);
		b3.setBounds(200+margen, y/5+3*alto, ancho, alto);
		
		b4=new JRadioButton("Pez",false);
		b4.setBounds(200+margen, y/5+4*alto, ancho, alto);
		
		b5=new JRadioButton("Ave",false);
		b5.setBounds(200+margen, y/5+5*alto, ancho, alto);

		ButtonGroup grupo=new ButtonGroup();
		grupo.add(b1);
		grupo.add(b2);
		grupo.add(b3);
		grupo.add(b4);
		grupo.add(b5);
		
		//Se crea una accion que determina el tipo de animal y muestra el atributo en base a ello
		ActionListener Accion=new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				if(evento.getSource()==b1) {
					c2.setText("Pelaje");
				}else if(evento.getSource()==b2){
					c2.setText("Resbaladizo");
				}else if(evento.getSource()==b3) {
					c2.setText("Escamas");
				}else if(evento.getSource()==b4) {
					c2.setText("Branqueas");
				}else {
					c2.setText("Pico");
				}
			}
		};
		
		//Se crea la accion de agregar el animal a la base de datos
		agregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				if(l1.getText().isBlank()||l4.getText().isBlank()||l5.getText().isBlank()||l6.getText().isBlank()) {
					JOptionPane.showMessageDialog(cuadro, "Datos Insuficientes");					
				}else {
					DB db = DB.getInstances();
					cuadro.setContentPane(anterior);
					if(b1.isSelected()) {
						Object[] objetos= {l1.getText(), "Sangre Caliente" ,l3.getText(),Float.parseFloat(l4.getText()) ,Float.parseFloat(l5.getText()) ,Integer.parseInt(l6.getText()),l2.getText(),"Mamifero"};
						db.dbPrepareStatement("insert into animales(descripcion,circulacion,alimentacion,altura,peso,edad,atributo,categoria) values( ?, ?, ?, ?, ?, ?, ?, ?)", objetos);
					}else if(b2.isSelected()){
						Object[] objetos = {l1.getText(), "Sangre Fria" ,l3.getText(),Float.parseFloat(l4.getText()) ,Float.parseFloat(l5.getText()) ,Integer.parseInt(l6.getText()),l2.getText(),"Anfibio"};
						db.dbPrepareStatement("insert into animales(descripcion,circulacion,alimentacion,altura,peso,edad,atributo,categoria) values( ?, ?, ?, ?, ?, ?, ?, ?)", objetos);
					}else if(b3.isSelected()) {
						Object[] objetos = {l1.getText(), "Sangre Fria" ,l3.getText(),Float.parseFloat(l4.getText()) ,Float.parseFloat(l5.getText()) ,Integer.parseInt(l6.getText()),l2.getText(),"Reptil"};
						db.dbPrepareStatement("insert into animales(descripcion,circulacion,alimentacion,altura,peso,edad,atributo,categoria) values( ?, ?, ?, ?, ?, ?, ?, ?)", objetos);
					}else if(b4.isSelected()) {
						Object[] objetos = {l1.getText(), "Sangre Fria" ,l3.getText(),Float.parseFloat(l4.getText()) ,Float.parseFloat(l5.getText()) ,Integer.parseInt(l6.getText()),l2.getText(),"Pez"};
						db.dbPrepareStatement("insert into animales(descripcion,circulacion,alimentacion,altura,peso,edad,atributo,categoria) values( ?, ?, ?, ?, ?, ?, ?, ?)", objetos);
					}else {
						Object[] objetos = {l1.getText(), "Sangre Caliente" ,l3.getText(),Float.parseFloat(l4.getText()) ,Float.parseFloat(l5.getText()) ,Integer.parseInt(l6.getText()),l2.getText(),"Ave"};
						db.dbPrepareStatement("insert into animales(descripcion,circulacion,alimentacion,altura,peso,edad,atributo,categoria) values( ?, ?, ?, ?, ?, ?, ?, ?)", objetos);
					}
					JOptionPane.showMessageDialog(cuadro, "Animal Ingresado");
				}
			}
		});
		
		//Se crea una accion para salir de la vista actual
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				cuadro.setContentPane(anterior);
			}
		});
		
		
		//Se crea un KeyListener que permite evitar que el usuario meta datos no numericos dentro de los campos edad, altura y peso
		KeyListener validar= new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				if((!Character.isDigit(e.getKeyChar()))&&(e.getSource()==l6)) {
					e.consume();
				}else if(!((e.getKeyChar()=='.')||Character.isDigit(e.getKeyChar()))) {
					e.consume();
				}			
			}
			@Override
			public void keyPressed(KeyEvent e) {
							
			}
			@Override
			public void keyReleased(KeyEvent e) {
					
			}
		};
		
		//Se agrega los Listener de de acciones y de teclas
		l4.addKeyListener(validar);
		l5.addKeyListener(validar);
		l6.addKeyListener(validar);
		
		b1.addActionListener(Accion);
		b2.addActionListener(Accion);
		b3.addActionListener(Accion);
		b4.addActionListener(Accion);
		b5.addActionListener(Accion);
		
		//Se crea el panel y se le agregan todos los elementos
		
		panel=new JPanel();
		panel.setSize(500, 500);
		panel.setLayout(null);
		panel.add(ingresar);
		panel.add(agregar);
		panel.add(salir);
		
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);
		panel.add(b5);
		
		panel.add(c1);
		panel.add(c2);
		panel.add(c3);
		panel.add(c4);
		panel.add(c5);
		panel.add(c6);
		
		panel.add(l1);
		panel.add(l2);
		panel.add(l3);
		panel.add(l4);
		panel.add(l5);
		panel.add(l6);
	}
	public JPanel getPanel() {
		return this.panel;
	}
}
