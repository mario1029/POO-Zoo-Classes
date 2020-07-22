package especies;

public class Reptil extends Animal{

	private String escama;
	
	public Reptil() {
		
	}
	
	public Reptil(int edad,float peso, float altura, String descripcion, String alimentacion, String escama) {
		super(edad, peso, altura, "Sangre fria", descripcion, alimentacion);
		this.escama=escama;
	}
	public String getEscama() {
		return escama;
	}
	public void setEscama(String escama) {
		this.escama=escama;
	}
	
	@Override
	public String moverse() {
		return "Los reptiles suelen moverse a cuatro patas";
	}
	@Override
	public String dormir() {
		return "Los reptiles, aparte de su ciclo normal, duermen todo el invierno";
	}
	@Override
	public String reproduccion() {
		return "Los reptiles son oviparos por lo cual se fecundan y ponen huevos";
	}
	@Override
	public String ver() {
		return "Los reptiles poseen parpados moviles en algunos casos fucionados";
	}
	public String toString() {
		String u ="\n\nNombre Cientifico:"+this.getDescripcion()+"\nEdad:"+this.getEdad()+"\nAlimentacion:"+this.getAlimentacion();
		String v ="\nPeso:"+this.getPeso()+"\nAltura:"+this.getAltura()+"\nCirculacion:"+this.getCirculacion()+"\nEscama:"+this.getEscama();
		return u+v;
	}
	
}
