package catalogue.web.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookQueryResponseEntity {

    private String kind;
    private List<Object> items;
    private int totalItems;

    public BookQueryResponseEntity() {
    }

    public BookQueryResponseEntity(String kind, List<Object> items, int totalItems) {
        this.kind = kind;
        this.items = items;
        this.totalItems = totalItems;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public List<Object> getItems() {
        return items;
    }

    public void setItems(List<Object> items) {
        this.items = items;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    @Override
    public String toString() {
        return "BookQueryResponseEntity{" +
                "kind='" + kind + '\'' +
                ", items=" + items +
                ", totalItems=" + totalItems +
                '}';
    }
}
