package Implementaciones;

import java.util.Date;

public class TarjetaCredito {
	public long numero; 
	private int cvc; 
	private Date fechaVencimiento; 
	private String imagen;
	private boolean estado; 
	//constructor
	public TarjetaCredito(long numero, int cvc, Date fechaVencimiento, String imagen) {
		this.numero = numero;
		this.cvc = cvc;
		this.fechaVencimiento = fechaVencimiento;
		this.imagen = imagen;
		this.estado = true;
	}
	
	//metodos 
	public void actualizarTarjetaEstado(boolean estado) { 
		this.estado = estado;
	}
}
