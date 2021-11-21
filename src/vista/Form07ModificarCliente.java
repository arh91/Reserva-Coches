package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

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


public class Form07ModificarCliente extends JDialog {

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

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
	
	public static void main(String[] args) {
		try {
			Form07ModificarCliente dialog = new Form07ModificarCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Form07ModificarCliente() {
		setTitle("Modificar Cliente");
		setBounds(100, 100, 869, 455);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblDni = new JLabel("Dni:");
		lblDni.setBackground(new Color(240, 240, 240));
		lblDni.setBounds(35, 47, 56, 16);
		contentPanel.add(lblDni);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(35, 171, 56, 16);
		contentPanel.add(lblNombre);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n:");
		lblDireccion.setBounds(35, 214, 67, 13);
		contentPanel.add(lblDireccion);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono:");
		lblTelefono.setBounds(35, 261, 45, 13);
		contentPanel.add(lblTelefono);
		
		textFieldDni = new JTextField();
		textFieldDni.setBounds(164, 46, 127, 19);
		contentPanel.add(textFieldDni);
		textFieldDni.setColumns(10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(162, 170, 303, 19);
		contentPanel.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setBounds(159, 208, 306, 19);
		contentPanel.add(textFieldDireccion);
		textFieldDireccion.setColumns(10);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setBounds(161, 258, 128, 19);
		contentPanel.add(textFieldTelefono);
		textFieldTelefono.setColumns(10);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new BtnModificarActionListener());
		btnModificar.setBounds(278, 324, 85, 21);
		contentPanel.add(btnModificar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new BtnBuscarActionListener());
		btnBuscar.setBounds(497, 43, 85, 21);
		contentPanel.add(btnBuscar);
		
		JButton btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(new BtnAtrasActionListener());
		btnAtras.setBounds(426, 324, 85, 21);
		contentPanel.add(btnAtras);
	}
	
	
	private class BtnModificarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			CapturarCamposModificados();
			if (JOptionPane.showConfirmDialog(rootPane, "¿Está seguro que desea modificar los datos?",
					"Modificar registro", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
				controlador.modificarCliente(cliente);
			VaciarCampos();
		}
	}
	
	private class BtnBuscarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			CapturarDni();
			controlador.buscarCliente(cliente, DniCliente);
			RellenarCampos();
		}
	}
	
	private class BtnAtrasActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
			controlador.mostrarF05Clientes();
		}
	}
	
	public void CapturarDni() {		
		DniCliente = textFieldDni.getText();		
	}
	
	public void RellenarCampos() {
		TelefonoCliente = cliente.getTelefono();

		textFieldNombre.setText(cliente.getNombre());
		textFieldDireccion.setText(cliente.getDireccion());
		textFieldTelefono.setText(String.valueOf(TelefonoCliente));
		textFieldNombre.setEditable(true);
		textFieldDireccion.setEditable(true);
		textFieldTelefono.setEditable(true);

	}
	
	public void VaciarCampos() {
		textFieldDni.setText("");
		textFieldNombre.setText("");
		textFieldDireccion.setText("");
		textFieldTelefono.setText("");
	}
	
	
	public void CapturarCamposModificados() {
		DniCliente = textFieldDni.getText();
		NombreCliente = textFieldNombre.getText();
		DireccionCliente = textFieldDireccion.getText();
		TelefonoCliente = Integer.parseInt(textFieldTelefono.getText());
		
		cliente.setNif(DniCliente);
		cliente.setNombre(NombreCliente);
		cliente.setDireccion(DireccionCliente);
		cliente.setTelefono(TelefonoCliente);
	}
	
}
