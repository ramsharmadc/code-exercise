package catalogue.web.model;

public enum AlbumResponseEntityField {

    TrackName("trackName"),
    ArtistName("artistName");

    String jsonField;

    AlbumResponseEntityField(String k) {
        this.jsonField = k;
    }

    public String getJsonField() {
        return jsonField;
    }
}
