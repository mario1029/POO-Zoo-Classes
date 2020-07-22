package main;
import db.DB;
import interfaz.UserInterface;
import java.util.ArrayList;
public class Main {

	public static void main(String[] args) {
		//Para el correcto funcionamiento del programa debe existir 
		//una base de datos bajo el nombre de "animales" tal que:
		/*
		CREATE TABLE animales
		(descripcion VARCHAR(30),
 		circulacion VARCHAR(30),
 		alimentacion VARCHAR(30),
 		altura NUMERIC(10,2),
 		peso NUMERIC(10,2),
 		edad INTEGER,
 		atributo VARCHAR(30),
 		categoria VARCHAR(10),
 		PRIMARY KEY(descripcion));
		*/
		//Agregando animales al ArrayList
		ArrayList<Object[]> Animales = new ArrayList<Object[]>();
		DB db= DB.getInstances();
		db.dbStatement("SELECT * FROM animales", Animales);
		UserInterface nuevo= new UserInterface();
		nuevo.cerrar();
	}
}
