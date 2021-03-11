package catalogue.web.controller;

import catalogue.web.model.BookQueryResponseEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Calendar;

@Component
public class BookQueryController {

    private static final Logger LOGGER = LogManager.getLogger(BookQueryController.class);

    @Value("${book.search.limit}")
    private int bookSearchLimit;

    @Value("${book.search.api}")
    private String bookBaseUrl;

    /**
     * Search for Books with the configured API.
     * Expects a token as the parameter, if the token is not provided it will not do the search.
     * Search result are in the limit that can be configured
     *
     * @param token
     * @return
     */
    public ResponseEntity<BookQueryResponseEntity> searchBooks(String token) throws Exception {
        long startSearchAt = Calendar.getInstance().getTimeInMillis();
        RestTemplate restTemplate = new RestTemplate();
        try {
            String urlToHit = getUrl(token);
            LOGGER.info("Searching for books -> " + urlToHit);
            ResponseEntity<BookQueryResponseEntity> bookSearchResult = restTemplate.getForEntity(
                    urlToHit,
                    BookQueryResponseEntity.class);
            long startFinishedAt = Calendar.getInstance().getTimeInMillis();
            long timeTaken = startFinishedAt - startSearchAt;
            LOGGER.info("Search for Books finished in {} milli seconds", timeTaken);
            return bookSearchResult;
        } catch (Exception e) {
            throw new Exception("Error while searching for books", e);
        }
    }

    private String getUrl(String token) {
        if (StringUtils.isEmpty(bookBaseUrl)) {
            throw new RuntimeException("Invalid Api -> " + bookBaseUrl);
        }
        StringBuilder urlBuilder = new StringBuilder(bookBaseUrl);
        if (!StringUtils.isEmpty(token)) {
            urlBuilder.append("?q=" + token);
        }
        if (bookSearchLimit > 0) {
            urlBuilder.append("&maxResults=" + bookSearchLimit);
        }
        return urlBuilder.toString();
    }
}
