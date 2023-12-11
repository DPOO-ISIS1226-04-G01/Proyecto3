package Implementaciones;

import java.util.Date;

public class ConductorAdicional {
	String nombre;
	Licencia licencia;
	
	public ConductorAdicional(String nombre,int numero, String paisExpedicion, Date fechaVencimiento, String imagen) {
		this.nombre = nombre;
		this.licencia = new Licencia(numero,paisExpedicion,fechaVencimiento,imagen);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Licencia getLicencia() {
		return licencia;
	}

	public void setLicencia(Licencia licencia) {
		this.licencia = licencia;
	}
	
}
