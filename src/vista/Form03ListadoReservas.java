package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;



import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;

import conexion.Conexion;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Form03ListadoReservas extends JDialog {

	private final JPanel contentPanel = new JPanel();


	Controlador controlador;
	private JScrollPane scrollPane;
	
	


	private DefaultTableCellRenderer alinearCentro, alinearDerecha, alinearIzquierda;
	private JTextField textFieldPrecioMedio;
	private JTextField textDiasMedia;
	/**
	 * @wbp.nonvisual location=-49,244
	 */
	private final JTextField textField = new JTextField();
	private JTextField textTotalMes;
	private JTextField textNumAlquileres;
	private JTable table_1;
	private JComboBox meses;
	private String[] mesesAño = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
	private ModeloTablaReservas miModelo;
	private double PrecioMedio = 5.5;
	private double DiasMedia, TotalMes;
	private int NumeroAlquileres;
	String mes;
	private Conexion conexion = new Conexion();
	
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
	
	
	public static void main(String[] args) {
		try {
			Form03ListadoReservas dialog = new Form03ListadoReservas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Form03ListadoReservas() {
		textField.setColumns(10);
		setTitle("Listado Reservas Mes");
		setBounds(100, 100, 884, 345);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Seleccionar Mes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(12, 13, 842, 44);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		meses = new JComboBox();
		meses.setBounds(65, 13, 106, 20);
		for(int i=0; i<mesesAño.length; i++) {
			meses.addItem(mesesAño[i]);
		}
		panel.add(meses);

		

		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 70, 842, 109);
		contentPanel.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setColumnHeaderView(table_1);
		
		{
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Resumen Mes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(12, 200, 842, 67);
			contentPanel.add(panel_1);
			panel_1.setLayout(null);
			
			textFieldPrecioMedio = new JTextField();
			textFieldPrecioMedio.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldPrecioMedio.setBounds(322, 35, 116, 22);
			panel_1.add(textFieldPrecioMedio);
			textFieldPrecioMedio.setColumns(10);
			
			textDiasMedia = new JTextField();
			textDiasMedia.setHorizontalAlignment(SwingConstants.CENTER);
			textDiasMedia.setBounds(520, 35, 116, 22);
			panel_1.add(textDiasMedia);
			textDiasMedia.setColumns(10);
			
			textTotalMes = new JTextField();
			textTotalMes.setHorizontalAlignment(SwingConstants.CENTER);
			textTotalMes.setBounds(716, 35, 116, 22);
			panel_1.add(textTotalMes);
			textTotalMes.setColumns(10);
			
			textNumAlquileres = new JTextField();
			textNumAlquileres.setHorizontalAlignment(SwingConstants.CENTER);
			textNumAlquileres.setBounds(137, 35, 116, 22);
			panel_1.add(textNumAlquileres);
			textNumAlquileres.setColumns(10);
			
			JLabel lblPrecioMedio = new JLabel("Precio Medio");
			lblPrecioMedio.setBounds(335, 12, 126, 13);
			panel_1.add(lblPrecioMedio);
			
			JLabel lblNumAlquileres = new JLabel("N\u00FAmero Alquileres");
			lblNumAlquileres.setBounds(163, 12, 102, 13);
			panel_1.add(lblNumAlquileres);
			
			JLabel lblDiasMedia = new JLabel("Dias Media");
			lblDiasMedia.setBounds(545, 12, 102, 13);
			panel_1.add(lblDiasMedia);
			
			JLabel lblTotalMes = new JLabel("Total Mes");
			lblTotalMes.setBounds(740, 12, 102, 13);
			panel_1.add(lblTotalMes);
		}

	


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
	
	private class ComboMesActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
		}
	}
	private class OkButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			cargarTabla();
			AsignarMes();
			PrecioMedio();
			DiasMedia();
			NumeroAlquileres();
			TotalMensual();
			mostrarResultados();
		}
	}
	private class CancelButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			VaciarCampos();
			dispose();
			controlador.mostrarF01Inicial();
		}
	}
	
	
	public void mostrarResultados() {
		textFieldPrecioMedio.setText(String.valueOf(PrecioMedio));
		textDiasMedia.setText(String.valueOf(DiasMedia));
		textTotalMes.setText(String.valueOf(TotalMes));
		textNumAlquileres.setText(String.valueOf(NumeroAlquileres));
	}
	
	
	public void VaciarCampos() {
		meses.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
		table_1.setVisible(false);
		textFieldPrecioMedio.setText("");
		textDiasMedia.setText("");
		textTotalMes.setText("");
		textNumAlquileres.setText("");
	}
	
	public void AsignarMes() {
		if (meses.getSelectedItem()== "Enero") {
			mes="01";
		}else if(meses.getSelectedItem()== "Febrero") {
			mes="02";
		}else if(meses.getSelectedItem()== "Marzo") {
			mes="03";
		}else if(meses.getSelectedItem()== "Abril") {
			mes="04";
		}else if(meses.getSelectedItem()== "Mayo") {
			mes="05";
		}else if(meses.getSelectedItem()== "Junio") {
			mes="06";
		}else if(meses.getSelectedItem()== "Julio") {
			mes="07";
		}else if(meses.getSelectedItem()== "Agosto") {
			mes="08";
		}else if(meses.getSelectedItem()== "Septiembre") {
			mes="09";
		}else if(meses.getSelectedItem()== "Octubre") {
			mes="10";
		}else if(meses.getSelectedItem()== "Noviembre") {
			mes="11";
		}else{
			mes="12";
		}
	}
	public void PrecioMedio () {
		try {
			String consulta = "Select avg(coPrecio) as precio_Medio from Coches c join Involucra i on i.inMatricula=c.coMatricula"+
				" join Reservas r on i.inReserva=r.reCodigo"+
				" where month(r.reFecInicio)= "+mes;
			PreparedStatement ps = (PreparedStatement) conexion.getConnection().prepareStatement(consulta); 
			ResultSet rs = ps.executeQuery();
			rs.next();
			PrecioMedio = rs.getDouble("precio_Medio");
			ps.close();
			conexion.desconectar();
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al obtener los datos");
		}
	}
	
	
	public void DiasMedia () {
		try {
			String consulta = "Select avg(coPrecio) as Precio_Medio from Coches c join Involucra i on i.inMatricula=c.coMatricula"+
				" join Reservas r on i.inReserva=r.reCodigo"+
				" where month(r.reFecInicio)= "+mes;
			System.out.println(consulta);
			PreparedStatement ps = (PreparedStatement) conexion.getConnection().prepareStatement(consulta); 
			ResultSet rs = ps.executeQuery();
			rs.next();
			DiasMedia = rs.getDouble("Precio_Medio");
			ps.close();
			conexion.desconectar();
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al obtener los datos");
		}
	}
	
	
	public void NumeroAlquileres () {
		try {
			String consulta = "Select count(reCodigo) as Numero_Alquileres from Reservas where month(reFecInicio)="+mes;
				System.out.println(consulta);
			PreparedStatement ps = (PreparedStatement) conexion.getConnection().prepareStatement(consulta); 
			ResultSet rs = ps.executeQuery();
			rs.next();
			NumeroAlquileres = rs.getInt("Numero_Alquileres");
			System.out.println(NumeroAlquileres);
			ps.close();
			conexion.desconectar();
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al obtener los datos");
		}
	}
	
	
	public void TotalMensual () {
		try {
			String consulta = "Select avg(coPrecio) as precio_Medio from Coches c join Involucra i on i.inMatricula=c.coMatricula"+
				" join Reservas r on i.inReserva=r.reCodigo"+
				" where month(r.reFecInicio)= "+mes;
			PreparedStatement ps = (PreparedStatement) conexion.getConnection().prepareStatement(consulta); 
			ResultSet rs = ps.executeQuery();
			rs.next();
			TotalMes = rs.getDouble("precio_Medio");
			ps.close();
			conexion.desconectar();
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al obtener los datos");
		}
	}
	
	
	private void cargarTabla() {
		if (meses.getSelectedItem() == "Enero") {
			ReservasMes(1);
		}else if(meses.getSelectedItem() == "Febrero") {
			ReservasMes(2);
		}else if(meses.getSelectedItem() == "Marzo") {
			ReservasMes(3);
		}else if(meses.getSelectedItem() == "Abril") {
			ReservasMes(4);
		}else if(meses.getSelectedItem() == "Mayo") {
			ReservasMes(5);
		}else if(meses.getSelectedItem() == "Junio") {
			ReservasMes(6);
		}else if(meses.getSelectedItem() == "Julio") {
			ReservasMes(7);
		}else if(meses.getSelectedItem() == "Agosto") {
			ReservasMes(8);
		}else if(meses.getSelectedItem() == "Septiembre") {
			ReservasMes(9);
		}else if(meses.getSelectedItem() == "Octubre") {
			ReservasMes(10);
		}else if(meses.getSelectedItem() == "Noviembre") {
			ReservasMes(11);
		}else {
			ReservasMes(12);
		}
	}
	
	private void ReservasMes(int a) {
		miModelo = new ModeloTablaReservas();				
		table_1 = new JTable(miModelo);
		
		switch(a) {
			case 1:
				miModelo.ListadoReservasEnero();
				break;
			case 2:
				miModelo.ListadoReservasFebrero();
				break;
			case 3:
				miModelo.ListadoReservasMarzo();
				break;
			case 4:
				miModelo.ListadoReservasAbril();
				break;
			case 5:
				miModelo.ListadoReservasMayo();
				break;
			case 6:
				miModelo.ListadoReservasJunio();
				break;
			case 7:
				miModelo.ListadoReservasJulio();
				break;
			case 8:
				miModelo.ListadoReservasAgosto();
				break;
			case 9:
				miModelo.ListadoReservasSeptiembre();
				break;
			case 10:
				miModelo.ListadoReservasOctubre();
				break;
			case 11:
				miModelo.ListadoReservasNoviembre();
				break;
			case 12:
				miModelo.ListadoReservasDiciembre();
				break;
		}
		scrollPane.setViewportView(table_1);
	}
}
