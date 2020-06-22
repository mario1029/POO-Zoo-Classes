package excepciones;
import especies.Reptil;
public class Serpiente extends Reptil{
	private String veneno;
	public Serpiente(int edad,float peso, float altura, String descripcion, String veneno) {
		super( edad ,peso, altura, descripcion, "Carnivoro", "Imbricadas");
		this.veneno=veneno;
	}
	public String getVeneno() {
		return veneno;
	}
	public void setVeneno(String veneno) {
		this.veneno=veneno;
	}
	@Override
	public void moverse() {
		System.out.println("Las serpientes se arrastran por el suelo para moverse.");
	}
	public String toString() {
		String u ="\n\nNombre Cientifico:"+this.getDescripcion()+"\nEdad:"+this.getEdad()+"\nAlimentacion:"+this.getAlimentacion();
		String v ="\nPeso:"+this.getPeso()+"\nAltura:"+this.getAltura()+"\nCirculacion:"+this.getCirculacion()+"\nEscama:"+this.getEscama();
		return u+v+"\nVeneno:"+this.getVeneno();
	}
		

}
