package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import especies.*;

public class Mostrar {
	JLabel l1,l2,l3,l4,l5,l6,l7, titulo;
	JPanel panel;
	JButton siguiente,salir,borrar,atras;
	Animal muestra;
	final int x=500,y=500,ancho=400,alto=30;
	int index;
	public Mostrar(ArrayList<Animal> Animales,JPanel anterior, JFrame cuadro) {
		index =Animales.size()-1;
		muestra = Animales.get(index);
		panel = new JPanel();
		panel.setSize(x,y);
		
		titulo=new JLabel("Animal #"+index);
		titulo.setBounds(250-100, 70, 100, alto);
		
		l1= new JLabel("Descripcion:"+muestra.getDescripcion());
		l1.setBounds(100,100,ancho,alto);
		
		l2= new JLabel("Circulacion:"+muestra.getCirculacion());
		l2.setBounds(100,130,ancho,alto);
		
		l3= new JLabel("Alimentacion:"+muestra.getAlimentacion());
		l3.setBounds(100,160,ancho,alto);
		
		l4= new JLabel("Altura:"+muestra.getAltura());
		l4.setBounds(100,190,ancho,alto);
		
		l5= new JLabel("Peso:"+muestra.getPeso());
		l5.setBounds(100,220,ancho,alto);
		
		l6= new JLabel("Edad:"+muestra.getEdad());
		l6.setBounds(100,250,ancho,alto);
		
		l7= new JLabel();
		l7.setBounds(100,280,ancho,alto);
		
		if(Animales.get(index).getClass()==Mamifero.class) {
			Mamifero M = (Mamifero)Animales.get(index);
			l7.setText("Tipo de pelaje: "+M.getPelaje());
		}else if(Animales.get(index).getClass()==Ave.class){
			Ave M = (Ave)Animales.get(index);
			l7.setText("Tipo de pico: "+M.getPico());
		}else if(Animales.get(index).getClass()==Reptil.class) {
			Reptil M = (Reptil)Animales.get(index);
			l7.setText("Tipo de escamas: "+M.getEscama());
		}else if(Animales.get(index).getClass()==Anfibio.class) {
			Anfibio M = (Anfibio)Animales.get(index);
			l7.setText("Piel Resbaladiza: "+M.getResbaladizo());
		}else {
			Pez M = (Pez)Animales.get(index);
			l7.setText("Tipo de branqueas: "+M.getBranqueas());
		}
		
		
		siguiente = new JButton("Siguiente.");
		siguiente.setBounds(x-200, y-5*alto, 100, alto);
		
		salir = new JButton("Salir");
		salir.setBounds(50, y-3*alto, 100, alto);
		
		borrar = new JButton("Borrar");
		borrar.setBounds(175, y-5*alto, 100, alto);
		
		atras = new JButton("Anterior");
		atras.setBounds(50, y-5*alto, 100, alto);
		
		ActionListener cambio= new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				if(evento.getSource()==borrar && Animales.size()==1) {
					Animales.clear();
					cuadro.setContentPane(anterior);
				}else {
					if(evento.getSource()==borrar && (Animales.size()!=1) && (index!=(Animales.size()-1))) {
						Animales.remove(index);
						}else if(evento.getSource()==borrar && (Animales.size()!=1) && (index==(Animales.size()-1))){
							index--;
							Animales.remove(index);
						}
					
					if(evento.getSource()==siguiente && index!=0) {
						index--;}
						else if(((evento.getSource()==atras)&&(index!=(Animales.size()-1)))) {
							index++;
							}
					if(index>=0) {
						muestra=Animales.get(index);
						l1.setText("Descripcion:"+muestra.getDescripcion());
						l2.setText("Circulacion:"+muestra.getCirculacion());
						l3.setText("Alimentacion:"+muestra.getAlimentacion());
						l4.setText("Altura:"+muestra.getAltura());
						l5.setText("Peso:"+muestra.getPeso());
						l6.setText("Edad:"+muestra.getEdad());
						titulo.setText("Animal #"+index);
						if(Animales.get(index).getClass()==Mamifero.class) {
							Mamifero M = (Mamifero)Animales.get(index);
							l7.setText("Tipo de pelaje: "+M.getPelaje());
							}else if(Animales.get(index).getClass()==Ave.class){
								Ave M = (Ave)Animales.get(index);
								l7.setText("Tipo de pico: "+M.getPico());
								}else if(Animales.get(index).getClass()==Reptil.class) {
									Reptil M = (Reptil)Animales.get(index);
									l7.setText("Tipo de escamas: "+M.getEscama());
									}else if(Animales.get(index).getClass()==Anfibio.class) {
										Anfibio M = (Anfibio)Animales.get(index);
										l7.setText("Piel Resbaladiza: "+M.getResbaladizo());
										}else {
											Pez M = (Pez)Animales.get(index);
											l7.setText("Tipo de branqueas: "+M.getBranqueas());
											}
						}
				}
			}
		};
		
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				cuadro.setContentPane(anterior);
			}
		});
		
		siguiente.addActionListener(cambio);
		borrar.addActionListener(cambio);
		atras.addActionListener(cambio);
		
		panel.add(titulo);
		panel.add(l1);
		panel.add(l2);
		panel.add(l3);
		panel.add(l4);
		panel.add(l5);
		panel.add(l6);
		panel.add(l7);
		
		panel.add(siguiente);
		panel.add(borrar);
		panel.add(salir);
		panel.add(atras);
		
		panel.setLayout(null);
	}
	public JPanel getPanel() {
		return this.panel;
	}
}
