import java.sql.*;

/**
 * @ChartController
 * @clearChart aceasta metoda sterge tot din tabel
 * @printChart afiseaza tot ce se afla in tabelul charts
 * @generateChart prima data se insereaza in tabel datele. Are loc un join intre tabela artists si tabela albums in functie de id-ul artistilor.
 * Datele vor fi puse in ordine ascendenta in functie de id-ul albumelor inserate. Dupa ce datele au fost inserate in tabel cu succes
 * ele vor fi puse si in listele din clasa Chart pentru ca mai apoi sa poata fi facut clasamentul din metoda rank
 * @rank in aceasta metoda va fi creat clasamentul
 */
public class ChartController {
    private Connection connection;

    public ChartController(Connection connection) {
        this.connection = connection;
    }
    public void clearChart() {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM CHARTS");
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void printChart() {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM CHARTS");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                System.out.println("id: " + rs.getInt("id") + ", artist name: " + rs.getString("name_artist")+", id album: " + rs.getInt("album_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void generateChart(Chart chart) {
        String query = "";
        query = query.concat("INSERT INTO CHARTS (name_artist, album_id) ");
        query = query.concat("SELECT artists.name, albums.id ");
        query = query.concat("FROM artists JOIN albums ON artists.id = albums.artist_id ");
        query = query.concat("ORDER BY albums.id ASC");

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate();
            PreparedStatement statement2 = connection.prepareStatement("SELECT * FROM CHARTS");
            ResultSet rs = statement2.executeQuery();
            while(rs.next()){
                chart.addDataInLists(rs.getString("name_artist"), rs.getInt("album_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void rank(Chart chart) {
        for (int i = 0; i < chart.getNameArtist().size(); i++)
            System.out.println("Rank #" + (i+1) + ": " + chart.getNameArtist().get(i));
    }
}
