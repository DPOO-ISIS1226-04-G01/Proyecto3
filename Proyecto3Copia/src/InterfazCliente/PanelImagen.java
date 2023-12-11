package InterfazCliente;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PanelImagen extends JPanel {
	
	public PanelImagen() {
		JLabel imagen = new JLabel();
		ImageIcon icono = new ImageIcon("Imagenes/Logo4.png");
		imagen.setIcon(icono);
		add(imagen);
		
		setBackground(Color.WHITE);
		setBorder(new LineBorder(Color.BLACK));
	}

}
