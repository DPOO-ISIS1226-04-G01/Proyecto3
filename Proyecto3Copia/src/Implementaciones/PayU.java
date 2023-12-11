package Implementaciones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class PayU implements Pagos {

	
	public void PayU() {
		
	}
	@Override
	public void pagoProcesado(TarjetaCredito tarjeta, Cliente cliente, double amount) {
		String ruta = "data\\PayU\\clientesPagaron.txt";
		try {
			BufferedWriter archivoClientes = new BufferedWriter(new FileWriter(ruta, true));
			archivoClientes.write(cliente.getNombre() + ";" + Long.toString(tarjeta.numero));
			archivoClientes.newLine();
			archivoClientes.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	
	}

	@Override
	public boolean cupoBloqueado(TarjetaCredito tarjeta, double amount) {
		return false;
	}

}
