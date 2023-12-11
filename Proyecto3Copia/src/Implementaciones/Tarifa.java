package Implementaciones;

import java.util.*;

public class Tarifa {
	
	String temporada;
	Date fechaInicio;
	Date fechaFin;
	int cobroDia;
	
	public Tarifa(String temporada, Date fechaInicio, Date fechaFin, int cobroDia){
		this.temporada = temporada;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.cobroDia = cobroDia;
	}
	
	public String getTemporada() {
		return temporada;
	}
	
	public boolean fechaEnTarifa(Date fecha){
		boolean resp = false;
		if (fecha.compareTo(this.fechaInicio) >= 0 && fecha.compareTo(this.fechaFin) <= 0) {
			resp = true;
		}
		return resp;
	}
	
	public int getCobroDia() {
		return cobroDia;
	}
	
	
	
}
