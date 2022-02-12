package catalogue.web.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Calendar;

@Component
public class AlbumQueryController {

    private static final Logger LOGGER = LogManager.getLogger(AlbumQueryController.class);

    @Value("${album.search.limit}")
    private int albumSearchLimit;

    @Value("${album.search.api}")
    private String albumBaseUrl;

    /**
     * Search for Albums with the configured API.
     * Expects a token as the parameter, if the token is not provided it will not do the search.
     * Search result are in the limit that can be configured
     *
     * @param token
     * @return
     */
    public ResponseEntity<String> searchAlbums(String token) throws Exception {
        long startSearchAt = Calendar.getInstance().getTimeInMillis();
        RestTemplate restTemplate = new RestTemplate();
        try {
            String urlToHit = getUrl(token);
            LOGGER.info("Searching for albums -> " + urlToHit);
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.add(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
            HttpEntity<String> httpEntity = new HttpEntity<>("parameters", requestHeaders);
            ResponseEntity<String> responseEntity = restTemplate.exchange(
                    urlToHit, HttpMethod.GET, httpEntity, String.class);
            long startFinishedAt = Calendar.getInstance().getTimeInMillis();
            long timeTaken = startFinishedAt - startSearchAt;
            LOGGER.info("Search for Albums finished in {} milli seconds", timeTaken);
            return responseEntity;
        } catch (Exception e) {
            throw new Exception("Error while searching for albums", e);
        }
    }

    private String getUrl(String token) {
        if (StringUtils.isEmpty(albumBaseUrl)) {
            throw new RuntimeException("Invalid Api -> " + albumBaseUrl);
        }
        StringBuilder urlBuilder = new StringBuilder(albumBaseUrl);
        if (!StringUtils.isEmpty(token)) {
            urlBuilder.append("?term=" + token);
        }
        if (albumSearchLimit > 0) {
            urlBuilder.append("&limit=" + albumSearchLimit);
        }
        return urlBuilder.toString();
    }
}