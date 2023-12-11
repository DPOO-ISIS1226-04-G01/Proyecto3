package Implementaciones;

import java.text.ParseException;
import java.util.*;

public class Sede {
	private String nombre; 
	private String ubicacion; 
	private List<List<Date>> horarios;
	private List<Empleado> empleados;
	private HashMap<String, ArrayList<Vehiculo>> vehiculosCategoria;
	
	public Sede(String nombre, String direccion, String horarios) throws ParseException{
		this.setNombre(nombre);
		this.setUbicacion(direccion);
		this.horarios = new ArrayList<>();
		this.vehiculosCategoria = new HashMap<String, ArrayList<Vehiculo>>();
		this.empleados = new ArrayList<>();
		String[] horasSemana = horarios.split(",");
		for (String horasDia: horasSemana) {
			if (horasDia.equals("NA")) {
				this.horarios.add(null);
			}
			else {
				String[] partes = horasDia.split("-");
				Date hora1 = Empresa.obtenerHora(partes[0]);
				Date hora2 = Empresa.obtenerHora(partes[1]);
				List<Date> horas = new ArrayList<>();
				horas.add(hora1);
				horas.add(hora2);
				this.horarios.add(horas);
			}
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}
	
	// ------------------------------------------------------

	public HashMap<String, ArrayList<Vehiculo>> getVehiculosCategoria() {
		return vehiculosCategoria;
	}
	public void eliminarVehiculo(Vehiculo vehiculo){
		this.vehiculosCategoria.get(vehiculo.getCategoria()).remove(vehiculo);
	}
	public Vehiculo buscarVehiculoCategoria(String categoria) {
		Vehiculo vehiculo = null;
		ArrayList<Vehiculo> lista = vehiculosCategoria.get(categoria);
		if (lista.size() > 0) {
			vehiculo = lista.get(0);
		}
		return vehiculo;
	}
	
	// ------------------------------------------------------

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	public void añadirEmpleado(Empleado empleado){
		this.empleados.add(empleado);
	}
	
	public void añadirVehiculoDisponible(Vehiculo vehiculo) { // CAMBIOS IMPORTANTE CARGA DE SEDES
		String categoria = vehiculo.getCategoria();
		if (vehiculosCategoria.containsKey(categoria)){
			vehiculosCategoria.get(categoria).add(vehiculo);
		}
		else {
			ArrayList<Vehiculo> lista = new ArrayList<Vehiculo>();
			lista.add(vehiculo);
			vehiculosCategoria.put(categoria, lista);
		}
	}
}
