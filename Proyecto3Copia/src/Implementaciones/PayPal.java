package Implementaciones;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PayPal implements Pagos {

	@Override
	public void pagoProcesado(TarjetaCredito tarjeta, Cliente cliente, double amount) {
		String ruta = "data\\PayPal\\clientesPagaron.txt";
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
