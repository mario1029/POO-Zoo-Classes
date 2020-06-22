package excepciones;
import especies.Pez;
public class Mudskipper extends Pez{

	public Mudskipper(int edad, float peso, float altura, String descripcion) {
		super( edad, peso, altura,descripcion,"Herbívoro", "Internas");
	}
	public void succion() {
		System.out.println("El mudskipper puede usar sus ventosas para fijarse a ramas.");
	}
	@Override
	public void moverse() {
		System.out.println("El mudskipper puede nadar y ademas arrastrarse en tierra con sus aletas.");
	}
}
