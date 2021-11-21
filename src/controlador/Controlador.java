package controlador;

import java.util.ArrayList;

import modeloDao.ClienteDao;
import modeloDao.CocheDao;
import modeloDao.InvolucraDao;
import modeloDao.ReservaDao;
import modeloVo.Cliente;
import modeloVo.Coche;
import modeloVo.FilaReserva;
import modeloVo.Involucra;
import modeloVo.Reserva;

import vista.Form01Inicial;
import vista.Form02NuevaReserva;
import vista.Form03ListadoReservas;
import vista.Form04ClienteMes;
import vista.Form05Clientes;
import vista.Form06NuevoCliente;
import vista.Form07ModificarCliente;
import vista.Form08EliminarCliente;

public class Controlador {
	
	Form01Inicial inicio;
	Form02NuevaReserva nuevaReserva;
	Form03ListadoReservas listaReservas;
	Form04ClienteMes clienteMes;
	Form05Clientes clientes;
	Form06NuevoCliente nuevoCliente;
	Form07ModificarCliente modificarCliente;
	Form08EliminarCliente eliminarCliente;
	
	ClienteDao clienteDao = new ClienteDao();
	CocheDao cocheDao = new CocheDao();
	ReservaDao reservaDao = new ReservaDao();
	InvolucraDao involucraDao = new InvolucraDao();
	
	
	public void setInicio (Form01Inicial inicio) {
		this.inicio = inicio;
	}
	
	public void setNuevaReserva (Form02NuevaReserva nuevaReserva) {
		this.nuevaReserva = nuevaReserva;
	}
	
	public void setListadoReservas (Form03ListadoReservas listaReservas) {
		this.listaReservas = listaReservas;
	}
	
	public void setClienteMes (Form04ClienteMes clienteMes) {
		this.clienteMes = clienteMes;
	}
		
	public void setClientes(Form05Clientes clientes) {
		this.clientes = clientes;
	}

	public void setNuevoCliente(Form06NuevoCliente nuevoCliente) {
		this.nuevoCliente = nuevoCliente;
	}

	public void setModificarCliente(Form07ModificarCliente modificarCliente) {
		this.modificarCliente = modificarCliente;
	}

	public void setEliminarCliente(Form08EliminarCliente eliminarCliente) {
		this.eliminarCliente = eliminarCliente;
	}

	public void setClienteDao (ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}
	
	public void setCocheDao (CocheDao cocheDao) {
		this.cocheDao = cocheDao;
	}
	
	public void setReservaDao (ReservaDao reservaDao) {
		this.reservaDao = reservaDao;
	}
	
	////////////////////////////////////////////////////////////////////////////////////
	
	public void mostrarF01Inicial() {
		inicio.setVisible(true);
	}
	
	public void mostrarF02NuevaReserva() {
		nuevaReserva.setVisible(true);
	}
	
	public void mostrarF03ListadoReservas() {
		listaReservas.setVisible(true);
	}
	
	public void mostrarF04ClienteMes() {
		clienteMes.setVisible(true);
	}
	
	public void mostrarF05Clientes() {
		clientes.setVisible(true);
	}
	
	public void mostrarF06NuevoCliente() {
		nuevoCliente.setVisible(true);		
	}

	public void mostrarF07ModificarCliente() {
		modificarCliente.setVisible(true);		
	}

	public void mostrarF08EliminarCliente() {
		eliminarCliente.setVisible(true);		
	}
	
	///////////////////////////////////////////////////////////////////////
	
	public void InsertarReserva (Reserva reserva) {
		reservaDao.InsertarReserva(reserva);
	}
	
	public void InsertarInvolucra (Involucra involucra) {
		involucraDao.InsertarInvolucra(involucra);
	}
	
	public void InsertarCliente (Cliente cliente) {
		clienteDao.InsertarCliente(cliente);
	}
	
	public void buscarCliente(Cliente cliente, String codigo) {
		clienteDao.BuscarCliente(cliente, codigo);
	}
	
	/*public Departamento buscarDepartamento (int codigo) {
		return depao.buscarDepartamento(codigo);
	}*/
	
	public void eliminarCliente (String codigo) {
		clienteDao.EliminarCliente(codigo);
	}
	
	public void eliminarReservasCliente (String codigo) {
		clienteDao.EliminarReservasCliente(codigo);
	}
	
	public void modificarCliente(Cliente cliente) {
		clienteDao.ModificarCliente(cliente);
	}
	
	public ArrayList<FilaReserva> ReservasEnero() {
		return reservaDao.ReservasEnero();		
	}
	
	public ArrayList<FilaReserva> ReservasFebrero() {
		return reservaDao.ReservasFebrero();		
	}
	
	public ArrayList<FilaReserva> ReservasMarzo() {
		return reservaDao.ReservasMarzo();		
	}
	
	public ArrayList<FilaReserva> ReservasAbril() {
		return reservaDao.ReservasAbril();		
	}
	
	public ArrayList<FilaReserva> ReservasMayo() {
		return reservaDao.ReservasMayo();		
	}
	
	public ArrayList<FilaReserva> ReservasJunio() {
		return reservaDao.ReservasJunio();		
	}
	
	public ArrayList<FilaReserva> ReservasJulio() {
		return reservaDao.ReservasJulio();		
	}
	
	public ArrayList<FilaReserva> ReservasAgosto() {
		return reservaDao.ReservasAgosto();		
	}
	
	public ArrayList<FilaReserva> ReservasSeptiembre() {
		return reservaDao.ReservasSeptiembre();		
	}
	
	public ArrayList<FilaReserva> ReservasOctubre() {
		return reservaDao.ReservasOctubre();		
	}
	
	public ArrayList<FilaReserva> ReservasNoviembre() {
		return reservaDao.ReservasNoviembre();		
	}
	
	public ArrayList<FilaReserva> ReservasDiciembre() {
		return reservaDao.ReservasDiciembre();		
	}
	
	public ArrayList<Cliente> cargarClientes(){
		return clienteDao.cargarClientes();
	}
	
	public ArrayList<Coche> cargarCoches(){
		return cocheDao.cargarCoches();
	}

}
