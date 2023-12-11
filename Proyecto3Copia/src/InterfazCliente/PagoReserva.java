package InterfazCliente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.qoppa.pdf.PDFException;

import Implementaciones.Cliente;

public class PagoReserva extends JFrame implements ActionListener{
	private final static String PAGAR = "Pagar";
	private final static String CANCELAR = "Cancelar";
	
	PanelImagen imagen;
	JLabel textoElegir;
	JRadioButton login,signUp;
	JButton iniciar,salir;
	ButtonGroup gBotones;
	Aplicacion consola1;
	Cliente cliente;
	String pasarela,categ,fechaI,fechaF,sedeI,sedeF,doc,conducA;
	
	public PagoReserva(Aplicacion consola12, Cliente cliente1,String pasarela1,String categ1,String fechaI1,String fechaF1,String sedeI1,String sedeF1,String doc1,String conducA1){
		consola1 = consola12;
		cliente = cliente1;
		pasarela = pasarela1;
		categ = categ1;
		fechaI = fechaI1;
		fechaF = fechaF1;
		sedeI = sedeI1;
		sedeF = sedeF1;
		doc = doc1;
		conducA = conducA1;
		// VENTANA PRINCIPAL
		setTitle("Pago");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(600,700);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setResizable(false);
		imagen = new PanelImagen();
		add(imagen,BorderLayout.NORTH);
		
		JPanel mens = new JPanel();
		mens.setLayout(new GridLayout(4,1));
		JLabel mensaje1 = new JLabel();
		mensaje1.setText("Esta a punto de hacer el pago con la informacion siguiente: ");
		mensaje1.setFont(new Font("Consola",Font.BOLD,20));
		mens.add(mensaje1);
		
		JLabel mensaje2 = new JLabel();
		mensaje2.setText("-Cliente: " + cliente.getNombre());
		mens.add(mensaje2);

		JLabel mensaje3 = new JLabel();
		mensaje3.setText("-Tarjeta: " + Long.toString(cliente.medioPago.numero));
		mens.add(mensaje3);
		
		JLabel mensaje4 = new JLabel();
		mensaje4.setText("De clic en 'Pagar' si esta de acuerdo.");
		mensaje4.setFont(new Font("Consola",Font.BOLD,20));
		mens.add(mensaje4);
		
		add(mens,BorderLayout.CENTER);
		
		JPanel botones = new JPanel();
		
		iniciar = new JButton();
		iniciar.setText("Pagar");
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
		
		iniciar.setActionCommand(PAGAR);
		iniciar.addActionListener(this);
		
		salir = new JButton();
		salir.setText("Cancelar");
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
		
		salir.setActionCommand(CANCELAR);
		salir.addActionListener(this);

		
		botones.add(iniciar);
		botones.add(salir);
		
		add(botones, BorderLayout.SOUTH);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		String rta,rta1;
		if (comando.equals(PAGAR)) {
			try {
				rta = consola1.crearReserva(categ, fechaI, fechaF, sedeI, sedeF, doc, conducA,pasarela);
				JOptionPane.showMessageDialog(null, rta);
				rta1 = consola1.guardarReserva(cliente.getDocumento());
				JOptionPane.showMessageDialog(null, rta1);
				setVisible(false);
			} catch (ParseException | IOException e1) {
				e1.printStackTrace();
			} catch (PDFException e1) {
				e1.printStackTrace();
			}
			
		}else if (comando.equals(CANCELAR)){
			setVisible(false);
		}
		
		
	}

}
