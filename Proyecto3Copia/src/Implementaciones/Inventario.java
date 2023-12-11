package Implementaciones;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Inventario {
	List<Categoria> categorias;
	List<Seguro> seguros;
	Map<Vehiculo, Reserva> vehiculosReservados;
	Map<Vehiculo, String> vehiculosNoDisponibles;
	
	public Inventario() {
		this.categorias = new ArrayList<>();
		this.vehiculosReservados = new HashMap <>();
		this.vehiculosNoDisponibles = new HashMap<>();
		this.seguros = new ArrayList<>();
	}
	
	
	//----------------------------------------------------------------
	public Map<Vehiculo, Reserva> getVehiculosReservados() {
		return vehiculosReservados;
	}
	
	public Map<Vehiculo, String> getVehiculosNoDisponibles() {
		return vehiculosNoDisponibles;
	}
	
	public boolean existeCategoria(String categoria) {
		boolean rta = false;
		for(Categoria categoriaBuscar: categorias) {
			if (categoriaBuscar.getTipo().equals(categoria)) {
				rta = true;
			}
		}
		return rta;
	}
	
	public void guardarReserva(Vehiculo vehiculo, Reserva reserva) throws IOException {
		String entrada = "reservado";
		entrada += ";" + reserva.getCategoria();
		entrada += ";" + Empresa.dateToString(reserva.getFechaInicio(),"dd/MM/yyyy");
		entrada += ";" + Empresa.dateToString(reserva.getFechaFin(),"dd/MM/yyyy");
		entrada += ";" + reserva.getSedeInicio().getNombre().replaceAll("\n","");
		entrada += ";" + reserva.getSedeFin().getNombre().replaceAll("\n","");
		entrada += ";" + reserva.getCobro();
		entrada += ";" + reserva.getCliente().getId();
		if (reserva.verificarConductoresExtra()) {
			int conductores = reserva.getConductoresExtra();
			entrada += ";" + Integer.toString(conductores);
		}
		else {
			entrada += ";NA"; 
		}
		BufferedWriter estadoVehiculo = new BufferedWriter(new FileWriter("data\\Historial vehiculos\\" + vehiculo.getPlaca() + ".txt", true));
		estadoVehiculo.newLine();
		estadoVehiculo.write(entrada);
		estadoVehiculo.close();
	}
	
	public Reserva crearReserva(String categoriaa, Date fechaInicio, Date fechaFin, Sede sedeInicio, Sede sedeFin, Cliente cliente, int conductores, Vehiculo vehiculo) throws IOException{
		Categoria categoria = this.buscarCategoria(categoriaa);
		int cobro = categoria.calcularCostoTarifa(fechaInicio, fechaFin);
		Reserva reserva = new Reserva(categoriaa, fechaInicio, fechaFin,sedeInicio,sedeFin,cobro,cliente,conductores);
		reserva.generarExcedente();
		vehiculo.setSede(null);
		sedeInicio.eliminarVehiculo(vehiculo);
		añadirVehiculoReservado(vehiculo, reserva);

		cliente.setReserva(reserva);
		guardarReserva(vehiculo, reserva);
		return reserva;
	}
	
	public Reserva crearReservaNuevo(String categoriaa, Date fechaInicio, Date fechaFin, Sede sedeInicio, Sede sedeFin, Cliente cliente, int conductores, Vehiculo vehiculo) throws IOException{
		Categoria categoria = this.buscarCategoria(categoriaa);
		int cobro = categoria.calcularCostoTarifa(fechaInicio, fechaFin);
		Reserva reserva = new Reserva(categoriaa, fechaInicio, fechaFin,sedeInicio,sedeFin,cobro*0.9,cliente,conductores);
		reserva.generarExcedente();
		vehiculo.setSede(null);
		sedeInicio.eliminarVehiculo(vehiculo);
		añadirVehiculoReservado(vehiculo, reserva);

		cliente.setReserva(reserva);
		guardarReserva(vehiculo, reserva);
		return reserva;
	}
	
	public List<Tarifa> getTarifasCategoria(int valor){
		List<Tarifa> resp = null;
		for (Categoria categoria: categorias) {
			if (categoria.getValor() == valor) {
				resp = categoria.getTarifas();
				break;
			}
		}
		return resp;
	}
	
	public List<Seguro> getSeguros(){
		return seguros;
	}
	//----------------------------------------------------------------
	public void añadirCategoria(Categoria categoria) {
		this.categorias.add(categoria);
	}
	
	
	public void añadirSeguro(Seguro seguro) {
		this.seguros.add(seguro);
	}
	
	public List<Categoria> getCategorias(){
		return categorias;
	}
	
	public Categoria buscarCategoria(String categoria) {
		Categoria resp = null;
		for (Categoria cat: this.getCategorias()) {
			if (categoria.equals(cat.getTipo())) {
				resp = cat;
				break;
			}
		}
		return resp;
	}
	
	public void añadirVehiculoReservado(Vehiculo vehiculo, Reserva reserva) {
		this.vehiculosReservados.put(vehiculo, reserva);
	}
	
	public void añadirVehiculoNoDisponible(Vehiculo vehiculo, String razon) {
		this.vehiculosNoDisponibles.put(vehiculo, razon);
	}
}
