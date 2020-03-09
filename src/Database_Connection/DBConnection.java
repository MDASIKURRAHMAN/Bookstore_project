import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by pc on 3/3/2020.
 */
public class DBConnection {
    public static String url="jdbc:mysql://localhost:3306/Student";
    public static String username="root";
    public static String password="";
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con= DriverManager.getConnection(url,username,password);
        Statement st=con.createStatement();
        return con;
    }
}
