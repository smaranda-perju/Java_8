import java.sql.*;

/**
 * @create metoda create e la fel ca in clasa ArtistController, dor parametrul e diferit (Album album)
 * @findByArtist tot asematator cu findByName din clasa ArtistController
 */
public class AlbumController {
    private Connection connection;

    public AlbumController(Connection connection) {
        this.connection = connection;
    }

    public void create(Album album) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO albums(name, artist_id, release_year) VALUES(\"" + album.getName() + "\", \"" + album.getArtistId() + "\",\"" + album.getReleaseYear() + "\")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findByArtist(Album album) {
        try {
            String query = "SELECT * FROM albums WHERE artist_id = (\"" + album.getArtistId() + "\")";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            if (rs != null) {
                System.out.println("Albums with artistId = \"" + album.getArtistId() + "\":");
                while (rs.next()) {
                    System.out.println("id: " + rs.getInt("id") + ", name: " + rs.getString("name") + ", artistId: " + rs.getInt("artist_id") + ", releaseYear: " + rs.getInt("release_year"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
