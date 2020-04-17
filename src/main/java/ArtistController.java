import java.sql.*;

/**
 * @create primeste ca parametru un artist si introduce pe o noua linie in tabel tabel un nou artist
 * @findByName in findByName se va face un select, iar daca rezultatul va fi diferit de null (adica in tabel exista numele dat ca parametru)
 * se vor afisa toate liniile din tabel in care la coloana nume se gaseste numele dat ca parametru
 */
public class ArtistController {
    private Connection connection;

    public ArtistController(Connection connection) {
        this.connection = connection;
    }

    public void create(Artist artist) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO artists(name, country) VALUES(\"" + artist.getName() + "\", \"" + artist.getCountry() + "\")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findByName(Artist artist) {
        try {
            String query = "SELECT * FROM artists WHERE UPPER(name) = UPPER(\"" + artist.getName() + "\")";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            if (rs != null) {
                System.out.println("Artists with name = \"" + artist.getName() + "\":");
                while (rs.next()) {
                    System.out.println("id: " + rs.getInt("id") + ", name: " + rs.getString("name") + ", country: " + rs.getString("country"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
