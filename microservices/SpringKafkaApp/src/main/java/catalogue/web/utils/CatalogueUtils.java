package catalogue.web.utils;

import catalogue.web.model.*;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class CatalogueUtils {
    /**
     * Sorts the Catalogue by Title
     */
    public static final Comparator<Catalogue> SORT_BY_TITLE = Comparator.comparing(Catalogue::getTitle);
    private static final Logger LOGGER = LogManager.getLogger(CatalogueUtils.class);

    /**
     * Util method to convert the Book API Response to the Catalogue
     *
     * @param bookQueryResponseEntity
     * @return
     */
    public static List<Catalogue> getBookCatalogues(
            ResponseEntity<BookQueryResponseEntity> bookQueryResponseEntity) {
        if (bookQueryResponseEntity == null ||
                bookQueryResponseEntity.getBody() == null ||
                bookQueryResponseEntity.getBody().getItems() == null ||
                bookQueryResponseEntity.getBody().getItems().isEmpty()) {
            return new ArrayList<>();
        }
        List<Object> items = bookQueryResponseEntity.getBody().getItems();
        List<Catalogue> catalogues = new ArrayList<>();
        for (Object o : items) {
            if (o instanceof Map) {
                Map<String, Object> volumeInfo = (Map<String, Object>) ((Map) o).get("volumeInfo");
                String title = (String) volumeInfo.get(BookResponseEntityField.Title.getJsonField());
                List<String> authors = (List<String>) volumeInfo.
                        get(BookResponseEntityField.Authors.getJsonField());
                Catalogue c = new Catalogue(title, authors, CatalogueType.Book);
                catalogues.add(c);
            }
        }
        return catalogues;
    }

    /**
     * Util method to convert the Album API Response to the Catalogue
     * * @param bookQueryResponseEntity
     * * @return
     */
    public static List<Catalogue> getAlbumCatalogues(ResponseEntity<String> responseEntity) {
        if (responseEntity == null ||
                responseEntity.getBody() == null) {
            return new ArrayList<>();
        }
        Gson g = new Gson();
        AlbumQueryResponseEntity dto = g.fromJson(responseEntity.getBody(), AlbumQueryResponseEntity.class);
        List<Catalogue> catalogues = new ArrayList<>();
        for (Object o : dto.getResults()) {
            if (o instanceof Map) {
                String title = (String) ((Map) o).get(AlbumResponseEntityField.TrackName.getJsonField());
                List<String> artists = new ArrayList<>();
                String artistName = (String) ((Map) o).get(AlbumResponseEntityField.ArtistName.getJsonField());
                artists.add(artistName);
                Catalogue c = new Catalogue(title, artists, CatalogueType.Album);
                catalogues.add(c);
            }
        }
        return catalogues;
    }
}
