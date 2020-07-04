package main;
import especies.*;
import interfaz.UserInterface;
import java.util.ArrayList;
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
		
/*		final Murcielago bat1= new Murcielago(15, 2.9f, 11f, "Pteropus livingstonii (Muercielago de la fruta)","Herbívoro");
		final Murcielago bat2= new Murcielago(14, 2.3f, 18f, "Desmodontinae (Muercielago vampiro)","Hematofagia");
		
		final Avestruz av1= new Avestruz(7, 60.3f, 207f,"Struthio camelus camelus (Avestruz cuello Rojo)");
		final Avestruz av2= new Avestruz(19, 67.3f, 195f,"Struthio camelus australis (Avestruz cuello Azul)");
		
		final Serpiente s1= new Serpiente(6, 1.7f, 8f,"Naja naja (Cobra India)", "Neurotoxina postsináptica"); 
		final Serpiente s2= new Serpiente(3, 2.3f, 11f,"Bothriechis schlegelii (Serpiente Bocaraca)", "Hemotóxico");
		
		final Mudskipper mud1= new Mudskipper(6, .6f, 7f,"Periophthalmus kalolo");
		final Mudskipper mud2= new Mudskipper(14, .7f, 9f,"Periophthalmus magnuspinnatus"); */
		
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
		
		
		UserInterface nuevo= new UserInterface(Animales);
		nuevo.cerrar();
	}
}
