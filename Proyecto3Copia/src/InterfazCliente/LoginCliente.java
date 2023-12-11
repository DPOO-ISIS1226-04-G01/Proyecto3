package InterfazCliente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class LoginCliente extends JFrame implements ActionListener{
	
	
	private final static String INICIAR = "Iniciar";
	private final static String SALIR = "Salir";
	private PanelImagen imagen;
	
	MenuCliente menu;
	ClienteLoginSignUp vAnterior;
	JLabel textoLogin;
	JButton iniciar,salir;
	JTextField campoLogin,campoPassword;
	Aplicacion consola1;
	
	public LoginCliente(Aplicacion consola12) {
		consola1 = consola12;
		// VENTANA PRINCIPAL
		setTitle("Iniciar Sesion");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(400,600);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setResizable(false);
		
		imagen = new PanelImagen();
		add(imagen,BorderLayout.NORTH);
				
		// TEXTO INICIAR SESION]
		
		JPanel login = new JPanel();
		login.setLayout(new GridLayout(5,1));
		
		textoLogin = new JLabel();
		textoLogin.setText("Iniciar Sesion:");
		textoLogin.setBounds(140, 100, 120, 20);
		textoLogin.setFont(new Font("Consola",Font.BOLD,16));
		
		login.add(textoLogin);
		

		JLabel usuario = new JLabel();
		usuario.setText("Usuario:");
		usuario.setFont(new Font("Consola",Font.PLAIN,16));
		
		campoLogin = new JTextField();
		
		JLabel contraseña = new JLabel();
		contraseña.setText("Contraseña:");
		contraseña.setFont(new Font("Consola",Font.PLAIN,16));
		
		
		campoPassword = new JTextField();
		
		login.add(usuario);
		login.add(campoLogin);
		login.add(contraseña);
		login.add(campoPassword);
		
		// BOTONES
		
		JPanel botones = new JPanel();
		
		
		iniciar = new JButton();
		iniciar.setText("Iniciar");
		iniciar.setBackground(Color.decode("#BBBBBB"));
		iniciar.setBounds(140, 390, 100, 50);
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
				
			}});
		iniciar.setActionCommand(INICIAR);
		iniciar.addActionListener(this);
		
		salir = new JButton();
		salir.setText("Salir");
		salir.setBackground(Color.decode("#FF6969"));
		salir.addMouseListener(new MouseListener() {

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
				salir.setBackground(Color.decode("#FF2A2A"));				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				salir.setBackground(Color.decode("#FF6969")); // Cuando se quita el mouse de encima
				
			}});
		
		salir.setActionCommand(SALIR);
		salir.addActionListener(this);

		botones.add(iniciar);
		botones.add(salir);
		
		// AGREGAR A LA VENTANA
		
		add(login,BorderLayout.CENTER);
		add(botones,BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equals(INICIAR) && (campoLogin.getText().equals("") || campoPassword.getText().equals(""))) {
			JOptionPane.showMessageDialog(null,"Tienes que ingresar el usuario y contrasena");
		}else if (comando.equals(INICIAR) && consola1.iniciarClienteInterfaz(campoLogin.getText(),campoPassword.getText())) {
			menu = new MenuCliente(consola1,campoLogin.getText());
			menu.setVisible(true);
			setVisible(false);
		}else if (comando.equals(INICIAR) && (consola1.iniciarClienteInterfaz(campoLogin.getText(),campoPassword.getText()) == false)) {
			JOptionPane.showMessageDialog(null,"Usuario y/o contrasena incorrectos");
		}
		
		if (comando.equals(SALIR)){
			vAnterior = new ClienteLoginSignUp(consola1);
			vAnterior.setVisible(true);
			setVisible(false);
		}
	}
	

}
