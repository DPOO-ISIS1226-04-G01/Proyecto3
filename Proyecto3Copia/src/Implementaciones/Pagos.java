package Implementaciones;

public interface Pagos {
	
	
	 void pagoProcesado(TarjetaCredito tarjeta, Cliente cliente, double amount);
	 boolean cupoBloqueado(TarjetaCredito tarjeta, double amount);
	

}
