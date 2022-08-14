package conexaoJDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {

	private static String url = "jdbc:postgresql://localhost:5433/BaseFronerConstrucoes";
	private static String password = "admin";
	private static String user = "postgres";
	
	private static Connection conexao  = null;
	
	static {
		conectar();
	}
	
	public SingleConnection() {
		
		conectar();
	}
	
	private static  void conectar() {
		
		try {
				if(conexao == null) /*verifica se a conexão está permitida somente uma vez*/ {
					Class.forName("org.postgresql.Driver");
					conexao = DriverManager.getConnection(url,user,password);
					conexao.setAutoCommit(false);
					System.out.println("Conectou");
					
				}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnecntion(){
		
		return conexao;
		
	}
	
}
