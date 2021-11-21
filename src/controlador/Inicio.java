package controlador;



import vista.Form01Inicial;
import vista.Form02NuevaReserva;
import vista.Form03ListadoReservas;
import vista.Form04ClienteMes;
import vista.Form05Clientes;
import vista.Form06NuevoCliente;
import vista.Form07ModificarCliente;
import vista.Form08EliminarCliente;

public class Inicio {

	private void iniciar() {
		Form01Inicial inicio = new Form01Inicial();
		Form02NuevaReserva nuevaReserva = new Form02NuevaReserva();
		Form03ListadoReservas listaReservas = new Form03ListadoReservas();
		Form04ClienteMes clienteMes = new Form04ClienteMes();
		Form05Clientes clientes = new Form05Clientes();
		Form06NuevoCliente nuevoCliente = new Form06NuevoCliente();
		Form07ModificarCliente modificarCliente = new Form07ModificarCliente();
		Form08EliminarCliente eliminarCliente = new Form08EliminarCliente();
		Controlador controlador = new Controlador();
		
		inicio.setControlador(controlador);
		nuevaReserva.setControlador(controlador);
		listaReservas.setControlador(controlador);
		clienteMes.setControlador(controlador);
		clientes.setControlador(controlador);
		nuevoCliente.setControlador(controlador);
		modificarCliente.setControlador(controlador);
		eliminarCliente.setControlador(controlador);
		
		controlador.setInicio(inicio);
		controlador.setNuevaReserva(nuevaReserva);
		controlador.setListadoReservas(listaReservas);
		controlador.setClienteMes(clienteMes);
		controlador.setClientes(clientes);
		controlador.setNuevoCliente(nuevoCliente);
		controlador.setModificarCliente(modificarCliente);
		controlador.setEliminarCliente(eliminarCliente);
		
		controlador.mostrarF01Inicial();
	}
	
	
	public static void main(String[] args) {
		Inicio principal = new Inicio();
		principal.iniciar();
	}
	
		


}
