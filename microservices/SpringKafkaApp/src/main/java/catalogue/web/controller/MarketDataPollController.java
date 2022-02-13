package catalogue.web.controller;

import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.Calendar;
import java.util.Map;

@Component
@RequestMapping("/marketdata")
public class MarketDataPollController {

    private static final Logger LOGGER = LogManager.getLogger(MarketDataPollController.class);

    @Value("${marketdata.search.limit}")
    private int albumSearchLimit;

    @Value("${marketdata.search.api}")
    private String albumBaseUrl;

    /**
     * Search for Albums with the configured API.
     * Expects a token as the parameter, if the token is not provided it will not do the search.
     * Search result are in the limit that can be configured
     *
     * @param symbol
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public ResponseEntity<String> searchAlbums(String symbol) throws Exception {
        long startSearchAt = Calendar.getInstance().getTimeInMillis();
        RestTemplate restTemplate = new RestTemplate();
        try {
            String urlToHit = appendSymbol(symbol);
            LOGGER.info("searching for market data -> " + urlToHit);
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.add(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
            HttpEntity<String> httpEntity = new HttpEntity<>("parameters", requestHeaders);
            ResponseEntity<String> responseEntity = restTemplate.exchange(
                    urlToHit, HttpMethod.GET, httpEntity, String.class);
            Gson gson = new Gson();
            Map map = gson.fromJson(responseEntity.getBody(), Map.class);
            readMarketData(map);
            long startFinishedAt = Calendar.getInstance().getTimeInMillis();
            long timeTaken = startFinishedAt - startSearchAt;
            LOGGER.info("search for market data finished in {} milli seconds", timeTaken);
            return responseEntity;
        } catch (Exception e) {
            throw new Exception("error while searching for albums", e);
        }
    }

    private String getUrl(String token) {
        if (StringUtils.isEmpty(albumBaseUrl)) {
            throw new RuntimeException("invalid api -> " + albumBaseUrl);
        }
        StringBuilder urlBuilder = new StringBuilder(albumBaseUrl);
        if (!StringUtils.isEmpty(token)) {
            urlBuilder.append("?term=" + token);
        }
        /*if (albumSearchLimit > 0) {
            urlBuilder.append("&limit=" + albumSearchLimit);
        }*/
        return urlBuilder.toString();
    }

    private String appendSymbol(String symbol) {
        return appendQueryParam("symbol", symbol);
    }

    private String appendQueryParam(String paramName, String paramValue) {
        if (StringUtils.isEmpty(albumBaseUrl)) {
            throw new RuntimeException("invalid api -> " + albumBaseUrl);
        }
        StringBuilder urlBuilder = new StringBuilder(albumBaseUrl);
        if (!StringUtils.isEmpty(paramName) && !StringUtils.isEmpty(paramValue)) {
            urlBuilder.append("&" + paramName + "=" + paramValue);
        }
        return urlBuilder.toString();
    }

    private void readMarketData(Map<Object, Object> dataMap) {

//        System.out.println(dataMap.keySet());

        Map<String, Object> metadata = (Map<String, Object>) dataMap.get("Meta Data");
        Map<String, Object> timeSeriesData = (Map<String, Object>) dataMap.get("Time Series (5min)");

        metadata.entrySet().stream().forEach(m -> {
            System.out.println(m.getKey() + " <-> " + m.getValue());
        });

        timeSeriesData.entrySet().stream().forEach(t -> {
            System.out.println(t.getKey());
            Map<String, String> m = (Map<String, String>) t.getValue();
            m.entrySet().stream().forEach(e -> {
                System.out.println("\t" + e.getKey() + " <=> " + e.getValue());
            });
        });

       /* dataMap.entrySet().forEach(x -> {
            System.out.println(x.getKey());
            System.out.println(x.getValue());
        });*/
    }
}