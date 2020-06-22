package especies;

public abstract class Animal {
	// Atributos
		private int edad;
		private float peso;
		private float altura;
		private String circulacion;
		private String descripcion;
		private String alimentacion;
		//Constructor
		public Animal(int edad,float peso,float altura,String circulacion, String descripcion, String alimentacion) {
			this.edad=edad;
			this.altura=altura; //Altura en cm´s
			this.peso=peso; //Peso en Kg
			this.circulacion=circulacion;//Si es de sangre caliente o fria
			this.descripcion=descripcion;//Nombre cientifico del animal
			this.alimentacion=alimentacion;//Si es carnivoro, hervivoro u omnivoro (o Hematofagia si se alimenta de sangre)
		}
		//Metodos abstractos
		public abstract void moverse();
		public abstract void dormir();
		public abstract void reproduccion();
		public abstract void ver();
		
		//Metodos
		public String toString() {
			return "\n\nNombre Cientifico:"+this.descripcion+"\nEdad:"+this.edad+"\nAlimentacion:"+this.alimentacion+"\nPeso:"+this.peso+"\nAltura:"+this.altura+"\nCirculacion:"+this.circulacion;
		}
		
		public void comportamiento() {
			System.out.println("-Locomocion:");
			this.moverse();
			System.out.println("-Ciclo de sueño:");
			this.dormir();
			System.out.println("-Tipo de reproduccion:");
			this.reproduccion();
			System.out.println("-Vision");
			this.ver();
		}
		//Getters y Setters
		public int getEdad() {
			return edad;
		}
		
		public void setEdad(int edad){
			this.edad=edad;
		}
		
		public float getPeso(){
			return peso;
		}
		
		public void setPeso(float peso){
			this.peso=peso;
		}
		
		public float getAltura(){
			return altura;
		}
		
		public void setAltura(float altura){
			this.altura=altura;
		}
		
		public String getCirculacion(){
			return circulacion;
		}
		
		public void setCirculacion(String circulacion) {
			this.circulacion=circulacion;
		}

		public String getDescripcion(){
			return descripcion;
		}
		
		public void setDescripcion(String descripcion) {
			this.descripcion=descripcion;
		}
		public String getAlimentacion() {
			return alimentacion;
		}
		public void setAlimentacion(String alimentacion) {
			this.alimentacion=alimentacion;
		}
}
