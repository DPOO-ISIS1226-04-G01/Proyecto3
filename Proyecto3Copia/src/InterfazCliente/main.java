package InterfazCliente;

import java.io.IOException;
import java.text.ParseException;

public class main {

	public static void main(String[] args) throws IOException, ParseException {
		Aplicacion consola = new Aplicacion();
		consola.ejecutarAplicacion();
		ClienteLoginSignUp d = new ClienteLoginSignUp(consola);
		//PagoReserva d1 = new PagoReserva(consola);
		d.setVisible(true);
		
	}
}
