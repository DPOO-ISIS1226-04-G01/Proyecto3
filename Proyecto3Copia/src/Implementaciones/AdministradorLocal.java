package Implementaciones;

public class AdministradorLocal extends Usuario {
	Sede sede;
	
	public AdministradorLocal(String login, String password, Sede sede) {
		super(login, password);
		this.sede = sede;
	}
}
