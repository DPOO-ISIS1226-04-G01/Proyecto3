package InterfazCliente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class ClienteLoginSignUp extends JFrame implements ActionListener{
	
	// ATRIBUTOS DE LA VENTANA
	private final static String INICIAR = "Iniciar";
	private PanelImagen imagen;
	
	// Ventanas que estan conectadass
	LoginCliente vLogin;
	SignUpCliente vSignUp;
	
	// Elementos de la ventana
	JLabel textoElegir;
	JRadioButton login,signUp;
	JButton iniciar,salir;
	ButtonGroup gBotones;
	Aplicacion consola1;
	
	public ClienteLoginSignUp(Aplicacion consola12){
		consola1 = consola12;
		// VENTANA PRINCIPAL
		setTitle("Login/SignUp");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(600,700);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setResizable(false);
		
		imagen = new PanelImagen();
		add(imagen,BorderLayout.NORTH);
		
		// TEXTO ELEGIR
		
		JPanel opciones = new JPanel();		
		opciones.setLayout(new GridLayout(6,3));
	
		textoElegir = new JLabel();
		textoElegir.setText("BIENVENIDO CLIENTE");
		textoElegir.setBounds(100, 100, 300, 30);
		textoElegir.setFont(new Font("Consola",Font.BOLD,17));
		opciones.add(new JLabel(""));
		opciones.add(new JLabel(""));
		opciones.add(new JLabel(""));
		opciones.add(new JLabel(""));
		opciones.add(textoElegir);
		opciones.add(new JLabel(""));
		JLabel texto = new JLabel();
		texto.setText("Iniciar Sesion/Registrarse");
		texto.setBounds(100, 100, 300, 30);
		texto.setFont(new Font("Consola",Font.ITALIC,16));
		opciones.add(new JLabel(""));
		opciones.add(texto);
		opciones.add(new JLabel(""));
		//OPCIONES ELEGIR
		
		login = new JRadioButton();
		login.setText("Iniciar Sesion");
		login.setFont(new Font("Consola",Font.PLAIN,15));
		
		signUp = new JRadioButton();
		signUp.setText("Registrarse");
		signUp.setFont(new Font("Consola",Font.PLAIN,15));
		
		gBotones = new ButtonGroup();
		gBotones.add(login);
		gBotones.add(signUp);
		
		opciones.add(new JLabel(""));
		opciones.add(login);
		opciones.add(new JLabel(""));
		opciones.add(new JLabel(""));
		opciones.add(signUp);
		opciones.add(new JLabel(""));
		opciones.add(new JLabel(""));
		opciones.add(new JLabel(""));
		opciones.add(new JLabel(""));
		// BOTONES DE ABAJO
		
		JPanel botones = new JPanel();
		
		iniciar = new JButton();
		iniciar.setText("Iniciar");
		iniciar.setBounds(140, 400, 100, 50);
		iniciar.setBackground(Color.decode("#BBBBBB"));
		iniciar.addMouseListener(new MouseListener() {

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
				iniciar.setBackground(Color.decode("#737373"));				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				iniciar.setBackground(Color.decode("#BBBBBB")); // Cuando se quita el mouse de encima
				
			
			}
			});		
		
		iniciar.addActionListener(this);
		
		botones.add(iniciar);
		
		// AGREGAR A LA VENTANA
		
		add(opciones,BorderLayout.CENTER);
		add(botones, BorderLayout.SOUTH);

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equals(INICIAR) && login.isSelected()) {
			vLogin = new LoginCliente(consola1);
			vLogin.setVisible(true);
			setVisible(false);
			
		}else if (comando.equals(INICIAR) && signUp.isSelected()) {
			vSignUp = new SignUpCliente(consola1);
			vSignUp.setVisible(true);
			setVisible(false);
		}else {
			JOptionPane.showMessageDialog(null,"Debes seleccionar una opcion para continuar.");
		}
	}
	

}
