package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


public class MenuAdmin extends JFrame implements ActionListener {
	
	
	private final static String OPCION1 = "Opcion1";
	private final static String OPCION2 = "Opcion2";
	private final static String OPCION3 = "Opcion3";
	private final static String OPCION4 = "Opcion4";
	private final static String SALIR = "Salir";

	PanelImagen imagen;
	JButton option1,option2,option3,option4,salir;
	JLabel bienvenido,tOption1,tOption2,tOption3,tOption4,tSede,tPlaca,tMarca,tModelo,tColor,tTrans,tCateg,tSede2,tUbicacion,tHorarios,tCateg2,tNombre,tDoc,tUsuario,tContra,tValor;
	JTextField sede,placa,marca,modelo,color,trans,categ,sede2,ubicacion,horarios,categ2,nombre,doc,usuario,contra,valor;
	Aplicacion consola1;
	LoginAdmin vAnterior;
	
	public MenuAdmin(Aplicacion consola) {
		consola1 = consola;
		setTitle("Menu Administrador");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1200,800);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setResizable(false);
		
		imagen = new PanelImagen();
		add(imagen,BorderLayout.NORTH);
		
		JPanel opciones = new JPanel();
		opciones.setLayout(new GridLayout(15,1));
		opciones.setBorder(new LineBorder(Color.BLACK));
		
		opciones.add(new JLabel(""));
		opciones.add(new JLabel(""));
		opciones.add(new JLabel(""));
		opciones.add(new JLabel(""));
		opciones.add(new JLabel(""));
		bienvenido = new JLabel();
		bienvenido.setText("       Bienvenido Administrador,");
		bienvenido.setFont(new Font("Consola",Font.BOLD,20));
		opciones.add(bienvenido);
		JLabel elegir = new JLabel(" elija una opcion");
		elegir.setFont(new Font("Consola",Font.BOLD,20));
		opciones.add(elegir);
		opciones.add(new JLabel(""));
		opciones.add(new JLabel(""));
		opciones.add(new JLabel(""));
		opciones.add(new JLabel(""));
		opciones.add(new JLabel(""));
	
		
		tOption1 = new JLabel();
		tOption1.setText("1) Registrar vehiculo");
		tOption1.setFont(new Font("Consola",Font.BOLD,18));
		opciones.add(tOption1);
		opciones.add(new JLabel(""));
		
				
		tOption2 = new JLabel();
		tOption2.setText("2) Crear sede");
		tOption2.setFont(new Font("Consola",Font.BOLD,18));
		opciones.add(tOption2);	
		opciones.add(new JLabel(""));

		tSede = new JLabel();
		tSede.setText("Sede: ");
		tSede.setFont(new Font("Consola",Font.PLAIN,16));
		opciones.add(tSede);	
		sede = new JTextField();
		opciones.add(sede);
		
		tSede2 = new JLabel();
		tSede2.setText("Nombre sede: ");
		tSede2.setFont(new Font("Consola",Font.PLAIN,16));
		opciones.add(tSede2);	
		sede2 = new JTextField();
		opciones.add(sede2);
		
		tPlaca = new JLabel();
		tPlaca.setText("Placa: ");
		tPlaca.setFont(new Font("Consola",Font.PLAIN,16));
		opciones.add(tPlaca);	
		placa = new JTextField();
		opciones.add(placa);
		
		tUbicacion = new JLabel();
		tUbicacion.setText("Ubicacion: ");
		tUbicacion.setFont(new Font("Consola",Font.PLAIN,16));
		opciones.add(tUbicacion);	
		ubicacion = new JTextField();
		opciones.add(ubicacion);
		
		tMarca = new JLabel();
		tMarca.setText("Marca: ");
		tMarca.setFont(new Font("Consola",Font.PLAIN,16));
		opciones.add(tMarca);	
		marca = new JTextField();
		opciones.add(marca);

		opciones.add(new JLabel(""));
		opciones.add(new JLabel(""));
		
		tModelo = new JLabel();
		tModelo.setText("Modelo: ");
		tModelo.setFont(new Font("Consola",Font.PLAIN,16));
		opciones.add(tModelo);	
		modelo = new JTextField();
		opciones.add(modelo);
		
		opciones.add(new JLabel(""));
		opciones.add(new JLabel(""));

		tColor = new JLabel();
		tColor.setText("Color: ");
		tColor.setFont(new Font("Consola",Font.PLAIN,16));
		opciones.add(tColor);	
		color = new JTextField();
		opciones.add(color);
		
		opciones.add(new JLabel(""));
		opciones.add(new JLabel(""));
		
		tTrans = new JLabel();
		tTrans.setText("Transmision: ");
		tTrans.setFont(new Font("Consola",Font.PLAIN,16));
		opciones.add(tTrans);	
		trans = new JTextField();
		opciones.add(trans);
		
		
		tOption4 = new JLabel();
		tOption4.setText("4) Registrar empleado");
		tOption4.setFont(new Font("Consola",Font.BOLD,18));
		opciones.add(tOption4);
		opciones.add(new JLabel(""));
		
		tCateg = new JLabel();
		tCateg.setText("Categoria: ");
		tCateg.setFont(new Font("Consola",Font.PLAIN,16));
		opciones.add(tCateg);	
		categ = new JTextField();
		opciones.add(categ);
		
		tNombre = new JLabel();
		tNombre.setText("Nombre: ");
		tNombre.setFont(new Font("Consola",Font.PLAIN,16));
		opciones.add(tNombre);	
		nombre = new JTextField();
		opciones.add(nombre);
		opciones.add(new JLabel(""));
		opciones.add(new JLabel(""));
		
