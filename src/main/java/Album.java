import java.sql.*;

/**
 * @Album
 * similar ca in clasa Artist id-ul are proprietatea auto_increment, iar in constructor am doar name, artistId si releaseYear
 */
public class Album {
    private int id;
    private String name;
    private int artistId;
    private int releaseYear;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getArtistId() {
        return artistId;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public Album(String name, int artistId, int releaseYear) {
        this.name = name;
        this.artistId = artistId;
        this.releaseYear = releaseYear;
    }
    public Album(){}

}
