package especies;

public class Reptil extends Animal{

	public Reptil(int edad,float peso, float altura, String descripcion, String alimentacion, String escama) {
		super(edad, peso, altura, "Sangre fria", descripcion, alimentacion);
		this.escama=escama;
	}
	private String escama;
	public String getEscama() {
		return escama;
	}
	public void setEscama(String escama) {
		this.escama=escama;
	}
	
	@Override
	public void moverse() {
		System.out.println("Los reptiles suelen moverse a cuatro patas");
	}
	@Override
	public void dormir() {
		System.out.println("Los reptiles, aparte de su ciclo normal, duermen todo el invierno");
	}
	@Override
	public void reproduccion() {
		System.out.println("Los reptiles son oviparos por lo cual se fecundan y ponen huevos");
	}
	@Override
	public void ver() {
		System.out.println("Los reptiles poseen parpados moviles en algunos casos fucionados");
	}
	public String toString() {
		String u ="\n\nNombre Cientifico:"+this.getDescripcion()+"\nEdad:"+this.getEdad()+"\nAlimentacion:"+this.getAlimentacion();
		String v ="\nPeso:"+this.getPeso()+"\nAltura:"+this.getAltura()+"\nCirculacion:"+this.getCirculacion()+"\nEscama:"+this.getEscama();
		return u+v;
	}
	
}
