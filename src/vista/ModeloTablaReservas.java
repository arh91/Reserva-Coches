package vista;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.table.AbstractTableModel;

import controlador.Controlador;
import modeloVo.FilaReserva;


public class ModeloTablaReservas extends AbstractTableModel{

	ArrayList <FilaReserva> filaReserva = null;
	String[] nombresColumnas = new String[5];
	 Controlador controlador = new Controlador();
	

	public ModeloTablaReservas() {		
		nombresColumnas[0]="Cliente";
		nombresColumnas[1]="Matrícula";
		nombresColumnas[2]="Precio";
		nombresColumnas[3]="Días";
		nombresColumnas[4]="Importe";
		
		filaReserva = new ArrayList <FilaReserva>();
		
	}

	public int getColumnCount() {		
		return nombresColumnas.length;
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		return filaReserva.size();
	}
	
	public String getColumnName(int columna) {
		return nombresColumnas[columna];
	}
	

	public Object getValueAt(int fila, int columna) {
		
FilaReserva reserva = filaReserva.get(fila);
		
		//poner formato a los numeros
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.getDefault());
		
		switch (columna) {
		case 0:
			return reserva.getNombreCliente();
		case 1:
			return reserva.getMatriculaCoche();
		case 2:
			return nf.format(reserva.getPrecio());
		case 3:
			return reserva.getDias();
		case 4:
			return nf.format(reserva.getImporte());
		}
		return reserva;
	}
	
	public void ListadoReservasEnero() {
		filaReserva = controlador.ReservasEnero();		
	}
	
	public void ListadoReservasFebrero() {
		filaReserva = controlador.ReservasFebrero();		
	}
	
	public void ListadoReservasMarzo() {
		filaReserva = controlador.ReservasMarzo();		
	}
	
	public void ListadoReservasAbril() {
		filaReserva = controlador.ReservasAbril();		
	}
	
	public void ListadoReservasMayo() {
		filaReserva = controlador.ReservasMayo();		
	}
	
	public void ListadoReservasJunio() {
		filaReserva = controlador.ReservasJunio();		
	}
	
	public void ListadoReservasJulio() {
		filaReserva = controlador.ReservasJulio();		
	}
	
	public void ListadoReservasAgosto() {
		filaReserva = controlador.ReservasAgosto();		
	}
	
	public void ListadoReservasSeptiembre() {
		filaReserva = controlador.ReservasSeptiembre();		
	}
	
	public void ListadoReservasOctubre() {
		filaReserva = controlador.ReservasOctubre();		
	}
	
	public void ListadoReservasNoviembre() {
		filaReserva = controlador.ReservasNoviembre();		
	}
	
	public void ListadoReservasDiciembre() {
		filaReserva = controlador.ReservasDiciembre();		
	}
}
