package Implementaciones;

import java.util.Date;

public class Cliente extends Usuario{
	private String nombre; 
	private long numeroCelular; 
	private Date fechaNacimiento;  
	private String nacionalidad; 
	private Licencia licencia; 
	private long documento; 
	private Reserva reserva;
	public TarjetaCredito medioPago;
	
	public Cliente(String login, String password, String nombre, long numeroCelular, Date fechaNacimiento, 
			String nacionalidad, long documento, long numeroTar, int cvc, Date fechaVencimientoTar, String imagenTar,
			long numeroLic, String paisExpedicionLic, Date fechaVencimientoLic, String imagenLic) 
	{
		super(login, password);
		this.nombre = nombre;
		this.numeroCelular = numeroCelular;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.documento = documento;
		this.registrarTarjetaCredito(numeroTar,cvc,fechaVencimientoTar,imagenTar);
		this.registrarLicencia(numeroLic, paisExpedicionLic, fechaVencimientoLic, imagenLic);
		this.setReserva(null);
	}
	
	public void registrarTarjetaCredito(long numero, int cvc, Date fechaVencimiento, String imagen) {
		TarjetaCredito tarjeta = new TarjetaCredito(numero, cvc, fechaVencimiento, imagen);
		this.medioPago = tarjeta;
	}
	
	public void registrarLicencia(long numero, String paisExpedicion, Date fechaVencimiento, String imagen) {
		Licencia licencia = new Licencia(numero, paisExpedicion, fechaVencimiento, imagen);
		this.licencia = licencia;
	}
	
	public long getId() {
		return documento;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	// ---------------------------------------------------
	public String getNombre() {
		return nombre;
	}

	public long getNumeroCelular() {
		return numeroCelular;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public Licencia getLicencia() {
		return licencia;
	}

	public long getDocumento() {
		return documento;
	}
	
	public boolean verificarReserva() {
		boolean resp = true;
		if (reserva == null) {
			resp = false;
		}
		return resp;
	}
	
	// ----------------------------------------------------------
	
	
}
