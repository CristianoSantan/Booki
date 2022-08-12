package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionMySQL {
	
	private static String URL = "jdbc:mysql://localhost:3306/booki";
	private static String USUARIO = "root";
	private static String SENHA = "Cris@admin88";
	
	public static Connection createConnectionMySQL() throws Exception {
		// Faz com que a classe seja carregada pela JVM
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Cria conex�o com banco de dados ---------- com senha
		Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);
		
		return connection;
	}

	public static void main(String[] args) throws Exception {
		// Recupera uma conex�o com o banco de dados
		Connection con = createConnectionMySQL();
		
		// testar a conex�o 
		if (con != null) {
			System.out.println(con + "\n\n ****  Conex�o obtida com sucesso!  ****");
			con.close();
		}
	}
}
