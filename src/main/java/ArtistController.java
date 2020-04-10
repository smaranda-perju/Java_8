import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @create in create vor fi inserate pe o noua linie in tabelul artists numele si tara data ca parametru
 * @findByName in findByName se va face un select, iar daca rezultatul va fi diferit de null (adica in tabel exista numele dat ca parametru)
 * se vor afisa toate liniile din tabel in care la coloana nume se gaseste numele dat ca parametru
 */
public class ArtistController {
    private Connection connection;

    public ArtistController(Connection connection) {
        this.connection = connection;
    }

    public void create(String name, String country) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO artists(name, country) VALUES(\"" + name + "\", \"" + country + "\")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findByName(String name) {
        try {
            String query = "SELECT * FROM artists WHERE UPPER(name) = UPPER(\"" + name + "\")";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            if (rs != null) {
                System.out.println("Artists with name = \"" + name + "\":");
                while (rs.next()) {
                    System.out.println("id: " + rs.getInt("id") + ", name: " + rs.getString("name") + ", country: " + rs.getString("country"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
