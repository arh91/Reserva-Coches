package modeloDao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import conexion.Conexion;
import modeloVo.Involucra;

public class InvolucraDao {

	public void InsertarInvolucra(Involucra involucra){
		Conexion conex= new Conexion();
		try {
			String consulta = "INSERT INTO Involucra VALUES (?,?,?,?,?)";
			PreparedStatement ps = conex.getConnection().prepareStatement(consulta);
			ps.setInt(1, involucra.getCodigo());
			ps.setString(2, involucra.getMatricula());
			ps.setString(3, involucra.getCliente());
			ps.setInt(4, involucra.getReserva());
			ps.setInt(5, involucra.getLitros());
			
			
			int filas = ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Se han guardado los datos correctamente","Información", JOptionPane.INFORMATION_MESSAGE);
			ps.close();
			conex.desconectar();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Guardo");
		}
	}
}
