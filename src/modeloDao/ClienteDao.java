package modeloDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import conexion.Conexion;
import modeloVo.Cliente;
import modeloVo.Involucra;


public class ClienteDao {

	public ArrayList<Cliente> cargarClientes() {
		Conexion conexion = new Conexion();
		
		String consulta = "SELECT * FROM Clientes Order BY clNombre";
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList <Cliente> clientes = new ArrayList<Cliente>();
		try {
			ps = conexion.getConnection().prepareStatement(consulta);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Cliente cli = new Cliente();
				cli.setNif(rs.getString(1));
				cli.setNombre(rs.getString(2));
				cli.setDireccion(rs.getString(3));
				cli.setTelefono(rs.getInt(4));				
				
				clientes.add(cli);
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		conexion.desconectar();
		return clientes;
	}
	
	
	public void InsertarCliente(Cliente cliente){
		Conexion conex= new Conexion();
		try {
			String consulta = "INSERT INTO Clientes VALUES (?,?,?,?)";
			PreparedStatement ps = conex.getConnection().prepareStatement(consulta);
			ps.setString(1, cliente.getNif());
			ps.setString(2, cliente.getNombre());
			ps.setString(3, cliente.getDireccion());
			ps.setInt(4, cliente.getTelefono());
			
			
			int filas = ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Se han guardado los datos correctamente","Información", JOptionPane.INFORMATION_MESSAGE);
			ps.close();
			conex.desconectar();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Guardo");
		}
	}
	
	
	public void BuscarCliente(Cliente cliente, String codigo){
		Conexion conex= new Conexion();		
		boolean existe=false;
		try {
			String consulta = "SELECT * FROM clientes where clNif = ? ";
			PreparedStatement ps = conex.getConnection().prepareStatement(consulta);
			ps.setString(1, codigo);
			ResultSet res = ps.executeQuery();
			while(res.next()){
				existe=true;
				cliente.setNif(res.getString("clNif"));
				cliente.setNombre(res.getString("clNombre"));
				cliente.setDireccion(res.getString("clDireccion"));	
				cliente.setTelefono(res.getInt("clTelefono"));				

			}
			res.close();
			conex.desconectar();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error, no se conecto");
			System.out.println(e);
		}}
	
	
	/*public Empleado buscarEmpleado(int codigo){
		Conexion conex= new Conexion();
		Empleado empleado= new Empleado();
		boolean existe=false;
		try {
			String consulta = "SELECT * FROM empleados where CodEmpleado =? ";
			PreparedStatement ps = conex.getConnection().prepareStatement(consulta);
			ps.setInt(1, codigo);
			ResultSet res = ps.executeQuery();
			while(res.next()){
				existe=true;
				empleado.setCodEmple(Integer.parseInt(res.getString("código")));
				empleado.setNombre(res.getString("nombre"));
				empleado.setPuesto(res.getString("puesto"));
				empleado.setDirector(Integer.parseInt(res.getString("director")));
				empleado.setFechaalta(Date.parseDate(res.getString("fecha alta")));
				empleado.setSalario(Float.parseFloat(res.getString("salario")));
				empleado.setComision(Integer.parseInt(res.getString("comision")));
				empleado.setCodDepartamento(Integer.parseInt(res.getString("codigo departamento")));
			}
			res.close();
			conex.desconectar();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error, no se conecto");
			System.out.println(e);
		}
			if (existe) {
				return empleado;
			}
			else return null;
	}*/
	
	
	public void EliminarCliente(String codigo){
		Conexion conex= new Conexion();
		try {
			String consulta = "DELETE FROM clientes WHERE clNif=?";
			PreparedStatement ps = conex.getConnection().prepareStatement(consulta);
			ps.setString(1, codigo);
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, " Se ha eliminado el registro","Información",JOptionPane.INFORMATION_MESSAGE);
			ps.close();
			conex.desconectar();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se elimino");
		}
		
	}
	
	
	public void EliminarReservasCliente(String codigo){
		Conexion conex= new Conexion();
		try {
			String consulta = "DELETE FROM reservas r "+
					"INNER JOIN involucra i ON r.reCodigo = i.inReserva "+
					"INNER JOIN clientes cl ON i.inCliente = cl.clNif "+
					"WHERE cl.clNif=?";
			PreparedStatement ps = conex.getConnection().prepareStatement(consulta);
			ps.setString(1, codigo);
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, " Se ha eliminado el registro","Información",JOptionPane.INFORMATION_MESSAGE);
			ps.close();
			conex.desconectar();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se elimino");
		}
		
	}
	
	
	public void ModificarCliente(Cliente cliente) {
			Conexion conex= new Conexion();
			try{
				String consulta="UPDATE clientes SET clNombre=? , clDireccion=?, clTelefono=? "+ "WHERE clNif=? ";
				PreparedStatement ps = conex.getConnection().prepareStatement(consulta);
				ps.setString(1, cliente.getNombre());
				ps.setString(2, cliente.getDireccion());
				ps.setInt(3, cliente.getTelefono());
				ps.setString(4, cliente.getNif());
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null, " Se han modificado los datos ","Confirmación", JOptionPane.INFORMATION_MESSAGE);
				ps.close();
				conex.desconectar();
			}catch(SQLException e){
				System.out.println(e);
				JOptionPane.showMessageDialog(null, "Error al Modificar","Error",JOptionPane.ERROR_MESSAGE);
			}
		}


}
