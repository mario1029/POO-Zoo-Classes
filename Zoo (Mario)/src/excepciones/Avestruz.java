package excepciones;
import especies.Ave;
public class Avestruz extends Ave{

	public Avestruz(int edad, float peso, float altura, String descripcion) {
		super(edad, peso, altura, descripcion, "Herbívoro" , "Insectivoro");
	}
	public void huir() {
		System.out.println("Las avestruces en peligro agachan la cabeza y huyen del peligro.");
	}
	@Override
	public void volar() {
		System.out.println("Las avestruces no pueden volar por lo cual corren rapido.");
	}
}
