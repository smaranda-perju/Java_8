//import java.sql.*;

/**
 * @Artist
 * intrucat in baza de date tabelul artists contine un id, numele si tara artistului, clasa contine cele 3 artibute
 * constructorul Artist (String name, String country) primeste ca parametri doar numele si tara pentru ca atunci cand am creat tabelul in mysql
 * am setat id-ului proprietatea auto_increment
 */
public class Artist {
    private int id;
    private String name;
    private String country;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public Artist(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public Artist() {
    }

}
