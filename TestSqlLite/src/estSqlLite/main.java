package estSqlLite;

public class main {

	public static void main(String[] args) {
		/*Conector con = new Conector();		//Para conectar
		con.connect();
		con.close();*/
		
		Alumno alumno = new Alumno("Ramon", "Martinez");	// Para hacer un insert
		alumno.save();
		
	}

}
