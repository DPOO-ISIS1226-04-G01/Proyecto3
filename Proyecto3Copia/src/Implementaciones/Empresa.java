package Implementaciones;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.qoppa.pdf.PDFException;

import Implementaciones.*;

public class Empresa {
	
	private String nombre;
	private Map<String, Cliente> clientes;
	private Map<String, Sede> sedes;
	private Map<String, Empleado> empleados;
	private Map<String, AdministradorLocal> adminLocales;
	private Map<String, Vehiculo> vehiculos;
	private Administrador administrador;
	private Inventario inventario;
	private pdfCreator creator;
	
	public Empresa(String nombre) {
		this.setNombre(nombre);
		this.inventario = new Inventario();
		creator = new pdfCreator();
	}
	
	public Cliente buscarClienteLogin(String login) {
		return this.clientes.get(login);
	}
	
	public void cargarEmpresa(File archivoAdministrador, File archivoAdminLocales, File archivoCategorias,
							File archivoClientes, File archivoEmpleados, File archivoSedes, File archivoVehiculos, File archivoTarifas, 
							File archivoSeguros) throws ParseException {
		this.cargarAdministrador(archivoAdministrador);
		this.cargarClientes(archivoClientes);
		this.cargarSedes(archivoSedes);
		this.cargarAdminLocales(archivoAdminLocales);
		this.cargarEmpleados(archivoEmpleados);
		this.cargarCategorias(archivoCategorias);
		this.cargarTarifas(archivoTarifas);
		this.cargarVehiculos(archivoVehiculos);
		this.cargarSeguros(archivoSeguros);
	}
	
	public Administrador buscarAdministrador(String login) {
		Administrador resp = null;
		Administrador admin = this.administrador;
		if (admin.getLogin().equals(login)) {
			resp = admin;
		}
		return resp;
	}
	
