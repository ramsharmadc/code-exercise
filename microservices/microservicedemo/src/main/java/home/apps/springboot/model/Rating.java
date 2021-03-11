package home.apps.springboot.model;

public class Rating {

    private int movieId;
    private String value;

    public Rating(int id, String value) {
        this.movieId = id;
        this.value = value;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int id) {
        this.movieId = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
