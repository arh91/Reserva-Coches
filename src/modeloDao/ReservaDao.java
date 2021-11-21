package modeloDao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import conexion.Conexion;
import modeloVo.Cliente;
import modeloVo.FilaReserva;
import modeloVo.Involucra;
import modeloVo.Reserva;
import validaciones.ConvertirFechas;

public class ReservaDao {

	public void InsertarReserva(Reserva reserva){
		Conexion conex= new Conexion();
		try {
			String consulta = "INSERT INTO Reservas VALUES (?,?,?)";
			PreparedStatement ps = conex.getConnection().prepareStatement(consulta);
			ps.setLong(1, reserva.getCodigo());
			ps.setDate(2, (Date) reserva.getFecInicio());
			ps.setDate(3, (Date) reserva.getFecFinal());
			
			
			int filas = ps.executeUpdate();
			//JOptionPane.showMessageDialog(null, "Se han guardado los datos correctamente","Informaci�n", JOptionPane.INFORMATION_MESSAGE);
			ps.close();
			conex.desconectar();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Guardo");
		}
	}
	
	public ArrayList<FilaReserva> ReservasEnero() {
		Conexion conexion = new Conexion();
				
		String consulta = "select clNombre, inMatricula, coPrecio, DateDiff(reFecFinal, reFecInicio), coPrecio*DateDiff(reFecFinal, reFecInicio)"
				 +" from Involucra join Clientes on inCliente = clNif"
				 +" join Reservas on inReserva = reCodigo"
				 +" join Coches on inMatricula = coMatricula"
				 +" where month(reFecInicio)=1";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList <FilaReserva> reserva = new ArrayList<FilaReserva>();
		
		try {
			ps = conexion.getConnection().prepareStatement(consulta);
			//ps.setInt(1, departamento.getCodDepar());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				FilaReserva fila = new FilaReserva();
				fila.setNombreCliente(rs.getString(1));
				fila.setMatriculaCoche(rs.getString(2));
				fila.setPrecio(rs.getInt(3));
				fila.setDias(rs.getInt(4));
				fila.setImporte(rs.getInt(5));
				
				
				
				reserva.add(fila);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		conexion.desconectar();
		
		return reserva;
	}
	
	
	public ArrayList<FilaReserva> ReservasFebrero() {
		Conexion conexion = new Conexion();
		
		String consulta = "select clNombre, inMatricula, coPrecio, DateDiff(reFecFinal, reFecInicio), coPrecio*DateDiff(reFecFinal, reFecInicio)"
				 +" from Involucra join Clientes on inCliente = clNif"
				 +" join Reservas on inReserva = reCodigo"
				 +" join Coches on inMatricula = coMatricula"
				 +" where month(reFecInicio)=2";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList <FilaReserva> reserva = new ArrayList<FilaReserva>();
		
		try {
			ps = conexion.getConnection().prepareStatement(consulta);
			//ps.setInt(1, departamento.getCodDepar());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				FilaReserva fila = new FilaReserva();
				fila.setNombreCliente(rs.getString(1));
				fila.setMatriculaCoche(rs.getString(2));
				fila.setPrecio(rs.getInt(3));
				fila.setDias(rs.getInt(4));
				fila.setImporte(rs.getInt(5));
				
				
				
				reserva.add(fila);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		conexion.desconectar();
		
		return reserva;
	}
	
	
	public ArrayList<FilaReserva> ReservasMarzo() {
		Conexion conexion = new Conexion();
		
		String consulta = "select clNombre, inMatricula, coPrecio, DateDiff(reFecFinal, reFecInicio), coPrecio*DateDiff(reFecFinal, reFecInicio)"
				 +" from Involucra join Clientes on inCliente = clNif"
				 +" join Reservas on inReserva = reCodigo"
				 +" join Coches on inMatricula = coMatricula"
				 +" where month(reFecInicio)=3";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList <FilaReserva> reserva = new ArrayList<FilaReserva>();
		
		try {
			ps = conexion.getConnection().prepareStatement(consulta);
			//ps.setInt(1, departamento.getCodDepar());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				FilaReserva fila = new FilaReserva();
				fila.setNombreCliente(rs.getString(1));
				fila.setMatriculaCoche(rs.getString(2));
				fila.setPrecio(rs.getInt(3));
				fila.setDias(rs.getInt(4));
				fila.setImporte(rs.getInt(5));
				
				
				
				reserva.add(fila);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		conexion.desconectar();
		
		return reserva;
	}
	
	
	public ArrayList<FilaReserva> ReservasAbril() {
		Conexion conexion = new Conexion();
		
		String consulta = "select clNombre, inMatricula, coPrecio, DateDiff(reFecFinal, reFecInicio), coPrecio*DateDiff(reFecFinal, reFecInicio)"
				 +" from Involucra join Clientes on inCliente = clNif"
				 +" join Reservas on inReserva = reCodigo"
				 +" join Coches on inMatricula = coMatricula"
				 +" where month(reFecInicio)=4";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList <FilaReserva> reserva = new ArrayList<FilaReserva>();
		
		try {
			ps = conexion.getConnection().prepareStatement(consulta);
			//ps.setInt(1, departamento.getCodDepar());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				FilaReserva fila = new FilaReserva();
				fila.setNombreCliente(rs.getString(1));
				fila.setMatriculaCoche(rs.getString(2));
				fila.setPrecio(rs.getInt(3));
				fila.setDias(rs.getInt(4));
				fila.setImporte(rs.getInt(5));
				
				
				
				reserva.add(fila);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		conexion.desconectar();
		
		return reserva;
	}
	
	
	public ArrayList<FilaReserva> ReservasMayo() {
		Conexion conexion = new Conexion();
		
		String consulta = "select clNombre, inMatricula, coPrecio, DateDiff(reFecFinal, reFecInicio), coPrecio*DateDiff(reFecFinal, reFecInicio)"
				 +" from Involucra join Clientes on inCliente = clNif"
				 +" join Reservas on inReserva = reCodigo"
				 +" join Coches on inMatricula = coMatricula"
				 +" where month(reFecInicio)=5";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList <FilaReserva> reserva = new ArrayList<FilaReserva>();
		
		try {
			ps = conexion.getConnection().prepareStatement(consulta);
			//ps.setInt(1, departamento.getCodDepar());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				FilaReserva fila = new FilaReserva();
				fila.setNombreCliente(rs.getString(1));
				fila.setMatriculaCoche(rs.getString(2));
				fila.setPrecio(rs.getInt(3));
				fila.setDias(rs.getInt(4));
				fila.setImporte(rs.getInt(5));
				
				
				
				reserva.add(fila);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		conexion.desconectar();
		
		return reserva;
	}
	
	
	public ArrayList<FilaReserva> ReservasJunio() {
		Conexion conexion = new Conexion();
		
		String consulta = "select clNombre, inMatricula, coPrecio, DateDiff(reFecFinal, reFecInicio), coPrecio*DateDiff(reFecFinal, reFecInicio)"
				 +" from Involucra join Clientes on inCliente = clNif"
				 +" join Reservas on inReserva = reCodigo"
				 +" join Coches on inMatricula = coMatricula"
				 +" where month(reFecInicio)=6";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList <FilaReserva> reserva = new ArrayList<FilaReserva>();
		
		try {
			ps = conexion.getConnection().prepareStatement(consulta);
			//ps.setInt(1, departamento.getCodDepar());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				FilaReserva fila = new FilaReserva();
				fila.setNombreCliente(rs.getString(1));
				fila.setMatriculaCoche(rs.getString(2));
				fila.setPrecio(rs.getInt(3));
				fila.setDias(rs.getInt(4));
				fila.setImporte(rs.getInt(5));
				
				
				
				reserva.add(fila);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		conexion.desconectar();
		
		return reserva;
	}
	
	
	public ArrayList<FilaReserva> ReservasJulio() {
		Conexion conexion = new Conexion();
	
		String consulta = "select clNombre, inMatricula, coPrecio, DateDiff(reFecFinal, reFecInicio), coPrecio*DateDiff(reFecFinal, reFecInicio)"
				 +" from Involucra join Clientes on inCliente = clNif"
				 +" join Reservas on inReserva = reCodigo"
				 +" join Coches on inMatricula = coMatricula"
				 +" where month(reFecInicio)=7";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList <FilaReserva> reserva = new ArrayList<FilaReserva>();
		
		try {
			ps = conexion.getConnection().prepareStatement(consulta);
			//ps.setInt(1, departamento.getCodDepar());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				FilaReserva fila = new FilaReserva();
				fila.setNombreCliente(rs.getString(1));
				fila.setMatriculaCoche(rs.getString(2));
				fila.setPrecio(rs.getInt(3));
				fila.setDias(rs.getInt(4));
				fila.setImporte(rs.getInt(5));
				
				
				
				reserva.add(fila);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		conexion.desconectar();
		
		return reserva;
	}
	
	
	public ArrayList<FilaReserva> ReservasAgosto() {
		Conexion conexion = new Conexion();
		
		String consulta = "select clNombre, inMatricula, coPrecio, DateDiff(reFecFinal, reFecInicio), coPrecio*DateDiff(reFecFinal, reFecInicio)"
				 +" from Involucra join Clientes on inCliente = clNif"
				 +" join Reservas on inReserva = reCodigo"
				 +" join Coches on inMatricula = coMatricula"
				 +" where month(reFecInicio)=8";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList <FilaReserva> reserva = new ArrayList<FilaReserva>();
		
		try {
			ps = conexion.getConnection().prepareStatement(consulta);
			//ps.setInt(1, departamento.getCodDepar());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				FilaReserva fila = new FilaReserva();
				fila.setNombreCliente(rs.getString(1));
				fila.setMatriculaCoche(rs.getString(2));
				fila.setPrecio(rs.getInt(3));
				fila.setDias(rs.getInt(4));
				fila.setImporte(rs.getInt(5));
				
				
				
				reserva.add(fila);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		conexion.desconectar();
		
		return reserva;
	}
	
	
	public ArrayList<FilaReserva> ReservasSeptiembre() {
		Conexion conexion = new Conexion();
		
		String consulta = "select clNombre, inMatricula, coPrecio, DateDiff(reFecFinal, reFecInicio), coPrecio*DateDiff(reFecFinal, reFecInicio)"
				 +" from Involucra join Clientes on inCliente = clNif"
				 +" join Reservas on inReserva = reCodigo"
				 +" join Coches on inMatricula = coMatricula"
				 +" where month(reFecInicio)=9";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList <FilaReserva> reserva = new ArrayList<FilaReserva>();
		
		try {
			ps = conexion.getConnection().prepareStatement(consulta);
			//ps.setInt(1, departamento.getCodDepar());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				FilaReserva fila = new FilaReserva();
				fila.setNombreCliente(rs.getString(1));
				fila.setMatriculaCoche(rs.getString(2));
				fila.setPrecio(rs.getInt(3));
				fila.setDias(rs.getInt(4));
				fila.setImporte(rs.getInt(5));
				
				
				
				reserva.add(fila);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		conexion.desconectar();
		
		return reserva;
	}
	
	
	public ArrayList<FilaReserva> ReservasOctubre() {
		Conexion conexion = new Conexion();
		
		String consulta = "select clNombre, inMatricula, coPrecio, DateDiff(reFecFinal, reFecInicio), coPrecio*DateDiff(reFecFinal, reFecInicio)"
				 +" from Involucra join Clientes on inCliente = clNif"
				 +" join Reservas on inReserva = reCodigo"
				 +" join Coches on inMatricula = coMatricula"
				 +" where month(reFecInicio)=10";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList <FilaReserva> reserva = new ArrayList<FilaReserva>();
		
		try {
			ps = conexion.getConnection().prepareStatement(consulta);
			//ps.setInt(1, departamento.getCodDepar());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				FilaReserva fila = new FilaReserva();
				fila.setNombreCliente(rs.getString(1));
				fila.setMatriculaCoche(rs.getString(2));
				fila.setPrecio(rs.getInt(3));
				fila.setDias(rs.getInt(4));
				fila.setImporte(rs.getInt(5));
				
				
				
				reserva.add(fila);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		conexion.desconectar();
		
		return reserva;
	}
	
	
	public ArrayList<FilaReserva> ReservasNoviembre() {
		Conexion conexion = new Conexion();
		
		String consulta = "select clNombre, inMatricula, coPrecio, DateDiff(reFecFinal, reFecInicio), coPrecio*DateDiff(reFecFinal, reFecInicio)"
				 +" from Involucra join Clientes on inCliente = clNif"
				 +" join Reservas on inReserva = reCodigo"
				 +" join Coches on inMatricula = coMatricula"
				 +" where month(reFecInicio)=11";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList <FilaReserva> reserva = new ArrayList<FilaReserva>();
		
		try {
			ps = conexion.getConnection().prepareStatement(consulta);
			//ps.setInt(1, departamento.getCodDepar());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				FilaReserva fila = new FilaReserva();
				fila.setNombreCliente(rs.getString(1));
				fila.setMatriculaCoche(rs.getString(2));
				fila.setPrecio(rs.getInt(3));
				fila.setDias(rs.getInt(4));
				fila.setImporte(rs.getInt(5));
				
				
				
				reserva.add(fila);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		conexion.desconectar();
		
		return reserva;
	}
	
	
	public ArrayList<FilaReserva> ReservasDiciembre() {
		Conexion conexion = new Conexion();
	
		String consulta = "select clNombre, inMatricula, coPrecio, DateDiff(reFecFinal, reFecInicio), coPrecio*DateDiff(reFecFinal, reFecInicio)"
				 +" from Involucra join Clientes on inCliente = clNif"
				 +" join Reservas on inReserva = reCodigo"
				 +" join Coches on inMatricula = coMatricula"
				 +" where month(reFecInicio)=12";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList <FilaReserva> reserva = new ArrayList<FilaReserva>();
		
		try {
			ps = conexion.getConnection().prepareStatement(consulta);
			//ps.setInt(1, departamento.getCodDepar());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				FilaReserva fila = new FilaReserva();
				fila.setNombreCliente(rs.getString(1));
				fila.setMatriculaCoche(rs.getString(2));
				fila.setPrecio(rs.getInt(3));
				fila.setDias(rs.getInt(4));
				fila.setImporte(rs.getInt(5));
				
				
				
				reserva.add(fila);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		conexion.desconectar();
		
		return reserva;
	}
}
