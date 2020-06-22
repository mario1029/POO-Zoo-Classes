package especies;

public class Anfibio extends Animal{
	private String resbaladizo;//Puede ser poco o muy resbaladizo en su piel
	public Anfibio(int edad, float peso, float altura, String descripcion, String alimentacion, String resbaladizo) {
		super(edad, peso, altura,"Sangre Fria",descripcion, alimentacion);
		this.resbaladizo=resbaladizo;
	}
	public String getResbaladizo() {
		return resbaladizo;
	}
	public void setResbaladizo(String resbaladizo) {
		this.resbaladizo=resbaladizo;
	}
	@Override
	public void moverse() {
		System.out.println("Los anfibios usan sus patas para desplzarse y en algunos casos nadar.");
	}
	@Override
	public void dormir() {
		System.out.println("Los anfibios puedes estar en un estado se seminconsiente donde una parte duerme y otra no.");
	}
	@Override
	public void reproduccion() {
		System.out.println("Los anfibios utilizan huevos para reproducirse por lo cual son oviparos");
	}
	@Override
	public void ver() {
		System.out.println("Los anfibios usan 3 parpados y glandulas lacrimales para mantener el ojo humedo.");
		}
	public String toString() {
		String u ="\n\nNombre Cientifico:"+this.getDescripcion()+"\nEdad:"+this.getEdad()+"\nAlimentacion:"+this.getAlimentacion();
		String v ="\nPeso:"+this.getPeso()+"\nAltura:"+this.getAltura()+"\nCirculacion:"+this.getCirculacion()+"\nEscama:"+this.getResbaladizo();
		return u+v;
	}
}
