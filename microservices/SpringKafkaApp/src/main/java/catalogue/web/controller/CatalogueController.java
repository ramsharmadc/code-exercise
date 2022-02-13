package catalogue.web.controller;

import catalogue.web.model.BookQueryResponseEntity;
import catalogue.web.model.Catalogue;
import catalogue.web.utils.CatalogueUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/catalogue")
public class CatalogueController {

    private static final Logger LOGGER = LogManager.getLogger(CatalogueController.class);
    @Value("${book.search.limit}")
    private int bookSearchLimit;
    @Autowired
    private BookQueryController bookSearchController;
    @Autowired
    private AlbumQueryController albumQueryController;

    @RequestMapping(method = RequestMethod.GET, value = "/ping")
    @ResponseBody
    public ResponseEntity<String> ping() {
        LOGGER.info("Received a Ping");
        return ResponseEntity.status(HttpStatus.CREATED).body("Service is up and running");
    }

    /**
     * Search for Albums and Books. New Search modules can be added as required.
     * Expects a token as the parameter, if the token is not provided it will not do the search.
     * Search result are the aggregation of all the modules that are sorted on Title
     * <p>
     * Examples -
     * 1. To search for a single word token like Jimmy,
     * use url - http://localhost:8080/catalogue/search/Jimmy
     * 2. To search for multiple token like Jimmy Hendrix,
     * use url - http://localhost:8080/catalogue/search/Jimmy+Hendrix
     * <p>
     */
    @RequestMapping(method = RequestMethod.GET, value = "/search/{token}")
    @ResponseBody
    public ResponseEntity<List<Catalogue>> search(@PathVariable("token") String token) {
        long benchMarkTime = 60000;
        long startSearchAt = Calendar.getInstance().getTimeInMillis();
        List<Catalogue> catalogues = new ArrayList<>();

        try {
            if (StringUtils.isEmpty(token)) {
                LOGGER.warn("Invalid token to search.");
            } else {
                LOGGER.info("Searching for token -> [{}] ", token);

                // Any issue with Books API should not impact the rest of the modules
                try {
                    ResponseEntity<BookQueryResponseEntity> bookSearchResult =
                            bookSearchController.searchBooks(token);
                    catalogues = CatalogueUtils.getBookCatalogues(bookSearchResult);
                } catch (Exception e) {
                    LOGGER.error("Error occurred while searching for Books with token -> [{}]",
                            token, e);
                }

                try {
                    ResponseEntity<String> albumSearchResult =
                            albumQueryController.searchAlbums(token);
                    catalogues.addAll(CatalogueUtils.getAlbumCatalogues(albumSearchResult));
                } catch (Exception e) {
                    LOGGER.error("Error occurred while searching for Albums with token -> [{}]",
                            token, e);
                }

                catalogues.sort(CatalogueUtils.SORT_BY_TITLE);
            }

            long startFinishedAt = Calendar.getInstance().getTimeInMillis();
            long timeTaken = startFinishedAt - startSearchAt;
            LOGGER.info("Search finished in {} milli seconds", timeTaken);
            if (timeTaken > benchMarkTime) {
                LOGGER.warn("Time limit exceeded benchmark of {} milli seconds", benchMarkTime);
            }

        } catch (Exception e) {
            LOGGER.error("Error occurred while searching for token -> [{}]", token, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(catalogues);
    }
}