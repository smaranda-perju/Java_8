import java.sql.*;

/**
 * Am introdus in baza de date cateva albume si cativa artisti si i-am si cautat in functie de id-ul artistului (pentru albume)
 * si nume (pentru artisti)
 */
public class Main {
    public static void main(String[] args) {
        Connection connection = Database.getCon();
        ArtistController art = new ArtistController(connection);
        AlbumController alb = new AlbumController(connection);

        art.create("Test", "Romania");
        art.findByName("Test");

        art.create("Artist", "UK");
        art.findByName("Artist");

        alb.create("Alb1", 2, 1999);
        alb.findByArtist(2);

        alb.create("Alb2", 5, 2000);
        alb.findByArtist(5);

    }
}
