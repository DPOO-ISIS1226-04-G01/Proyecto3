package InterfazCliente;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.qoppa.pdf.PDFException;

import Implementaciones.*;

public class Aplicacion {
	
	Empresa empresa;
	
	public void ejecutarAplicacion() throws IOException, ParseException {
		File archivoSedes = new File("data\\sedes.txt");
		archivoSedes.createNewFile();
		File archivoEmpleados = new File("data\\empleados.txt");
		archivoEmpleados.createNewFile();
		File archivoClientes = new File("data\\clientes.txt");
		archivoClientes.createNewFile(); 
		File archivoVehiculos = new File("data\\vehiculos.txt");
		archivoVehiculos.createNewFile();
		File archivoAdmin = new File("data\\administrador.txt");
		archivoAdmin.createNewFile();
		File archivoAdminLocales = new File("data\\administradorLocal.txt");
		archivoAdminLocales.createNewFile();
		File archivoCategorias = new File("data\\categorias.txt");
		archivoCategorias.createNewFile();
		File archivoTarifas = new File("data\\tarifas.txt");
		archivoCategorias.createNewFile();
		File archivoSeguros = new File("data\\seguros.txt");
		archivoSeguros.createNewFile();
		Empresa empresa = new Empresa("Car Prime");
		empresa.cargarEmpresa(archivoAdmin, archivoAdminLocales, archivoCategorias, archivoClientes, archivoEmpleados,
				archivoSedes, archivoVehiculos, archivoTarifas, archivoSeguros);
		setEmpresa(empresa);
	}
	
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}
	
	public static void main(String [] args) throws IOException, ParseException {
		Aplicacion carPrime = new Aplicacion();
		carPrime.ejecutarAplicacion();
	}

	public boolean iniciarEmpleadoInterfaz(String login,String contra) {
			
		boolean existe = true;
		Empleado empleado = empresa.buscarEmpleado(login);
		if (empleado == null) {
			existe = false;
		}else if (empleado.getPassword().equals(contra)) {
			existe = true;
		}else{
			existe = false;
		}		
		return existe;
	}
	
	public boolean iniciarClienteInterfaz(String login,String contra) {
		
		boolean existe = true;
		Cliente cliente = this.empresa.buscarClienteLogin(login);
		if (cliente == null) {
			existe = false;
		}
		if (cliente.getPassword().equals(contra)) {
			existe = true;
		}else{
			existe = false;
		}		
		return existe;
	}
	
	public boolean iniciarAdminInterfaz(String login,String contra) {
		
		boolean existe = true;
		Administrador admin = this.empresa.buscarAdministrador(login);
		if (admin == null) {
			existe = false;
		}else if (admin.getPassword().equals(contra)) {
			existe = true;
		}else{
			existe = false;
		}		
		return existe;
	}
	
	
	public boolean crearVehiculoNuevo(String sede,String placa,String marca,String modelo,String color,String transmision,String categoria){ 
		return empresa.crearVehiculoNuevo2(sede,placa, marca, modelo, color, transmision, categoria);
	} 
	
	public void registrarUsuario(String login, String password, String nombre, long numeroCelular, Date fechaNacimiento, 
			String nacionalidad, long documento, long numeroTar, int cvc, Date fechaVencimientoTar, String imagenTar,
			long numeroLic, String paisExpedicionLic, Date fechaVencimientoLic, String imagenLic) throws ParseException { 
		
		empresa.crearUsuarioNuevo(login, password, nombre, numeroCelular, fechaNacimiento, nacionalidad, documento, numeroTar, cvc, fechaVencimientoTar, imagenTar, numeroLic, paisExpedicionLic, fechaVencimientoLic, imagenLic);
	}
	
	
	public String consultarVehiculoPlaca(String placa) {
		return empresa.consultarVehiculoPorPlaca(placa);
	}	

	public String consultarCantidadCategoria(String categoria) {
		String rta = "No existe la categoria en nuestros inventarios";
		
		if ((empresa.saberDisposicionporCategoria(categoria)) > 0) {
			rta = "La cantidad de vehiculos en la categoria son: " + Integer.toString(empresa.saberDisposicionporCategoria(categoria));
		}
		
		return rta;
		
	}
	
	public String crearReserva(String categ, String fechaI,String fechaF,String sedeI,String sedeF,String doc,String conduc,String pasarela) throws ParseException, IOException {
		String rta = "";
		if (empresa.buscarClientePorId(Long.parseLong(doc)) != null) {
			Cliente cliente = empresa.buscarClientePorId(Long.parseLong(doc));
			Date fecha1 = Empresa.obtenerFecha(fechaI);
			Date fecha2 = Empresa.obtenerFecha(fechaF);
			int conduct = Integer.parseInt(conduc);
			rta = empresa.crearReserva(categ, fecha1, fecha2, sedeI, sedeF, cliente, conduct);
			if (pasarela.equals("PayU")) {
				PayU pasa = new PayU();
				pasa.pagoProcesado(cliente.medioPago,cliente,cliente.getReserva().getCobro());
			}else if (pasarela.equals("PayPal")) {
				PayPal pasa = new PayPal();
				pasa.pagoProcesado(cliente.medioPago,cliente,cliente.getReserva().getCobro());
			}
		}else {
			rta = "No se pudo realizar la reserva, revisa bien los datos ingresados";
		}
		return rta;
		
	}
	
	public String guardarReserva(long doc) throws PDFException, IOException {
		return empresa.guardarReserva(doc);
		
	}
	
	public boolean verificarReserva(String categ, String fechaI,String fechaF,String sedeI,String sedeF,String doc,String conduc) throws ParseException, IOException {
		boolean rta = true;
		if (empresa.buscarClientePorId(Long.parseLong(doc)) != null) {
			Cliente cliente = empresa.buscarClientePorId(Long.parseLong(doc));
			Date fecha1 = Empresa.obtenerFecha(fechaI);
			Date fecha2 = Empresa.obtenerFecha(fechaF);
			int conduct = Integer.parseInt(conduc);
			rta = true;
		}else {
			rta = false;
		}
		return rta;
		
	}
	
	public String crearSede(String nombre,String ubicacion) throws ParseException, IOException {
		
		if (empresa.crearSedeNueva(nombre, ubicacion,"10:00:00-20:00:00,10:00:00-20:00:00,10:00:00-20:00:00,10:00:00-20:00:00,10:00:00-20:00:00,10:00:00-18:00:00,NA")) {
			return "La sede se creó con éxito.";
		}else {
			return "Ya existe una sede con ese nombre.";
		}
		
	}
	
	public String crearEmpleado(String nombre,String sede,String usuario,String contra) throws IOException {
		return empresa.registrarNuevoEmpleado(usuario, contra, nombre, sede);
	}
	
	public boolean crearCategoria(String nombre,String valor) {
		return empresa.crearCategoria(nombre,Integer.parseInt(valor));
	}
	
	public String consultarReserva(long doc) {
		return empresa.consultarReserva(doc);
	}
	
	public String consultarEstado(String placa,String limpio, String mantenim) {
		String rta = "";
		if (limpio.equals("Si") && mantenim.equals("Si")) {
			rta = empresa.actualizarEstado(placa, true, true);
		}else {
			rta = empresa.actualizarEstado(placa, false, false);
		}	
		return rta;
	}
	
	public Cliente buscarClienteLogin(String login) {
		return empresa.buscarClienteLogin(login);
	}
}
