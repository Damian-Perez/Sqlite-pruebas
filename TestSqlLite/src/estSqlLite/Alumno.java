package estSqlLite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Alumno {
	 
    private int id;
    private String nombre, apellidos;
	private Connection connect;
 
    public Alumno(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getNombre() {
        return nombre;
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    public String getApellidos() {
        return apellidos;
    }
 
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    public void save(){
        Conector con = new Conector();
        con.connect();
        con.saveAlumno(this);
        con.close();
    }
    
    public void mostrarAlumnos(){				//Para las consultas 
        ResultSet result = null;
        try {
            PreparedStatement st = connect.prepareStatement("select * from alumnos");
            result = st.executeQuery();
            while (result.next()) {
                System.out.print("ID: ");
                System.out.println(result.getInt("id"));
 
                System.out.print("Nombre: ");
                System.out.println(result.getString("nombre"));
 
                System.out.print("Apellidos: ");
                System.out.println(result.getString("apellidos"));
 
                System.out.println("=======================");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
 
}