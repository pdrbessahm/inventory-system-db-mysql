import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/inventory_db";
        String user = "root";
        String password = "MySecureDB4#";

        try(Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("✅ Conexão bem-sucedida com o banco de dados!");
        } catch (SQLException e) {
            System.out.println("❌ Falha na conexão:");
            e.printStackTrace();
        }
    }
}