	public void cargarAdministrador(File archivo) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			String linea = br.readLine();
			String[] partes = linea.split(";");
			Administrador admin = new Administrador(partes[0], partes[1]);
			this.setAdministrador(admin);
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void cargarSeguros(File archivo) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			String linea = br.readLine();
			while (linea != null)
			{
				String[] partes = linea.split(";");
				String nombre = partes[0];
				int costo = Integer.parseInt(partes[1]);
				Seguro seguro = new Seguro(nombre, costo);
				this.inventario.añadirSeguro(seguro);
				linea = br.readLine();
			}
			br.close();
			}
			catch (IOException e){
				e.printStackTrace();
			}
	}
	
	public void cargarAdminLocales(File archivo) {
		try {
			this.adminLocales = new HashMap<>();
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			String linea = br.readLine();
			while (linea != null)
			{
				String[] partes = linea.split(";");
				String login = partes[0];
				String password = partes[1];
				String sede = partes[2];
				Sede sedee = this.buscarSede(sede);
				AdministradorLocal adminLocal = new AdministradorLocal(login, password, sedee);
				this.adminLocales.put(login, adminLocal);
				linea = br.readLine();
			}
			br.close();
			}
			catch (IOException e){
				e.printStackTrace();
			}
	}
	
	public void cargarSedes(File archivo) throws ParseException {
		try {
			this.sedes = new HashMap<>();
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			String linea = br.readLine();
			while (linea != null)
			{
				String[] partes = linea.split(";");
				String nombre = partes[0]+"\n"; // CAMBIOS
				String direccion = partes[1];
				String horarios = partes[2];
				Sede sede = new Sede(nombre, direccion, horarios);
				sedes.put(sede.getNombre(), sede); // CAMBIO this.getSede(). por sedes.
				linea = br.readLine();
			}
			br.close();
			}
			catch (IOException e){
				e.printStackTrace();
			}
	}
	
	public void cargarClientes(File archivo) throws ParseException {
		try {
			this.clientes = new HashMap<>();
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			String linea = br.readLine();
			while (linea != null)
			{
				String[] partes = linea.split(";");
				String login = partes[0];
				String password = partes[1];
				String nombre = partes[2];
				long numeroCelular = Long.parseLong(partes[3]);
				Date fechaNacimiento = obtenerFecha(partes[4]);
				String nacionalidad = partes[5];
				long documento = Long.parseLong(partes[6]);
				long numeroTar = Long.parseLong(partes[7]);
				int cvc = Integer.parseInt(partes[8]);
				Date fechaVencimientoTar = obtenerFecha(partes[9]);
				String imagenTar = partes[10];
				int numeroLic = Integer.parseInt(partes[11]);
				String paisExpedicionLic = partes[12];
				Date fechaVencimientoLic = obtenerFecha(partes[13]);
				String imagenLic = partes[14];
				Cliente cliente = new Cliente(login, password, nombre, numeroCelular, fechaNacimiento, nacionalidad,
						documento, numeroTar, cvc, fechaVencimientoTar, imagenTar, numeroLic, paisExpedicionLic,
						fechaVencimientoLic, imagenLic);
				this.clientes.put(cliente.getLogin(), cliente);
				linea = br.readLine();
			}
			br.close();
			}
			catch (IOException e){
				e.printStackTrace();
			}
	}
	
	
	public void cargarEmpleados(File archivo) {
		try {
			this.empleados = new HashMap<>();
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			String linea = br.readLine();
			while (linea != null)
			{
				String[] partes = linea.split(";");
				String login = partes[0];
				String password = partes[1];
				String nombre = partes[2];
				String sede = partes[3]+"\n"; // CAMBIOS
				Empleado empleado = new Empleado(login, password, nombre, sede);
				//this.sedes.get(sede).añadirEmpleado(empleado);
				this.empleados.put(login, empleado);
				linea = br.readLine();
			}
			br.close();
			}
			catch (IOException e){
				e.printStackTrace();
			}
		
	}
	
	public void cargarCategorias(File archivo) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			String linea = br.readLine();
			while (linea != null)
			{
				String[] partes = linea.split(";");
				String tipo = partes[0];
				int valor = Integer.parseInt(partes[1]);
				Categoria categoria = new Categoria(tipo, valor);
				this.inventario.añadirCategoria(categoria);
				linea = br.readLine();
			}
			br.close();
			}
			catch (IOException e){
				e.printStackTrace();
			}
	}
	
	public void cargarTarifas(File archivo) throws ParseException {
		try {
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			String linea = br.readLine();
			while (linea != null)
			{
				String[] partes = linea.split(";");
				linea = br.readLine();
				String categoria = partes[0];
				String temporada = partes[1];
				Date fechaInicio = Empresa.obtenerFecha(partes[2]);
				Date fechaFin = Empresa.obtenerFecha(partes[3]);
				int valorDia = Integer.parseInt(partes[4]);
				Tarifa tarifa = new Tarifa(temporada,fechaInicio,fechaFin,valorDia);
				Categoria categoriaa = this.inventario.buscarCategoria(categoria);
				categoriaa.añadirTarifa(tarifa);
			}
			br.close();
			}
			catch (IOException e){
				e.printStackTrace();
			}
	}
	
	public void cargarVehiculos(File archivo) throws ParseException {
		try {
			this.vehiculos = new HashMap<>();
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			String linea = br.readLine();
			while (linea != null)
			{
				String[] partes = linea.split(";");
				String placa = partes[0];
				String marca = partes[1];
				String modelo = partes[2];
				String color = partes[3];
				String transmision = partes[4];
				String categoria = partes[5];
				Vehiculo vehiculo = new Vehiculo(placa, marca, modelo, color, transmision, categoria);
				this.vehiculos.put(placa, vehiculo);
				linea = br.readLine();
			}
			br.close();
			this.iniciarEstadosVehiculos();
			}
			catch (IOException e){
				e.printStackTrace();
			}
	}
	
	public String actualizarEstado(String placa,boolean limpio, boolean mantenimiento) {
		String rta1 = "Si no esta limpio y se le hizo el respectivo mantenimiento, no se puede actualizar el estado";
		if (limpio && mantenimiento) {
			Map<Vehiculo, String> mapaNoDisponibles = this.inventario.getVehiculosNoDisponibles();
			Set<Vehiculo> vND = mapaNoDisponibles.keySet();
			
			rta1 = "El vehiculo al parecer si está disponible";
			
			for (Vehiculo vehiculo: vND) {
				if (vehiculo.getPlaca().equals(placa)) {
					String ruta = "data\\Historial vehiculos\\" + placa + ".txt";
					Vehiculo vehiculoActualizar = this.buscarVehiculo(placa);
					String nuevaLinea = "disponible;Sede1";
					String[] partesNuevaLinea = nuevaLinea.split(";");
					try {
						BufferedReader br = new BufferedReader(new FileReader(ruta));
						String linea = br.readLine();
						while (linea!=null) {
							linea = br.readLine();
							if (linea == null) {
								FileWriter fileWriter = new FileWriter(ruta, true); 
					            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
					            bufferedWriter.newLine(); 
					            bufferedWriter.write(nuevaLinea);
					            bufferedWriter.close();
					            rta1 = "El estado del vehiculo con placa " + placa + " fue actualizado con exito";
								
							    mapaNoDisponibles.remove(vehiculoActualizar); 
							    Set<String> listaSedes = sedes.keySet(); 
							    for (String nombreSede: listaSedes) { 
								    if (nombreSede.equals(partesNuevaLinea[1])) { 
									    Sede sedeActualizar = sedes.get(nombreSede); 
									    String categoria = vehiculoActualizar.getCategoria();
									    HashMap<String, ArrayList<Vehiculo>> mapaActualizar = sedeActualizar.getVehiculosCategoria(); 
									    ArrayList<Vehiculo> listaActualizar = mapaActualizar.get(categoria); 
									    listaActualizar.add(vehiculoActualizar);
									    mapaActualizar.put(categoria, listaActualizar); 
								  } 
							  }
								 
							}	
						}
					}catch (IOException e){
						e.printStackTrace();
					}					
				}else {
					rta1 = "La placa del vehiculo no existe.";
				}
			}
		}
		return rta1;
	}
	
	public void iniciarEstadosVehiculos() throws ParseException {
		String estado = null;
		Set<String> placas = this.vehiculos.keySet();
		for(String placa: placas){
			String ruta = "data\\Historial vehiculos\\" + placa + ".txt";
			Vehiculo vehiculo = this.buscarVehiculo(placa);
			try {
				File archivo = new File(ruta);
				archivo.createNewFile();
				BufferedReader br = new BufferedReader(new FileReader(archivo));
				String linea = br.readLine();
				while (linea != null)
				{
					estado = linea;
					linea = br.readLine();
				}
				br.close();
				}
				catch (IOException e){
				e.printStackTrace();
				}
			String[] partes = estado.split(";");
			if (partes[0].equals("disponible")) {
				Sede sede = this.buscarSede(partes[1]+"\n"); // CAMBIOS
				sede.añadirVehiculoDisponible(vehiculo);
				
			}
			else if (partes[0].equals("noDisponible")) {
				String razon = partes[1] + ";" + partes[2];
				this.inventario.añadirVehiculoNoDisponible(vehiculo, razon);
				
			}
			else if (partes[0].equals("reservado")) {
				String conductoresExtra;
				String categoria = partes[1];
				Date fechaInicio = Empresa.obtenerFecha(partes[2]);
				Date fechaFin = Empresa.obtenerFecha(partes[3]);
				Sede sedeInicio = this.buscarSede(partes[4]+"\n");
				Sede sedeFin = this.buscarSede(partes[5]+"\n");
				double cobro = Double.parseDouble(partes[6]);
				Cliente cliente = this.buscarClientePorId(Long.parseLong(partes[7]));
				String conducExtra = partes[8];
				if (conducExtra.equals("NA")) {
					conductoresExtra = "0";
				}
				else {
					conductoresExtra = conducExtra;
				}
				Reserva reserva = new Reserva(categoria, fechaInicio, fechaFin, sedeInicio, sedeFin, cobro, cliente, Integer.parseInt(conductoresExtra));
				cliente.setReserva(reserva);
				this.inventario.añadirVehiculoReservado(vehiculo, reserva);
			}
		}
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Administrador getAdministrador() {
		return administrador;
	}
	
	public void setAdministrador(Administrador admin) {
		this.administrador = admin;
	}
	
	public Inventario getInventario() {
		return inventario;
	}
	
	public Map<String, Sede> getSedes(){
		return this.sedes;
	}
	
	public Sede buscarSede(String sede) {
		return sedes.get(sede); // CAMBIOS
	}
	
	public static Date obtenerHora(String cadena) throws ParseException{
		SimpleDateFormat r = new SimpleDateFormat("HH:mm:ss");
		Date hora = r.parse(cadena);
		return hora;
	}
	
	public static Date obtenerFecha(String cadena) throws ParseException {
		SimpleDateFormat r = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha = r.parse(cadena);
		return fecha;
	}
	
	public Vehiculo buscarVehiculo(String placa) {
		return this.vehiculos.get(placa);
	}
	
	public static String dateToString(Date date, String formato) {
	    SimpleDateFormat sdf = new SimpleDateFormat(formato);
	    String fechaFormateada = sdf.format(date);
	    return fechaFormateada;
	}
	
	public String consultarVehiculoPorPlaca(String placa) {
		Map<String,Sede> mapaSedes = this.sedes;
		Collection<Sede> listaSedes = mapaSedes.values();
		
		Map<Vehiculo, Reserva> mapaReservados = this.inventario.getVehiculosReservados();
		Set<Vehiculo> vR = mapaReservados.keySet();
		
		Map<Vehiculo, String> mapaNoDisponibles = this.inventario.getVehiculosNoDisponibles();
		Set<Vehiculo> vND = mapaNoDisponibles.keySet();
		
		String rta1 = "";
		String rta2 = "No existe la placa ingresada";
		String rta3 = "";
		String rta4 = "";
		String rta5 = "";
		
		for (Sede sede: listaSedes) {
			HashMap<String, ArrayList<Vehiculo>> mapaDisponibles = sede.getVehiculosCategoria();
			Set<String> listaCategorias = mapaDisponibles.keySet();
			for (String categoria: listaCategorias) {
				ArrayList<Vehiculo> listaVehiculos = mapaDisponibles.get(categoria);
				for (Vehiculo vehiculo: listaVehiculos) {
					if (vehiculo.getPlaca().equals(placa)) {
						rta1 = "La sede en donde se encuentra el vehiculo es: " + sede.getNombre();
						rta2 = "La categoria del vehiculo es: " + vehiculo.getCategoria() + "\n";
						rta3 = "La marca del vehiculo es: " + vehiculo.getMarca() + "\n";
					}
				}
			}
		}
		
		if (rta1 == "") {
			for (Vehiculo vehiculo: vND) {
				if (vehiculo.getPlaca().equals(placa)) {
					rta1 = "La categoria del vehiculo es: " + vehiculo.getCategoria() + "\n";
					rta2 = "El vehiculo no está disponible, su razon y la fecha de disponibilidad son: " + mapaNoDisponibles.get(vehiculo) + "\n";
						
				}
			}
		}
		
		if (rta1 == "") {
			for (Vehiculo vehiculo: vR) {
				if (vehiculo.getPlaca().equals(placa)) {
					Reserva reserva = mapaReservados.get(vehiculo);
					rta1 = "El cliente que tiene la reserva es: " + reserva.getCliente().getNombre() +
							"\n" + "Y su documento es: " + Long.toString(reserva.getCliente().getDocumento()) + "\n";
					if (reserva.getConductoresExtra() == 0) {
						rta2 = "La cantidad de conductores extra son: 0" + "\n";
						
					}else {
						rta2 = "La cantidad de conductores extra son: " + Integer.toString(reserva.getConductoresExtra()) + "\n";
					}
					//rta2 = "La cantidad de conductores extra son: " + Integer.toString(reserva.getConductoresExtra().size()) + "\n";
					rta3 = "La sede en donde será entregado es: " + reserva.getSedeFin().getNombre();
					rta4 = "La fecha de entrega es : " + dateToString(reserva.getFechaFin(),"dd/MM/yyyy HH:mm:ss") + "\n";
					rta5 = "La categoria del vehiculo es: " + vehiculo.getCategoria() + "\n";
				}
				
			}
		}
		return rta1+rta2+rta3+rta4+rta5;
	}
	

	

	public Cliente buscarClientePorId(long documento) {
		Cliente resp = null;
		for(Cliente client: this.clientes.values()){
			if(documento == client.getId()) {
				resp = client;
				break;
			}
		}
		return resp;
	}
	
	public Empleado buscarEmpleado(String login) {
		return this.empleados.get(login);
	}
	
	public static String obtenerFechaFormateada(Date fecha) {
        // Define el formato de fecha deseado
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        // Formatea la fecha como una cadena
        return formato.format(fecha);
    }
	//---------------------------------------------------------------------------------------------------------------
	public void crearUsuarioNuevo(String login, String password, String nombre, long numeroCelular, Date fechaNacimiento, 
			String nacionalidad, long documento, long numeroTar, int cvc, Date fechaVencimientoTar, String imagenTar,
			long numeroLic, String paisExpedicionLic, Date fechaVencimientoLic, String imagenLic) {
		
		Cliente newCliente = new Cliente(login,password,nombre,numeroCelular,fechaNacimiento, 
				nacionalidad,documento,numeroTar,cvc,fechaVencimientoTar,imagenTar,
				numeroLic, paisExpedicionLic, fechaVencimientoLic, imagenLic);
		clientes.put(login, newCliente);
		try {
		BufferedWriter archivoClientes = new BufferedWriter(new FileWriter("data\\clientes.txt", true));
		archivoClientes.newLine();
		archivoClientes.write(login+";"+password+";"+nombre+";"+numeroCelular+";"+obtenerFechaFormateada(fechaNacimiento)+";"+nacionalidad+";"+documento+";"+numeroTar+";"+cvc+";"+obtenerFechaFormateada(fechaVencimientoTar)+";"+"imagen_tarjeta"+";"+numeroLic+";"+paisExpedicionLic+";"+obtenerFechaFormateada(fechaVencimientoLic)+";"+"imagen_Licencia");
		archivoClientes.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public boolean crearVehiculoNuevo2(String sede,String placa,String marca,String modelo,String color,String transmision,String categoria){ 
		boolean rta = false;
		if (inventario.existeCategoria(categoria) ) {
			Vehiculo newVehiculo = new Vehiculo(placa,marca,modelo,color,transmision,categoria);
			vehiculos.put(placa, newVehiculo);	
			if (buscarSede(sede + "\n") != null) {
				Sede sedeAgregar = buscarSede(sede + "\n");
				sedeAgregar.añadirVehiculoDisponible(newVehiculo);
				rta = true;
				try {
					File file = new File("data\\Historial vehiculos\\" + placa + ".txt");
					BufferedWriter archivoHistorial = new BufferedWriter(new FileWriter(file, true));
					BufferedWriter archivoVehiculos = new BufferedWriter(new FileWriter("data\\vehiculos.txt", true));
					archivoHistorial.write("disponible;" + sede);
					archivoHistorial.close();
					archivoVehiculos.newLine();
					archivoVehiculos.write(placa+";"+marca+";"+modelo+";"+color+";"+transmision+";"+categoria);
					archivoVehiculos.close();
					}
					catch (IOException e) {
						e.printStackTrace();
					}
			}
		}
		return rta;
	}
	
	public int saberDisposicionporCategoria(String categoria) {  
		
		int cantidadCategoria = 0;
				
		Collection<Vehiculo> valores = vehiculos.values();
		for (Vehiculo vehiculo: valores) {
			if (vehiculo.getCategoria().equals(categoria)) {
				cantidadCategoria += 1;
			}
		}
		return cantidadCategoria;
	}
	
	
	public String crearReserva(String categoria, Date fechaInicio, Date fechaFin, String sedeInicio, String sedeFin, Cliente cliente,int conductores) throws IOException{
		String resp = "";
		Vehiculo vehiculo = sedes.get(sedeInicio+"\n").buscarVehiculoCategoria(categoria);
		if (sedes.get(sedeInicio+"\n").buscarVehiculoCategoria(categoria) == null) {
			resp = "No se encontraron vehiculos de la categoria " + categoria + "en la sede " + sedeInicio; 
		}
		else if (cliente.verificarReserva()){
			resp = "Ya tienes una reserva activa";
		}
		else {
			Sede sede_inicio = sedes.get(sedeInicio+"\n");
			Sede sede_fin = sedes.get(sedeFin+"\n");
			Reserva reserva = inventario.crearReserva(categoria, fechaInicio, fechaFin, sede_inicio, sede_fin, cliente, conductores, vehiculo);
			resp = "La reserva se realizo correctamente";
			resp += "\n>>Datos reserva";
			resp += "\nCategoria: " + reserva.getCategoria();
			resp += "\nCobro: " + reserva.getCobro();
			resp += "\nSede inicio: " + reserva.getSedeInicio().getNombre();
			resp += "Sede final: " + reserva.getSedeFin().getNombre();
			resp += "Fecha inicio: " + reserva.getFechaInicio();
			resp += "\nFecha fin: " + reserva.getFechaFin();
		}
		
		return resp;
	}
	
	public String consultarReserva(long documento) {
		String resp = "";
		Cliente cliente = buscarClientePorId(documento);
		if (cliente != null) {
			if (cliente.verificarReserva()) {
				Reserva reserva = cliente.getReserva();
				resp += "\n>>Datos reserva";
				resp += "\nCategoria: " + reserva.getCategoria();
				resp += "\nCobro: " + reserva.getCobro();
				resp += "\nSede inicio: " + reserva.getSedeInicio().getNombre();
				resp += "Sede final: " + reserva.getSedeFin().getNombre();
				resp += "Fecha inicio: " + reserva.getFechaInicio();
				resp += "\nFecha fin: " + reserva.getFechaFin();
				}
			else {
				resp += "El cliente no tiene reserva";
			}
		}
		else {
			resp = "No se encuentra registrado ningún cliente con el documento " + documento;
		}
		return resp; 
	}
	
	public boolean crearSedeNueva(String nombre,String ubicacion,String horarios) throws ParseException, IOException { 
		boolean rta = false;
		if (buscarSede(nombre+"\n") == null) {
			Sede newSede = new Sede(nombre+"\n",ubicacion,horarios);
			guardarSede(nombre,ubicacion,horarios);
			sedes.put(nombre+"\n", newSede);
			rta = true;
		}
		return rta;
	}
	
	public void guardarSede(String nombre, String ubicacion, String horarios) throws IOException{
		String entrada = nombre + ";" + ubicacion + ";" + horarios;
		BufferedWriter estadoVehiculo = new BufferedWriter(new FileWriter("data\\sedes.txt", true));
		estadoVehiculo.newLine();
		estadoVehiculo.write(entrada);
		estadoVehiculo.close();
	}
	
	public String registrarNuevoEmpleado(String login, String password, String nombre, String sede) throws IOException{
		String resp = "";
		if (buscarEmpleado(login) != null) {
			resp = "Ya existe un usuario con el login ingresado.";
		}else if(buscarSede(sede+"\n") == null) {
			resp = "La sede que ingreso, no existe.";
		}		
		else {
			Empleado empleado = new Empleado(login, password, nombre, sede);
			this.empleados.put(login, empleado);
			this.buscarSede(sede + "\n").añadirEmpleado(empleado);
			guardarEmpleado(login, password, nombre, sede);
			resp = "El empleado se registro con exito";
		}
		return resp;
	}
	
	public void guardarEmpleado(String login, String password, String nombre, String sede) throws IOException{
		String entrada = login + ";" + password + ";" + nombre + ";" + sede;
		BufferedWriter estadoVehiculo = new BufferedWriter(new FileWriter("data\\empleados.txt", true));
		estadoVehiculo.newLine();
		estadoVehiculo.write(entrada);
		estadoVehiculo.close();
	}
	
	public boolean crearCategoria(String nombre, int valor) {
		boolean rta = false;
		if (inventario.existeCategoria(nombre)) {
			rta = false;
		}else {
			Categoria categ = new Categoria(nombre,valor);
			categ.setTarifas(inventario.getTarifasCategoria(valor));
			inventario.añadirCategoria(categ);
			try {
			BufferedWriter archivoCategorias = new BufferedWriter(new FileWriter("data\\categorias.txt", true));
			archivoCategorias.newLine();
			archivoCategorias.write(nombre+";"+valor);
			archivoCategorias.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			rta = true;
		}
		return rta;
	}
	
	public Map<String, Vehiculo> getVehiculos(){
		return this.vehiculos;
	}
	
	public Map<String, Cliente> getClientes(){
		return this.clientes;
	}
	
	public Map<String, Empleado> getEmpleados(){
		return this.empleados;
	}
	
	public String guardarReserva(long documento) throws PDFException, IOException {
		String resp = "";
		Cliente cliente = buscarClientePorId(documento);
		if (cliente != null) {
			if (cliente.verificarReserva()) {
				resp = creator.createReservationPDF(cliente.getReserva());
				}
			else {
				resp += "El cliente no tiene reserva";
			}
		}
		else {
			resp = "No se encuentra registrado ningún cliente con el documento " + documento;
		}
		return resp; 
	}
}
