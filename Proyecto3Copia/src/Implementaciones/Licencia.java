package Implementaciones;

import java.util.Date;

public class Licencia {
	private long numero; 
	private String paisExpedicion; 
	private Date fechaVencimiento; 
	private String imagen;

	//constructores 
	public Licencia(long numero, String paisExpedicion, Date fechaVencimiento, String imagen) {
		this.setNumero(numero);
		this.setPaisExpedicion(paisExpedicion);
		this.setFechaVencimiento(fechaVencimiento);
		this.setImagen(imagen);
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getPaisExpedicion() {
		return paisExpedicion;
	}

	public void setPaisExpedicion(String paisExpedicion) {
		this.paisExpedicion = paisExpedicion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
}
