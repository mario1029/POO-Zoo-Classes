package excepciones;
import especies.Mamifero;
import especies.Volar;
public class Murcielago extends Mamifero implements Volar{

	public Murcielago (int edad, float peso, float altura, String descripcion, String alimentacion) {
		super(edad, peso, altura, descripcion, alimentacion, "Poco");
	}
	public void sonar() {
		System.out.println("Los murcielagos usan su sonar para orientarse");
	}
	@Override
	public void volar() {
		System.out.println("Los murcielagos vuelan utilizando sus alas");
	}
}
