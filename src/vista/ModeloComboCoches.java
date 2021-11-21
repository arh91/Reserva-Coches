package vista;

import java.util.ArrayList;

import javax.swing.JComboBox;

import controlador.Controlador;
import modeloVo.Coche;


public class ModeloComboCoches extends JComboBox<Coche>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList <Coche> coches = null;	
	//Controlador controlador = new Controlador();

	public ModeloComboCoches() {
		cargarCoches();
	}

	
	private void cargarCoches() {
		Controlador controlador = new Controlador();
		
		coches = controlador.cargarCoches();
		for(Coche coche : coches) {
			this.addItem(coche);
		}
		
		
		
	}
}
