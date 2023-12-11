package testsProyecto3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.text.ParseException;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Implementaciones.Empresa;
import Implementaciones.Sede;


class pruebasProyecto3 {
	private Empresa empresa;  
	@BeforeEach
	void setUp() throws Exception { 
		empresa = new Empresa("Car Prime");  
		
	}
	@Test
	void testCargaVehiculo() throws ParseException {  
		File fileVehiculos = new File("\"data\\\\vehiculos.txt\""); 
		if (fileVehiculos.exists()) { 
			empresa.cargarVehiculos(fileVehiculos); 
			int cantidadEsperada = 10; 
			assertEquals(cantidadEsperada,empresa.getVehiculos().size());
		} else { 
			System.out.println("El archivo de sedes no se encuentra en la ruta especificada.");
		}
	} 
	@Test
	void testCargaAdmin() { 
		File fileAdmin = new File("data\\administrador.txt"); 
		if (fileAdmin.exists()) {  
			empresa.cargarAdministrador(fileAdmin);
			assertNotNull(empresa.getAdministrador());
		} else { 
			System.out.println("El archivo de sedes no se encuentra en la ruta especificada.");
		}
		}
	@Test
	void testCargaSedes() throws ParseException { 
		File fileSedes = new File("data\\sedes.txt"); 
		if (fileSedes.exists()) { 
			empresa.cargarSedes(fileSedes); 
			int cantidadEsperadaSedes = 4; 
			assertEquals(cantidadEsperadaSedes,empresa.getSedes().size());
		} else { 
			System.out.println("El archivo de sedes no se encuentra en la ruta especificada.");
		}
	} 
	 
	@Test
	void testCargaCliente() throws ParseException { 
		File fileCliente = new File("data\\clientes.txt"); 
		if (fileCliente.exists()) {  
			empresa.cargarClientes(fileCliente);
			int cantidadEsperada = 3;
			assertEquals(cantidadEsperada,empresa.getClientes().size());
		} else { 
			System.out.println("El archivo de sedes no se encuentra en la ruta especificada.");
		}
		} 
	@Test
	void testCargaEmpleado() throws ParseException { 
		File fileEmpleado = new File("data\\empleados.txt"); 
		if (fileEmpleado.exists()) {  
			empresa.cargarEmpleados(fileEmpleado);
			int cantidadEsperada = 8;
			assertEquals(cantidadEsperada,empresa.getEmpleados().size());
		} else { 
			System.out.println("El archivo de sedes no se encuentra en la ruta especificada.");
		}
		} 
	@Test
	void testCargaSeguros() throws ParseException { 
		File fileSeguro = new File("data\\seguros.txt"); 
		if (fileSeguro.exists()) {  
			empresa.cargarSeguros(fileSeguro);;
			int cantidadEsperada = 3;
			assertEquals(cantidadEsperada,empresa.getInventario().getSeguros().size());
		} else { 
			System.out.println("El archivo de sedes no se encuentra en la ruta especificada.");
		}
		} 	
	@Test
	void testCargaCategorias() throws ParseException { 
		File fileCategoria = new File("data\\categorias.txt"); 
		if (fileCategoria.exists()) {  
			empresa.cargarCategorias(fileCategoria);;
			int cantidadEsperada = 4;
			assertEquals(cantidadEsperada,empresa.getInventario().getCategorias().size());
		} else { 
			System.out.println("El archivo de sedes no se encuentra en la ruta especificada.");
		}
		} 

}
