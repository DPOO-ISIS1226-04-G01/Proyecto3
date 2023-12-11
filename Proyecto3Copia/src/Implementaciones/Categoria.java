package Implementaciones;

import java.util.*;

public class Categoria {
	String tipo;
	int valor;
	List<Tarifa> tarifas;
	
	public Categoria(String tipo, int valor) {
		this.tipo = tipo;
		this.valor = valor;
		this.tarifas = new ArrayList<>();
	}
	
	public void añadirTarifa(Tarifa tarifa) {
		this.tarifas.add(tarifa);
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public int calcularCostoTarifa(Date fechaInicio, Date fechaFin) {
		int cobro = 0;
		Date fecha = fechaInicio;
		while (fecha.before(fechaFin)) {
		        Calendar calendar = Calendar.getInstance();
		        calendar.setTime(fecha);
		        for (Tarifa tarifa: tarifas) {
		        	if (tarifa.fechaEnTarifa(fecha)) {
		        		cobro += tarifa.getCobroDia();
		        		break;
		        	}
		        }
		        calendar.add(Calendar.DATE, 1);
		        fecha = calendar.getTime();
		    }
		return cobro;
	}
	public List<Tarifa> getTarifas(){
		return tarifas;
	}
	
	public void setTarifas(List<Tarifa> tarifas) {
		this.tarifas = tarifas;
	}

	public int getValor() {
		return valor;
	}
	
	
}
