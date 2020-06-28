package catalogue.web.model;

public enum BookResponseEntityField {

    Title("title"),
    Authors("authors");

    String jsonField;

    BookResponseEntityField(String k) {
        this.jsonField = k;
    }

    public String getJsonField() {
        return jsonField;
    }
}
