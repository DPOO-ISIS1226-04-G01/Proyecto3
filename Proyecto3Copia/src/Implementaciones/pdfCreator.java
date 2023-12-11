package Implementaciones;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.qoppa.pdf.PDFException;
import com.qoppa.pdfProcess.PDFDocument;
import com.qoppa.pdfProcess.PDFGraphics;
import com.qoppa.pdfProcess.PDFPage;

public class pdfCreator {
	
	@SuppressWarnings("finally")
	public String createReservationPDF(Reserva reserva)throws PDFException, IOException{
		String resp = "";
		try {
			PDFDocument pdf = new PDFDocument();
			PDFPage page = pdf.appendNewPage(8.5 * 72, 11 * 72);
			/*
			String factura = "";
			factura += "\n>>Datos reserva";
			factura += "\nDocumento del cliente: " + reserva.getCliente().getId();
			factura += "\nCategoria: " + reserva.getCategoria();
			factura += "\nCobro: " + reserva.getCobro();
			factura += "\nSede inicio: " + reserva.getSedeInicio().getNombre();
			factura += "\nSede final: " + reserva.getSedeFin().getNombre();
			factura += "\nFecha inicio: " + reserva.getFechaInicio();
			factura += "\nFecha fin: " + reserva.getFechaFin();
			factura += "\nConductores adicionales: " + reserva.getConductoresExtra();
			*/
			PDFGraphics g2d = (PDFGraphics) page.createGraphics();
			g2d.setFont (PDFGraphics.HELVETICA.deriveFont(10));
	        g2d.setColor(Color.BLACK);
	
	        // draw text on the graphics object of the page
	        g2d.drawString("DATOS DE ENTREGA", 50, 60);
	        g2d.drawString("\nDocumento del cliente: " + reserva.getCliente().getId(), 50, 80);
	        g2d.drawString("\nCategoria: " + reserva.getCategoria(), 50, 100);
	        g2d.drawString("\nCobro: " + reserva.getCobro(), 50, 120);
	        g2d.drawString("\nSede inicio: " + reserva.getSedeInicio().getNombre(), 50, 140);
	        g2d.drawString("\nSede final: " + reserva.getSedeFin().getNombre(), 50, 160);
	        g2d.drawString("\nFecha inicio: " + reserva.getFechaInicio(), 50, 180);
	        g2d.drawString("\nFecha fin: " + reserva.getFechaFin(), 50, 200);
	        g2d.drawString("\nConductores adicionales: " + reserva.getConductoresExtra(), 50, 220);
	        g2d.drawString("Firma administrador: ", 100, 240);
	        BufferedImage image = ImageIO.read(new File("Imagenes/Firma.jpeg"));
	
	        // draw the image on the page
	        g2d.drawImage(image, 10, 250, 281, 102,  null);
			
			pdf.saveDocument("data/Facturas/" + reserva.getCliente().getId() + "_" + Empresa.dateToString(reserva.getFechaFin(),"dd_MM_yyyy") + ".pdf");
			resp = "Se guardo con exito el recibo de la entrega";
		}
		catch (Throwable e) {
			resp = "No se pudo generar el recibo de la entrega";
			e.printStackTrace();
		}
		finally {
			return resp;
		}
	}

}