package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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


public class Form08EliminarCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();

	Controlador controlador;
	private String DniCliente;
	private JTextField textFieldDni;

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
	
	public static void main(String[] args) {
		try {
			Form08EliminarCliente dialog = new Form08EliminarCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Form08EliminarCliente() {
		setTitle("Eliminar Cliente");
		setBounds(100, 100, 869, 455);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblDni = new JLabel("Dni:");
		lblDni.setBackground(new Color(240, 240, 240));
		lblDni.setBounds(35, 53, 56, 16);
		contentPanel.add(lblDni);
		
		textFieldDni = new JTextField();
		textFieldDni.setBounds(162, 52, 127, 19);
		contentPanel.add(textFieldDni);
		textFieldDni.setColumns(10);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new BtnEliminarActionListener());
		btnEliminar.setBounds(278, 324, 85, 21);
		contentPanel.add(btnEliminar);
		
		JButton btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(new BtnAtrasActionListener());
		btnAtras.setBounds(411, 324, 85, 21);
		contentPanel.add(btnAtras);
	}
	
	
	private class BtnEliminarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			RecogerDatos();
			VaciarCampos();
			if (JOptionPane.showConfirmDialog(rootPane, "¿Está seguro que desea eliminar el cliente con DNI "+DniCliente+" ?",
					"Eliminar Registro", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
				controlador.eliminarReservasCliente(DniCliente);
				controlador.eliminarCliente(DniCliente);
		}
	}
	
	private class BtnAtrasActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
			controlador.mostrarF05Clientes();
		}
	}
	
	public void RecogerDatos() {
		DniCliente = textFieldDni.getText();
	}
	
	public void VaciarCampos() {
		textFieldDni.setText("");
	}
	
}
