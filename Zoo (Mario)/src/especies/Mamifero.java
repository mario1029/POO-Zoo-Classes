package especies;

public class Mamifero extends Animal{

	private String pelaje;//Si es abundante, poco o ninguno
	public Mamifero(int edad, float peso, float altura, String descripcion, String alimentacion, String pelaje) {
		super(edad, peso, altura, "Sangre Caliente", descripcion, alimentacion);
		this.pelaje=pelaje;
	}
	public String getPelaje() {
		return pelaje;
	}
	public void setPelaje(String pelaje) {
		this.pelaje=pelaje;
	}
	@Override 
	public void moverse() {
		System.out.println("La mayoria de los mamiferios poseen multiples patas y las utilizan para moverse");
	}
	@Override
	public void dormir() {
		System.out.println("Los mamiferos presentan un ciclo circadiano que se repite cada 24 horas");
	}
	@Override
	public void reproduccion() {
		System.out.println("Los mamiferos son viviparos por lo cual la fecundacion es interna en el.");
	}
	@Override
	public void ver() {
		System.out.println("Los mamiferos tienen vision a color y una vision en la noche mejor que otras especies");
	}
	public String toString() {
		String u ="\n\nNombre Cientifico:"+this.getDescripcion()+"\nEdad:"+this.getEdad()+"\nAlimentacion:"+this.getAlimentacion();
		String v ="\nPeso:"+this.getPeso()+"\nAltura:"+this.getAltura()+"\nCirculacion:"+this.getCirculacion()+"\nEscama:"+this.getPelaje();
		return u+v;
	}
}
