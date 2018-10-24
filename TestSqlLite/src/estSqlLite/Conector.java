package estSqlLite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conector {
	String url = "C:\\Base\\base.sqlite";
	Connection connect;


public void connect(){
 try {
     connect = DriverManager.getConnection("jdbc:sqlite:"+url);
     if (connect!=null) {
         System.out.println("Conectado");
     }
 }catch (SQLException ex) {
     System.err.println("No se ha podido conectar a la base de datos\n"+ex.getMessage());
 }
}
 public void close(){
        try {
            connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
 
 public void saveAlumno(Alumno alumno){
        try {
            PreparedStatement st = connect.prepareStatement("insert into alumnos (nombre, apellidos) values (?,?)");
            st.setString(1, alumno.getNombre());
            st.setString(2, alumno.getApellidos());
            st.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
 
    }
 
}