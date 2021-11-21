package vista;

import java.util.ArrayList;

import javax.swing.JComboBox;

import controlador.Controlador;
import modeloVo.Cliente;


public class ModeloComboClientes extends JComboBox<Cliente>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList <Cliente> clientes = null;	
	//Controlador controlador = new Controlador();

	public ModeloComboClientes() {
		cargarClientes();
	}

	
	private void cargarClientes() {
		Controlador controlador = new Controlador();
		
		clientes = controlador.cargarClientes();
		for(Cliente cliente : clientes) {
			this.addItem(cliente);
		}
		
		
		
	}
}
