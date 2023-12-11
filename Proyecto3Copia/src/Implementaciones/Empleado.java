package Implementaciones;

public class Empleado extends Usuario{

	private String sede; 
	private String nombre; 
	
	public Empleado(String login, String password, String nombre, String sede) {
		super(login, password);
		this.sede = sede;
		this.nombre = nombre;
	}
	
	public String getSede() {
		return sede;
	}
	
	public String getNombre() {
		return nombre;
	}
}
