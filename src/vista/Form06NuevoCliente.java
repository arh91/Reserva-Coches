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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;


public class Form06NuevoCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();

	Controlador controlador;
	private int CodigoInvolucra;
	private String DniCliente;
	private String NombreCliente;
	private String DireccionCliente;
	private String validado = "no";
	private int TelefonoCliente;
	private JTextField textFieldDni;
	private JTextField textFieldNombre;
	private JTextField textFieldDireccion;
	private JTextField textFieldTelefono;
	private Cliente cliente = new Cliente();
	private Conexion conexion = new Conexion();
	private DniCompleto nif = new DniCompleto();
	private List <Integer> numeros = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
	private List <Character> letras = Arrays.asList('T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E');

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
			validarDni();
			if(validado == "si") { 
				VaciarCampos();
				controlador.InsertarCliente(cliente);
				validado = "no";
			}else {
				textFieldDni.setText("");
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
	
	
	public void validarDni() {
		String nif = textFieldDni.getText();
		
		ArrayList dni = new ArrayList();
		char caracter;
		
		
			for (int i=0; i<nif.length(); i++){
				caracter=nif.charAt(i);
				dni.add(caracter);
			}
			
			if(dni.size()!=9){       //Si el número de digitos del dni es distinto de 9, lanzamos el aviso correspondiente al usuario
				JOptionPane.showMessageDialog(null," El DNI tiene que contener nueve caracteres.","Información", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
		
		
			int index = dni.size() - 1;
			dni.remove(index);    //Eliminamos el último elemento del ArrayList dni
			
			int contador = 0;
			
			for (int num=0; num<dni.size(); num++){			
				for(int n=0; n<numeros.size(); n++){
					if(n==num){
						contador+=1;
					}
				}
			}
			
			String letraValidada = "no";
			dni.clear();               //Elimino todos los elementos del ArrayList dni
			
			for (int i=0; i<nif.length(); i++){         //Relleno ArrayList dni con los caracteres del dni introducido en el TextField
				caracter=nif.charAt(i);
				dni.add(caracter);
			}
			
			char letra = (char) dni.get(dni.size() - 1);            //Guardo en la variable letra el último elemento del ArrayList dni
			
			for (int a=0; a<letras.size(); a++){       //Compruebo que el último caracter del dni sea alguna de las letras que están en la lista de letras posibles
				if(letra == letras.get(a)){
					letraValidada = "si";
					break;
				}
			}
			
			if(contador!=8 || letraValidada == "no"){
				JOptionPane.showMessageDialog(null," Formato de dni incorrecto.","Información", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			dni.remove(index);    //Eliminamos el último elemento del ArrayList dni
			
			String numeros = "";
			
			for(int i=0; i<dni.size(); i++){
				numeros+=dni.get(i);
			}
			
			int numero = Integer.parseInt(numeros);
			
			comprobacion(numero, letra, letras);
			       
	}
	
	public void comprobacion (int numero, char letra, List<Character> listaLetras) {
		List<Integer> resto = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22);
		int r =numero%23;
		
		String encontrado = "no";
		
		for (int i=0;i<resto.size();i++) {
			if(r==i && letra==listaLetras.get(i)){
				encontrado = "si";
			}
		}
		
		if(encontrado=="si") {
		    JOptionPane.showMessageDialog(null," El DNI introducido es verdadero.","Información", JOptionPane.INFORMATION_MESSAGE);
		    validado = "si";
		}else {
		    JOptionPane.showMessageDialog(null," El DNI introducido es falso.","Información", JOptionPane.INFORMATION_MESSAGE);
		}

	}
	
}
