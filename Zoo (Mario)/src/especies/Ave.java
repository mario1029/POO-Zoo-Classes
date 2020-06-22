package especies;

public class Ave extends Animal implements Volar{
	private String pico;
	public Ave(int edad, float peso, float altura, String descripcion, String alimentacion, String pico) {
		super(edad, peso, altura,"Sangre Caliente",descripcion, alimentacion);
		this.pico=pico;
	}
	//Sobrecarga
	public void moverse(int rango) {
		System.out.println("Las aves pueden recorrer de media "+rango+" metros sin cansarse");
	}
	//Setters y getters
	public String getPico() {
		return pico;
	}
	public void setPico(String pico) {
		this.pico=pico;
	}
	//Sobreescritura de metodos
	@Override
	public void volar() {
		System.out.println("Las aves usas su alas para volar.");
	}
	@Override
	public void moverse() {
		System.out.println("Aparte de su vuelo las aves pueden agarrarse de ramas con sus patas.");
	}
	@Override
	public void dormir() {
		System.out.println("Las aves suelen dormir en sus nidos");
	}
	@Override
	public void reproduccion() {
		System.out.println("Las aves son ovipaaras por lo cual ponen huevos en sus nidos");
	}
	@Override
	public void ver() {
		System.out.println("La vision de un ave supera con creces la de otros animales");
	}
	public String toString() {
		String u ="\n\nNombre Cientifico:"+this.getDescripcion()+"\nEdad:"+this.getEdad()+"\nAlimentacion:"+this.getAlimentacion();
		String v ="\nPeso:"+this.getPeso()+"\nAltura:"+this.getAltura()+"\nCirculacion:"+this.getCirculacion()+"\nEscama:"+this.getPico();
		return u+v;
	}
}
