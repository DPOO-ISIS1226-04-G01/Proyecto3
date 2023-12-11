package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import javax.imageio.ImageIO;

import java.io.File;
import java.io.IOException;



public class TipoUsuario extends JFrame implements ActionListener {
	
	// ATRIBUTOS
	Interfaz anterior;

	LoginAdmin vAdmin;
	LoginEmpl vEmpl;
	private final static String INICIAR = "Iniciar";
	private final static String SALIR = "Salir";
	private PanelImagen imagen;
	
	
	JLabel textoUsuario;
	JButton bIniciar;
	JButton bSalir;
	JRadioButton admin,empl;
	ButtonGroup grupoBotones;
	Aplicacion consola1;
	
	
	public TipoUsuario(Aplicacion consola12) {
		
		consola1 = consola12;
		setTitle("Menu Principal");
		
		setSize(500,600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		setResizable(false);
		setLocationRelativeTo(null);
		
		// VENTANA
		imagen = new PanelImagen();
		add(imagen, BorderLayout.NORTH);
		

		
		
		// SELECCIONA UNA OPCION
		JPanel opciones = new JPanel();
		opciones.setLayout(new GridLayout(5,1));

		textoUsuario = new JLabel();
		textoUsuario.setText("Selecciona:");
		textoUsuario.setFont(new Font("Consola",Font.BOLD,16));
		opciones.add(new JLabel(""));
		
		opciones.add(new JLabel(""));
		opciones.add(new JLabel(""));
		opciones.add(new JLabel(""));
		opciones.add(textoUsuario);
		opciones.add(new JLabel(""));
		opciones.add(new JLabel(""));
		
		
		// BOTONES OPCION
		
		admin = new JRadioButton();
		empl = new JRadioButton();
		grupoBotones = new ButtonGroup();
		
		admin.setText("Administrador");
		admin.setFont(new Font("Consola",Font.BOLD,16));
		
		empl.setText("Empleado");
		empl.setFont(new Font("Consola",Font.BOLD,16));
		

		
		grupoBotones.add(admin);
		grupoBotones.add(empl);

		
		opciones.add(admin);
		opciones.add(new JLabel(""));
		opciones.add(new JLabel(""));
		opciones.add(empl);
		opciones.add(new JLabel(""));


		
		// BOTONES INICIAR Y SALIR
		
		JPanel botones = new JPanel();
		
		bIniciar = new JButton();
		bIniciar.setBounds(150, 430, 100, 50);
		bIniciar.setText("Iniciar");
		bIniciar.setBackground(Color.decode("#BBBBBB"));
		bIniciar.setActionCommand(INICIAR);
		bIniciar.addActionListener(this);
		bIniciar.addMouseListener(new MouseListener() {

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

			@Override
			public void mouseEntered(MouseEvent e) { // Cuando se pasa el mouse por encima
				bIniciar.setBackground(Color.decode("#737373"));				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				bIniciar.setBackground(Color.decode("#BBBBBB")); // Cuando se quita el mouse de encima
				
			}
			
		});
		
		botones.add(bIniciar);
		
		
		// AGREGAR LAS COSAS
		//vPrincipal.add(textoUsuario);
		
		add(opciones,BorderLayout.CENTER);
		add(botones,BorderLayout.SOUTH);


	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equals(INICIAR) && admin.isSelected()) {
			vAdmin = new LoginAdmin(consola1);
			vAdmin.setVisible(true);
			setVisible(false);
		}else if(comando.equals(INICIAR) && empl.isSelected()) {
			vEmpl = new LoginEmpl(consola1);
			vEmpl.setVisible(true);
			setVisible(false);
		}else {
			JOptionPane.showMessageDialog(null,"Debes seleccionar una opcion para continuar");
		}
		
	}

}
