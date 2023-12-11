package InterfazCliente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class SignUpCliente extends JFrame implements ActionListener{
	
	private final static String INICIAR = "Iniciar";
	private final static String SALIR = "Salir";
	private PanelImagen imagen;
	
	private JLabel signUp,tNombre,tDoc,tNacim,tNacio,tLic,tExp,tUsuario,tContrasena,metPago,tTarj,tCvc,tExpTarj;
	private JButton iniciar,salir;
	private JTextField nombre,doc,nacim,nacio,lic,expLic,usuario,contrasena,tarj,cvc,expTarj;
	private JRadioButton credito,debito = new JRadioButton();
	private ButtonGroup bPago = new ButtonGroup();
	
	ClienteLoginSignUp vAnterior;
	LoginCliente vLogin;
	Aplicacion consola1;
	
	public SignUpCliente(Aplicacion consola12) {
		consola1 = consola12;
		setTitle("Registrarse");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1200,800);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setResizable(false);
		
		
		imagen = new PanelImagen();
		add(imagen,BorderLayout.NORTH);
		
		JPanel formulario = new JPanel();
		formulario.setLayout(new GridLayout(10,4));
		
		JLabel aux = new JLabel();
		aux.setText("");
		signUp = new JLabel();
		signUp.setText("Registrarse: ");
		signUp.setFont(new Font("Consola",Font.BOLD,18));	
		formulario.add(signUp);
		formulario.add(aux);
		formulario.add(new JLabel(""));
		formulario.add(new JLabel(""));
		
		tNombre = new JLabel();
		tNombre.setText("Nombre completo: ");
		formulario.add(tNombre);
		nombre = new JTextField();
		nombre.setSize(30, 5);
		formulario.add(nombre);

		tDoc = new JLabel();
		tDoc.setText("Documento: ");
		formulario.add(tDoc);
		doc = new JTextField();
		formulario.add(doc);
		
		tNacim = new JLabel();
		tNacim.setText("Fecha nacimiento (dd/MM/aa): ");
		formulario.add(tNacim);
		nacim = new JTextField();
		formulario.add(nacim);
		
		tNacio = new JLabel();
		tNacio.setText("Nacionalidad: ");
		formulario.add(tNacio);
		nacio = new JTextField();
		formulario.add(nacio);
		
		tLic = new JLabel();
		tLic.setText("No Licencia: ");
		formulario.add(tLic);
		lic = new JTextField();
		formulario.add(lic);
		
		tExp = new JLabel();
		tExp.setText("Fecha expiracion Lic (dd/MM/aa): ");
		formulario.add(tExp);
		expLic = new JTextField();
		formulario.add(expLic);
		
		metPago = new JLabel();
		metPago.setFont(new Font("Consola",Font.BOLD,18));	
		metPago.setText("Metodo de pago: ");
		credito = new JRadioButton();
		credito.setText("Credito");
		debito = new JRadioButton();
		debito.setText("Debito");
		bPago.add(credito);
		bPago.add(debito);
		formulario.add(metPago);
		formulario.add(credito);
		formulario.add(debito);
		formulario.add(new JLabel(""));
		
		
		tTarj = new JLabel();
		tTarj.setText("No Tarjeta: ");
		formulario.add(tTarj);
		tarj = new JTextField();
		formulario.add(tarj);
		
		tExpTarj = new JLabel();
		tExpTarj.setText("Fecha expiracion Tarjeta (dd/MM/aa): ");
		formulario.add(tExpTarj);
		expTarj = new JTextField();
		formulario.add(expTarj);
		
		tCvc = new JLabel();
		tCvc.setText("CVC: ");
		formulario.add(tCvc);
		cvc = new JTextField();
		formulario.add(cvc);
		
		
		formulario.add(new JLabel(""));
		formulario.add(new JLabel(""));
		JLabel datos = new JLabel();
		datos.setText("Datos de la cuenta: ");
		datos.setFont(new Font("Consola",Font.BOLD,18));	
		formulario.add(datos);
		formulario.add(new JLabel(""));
		formulario.add(new JLabel(""));
		formulario.add(new JLabel(""));
		
		
		tUsuario = new JLabel();
		tUsuario.setText("Usuario: ");
		formulario.add(tUsuario);
		usuario = new JTextField();
		formulario.add(usuario);
		
		tContrasena = new JLabel();
		tContrasena.setText("Contrasena: ");
		formulario.add(tContrasena);
		contrasena = new JTextField();
		formulario.add(contrasena);	
		
		
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
		
		add(formulario);
		add(botones,BorderLayout.SOUTH);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equals(INICIAR)) {
			if (usuario.getText().isEmpty() || contrasena.getText().isEmpty() || nombre.getText().isEmpty() || nacim.getText().isEmpty() || nacio.getText().isEmpty() || doc.getText().isEmpty() || tarj.getText().isEmpty() || cvc.getText().isEmpty() || expTarj.getText().isEmpty() || lic.getText().isEmpty() || expLic.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null,"Debes ingresar todos los datos");
			}else {
				try {
					consola1.registrarUsuario(usuario.getText(),contrasena.getText(),nombre.getText(),Long.parseLong("3188008929"),convertirFecha(nacim.getText()),nacio.getText(),Long.parseLong(doc.getText()),Long.parseLong(tarj.getText()),Integer.parseInt(cvc.getText()),convertirFecha(expTarj.getText()),null,Long.parseLong(lic.getText()),null,convertirFecha(expLic.getText()),null);
				} catch (NumberFormatException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				vLogin = new LoginCliente(consola1);
				vLogin.setVisible(true);
				setVisible(false);
			}
		}
		if (comando.equals(SALIR)){
			vAnterior = new ClienteLoginSignUp(consola1);
			vAnterior.setVisible(true);
			setVisible(false);
		}
	}
	
	public Date convertirFecha(String fecha) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");  
		Date fechaDate = format.parse(fecha);
		
		return fechaDate;
		
	}

}
