package Interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class Interfaz extends JFrame {
	
	Aplicacion consola1 = new Aplicacion();
	// Para ventana principal
	JPanel vBienvenida;
	JButton botonIniciar;
	JLabel textoBienvenida;
	JLabel textoCar;
	JLabel textoIniciar;
	TipoUsuario vSig;
	
	public Interfaz() {
		
		// CREADORES
		vBienvenida = new JPanel(); //Creamos un JFrame que es la base de la ventana.
		botonIniciar = new JButton(); // Creamos el boton
		textoBienvenida = new JLabel();
		textoCar = new JLabel();
		textoIniciar = new JLabel();
		
		setBounds(500, 260, 600, 300); //Tamano y posicion en la pantalla del computador
		setTitle("Bienvenida");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		
		// VENTANA PRINCIPAL
		vBienvenida.setVisible(true);
		vBienvenida.setLayout(null);
		
		// BOTON INICIAR
		
		botonIniciar.setBounds(220,180,150,50); // Tamano y posicion en la ventana
		botonIniciar.setText("Iniciar"); // Texto que va a aparecer
		botonIniciar.setBackground(Color.decode("#BBBBBB")); // Color del boton
		botonIniciar.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
		botonIniciar.addActionListener(new ActionListener() { //Que hacer cuando se da clic
			@Override
			public void actionPerformed(ActionEvent e) {
				 // Muestro la sig ventana y quito la actual
				try {
					consola1.ejecutarAplicacion();
				} catch (IOException | ParseException e1) {
					e1.printStackTrace();
				}
				vSig = new TipoUsuario(consola1);
				vSig.setVisible(true);
				setVisible(false);
			}
			
		});
		
		botonIniciar.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) { // Cuando se pasa el mouse por encima
				botonIniciar.setBackground(Color.decode("#737373"));				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				botonIniciar.setBackground(Color.decode("#BBBBBB")); // Cuando se quita el mouse de encima
				
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		// TEXTO BIENVENIDA
		
		textoBienvenida.setText("Bienvenido a");
		textoBienvenida.setBounds(245, 10, 200, 100);
		textoBienvenida.setFont(new Font("Consola",Font.PLAIN,16));
		
		textoCar.setText("CarPrime - Reservas");
		textoCar.setBounds(195, 30, 200, 100);
		textoCar.setFont(new Font("Consola",Font.BOLD,20));
		
		textoIniciar.setText("Por favor, da clic en el boton 'Iniciar'");
		textoIniciar.setBounds(170, 50, 300, 140);
		textoIniciar.setFont(new Font("Consola",Font.PLAIN,16));
		
		
		vBienvenida.add(botonIniciar); // Agregar el boton a la ventana de Bienvenida
		vBienvenida.add(textoBienvenida);
		vBienvenida.add(textoCar);
		vBienvenida.add(textoIniciar);
		
		this.add(vBienvenida);
		
	}
}
