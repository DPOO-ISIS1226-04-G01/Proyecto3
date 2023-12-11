package Implementaciones;

import java.util.*;

public class Reserva {

	String categoria;
	Date fechaInicio;
	Date fechaFin;
	Sede sedeInicio;
	Sede sedeFin;
	double cobro;
	Cliente cliente;
	int conductoresExtra;
	
	public Reserva(String categoria, Date fechaInicio, Date fechaFin, Sede sedeInicio, Sede sedeFin, double cobro, Cliente cliente, int conductores) {
		this.categoria = categoria;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.sedeInicio = sedeInicio;
		this.sedeFin = sedeFin;
		this.cobro = cobro;
		this.cliente = cliente;
		this.conductoresExtra = conductores;
	}
	// ---------------------------------------

	public String getCategoria() {
		return categoria;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public Sede getSedeInicio() {
		return sedeInicio;
	}

	public Sede getSedeFin() {
		return sedeFin;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public int getConductoresExtra() {
		return conductoresExtra;
	}
	
	public double getCobro() {
		return cobro;
	}
	
	public boolean verificarConductoresExtra() {
		boolean resp = true;
		if (conductoresExtra == 0) {
			resp = false;
		}
		return resp;
	}
	
	public void generarExcedente() {
		if (sedeInicio.getNombre().equals(sedeFin.getNombre()) == false){
			cobro += 30.0;
		}
		if (conductoresExtra != 0) {
			int i = 0;
			while (i<conductoresExtra) {
				cobro += 20.0;
				i++;
			}
		}
		
	}
	// ------------------------------------------
	
	
}
