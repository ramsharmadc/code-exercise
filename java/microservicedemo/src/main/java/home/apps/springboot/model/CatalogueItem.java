package home.apps.springboot.model;

public class CatalogueItem {
    private String name;
    private int id;
    private String rating;

    public CatalogueItem(String name, int id, String rating) {
        this.name = name;
        this.id = id;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
