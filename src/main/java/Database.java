import java.sql.*;

/**
 * Clasa Database e de tip singleton si din ea ma conectez la baza de date creata in mysql
 */
public class Database {

    private static Connection conn;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/musicalbums", "dba", "sql");
            System.out.println("connected");
        } catch (ClassNotFoundException | SQLException e) {
            // e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static Connection getCon() {
        return conn;
    }
}
