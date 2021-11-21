package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modeloVo.Cliente;
import modeloVo.Coche;
import modeloVo.Involucra;
import modeloVo.Reserva;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;

import conexion.Conexion;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.awt.event.ActionEvent;


public class Form06NuevoCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();

	Controlador controlador;
	private int CodigoInvolucra;
	private String DniCliente;
	private String NombreCliente;
	private String DireccionCliente;
	private int TelefonoCliente;
	private JTextField textFieldDni;
	private JTextField textFieldNombre;
	private JTextField textFieldDireccion;
	private JTextField textFieldTelefono;
	private Cliente cliente = new Cliente();
	private Conexion conexion = new Conexion();
	private DniCompleto nif = new DniCompleto();

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
	
	public static void main(String[] args) {
		try {
			Form06NuevoCliente dialog = new Form06NuevoCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Form06NuevoCliente() {
		setTitle("Nuevo Cliente");
		setBounds(100, 100, 869, 455);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblDni = new JLabel("Dni:");
		lblDni.setBackground(new Color(240, 240, 240));
		lblDni.setBounds(35, 24, 56, 16);
		contentPanel.add(lblDni);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(35, 67, 56, 16);
		contentPanel.add(lblNombre);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n:");
		lblDireccion.setBounds(35, 112, 67, 13);
		contentPanel.add(lblDireccion);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono:");
		lblTelefono.setBounds(35, 159, 67, 13);
		contentPanel.add(lblTelefono);
		
		textFieldDni = new JTextField();
		textFieldDni.setBounds(162, 23, 127, 19);
		contentPanel.add(textFieldDni);
		textFieldDni.setColumns(10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(162, 66, 278, 19);
		contentPanel.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setBounds(162, 110, 278, 19);
		contentPanel.add(textFieldDireccion);
		textFieldDireccion.setColumns(10);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setBounds(164, 156, 128, 19);
		contentPanel.add(textFieldTelefono);
		textFieldTelefono.setColumns(10);
		
		JButton btnAnhadir = new JButton("A\u00F1adir");
		btnAnhadir.addActionListener(new BtnAnhadirActionListener());
		btnAnhadir.setBounds(278, 324, 85, 21);
		contentPanel.add(btnAnhadir);
		
		JButton btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(new BtnAtrasActionListener());
		btnAtras.setBounds(428, 324, 85, 21);
		contentPanel.add(btnAtras);
	}
	
	
	private class BtnAnhadirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent E) {
			RecogerDatos();
			if(conexion.validarDni(DniCliente)) { 
			    JOptionPane.showMessageDialog(null," El DNI introducido ya existe.","Información", JOptionPane.INFORMATION_MESSAGE);
			    return;
			}else {
				VaciarCampos();
				controlador.InsertarCliente(cliente);
			}	
			
		}
	}
	
	private class BtnAtrasActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			VaciarCampos();
			dispose();
			controlador.mostrarF05Clientes();
		}
	}
	
	
	public void RecogerDatos() {
		DniCliente = textFieldDni.getText();
		NombreCliente = textFieldNombre.getText();
		DireccionCliente = textFieldDireccion.getText();
		TelefonoCliente = Integer.parseInt(textFieldTelefono.getText());
		
		cliente.setNif(DniCliente);
		cliente.setNombre(NombreCliente);
		cliente.setDireccion(DireccionCliente);
		cliente.setTelefono(TelefonoCliente);
	}
	
	public void VaciarCampos() {
		textFieldDni.setText("");
		textFieldNombre.setText("");
		textFieldDireccion.setText("");
		textFieldTelefono.setText("");
	}
	
	
	public void validarDni(String dni) {
		while(nif.patron() == false) {
            System.out.println("El Dni introducido no contiene "
                    + "un patrón valido");
             System.out.print("Introduzca un Dni válido: ");
             nif.setDniIntroducido(dni);
		}
             nif.getLetraIntroducida();
             nif.setDniNumero(nif.getDniIntroducido());
             
             while(nif.getLetIntro() != nif.getLetraDni()) {
                 System.out.println("La letra introducida en el Dni "
                         + "no coincide con la verdadera letra");
                 System.out.print("Introduzca un Dni válido: ");
                 nif.setDniIntroducido(dni);
                 nif.getLetraIntroducida();
                 nif.setDniNumero(nif.getDniIntroducido());
             }
             
             System.out.println("Bien, el dni " + nif.getDniIntroducido() + 
                     " es un Dni válido");
        
	}
	
}
