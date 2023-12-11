package Implementaciones;

public class Vehiculo {
	
	private String sede;
	private String placa; 
	private String marca; 
	private String modelo;
	private String color; 
	private String transmision; 
	private String categoria; 

	public Vehiculo(String placa, String marca, String modelo, String color, String transmision,
			String categoria) {
		this.setPlaca(placa);
		this.setMarca(marca);
		this.setModelo(modelo);
		this.setColor(color);
		this.setTransmision(transmision);
		this.setCategoria(categoria);
	} 
	
	public void setSede(String sede) {
		this.sede = sede;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getTransmision() {
		return transmision;
	}

	public void setTransmision(String transmision) {
		this.transmision = transmision;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	//-----------------------------------------------
	public String getSede() {
		return sede;
	}
	// --------------------------------------
	
}
