import java.util.ArrayList;
import java.util.List;

/**
 * in clasa Chart nu a fost nevoie de contructor sau setters, ci doar de metoda addDataInList
 * @addDataInList are rolul de a adauga tot ce a fost inserat in tabelul charts (in clasa ChartController) in liste pentru ca mai apoi
 * este nevoie de ele pentru a crea clasamentul in metoda rank din clasa ChartController
 */
public class Chart {

    private List<Integer> id = new ArrayList<>();
    private List<String> nameArtist = new ArrayList<>();
    private List<Integer> idAlbum = new ArrayList<>();


    public Chart() {
    }

    public void addDataInLists(String numeArt, Integer idAlb) {
        nameArtist.add(numeArt);
        idAlbum.add(idAlb);
    }

    public List<String> getNameArtist() {
        return nameArtist;
    }

    public List<Integer> getIdAlbum() {
        return idAlbum;
    }
}