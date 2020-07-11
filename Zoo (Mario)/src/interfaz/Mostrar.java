package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

import db.DB;

public class Mostrar {
	private JLabel l1,l2,l3,l4,l5,l6,l7, titulo,edit;
	private JPanel panel;
	private JButton siguiente,salir,borrar,atras,edicion;
	private JComboBox<String> editar;
	private JTextField datoEdit;
	private Object[] muestra;
	final int x=500,y=500,ancho=400,alto=30;
	int index;
	public Mostrar(ArrayList<Object[]> Animales,JPanel anterior, JFrame cuadro) {
		//Se define el index con el cual se muestra al ultimo animal
		index =Animales.size()-1;
		muestra = Animales.get(index);
		
		//Se crean todos los JLabel y su posicion
		panel = new JPanel();
		panel.setSize(x,y);
		
		titulo=new JLabel("Animal #"+index);
		titulo.setBounds(250-100, 70, 100, alto);
		
		l1= new JLabel("Descripcion:"+muestra[0]);
		l1.setBounds(100,100,ancho,alto);
		
		l2= new JLabel("Circulacion:"+muestra[1]);
		l2.setBounds(100,130,ancho,alto);
		
		l3= new JLabel("Alimentacion:"+muestra[2]);
		l3.setBounds(100,160,ancho,alto);
		
		l4= new JLabel("Altura:"+muestra[3]);
		l4.setBounds(100,190,ancho,alto);
		
		l5= new JLabel("Peso:"+muestra[4]);
		l5.setBounds(100,220,ancho,alto);
		
		l6= new JLabel("Edad:"+muestra[5]);
		l6.setBounds(100,250,ancho,alto);
		
		l7= new JLabel();
		l7.setBounds(100,280,ancho,alto);
		
		edit = new JLabel("Opcion para editar un dato:");
		edit.setBounds(x-100, 80, 160, alto);
		
		//Se crea el TExtField donde se introduce el dato nuevo
		
		datoEdit = new JTextField();
		datoEdit.setBounds(x-100, 155, 160, alto);
		
		//Se muestra el septimo dato dependiendo del animal
		
		if("Mamifero".equals(Animales.get(index)[7])) {
			l7.setText("Tipo de pelaje: "+Animales.get(index)[6]);
		}else if("Ave".equals(Animales.get(index)[7])){
			l7.setText("Tipo de pico: "+Animales.get(index)[6]);
		}else if("Reptil".equals(Animales.get(index)[7])) {
			l7.setText("Tipo de escamas: "+Animales.get(index)[6]);
		}else if("Anfibio".equals(Animales.get(index)[7])) {
			l7.setText("Piel Resbaladiza: "+Animales.get(index)[6]);
		}else {
			l7.setText("Tipo de branqueas: "+Animales.get(index)[6]);
		}
		
		//Se crean los botones
		
		edicion = new JButton("Guardar Cambio");
		edicion.setBounds(x-100, 200, 160, alto);
		
		siguiente = new JButton("Siguiente.");
		siguiente.setBounds(x-200, y-5*alto, 100, alto);
		
		salir = new JButton("Salir");
		salir.setBounds(50, y-3*alto, 100, alto);
		
		borrar = new JButton("Borrar");
		borrar.setBounds(175, y-5*alto, 100, alto);
		
		atras = new JButton("Anterior");
		atras.setBounds(50, y-5*alto, 100, alto);
		
		//Se utiliza un Combo box para saber que dato se esta editando
		
		editar = new JComboBox<String>();
		editar.setBounds(x-100, 110, 160, alto);
		editar.addItem("descripcion");
		editar.addItem("alimentacion");
		editar.addItem("altura");
		editar.addItem("peso");
		editar.addItem("edad");
		
		//La accion cambio permite avanzar, retroceder, borrar y mostrar correctamente los animales
		
		ActionListener cambio= new ActionListener() {
		Object[] objeto = {Animales.get(index)[0]};
			public void actionPerformed(ActionEvent evento) {
				if(evento.getSource()==borrar && Animales.size()==1) {
					DB.getInstances().dbPrepareStatement("DELETE FROM animales WHERE descripcion=?", objeto);
					cuadro.setContentPane(anterior);
				}else {
					if(evento.getSource()==borrar && (Animales.size()!=1) && (index!=(Animales.size()-1))) {
						DB.getInstances().dbPrepareStatement("DELETE FROM animales WHERE descripcion=?", objeto);
						Animales.remove(index);
						}else if(evento.getSource()==borrar && (Animales.size()!=1) && (index==(Animales.size()-1))){
							index--;
							DB.getInstances().dbPrepareStatement("DELETE FROM animales WHERE descripcion=?", objeto);
							Animales.remove(index);
						}
					
					if(evento.getSource()==siguiente && index!=0) {
						index--;}
						else if(((evento.getSource()==atras)&&(index!=(Animales.size()-1)))) {
							index++;
							}
					if(index>=0) {
						muestra=Animales.get(index);
						l1.setText("Descripcion:"+muestra[0]);
						l2.setText("Circulacion:"+muestra[1]);
						l3.setText("Alimentacion:"+muestra[2]);
						l4.setText("Altura:"+muestra[3]);
						l5.setText("Peso:"+muestra[4]);
						l6.setText("Edad:"+muestra[5]);
						titulo.setText("Animal #"+index);
						if("Mamifero".equals(Animales.get(index)[7])) {
							l7.setText("Tipo de pelaje: "+Animales.get(index)[6]);
						}else if("Ave".equals(Animales.get(index)[7])){
							l7.setText("Tipo de pico: "+Animales.get(index)[6]);
						}else if("Reptil".equals(Animales.get(index)[7])) {
							l7.setText("Tipo de escamas: "+Animales.get(index)[6]);
						}else if("Anfibio".equals(Animales.get(index)[7])) {
							l7.setText("Piel Resbaladiza: "+Animales.get(index)[6]);
						}else {
							l7.setText("Tipo de branqueas: "+Animales.get(index)[6]);
							}
						}
				}
			}
		};
		
		//Se añaden los Action Listener
		edicion.addActionListener(cambio);
		siguiente.addActionListener(cambio);
		borrar.addActionListener(cambio);
		atras.addActionListener(cambio);
		
		
		//Se define una accion para que se edite el dato de la base de datos
		edicion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evento) {
					Object[] objeto = {datoEdit.getText(), Animales.get(index)[0],editar.getSelectedItem()};
					DB.getInstances().dbPrepareStatement("UPDATE animales SET "+editar.getSelectedItem().toString()+" =?  WHERE descripcion=?", objeto);
					Animales.clear();
	        		DB db = DB.getInstances();
	        		db.dbStatement("SELECT * FROM animales", Animales);
	        		JOptionPane.showMessageDialog(cuadro, "Cambio Realizado");
					}
				}
			);
		
		//Se define una accion para salir de la vista actual
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				cuadro.setContentPane(anterior);
			}
		});
	
		//Se agregan todos los elementos al panel
		panel.add(titulo);
		panel.add(l1);
		panel.add(l2);
		panel.add(l3);
		panel.add(l4);
		panel.add(l5);
		panel.add(l6);
		panel.add(l7);
		panel.add(datoEdit);
		
		panel.add(siguiente);
		panel.add(borrar);
		panel.add(salir);
		panel.add(atras);
		panel.add(edicion);
		panel.add(editar);
		panel.add(edit);
		
		panel.setLayout(null);
	}
	public JPanel getPanel() {
		return this.panel;
	}
}
