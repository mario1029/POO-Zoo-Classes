package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import especies.*;

public class Comportamiento {
	private JPanel panel;
	private JButton salir;
	private JLabel l1,l2,l3,l4,titulo;
	private JRadioButton b1,b2,b3,b4,b5;
	private final int ancho=600, alto=20;
	public Comportamiento(JPanel anterior, JFrame cuadro) {
		panel= new JPanel();
		panel.setSize(500, 600);
		panel.setLayout(null);
		
		Mamifero a1 = new Mamifero();
		Ave a2 = new Ave();
		Anfibio a3 = new Anfibio();
		Pez a4 = new Pez();
		Reptil a5 = new Reptil();
		
		titulo=new JLabel("Comportamientos");
		titulo.setBounds(ancho/2-75, 70, 150, alto);
		
		l1= new JLabel("Movimiento: "+a1.moverse());
		l1.setBounds(10,100,ancho,alto);
		
		l2= new JLabel("Dormir: "+a1.dormir());
		l2.setBounds(10,120,ancho,alto);
		
		l3= new JLabel("Reproduccion:"+a1.reproduccion());
		l3.setBounds(10,140,ancho,alto);
		
		l4= new JLabel("Vision: "+a1.ver());
		l4.setBounds(10,160,ancho,alto);
		
		b1=new JRadioButton("Mamifero",true);
		b1.setBounds(ancho/2-50, 230, 100, alto);
		
		b2=new JRadioButton("Anfibio",false);
		b2.setBounds(ancho/2-50, 250, 100, alto);
		
		b3=new JRadioButton("Reptil",false);
		b3.setBounds(ancho/2-50, 270, 100, alto);
		
		b4=new JRadioButton("Pez",false);
		b4.setBounds(ancho/2-50, 290, 100, alto);
		
		b5=new JRadioButton("Ave",false);
		b5.setBounds(ancho/2-50, 310, 100, alto);
		
		ButtonGroup grupo=new ButtonGroup();
		grupo.add(b1);
		grupo.add(b2);
		grupo.add(b3);
		grupo.add(b4);
		grupo.add(b5);
		
		salir = new JButton("Salir");
		salir.setBounds(50, 400, 100, 30);
		
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				cuadro.setContentPane(anterior);
			}
		});
		
		ActionListener cambiar = new ActionListener() {
			public void actionPerformed(ActionEvent cambio) {
				if(cambio.getSource()==b1) {
					l1.setText("Movimiento: "+a1.moverse());
					l2.setText("Dormir: "+a1.dormir());
					l3.setText("Reproduccion:"+a1.reproduccion());
					l4.setText("Vision: "+a1.ver());
				}else if(cambio.getSource()==b2){
					l1.setText("Movimiento: "+a2.moverse());
					l2.setText("Dormir: "+a2.dormir());
					l3.setText("Reproduccion:"+a2.reproduccion());
					l4.setText("Vision: "+a2.ver());
				}else if(cambio.getSource()==b3) {
					l1.setText("Movimiento: "+a3.moverse());
					l2.setText("Dormir: "+a3.dormir());
					l3.setText("Reproduccion:"+a3.reproduccion());
					l4.setText("Vision: "+a3.ver());
				}else if(cambio.getSource()==b4) {
					l1.setText("Movimiento: "+a4.moverse());
					l2.setText("Dormir: "+a4.dormir());
					l3.setText("Reproduccion:"+a4.reproduccion());
					l4.setText("Vision: "+a4.ver());
				}else {
					l1.setText("Movimiento: "+a5.moverse());
					l2.setText("Dormir: "+a5.dormir());
					l3.setText("Reproduccion:"+a5.reproduccion());
					l4.setText("Vision: "+a5.ver());
				}
			}
		};
		
		b1.addActionListener(cambiar);
		b2.addActionListener(cambiar);
		b3.addActionListener(cambiar);
		b4.addActionListener(cambiar);
		b5.addActionListener(cambiar);
		
		panel.add(salir);
		panel.add(titulo);
		panel.add(l1);
		panel.add(l2);
		panel.add(l3);
		panel.add(l4);
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);
		panel.add(b5);
		
	}
	public JPanel getPanel() {
		return this.panel;
	}
}
