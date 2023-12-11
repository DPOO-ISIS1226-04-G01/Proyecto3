package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class MenuEmpleado extends JFrame implements ActionListener {
	
	private final static String OPCION1 = "Opcion1";
	private final static String OPCION2 = "Opcion2";
	private final static String OPCION3 = "Opcion3";
	private final static String OPCION4 = "Opcion4";
	private final static String SALIR = "Salir";
	
	PanelImagen imagen;
	JButton option1,option2,option3,option4,salir;
	
	JLabel bienvenido,tOption1,tPlaca,tOption2,tCateg,tOption3,tPlaca2,tOption4,tNombre,tDoc,tCateg2,tLimpio,tMantenimiento;
	JTextField placa,categ,placa2,nombre,doc,categ2,limpio,mantenimiento;
	
	Aplicacion consola1;
	
	LoginEmpl vAnterior;
	
	
	public MenuEmpleado(Aplicacion consola) {
		
		consola1 = consola;
		setTitle("Menu Empleado");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1200,800);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setResizable(false);
		
		imagen = new PanelImagen();
		add(imagen,BorderLayout.NORTH);
		
		JPanel opciones = new JPanel();
		opciones.setLayout(new GridLayout(10,1));
		opciones.setBorder(new LineBorder(Color.BLACK));
		
		opciones.add(new JLabel(""));
		opciones.add(new JLabel(""));
		opciones.add(new JLabel(""));
		opciones.add(new JLabel(""));
		opciones.add(new JLabel(""));
		
		opciones.add(new JLabel(""));
		opciones.add(new JLabel(""));
		bienvenido = new JLabel();
		bienvenido.setText("Bienvenido Empleado");
		bienvenido.setFont(new Font("Consola",Font.BOLD,20));
		opciones.add(bienvenido);
		opciones.add(new JLabel(""));
		opciones.add(new JLabel(""));


		
		tOption1 = new JLabel();
		tOption1.setText("1) Consultar vehiculo por");
		tOption1.setFont(new Font("Consola",Font.BOLD,18));
		opciones.add(tOption1);
		JLabel arreglo1 = new JLabel("placa");
		arreglo1.setFont(new Font("Consola",Font.BOLD,18));
		opciones.add(arreglo1);
		opciones.add(new JLabel(""));
		
		
		
		tOption2 = new JLabel();
		tOption2.setText("2) Consultar  vehiculos  por");
		tOption2.setFont(new Font("Consola",Font.BOLD,17));
		opciones.add(tOption2);		
		JLabel arreglo2 = new JLabel("categoria");
		arreglo2.setFont(new Font("Consola",Font.BOLD,17));
		opciones.add(arreglo2);
		
		tPlaca = new JLabel();
		tPlaca.setText("Placa a consultar: ");
		tPlaca.setFont(new Font("Consola",Font.PLAIN,16));
		opciones.add(tPlaca);
		placa = new JTextField();
		opciones.add(placa);
		opciones.add(new JLabel(""));

		
		tCateg = new JLabel();
		tCateg.setText("Categoria a consultar: ");
		tCateg.setFont(new Font("Consola",Font.PLAIN,16));
		opciones.add(tCateg);
		categ = new JTextField();
		opciones.add(categ);
		opciones.add(new JLabel(""));
		opciones.add(new JLabel(""));
		opciones.add(new JLabel(""));
		opciones.add(new JLabel(""));
		opciones.add(new JLabel(""));
		

		
		
		tOption3 = new JLabel();
		tOption3.setText("3) Actualizar vehiculo: ");
		tOption3.setFont(new Font("Consola",Font.BOLD,18));
		opciones.add(tOption3);
		opciones.add(new JLabel(""));
		opciones.add(new JLabel(""));
		
		tOption4 = new JLabel();
		tOption4.setText("4) Consultar reserva: ");
		tOption4.setFont(new Font("Consola",Font.BOLD,18));
		opciones.add(tOption4);
		opciones.add(new JLabel(""));
		
		
		tPlaca2 = new JLabel();
		tPlaca2.setText("Placa: ");
		tPlaca2.setFont(new Font("Consola",Font.PLAIN,16));
		opciones.add(tPlaca2);
		placa2 = new JTextField();
		opciones.add(placa2);
		opciones.add(new JLabel(""));

		tDoc = new JLabel();
		tDoc.setText("Documento: ");
		tDoc.setFont(new Font("Consola",Font.PLAIN,16));
		opciones.add(tDoc);
		doc = new JTextField();
		opciones.add(doc);
		
		tLimpio = new JLabel();
		tLimpio.setText("Ya fue limpiado (Si/No): ");
		tLimpio.setFont(new Font("Consola",Font.PLAIN,16));
		opciones.add(tLimpio);
		limpio = new JTextField();
		opciones.add(limpio);
		opciones.add(new JLabel(""));
		opciones.add(new JLabel(""));
		opciones.add(new JLabel(""));
		
	
		
		tMantenimiento = new JLabel();
		tMantenimiento.setText("Ya tuvo mantenimiento (Si/No): ");
		tMantenimiento.setFont(new Font("Consola",Font.PLAIN,16));
		opciones.add(tMantenimiento);
		mantenimiento = new JTextField();
		opciones.add(mantenimiento);
		opciones.add(new JLabel(""));
		opciones.add(new JLabel(""));
		opciones.add(new JLabel(""));
		

		
		
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
			vAnterior = new LoginEmpl(consola1);
			vAnterior.setVisible(true);
			setVisible(false);
		}else if(comando.equals(OPCION1)) {
			String mensaje = consola1.consultarVehiculoPlaca(placa.getText());
			JOptionPane.showMessageDialog(null,mensaje);
		}else if(comando.equals(OPCION2)) {
			String cantidad = consola1.consultarCantidadCategoria(categ.getText());
			JOptionPane.showMessageDialog(null,cantidad);
		}else if(comando.equals(OPCION4)) {
			if(doc.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null,"Tienes que ingresar el documento.");
			}else {
				JOptionPane.showMessageDialog(null,consola1.consultarReserva(Long.parseLong(doc.getText())));
			}
		}else if (comando.equals(OPCION3)) {
			if (placa2.getText().isEmpty() || limpio.getText().isEmpty() || mantenimiento.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null,"Tienes que ingresar los datos.");
			}else {
				JOptionPane.showMessageDialog(null,consola1.consultarEstado(placa2.getText(),limpio.getText(),mantenimiento.getText()));
			}
		}
		
	}

}
