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
import java.io.IOException;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class MenuCliente extends JFrame implements ActionListener{
	
	private final static String OPCION1 = "Opcion1";
	private final static String OPCION2 = "Opcion2";
	private final static String SALIR = "Salir";
	
	public static final String FACIL = "PayU";
	public static final String MEDIO = "PayPal";
	
	ButtonGroup dificultades;
	
	static JRadioButton btnFacil = new JRadioButton(FACIL);
	static JRadioButton btnMedio = new JRadioButton(MEDIO);
	
	LoginCliente vAnterior;
	PagoReserva vSig;
	PanelImagen imagen;
	JLabel bienvenido,tOption1,datosP,tNombre,tDoc,tLic,tCateg,tDate,tSede,datosPago,tTarj,tExpTarj,tCvc,tOption2,tCategConsultar,tRecoger,tFecha,tSedeRecoger;
	JTextField nombre,doc,lic,categ,fecha,sede,tarj,fechaExp,cvc,categ2;
	JButton option1,option2,salir;
	Aplicacion consola1;
	String login1;
	
	public MenuCliente(Aplicacion consola,String login) {
		consola1 = consola;
		login1 = login;
		
		setTitle("Menu Cliente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1200,800);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setResizable(false);
		
		imagen = new PanelImagen();
		add(imagen,BorderLayout.NORTH);
		
		JPanel opciones = new JPanel();
		opciones.setLayout(new GridLayout(16,2));
		opciones.setBorder(new LineBorder(Color.BLACK));
		
		bienvenido = new JLabel();
		opciones.add(new JLabel(""));
		opciones.add(new JLabel(""));


		
		tOption1 = new JLabel();
		tOption1.setText("1) Realizar una reserva");
		tOption1.setFont(new Font("Consola",Font.BOLD,18));
		opciones.add(tOption1);	

		
		datosP = new JLabel();
		datosP.setText("Datos: ");
		datosP.setFont(new Font("Consola",Font.BOLD,18));
		opciones.add(datosP);
		
		tDoc = new JLabel();
		tDoc.setText("Documento: ");
		tDoc.setFont(new Font("Consola",Font.PLAIN,16));
		opciones.add(tDoc);
		doc = new JTextField();
		opciones.add(doc);
		
		tLic = new JLabel();
		tLic.setText("Fecha inicio (dd/MM/yyyy): ");
		tLic.setFont(new Font("Consola",Font.PLAIN,16));
		opciones.add(tLic);
		lic = new JTextField();
		opciones.add(lic);
		
		tNombre = new JLabel();
		tNombre.setText("Fecha fin (dd/MM/yyyy): ");
		tNombre.setFont(new Font("Consola",Font.PLAIN,16));
		opciones.add(tNombre);
		nombre = new JTextField();
		opciones.add(nombre);
		
		
		tCateg = new JLabel();
		tCateg.setText("Categoria a reservar: ");
		tCateg.setFont(new Font("Consola",Font.PLAIN,16));
		opciones.add(tCateg);
		categ = new JTextField();
		opciones.add(categ);
		

		
		tTarj = new JLabel();
		tTarj.setText("Sede inicio: ");
		tTarj.setFont(new Font("Consola",Font.PLAIN,16));
		opciones.add(tTarj);
		tarj = new JTextField();
		opciones.add(tarj);

		
		
		tExpTarj = new JLabel();
		tExpTarj.setText("Sede fin: ");
		tExpTarj.setFont(new Font("Consola",Font.PLAIN,16));
		opciones.add(tExpTarj);
		fechaExp = new JTextField();
		opciones.add(fechaExp);
		
		
		tCvc = new JLabel();
		tCvc.setText("# Conduct adicionales: ");
		tCvc.setFont(new Font("Consola",Font.PLAIN,16));
		opciones.add(tCvc);	
		cvc = new JTextField();
		opciones.add(cvc);
		btnFacil.setBackground(Color.GRAY);
		btnFacil.setForeground(Color.white);
		
		btnMedio.setBackground(Color.GRAY);
		btnMedio.setForeground(Color.white);
		
		
		dificultades = new ButtonGroup();
		
		
		dificultades.add(btnFacil);
		dificultades.add(btnMedio);

		JLabel pasarela = new JLabel();
		pasarela.setText("Pasarela de pago a usar: ");
		pasarela.setFont(new Font("Consola",Font.BOLD,16));
		opciones.add(pasarela);
		opciones.add(new JLabel(""));
		opciones.add(btnFacil);
		opciones.add(btnMedio);
		opciones.add(new JLabel(""));
		opciones.add(new JLabel(""));
		
		
		tOption2 = new JLabel();
		tOption2.setText("2) Consultar vehiculos por categoria");
		tOption2.setFont(new Font("Consola",Font.BOLD,18));
		opciones.add(tOption2);
		opciones.add(new JLabel(""));

		
		tCategConsultar = new JLabel();
		tCategConsultar.setText("Categoria a consultar: ");
		tCategConsultar.setFont(new Font("Consola",Font.PLAIN,16));
		opciones.add(tCategConsultar);
		categ2 = new JTextField();
		opciones.add(categ2);
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
		botones.add(salir);
		
		add(botones,BorderLayout.SOUTH);
		add(opciones,BorderLayout.CENTER);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equals(SALIR)){
			vAnterior = new LoginCliente(consola1);
			vAnterior.setVisible(true);
			setVisible(false);
		}else if(comando.equals(OPCION2)) {
			String cantidad = consola1.consultarCantidadCategoria(categ2.getText());
			JOptionPane.showMessageDialog(null,cantidad);
		}else if (comando.equals(OPCION1)) {
			if (categ.getText().isEmpty() || lic.getText().isEmpty() || nombre.getText().isEmpty() || tarj.getText().isEmpty() || fechaExp.getText().isEmpty() || doc.getText().isEmpty() || cvc.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null,"Debes ingresar todos los datos.");
			}else {
				ButtonModel selection = dificultades.getSelection();
				boolean rta;
					try {
						rta = consola1.verificarReserva(categ.getText(),lic.getText(),nombre.getText(), tarj.getText(),fechaExp.getText(),doc.getText(),cvc.getText());
						if (rta && btnFacil.isSelected() && (Long.parseLong(doc.getText()) == consola1.buscarClienteLogin(login1).getDocumento())) {
							vSig = new PagoReserva(consola1,consola1.buscarClienteLogin(login1),"PayU",categ.getText(),lic.getText(),nombre.getText(),tarj.getText(),fechaExp.getText(),doc.getText(),cvc.getText());
							vSig.setVisible(rta);
							
						}else if (rta && btnMedio.isSelected() && (Long.parseLong(doc.getText()) == consola1.buscarClienteLogin(login1).getDocumento())){ 
								vSig = new PagoReserva(consola1,consola1.buscarClienteLogin(login1),"PayPal",categ.getText(),lic.getText(),nombre.getText(),tarj.getText(),fechaExp.getText(),doc.getText(),cvc.getText());
								vSig.setVisible(rta);
								
						}else {
							JOptionPane.showMessageDialog(null,"La reserva no se pudo realizar, intentalo de nuevo");
						}
					} catch (ParseException | IOException e1) {
						e1.printStackTrace();
					}				
			}
		
		}
	}

}
