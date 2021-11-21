package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {
	
	static String bd = "UD02BDReservaCoches";
	static String login = "root";
	static String password = "celtA.991";
	static String url = "jdbc:mysql://localhost/"+bd+
			"?noAccessToProcedureBodies=true&useServerPrepStmts=true&serverTimezone=Europe/Madrid&useSSL=false";

	Connection conn = null;

	/** Constructor de DbConnection */
	
		public Conexion() {
			try{
				//obtenemos el driver de para mysql
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				//obtenemos la conexión
				conn = DriverManager.getConnection(url,login,password);
			//	System.out.println(url);
			/*
			 * if (conn==null){
			 * System.out.println("Conexión a base de datos "+bd+" no se ha podido realizar"
			 * ); }
			 */
		}
		catch(SQLException e){
			System.out.println(e);
		}catch(ClassNotFoundException e){
			System.out.println(e);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	/**Permite retornar la conexión*/
	public Connection getConnection(){
		try {
			conn = DriverManager.getConnection(url,login,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}			
		return conn;
	}

	public void desconectar(){
		conn = null;
	}
	
	
	public boolean validarReserva(int codigo) {        
        boolean res = false;       
        String verificar = "SELECT inReserva FROM Involucra WHERE inReserva = "+codigo;
        try{
            PreparedStatement ps = conn.prepareStatement(verificar);            
            ResultSet rs = ps.executeQuery();        
            if(rs.next())
                res = true;
        } catch(Exception e){
            System.err.print("Ha ocurrido un error: "+ e.getMessage());
        } 
          
        return res;
    }
	
	
	public boolean validarDni(String codigo) {        
        boolean res = false;       
        String verificar = "SELECT clNif FROM Clientes WHERE clNif = "+codigo;
        try{
            PreparedStatement ps = conn.prepareStatement(verificar);            
            ResultSet rs = ps.executeQuery();        
            if(rs.next())
                res = true;
        } catch(Exception e){
            System.err.print("Ha ocurrido un error: "+ e.getMessage());
        } 
          
        return res;
    }
}
