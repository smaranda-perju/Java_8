import java.sql.*;

/**
 * Am introdus in baza de date artisti, albume si am testat si metodele din ChartController
 * (am sters din tabel, am generat, am introdus in liste si am facut ranking)
 */
public class Main {
    public static void main(String[] args) {
        Connection connection = Database.getCon();
        ArtistController art = new ArtistController(connection);
        AlbumController alb = new AlbumController(connection);
        ChartController chr = new ChartController(connection);
        Artist artist = new Artist("test2", "usa");
        Artist artist1 = new Artist("test3", "it");
        Artist artist2 = new Artist("test4", "ro");
        Artist artist3 = new Artist("test5", "au");
        Artist artist4 = new Artist("test6", "fin");
        Album album = new Album("album1", 2, 2010);
        Album album1 = new Album("album2", 3, 2019);
        Album album2 = new Album("album3", 4, 2018);
        Album album3 = new Album("album4", 5, 2017);
        Album album4 = new Album("album5", 6, 2016);
        Chart chart1 = new Chart();
        //art.create(artist);
        art.findByName(artist);
        art.create(artist1);
        art.create(artist2);
        art.create(artist3);
        art.create(artist4);

        alb.create(album);
        alb.findByArtist(album);
        alb.create(album1);
        alb.create(album2);
        alb.create(album3);
        alb.create(album4);

        chr.clearChart();
        chr.generateChart(chart1);
        chr.rank(chart1);
        chr.printChart();

    }
}
