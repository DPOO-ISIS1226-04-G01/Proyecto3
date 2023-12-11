package Implementaciones;

public class Seguro {
	
	String nombre;
	int costo;
	
	public Seguro(String nombre, int costo) {
		this.costo = costo;
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getCosto() {
		return costo;
	}
	
}
