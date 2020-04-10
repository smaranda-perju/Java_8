import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @create metoda create e la fel ca in clasa ArtistController, doar parametrii sunt diferiti
 * @findByArtist tot asematator cu findByName din clasa ArtistController
 */
public class AlbumController {
    private Connection connection;

    public AlbumController(Connection connection) {
        this.connection = connection;
    }

    public void create(String name, int artistId, int releaseYear) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO albums(name, artist_id, release_year) VALUES(\"" + name + "\", \"" + artistId + "\",\"" + releaseYear + "\")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findByArtist(int artistId) {
        try {
            String query = "SELECT * FROM albums WHERE artist_id = (\"" + artistId + "\")";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            if (rs != null) {
                System.out.println("Albums with artistId = \"" + artistId + "\":");
                while (rs.next()) {
                    System.out.println("id: " + rs.getInt("id") + ", name: " + rs.getString("name") + ", artistId: " + rs.getInt("artist_id") + ", releaseYear: " + rs.getInt("release_year"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
