package catalogue.web.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AlbumQueryResponseEntity {

    private int resultCount;
    private List<Object> results;
    private CatalogueType type = CatalogueType.Album;

    public AlbumQueryResponseEntity() {
    }

    public AlbumQueryResponseEntity(int resultCount,
                                    List<Object> results) {
        this.resultCount = resultCount;
        this.results = results;
    }

    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    public List<Object> getResults() {
        return results;
    }

    public void setResults(List<Object> results) {
        this.results = results;
    }

    public CatalogueType getType() {
        return type;
    }

    public void setType(CatalogueType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AlbumQueryResponseEntity{" +
                "resultCount=" + resultCount +
                ", results=" + results +
                ", type=" + CatalogueType.Album +
                '}';
    }
}