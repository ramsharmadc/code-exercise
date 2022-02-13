package catalogue.web.model;

import java.util.List;

public class Catalogue {
    private String title;
    private List<String> authors;
    private List<String> artists;
    private CatalogueType type;

    public Catalogue(String title, List<String> authors, CatalogueType type) {
        this.title = title;
        this.type = type;
        if (CatalogueType.Book == type) this.authors = authors;
        else if (CatalogueType.Album == type) this.artists = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public List<String> getArtists() {
        return artists;
    }

    public void setArtists(List<String> artists) {
        this.artists = artists;
    }

    public CatalogueType getType() {
        return type;
    }

    public void setType(CatalogueType type) {
        this.type = type;
    }
}