		tDoc = new JLabel();
		tDoc.setText("Sede: ");
		tDoc.setFont(new Font("Consola",Font.PLAIN,16));
		opciones.add(tDoc);	
		doc = new JTextField();
		opciones.add(doc);
		
		tOption3 = new JLabel();
		tOption3.setText("3) Crear categoria");
		tOption3.setFont(new Font("Consola",Font.BOLD,18));
		opciones.add(tOption3);
		opciones.add(new JLabel(""));
		
		
		tUsuario = new JLabel();
		tUsuario.setText("Usuario: ");
		tUsuario.setFont(new Font("Consola",Font.PLAIN,16));
		opciones.add(tUsuario);	
		usuario = new JTextField();
		opciones.add(usuario);
		

		tCateg2 = new JLabel();
		tCateg2.setText("Categoria: ");
		tCateg2.setFont(new Font("Consola",Font.PLAIN,16));
		opciones.add(tCateg2);	
		categ2 = new JTextField();
		opciones.add(categ2);
		
		tContra = new JLabel();
		tContra.setText("Contrasena: ");
		tContra.setFont(new Font("Consola",Font.PLAIN,16));
		opciones.add(tContra);	
		contra = new JTextField();
		opciones.add(contra);
		
		tValor = new JLabel();
		tValor.setText("Valor: ");
		tValor.setFont(new Font("Consola",Font.PLAIN,16));
		opciones.add(tValor);	
		valor = new JTextField();
		opciones.add(valor);
		
		
		JPanel botones = new JPanel();
		
		
		option1 = new JButton();
		option1.setText("Opcion1");
		option1.setBackground(Color.decode("#BBBBBB"));
		option1.setBounds(140, 390, 100, 50);
		option1.addMouseListener(new MouseListener() {

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
				option1.setBackground(Color.decode("#737373"));				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				option1.setBackground(Color.decode("#BBBBBB")); // Cuando se quita el mouse de encima
				
			}});
		option1.setActionCommand(OPCION1);
		option1.addActionListener(this);
		
		
		option2 = new JButton();
		option2.setText("Opcion2");
		option2.setBackground(Color.decode("#BBBBBB"));
		option2.setBounds(140, 390, 100, 50);
		option2.addMouseListener(new MouseListener() {

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
				option2.setBackground(Color.decode("#737373"));				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				option2.setBackground(Color.decode("#BBBBBB")); // Cuando se quita el mouse de encima
				
			}});
		option2.setActionCommand(OPCION2);
		option2.addActionListener(this);
		
		option3 = new JButton();
		option3.setText("Opcion3");
		option3.setBackground(Color.decode("#BBBBBB"));
		option3.setBounds(140, 390, 100, 50);
		option3.addMouseListener(new MouseListener() {

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
				option3.setBackground(Color.decode("#737373"));				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				option3.setBackground(Color.decode("#BBBBBB")); // Cuando se quita el mouse de encima
				
			}});
		option3.setActionCommand(OPCION3);
		option3.addActionListener(this);
		
		option4 = new JButton();
		option4.setText("Opcion4");
		option4.setBackground(Color.decode("#BBBBBB"));
		option4.setBounds(140, 390, 100, 50);
		option4.addMouseListener(new MouseListener() {

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
				option4.setBackground(Color.decode("#737373"));				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				option4.setBackground(Color.decode("#BBBBBB")); // Cuando se quita el mouse de encima
				
			}});
		option4.setActionCommand(OPCION4);
		option4.addActionListener(this);
		
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

		botones.add(option1);
		botones.add(option2);
		botones.add(option3);
		botones.add(option4);
		botones.add(salir);
		
		add(botones,BorderLayout.SOUTH);
		
		add(opciones);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equals(SALIR)){
			vAnterior = new LoginAdmin(consola1);
			vAnterior.setVisible(true);
			setVisible(false);
		}else if(comando.equals(OPCION1) && (placa.getText().length() == 6)) {
			if (consola1.crearVehiculoNuevo(sede.getText(),placa.getText(),marca.getText(),modelo.getText(),color.getText(),trans.getText(),categ.getText())) {
				JOptionPane.showMessageDialog(null, "El vehiculo fue creado con exito.");
			}else {
				JOptionPane.showMessageDialog(null, "El vehiculo no pudo ser creado, quizas la categoria o la sede no existen en nuestra base de datos.");
			}
			
		}else if(comando.equals(OPCION2)){
			if (sede2.getText().isEmpty() || ubicacion.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null,"Tienes que ingresar los datos.");
			}else {
				try {
					JOptionPane.showMessageDialog(null,consola1.crearSede(sede2.getText(), ubicacion.getText()));
				} catch (HeadlessException | ParseException | IOException e1) {
					JOptionPane.showMessageDialog(null, "Intentalo de nuevo.");
					e1.printStackTrace();
				}
			}
		}else if (comando.equals(OPCION4)) {
			if (nombre.getText().isEmpty() || doc.getText().isEmpty() || usuario.getText().isEmpty() || contra.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null,"Tienes que ingresar los datos.");
			}else {
				String rta = "";
				try {
					rta = consola1.crearEmpleado(nombre.getText(),doc.getText(), usuario.getText(),contra.getText());
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Intentalo de nuevo.");
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,rta);
			}
		}else if(comando.equals(OPCION3)) {
			if (categ2.getText().isEmpty() || valor.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null,"Tienes que ingresar los datos.");
			}else {
				if (consola1.crearCategoria(categ2.getText(),valor.getText())) {
					JOptionPane.showMessageDialog(null,"La categoria se creo correctamente.");
				}else {
					JOptionPane.showMessageDialog(null,"Intentalo de nuevo.");
				}
			}
		}
		
	}
	
	
}
		
	

