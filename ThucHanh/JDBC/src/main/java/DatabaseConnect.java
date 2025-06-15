import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnect {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlserver://localhost:1433;instanceName=SQLEXPRESS;databaseName=QLSV;encrypt=true;trustServerCertificate=true;";
        String user = "sa";
        String password = "123456789";
        return DriverManager.getConnection(url, user, password);
    }
}
