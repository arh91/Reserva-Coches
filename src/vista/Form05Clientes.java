package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modeloVo.Cliente;
import modeloVo.Coche;
import modeloVo.Involucra;
import modeloVo.Reserva;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Form05Clientes extends JDialog {

	private final JPanel contentPanel = new JPanel();

	Controlador controlador;
	private int CodigoInvolucra;
	private String DniCliente;
	private String MatriculaCoche;
	private int CodigoReserva;
	private int Litros;
	private String FechaInicio;
	private String FechaFin;
	private java.sql.Date fechaInicioSqlDate;
	private java.sql.Date fechaFinSqlDate;
	private Date fechaJavaUtilDate;
	private Involucra involucra = new Involucra();
	private Reserva reserva = new Reserva();

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
	
	public static void main(String[] args) {
		try {
			Form05Clientes dialog = new Form05Clientes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Form05Clientes() {
		setTitle("Clientes");
		setBounds(100, 100, 869, 455);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnEliminarCliente = new JButton("Eliminar Cliente");
		btnEliminarCliente.addActionListener(new BtnEliminarClienteActionListener());
		btnEliminarCliente.setBounds(50, 230, 125, 37);
		contentPanel.add(btnEliminarCliente);
		
		JButton btnModificarCliente = new JButton("Modificar Cliente");
		btnModificarCliente.addActionListener(new BtnModificarClienteActionListener());
		btnModificarCliente.setBounds(50, 152, 154, 37);
		contentPanel.add(btnModificarCliente);
		
		JButton btnNuevoCliente = new JButton("Nuevo Cliente");
		btnNuevoCliente.addActionListener(new BtnNuevoClienteActionListener());
		btnNuevoCliente.setBounds(46, 74, 125, 37);
		contentPanel.add(btnNuevoCliente);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new BtnCancelActionListener());
		btnCancel.setBounds(431, 341, 85, 21);
		contentPanel.add(btnCancel);
	}
	
	
	private class BtnNuevoClienteActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			dispose();
			controlador.mostrarF06NuevoCliente();
		}
	}
	
	private class BtnModificarClienteActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
			controlador.mostrarF07ModificarCliente();
		}
	}
	
	private class BtnEliminarClienteActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
			controlador.mostrarF08EliminarCliente();
		}
	}
	
	private class BtnCancelActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
			controlador.mostrarF01Inicial();
		}
	}
	
	
}
