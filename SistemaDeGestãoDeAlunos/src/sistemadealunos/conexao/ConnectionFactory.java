
package sistemadealunos.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private final String ip = "localhost"; 
	private final int port = 5432;
	private final String user = "postgres";
	private final String password = "lucas2012";
	private final String database = "Aluno";
    
	public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://"+ip+":"+port+"/"+database, user, password); 
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
