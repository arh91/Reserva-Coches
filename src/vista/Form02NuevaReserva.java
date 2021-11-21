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
//import validaciones.ConvertirFechas;


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

public class Form02NuevaReserva extends JDialog {

	private final JPanel contentPanel = new JPanel();

	Controlador controlador;
	
	private JTextField textFecInicial;
	private JTextField textFecFinal;
	private JTextField textLitros;
	private JTextField textCodReserva;
	private ModeloComboClientes comboBox_Clientes;
	private ModeloComboCoches comboBox_Coches;
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
	private Conexion conexion = new Conexion();
	
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
	
	public static void main(String[] args) {
		try {
			Form02NuevaReserva dialog = new Form02NuevaReserva();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Form02NuevaReserva() {
		setTitle("Nueva Reserva");
		setBounds(100, 100, 869, 455);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(35, 24, 56, 16);
		contentPanel.add(lblCliente);
		
		JLabel lblCoche = new JLabel("Coche:");
		lblCoche.setBounds(35, 67, 56, 16);
		contentPanel.add(lblCoche);
		
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Reserva", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(12, 105, 827, 227);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblFechaInicial = new JLabel("Fecha Inicial (DD/MM/AAAA):");
		lblFechaInicial.setBounds(45, 35, 192, 16);
		panel.add(lblFechaInicial);
		
		JLabel lblFechafinal = new JLabel("FechaFinal (DD/MM/AAAA):");
		lblFechafinal.setBounds(438, 35, 179, 16);
		panel.add(lblFechafinal);
		
		textFecInicial = new JTextField();
		textFecInicial.setHorizontalAlignment(SwingConstants.CENTER);
		textFecInicial.setBounds(249, 32, 116, 22);
		panel.add(textFecInicial);
		textFecInicial.setColumns(10);
		
		textFecFinal = new JTextField();
		textFecFinal.setHorizontalAlignment(SwingConstants.CENTER);
		textFecFinal.setColumns(10);
		textFecFinal.setBounds(629, 32, 116, 22);
		panel.add(textFecFinal);
		
		JLabel lblLitros = new JLabel("Litros consumidos:");
		lblLitros.setBounds(438, 81, 152, 16);
		panel.add(lblLitros);
		
		textLitros = new JTextField();
		textLitros.setHorizontalAlignment(SwingConstants.CENTER);
		textLitros.setBounds(629, 78, 116, 22);
		panel.add(textLitros);
		textLitros.setColumns(10);
		
		JLabel lblCdigoReserva = new JLabel("C\u00F3digo Reserva:");
		lblCdigoReserva.setBounds(45, 81, 167, 16);
		panel.add(lblCdigoReserva);
		
		textCodReserva = new JTextField();
		textCodReserva.setHorizontalAlignment(SwingConstants.CENTER);
		textCodReserva.setColumns(10);
		textCodReserva.setBounds(249, 78, 116, 22);
		panel.add(textCodReserva);
		
		comboBox_Coches = new ModeloComboCoches();
		comboBox_Coches.setBounds(101, 65, 686, 20);
		contentPanel.add(comboBox_Coches);
		
		comboBox_Clientes = new ModeloComboClientes();
		comboBox_Clientes.setBounds(101, 22, 196, 20);
		contentPanel.add(comboBox_Clientes);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new OkButtonActionListener());
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new CancelButtonActionListener());
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	private class OkButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
				RecogerDatos();
				if(conexion.validarReserva(CodigoReserva)) { 
				    JOptionPane.showMessageDialog(null," El codigo de reserva introducido ya existe.","Información", JOptionPane.INFORMATION_MESSAGE);
				    return;
				}else {
					VaciarCampos();
					controlador.InsertarReserva(reserva);
					controlador.InsertarInvolucra(involucra);
				}		
			}}
			
	
	
	private class CancelButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			VaciarCampos();
			dispose();
			controlador.mostrarF01Inicial();
		}
	}
	
	public void RecogerDatos() {
		CodigoInvolucra = 0;
		Cliente cl = (Cliente) comboBox_Clientes.getSelectedItem();
		DniCliente = cl.getNif();
		Coche co = (Coche) comboBox_Coches.getSelectedItem();
		MatriculaCoche = co.getMatricula();
		CodigoReserva = Integer.parseInt(textCodReserva.getText());
		Litros = Integer.parseInt(textLitros.getText());
		FechaInicio = textFecInicial.getText();
		FechaFin = textFecFinal.getText();
		convertirStringDate(FechaInicio);
		fechaInicioSqlDate = new java.sql.Date(fechaJavaUtilDate.getTime());
		convertirStringDate(FechaFin);
		fechaFinSqlDate = new java.sql.Date(fechaJavaUtilDate.getTime());
		
		reserva.setCodigo(CodigoReserva);
		reserva.setFecInicio(fechaInicioSqlDate);
		reserva.setFecFinal(fechaFinSqlDate);
		involucra.setCodigo(CodigoInvolucra);
		involucra.setCliente(DniCliente);
		involucra.setMatricula(MatriculaCoche);
		involucra.setReserva(CodigoReserva);
		involucra.setLitros(Litros);
	}
	
	public void VaciarCampos() {
		textCodReserva.setText("");
		textFecInicial.setText("");
		textFecFinal.setText("");
		textLitros.setText("");
	}
	
	public void convertirStringDate(String fecha){
        try{
            // convertir la fecha de un String a un tipo Date
            SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
            fechaJavaUtilDate = (Date) formatoDelTexto.parse(fecha);
            
        }catch(ParseException pe){
            JOptionPane.showMessageDialog(null, "Error al introducir la fecha.", "Información"
                    ,JOptionPane.INFORMATION_MESSAGE);
        }       
    }
	
}
