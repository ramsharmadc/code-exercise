package home.apps.springboot.microservicedemo;

import home.apps.springboot.model.CatalogueItem;
import home.apps.springboot.model.MovieItem;
import home.apps.springboot.model.Rating;
import org.eclipse.collections.api.collection.ImmutableCollection;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.impl.iterator.ImmutableEmptyIntIterator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//import static org.eclipse.collections.impl.list.immutable.ImmutableArrayList.newListWith;

@RestController
@RequestMapping("catalog")
public class MovieCatalogController {

    @RequestMapping("/{userId}")
    public List<CatalogueItem> getCatalogue(@PathVariable("userId") String userId) {

        // to make a rest call
        RestTemplate restTemplate = new RestTemplate();


//        ImmutableList<Integer> iml = ImmutableEmptyIntIterator

        List<Rating> ratings = Arrays.asList(new Rating(1, "7.5"),
                new Rating(2, "8.7"));

        return ratings.stream().map(r -> {

            MovieItem movieItem = restTemplate.getForObject(
                    "http://localhost:8080/movieinfo/" + r.getMovieId(),
                    MovieItem.class);

            return new CatalogueItem(movieItem.getName(), r.getMovieId(), r.getValue());
        }).collect(Collectors.toList());
    }
}