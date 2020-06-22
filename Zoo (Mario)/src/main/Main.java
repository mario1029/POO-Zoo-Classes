package main;
import especies.*;
import excepciones.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		
		//Animales comunes que ya tiene el Zoo
		final Mamifero m1= new Mamifero(18, 42.3f , 114,"Panthera tigris (Tigre)","Carnivoro","Abundante");
		final Mamifero m2= new Mamifero(13, 53f , 123,"Panthera leo (Leon)","Carnivoro","Abundante");
		
		final Ave a1= new Ave(11, 0.01f , 19,"Serinus canaria (Canario)","Herbívoro","Granivoro");
		final Ave a2= new Ave(18, 0.008f , 11,"Trochilidae (Colibri)","Herbívoro","Nectarivoro");
		
		final Reptil r1= new Reptil(11, 1700 , 40,"Crocodylus porosus(Cocodrilo Marino)","Carnivoro","Yuxtapuestas");
		final Reptil r2= new Reptil(4, 13 , 3,"Iguana delicatissima(Iguana verde)","Omnívoro","Imbricadas");
		
		final Pez p1= new Pez(17, 3.9f , 0.005f,"Amphiprioninae(Pez payaso)","Omnívoro","Externas");
		final Pez p2= new Pez(11, 3.2f , 1550,"Carcharodon carcharias(Tiburon Blanco)","Carnivoro","Externas");
		
		final Anfibio an1= new Anfibio(4, .5f, 13f , "Pelophylax perezi (Rana)", "Carnivoro", "muy resbaladizo");
		final Anfibio an2= new Anfibio(8, .7f, 9f ,"Salamandra salamandra(Salamandra comun)","Carnivoro","poco resbaladizo");
		
		//Animales "excepcion" que tiene el zoo
		
		final Murcielago bat1= new Murcielago(15, 2.9f, 11f, "Pteropus livingstonii (Muercielago de la fruta)","Herbívoro");
		final Murcielago bat2= new Murcielago(14, 2.3f, 18f, "Desmodontinae (Muercielago vampiro)","Hematofagia");
		
		final Avestruz av1= new Avestruz(7, 60.3f, 207f,"Struthio camelus camelus (Avestruz cuello Rojo)");
		final Avestruz av2= new Avestruz(19, 67.3f, 195f,"Struthio camelus australis (Avestruz cuello Azul)");
		
		final Serpiente s1= new Serpiente(6, 1.7f, 8f,"Naja naja (Cobra India)", "Neurotoxina postsináptica"); 
		final Serpiente s2= new Serpiente(3, 2.3f, 11f,"Bothriechis schlegelii (Serpiente Bocaraca)", "Hemotóxico");
		
		final Mudskipper mud1= new Mudskipper(6, .6f, 7f,"Periophthalmus kalolo");
		final Mudskipper mud2= new Mudskipper(14, .7f, 9f,"Periophthalmus magnuspinnatus");
		
		//Agregando animales al ArrayList
		final ArrayList<Animal> Animales = new ArrayList<Animal>();
		Animales.add(m1);
		Animales.add(m2);
		Animales.add(a1);
		Animales.add(a2);
		Animales.add(r1);
		Animales.add(r2);
		Animales.add(p1);
		Animales.add(p2);
		Animales.add(an1);
		Animales.add(an2);
		Animales.add(bat1);
		Animales.add(bat2);
		Animales.add(av1);
		Animales.add(av2);
		Animales.add(s1);
		Animales.add(s2);
		Animales.add(mud1);
		Animales.add(mud2);
		
		//Menu de opciones
		Scanner entrada = new Scanner(System.in);
		int a;
		do {
			System.out.println("Desea mostrar animales(1), ingresar animales(2) o comportamientos(3)?");
			a = entrada.nextInt();
			if(a==1) {
				System.out.println(Animales);
			}else if(a==2){
				System.out.println("Opciones:\n1.Mamifero\n2.Ave\n3.Pez\n4.Reptil\n5.Anfibio\nTu eleccion:");
				a = entrada.nextInt();
				int edad;
				float peso,altura;
				String var1, var2,var3;
				System.out.println("Nombre:");
				var1= entrada.next();
				System.out.println("Edad:");
				edad= entrada.nextInt();
				System.out.println("Peso:");
				peso= entrada.nextFloat();
				System.out.println("Altura:");
				altura= entrada.nextFloat();
				System.out.println("Alimentacion:");
				var2= entrada.next();
				switch(a) {
					case 1:
						System.out.println("Pelaje:");
						var3= entrada.next();
						Animales.add(new Mamifero(edad, peso, altura,var1,var2,var3));break;
					case 2:
						System.out.println("Pico:");
						var3= entrada.next();
						Animales.add(new Ave(edad, peso, altura,var1,var2,var3));break;
					case 3:
						System.out.println("Branquea:");
						var3= entrada.next();
						Animales.add(new Pez(edad, peso, altura,var1,var2,var3));break;
					case 4:
						System.out.println("Escama:");
						var3= entrada.next();
						Animales.add(new Reptil(edad, peso, altura, var1,var2,var3));break;
					case 5:
						System.out.println("Resbaladizo:");
						var3= entrada.next();
						Animales.add(new Anfibio(edad, peso, altura,var1,var2,var3));break;
					default:
						System.out.println("Opcion no valida.");
				}
			}else {
				System.out.println("\nMamifero:");
				m1.comportamiento();
				System.out.println("\nAve:");
				a1.comportamiento();
				a1.volar();
				a1.moverse(155);
				System.out.println("\nReptil:");
				r1.comportamiento();
				System.out.println("\nPez:");
				p1.comportamiento();
				System.out.println("\nAnfibio:");
				an1.comportamiento();
				
				System.out.println("\nSerpiente:");
				s1.moverse();
				System.out.println("\nAvestruz:");
				av1.huir();
				av1.volar();
				System.out.println("\nMurcielago:");
				bat1.sonar();
				bat1.volar();
				System.out.println("\nMudskipper:");
				mud1.moverse();
				mud1.succion();
			}
			System.out.println("Desea continuar?1=Si, 0=No");
			a = entrada.nextInt();
		}while(a==1);
		entrada.close();
	}
}
