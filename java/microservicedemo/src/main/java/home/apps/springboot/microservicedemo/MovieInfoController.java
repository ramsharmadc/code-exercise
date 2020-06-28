package home.apps.springboot.microservicedemo;

import home.apps.springboot.model.MovieItem;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("movieinfo")
public class MovieInfoController {

    @RequestMapping("/{movieId}")
    public List<MovieItem> getMovieItem(@PathVariable("movieId") String movieId) {
        return Collections.singletonList(new MovieItem(1, "Phantom"));
    }
}
