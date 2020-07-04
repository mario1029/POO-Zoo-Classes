package especies;

public class Pez extends Animal{
	private String branqueas;//Internas o exteneras 
	public Pez() {
		
	}
	public Pez(int edad, float peso, float altura, String descripcion, String alimentacion,String branqueas) {
		super(edad,peso,altura,"Sangre Fria",descripcion, alimentacion);
		this.branqueas=branqueas;
	}
	public String getBranqueas() {
		return branqueas;
	}
	public void setBranqueas(String branqueas) {
		this.branqueas=branqueas;
	}
	@Override
	public String moverse() {
		return "Los peces usan sus aletas para desplazarse en el agua.";
	}
	@Override
	public String dormir() {
		return "Los peces no necesitan cerrar los parpados para dormir pues la gran mayoria no tiene.";
	}
	@Override
	public String reproduccion() {
		return"Los peces fecundan de los huevos de manera externa por lo cual son ovulíparos.";
	}
	@Override
	public String ver() {
		return"Los peces no poseen parpados y para enfocar usan musculos llamados retractores.";
	}
	public String toString() {
		String u ="\n\nNombre Cientifico:"+this.getDescripcion()+"\nEdad:"+this.getEdad()+"\nAlimentacion:"+this.getAlimentacion();
		String v ="\nPeso:"+this.getPeso()+"\nAltura:"+this.getAltura()+"\nCirculacion:"+this.getCirculacion()+"\nEscama:"+this.getBranqueas();
		return u+v;
	}
}
