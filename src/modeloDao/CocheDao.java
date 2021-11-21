package modeloDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.Conexion;
import modeloVo.Cliente;
import modeloVo.Coche;


public class CocheDao {

	public ArrayList<Coche> cargarCoches() {
		Conexion conexion = new Conexion();
		
		String consulta = "SELECT * FROM Coches Order BY coMarca, coMatricula";
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList <Coche> coches = new ArrayList<Coche>();
		try {
			ps = conexion.getConnection().prepareStatement(consulta);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Coche coch = new Coche();
				coch.setMatricula(rs.getString(1));
				coch.setMarca(rs.getString(2));
				coch.setModelo(rs.getString(3));
				coch.setColor(rs.getString(4));
				coch.setPrecio(rs.getInt(5));
				coch.setDisponible(rs.getBoolean(6));
				coch.setGaraje(rs.getInt(7));
				
				coches.add(coch);
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		conexion.desconectar();
		return coches;
	}
}
