package lang.jdk8.java8functional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class SimpleExample {

    public static void main(String[] args) {
        Artist artist1 = new Artist(true, "ram sharma");
        Artist artist2 = new Artist(false, "amit sharma");
        Artist artist3 = new Artist(true, "code exercise");
        Artist artist4 = new Artist(true, "hello world");
        Artist artist5 = new Artist(true, "covid corona");

        List<Artist> artists = new ArrayList<>();
        artists.add(artist1);
        artists.add(artist2);
        artists.add(artist3);
        artists.add(artist4);
        artists.add(artist5);

        artists.stream().filter(x -> {
            System.out.println("checking if artist from london");
            return x.isFromLondon();
        });

        // only when we call terminal operation, the filter operations are calculated
        long count = artists.stream().filter(Artist::isFromLondon).count();
        System.out.println("London artists: " + count);

        List<String> upperCaseNamedArtists = artists.stream().map(x ->
                x.name.toUpperCase()).collect(Collectors.toList());
        System.out.println(upperCaseNamedArtists);
    }

    static class Artist {
        static AtomicInteger artistCount = new AtomicInteger(1);
        int artistId;
        boolean fromLondon;
        String name;

        public Artist(boolean fromLondon, String name) {
            this.artistId = artistCount.getAndIncrement();
            this.fromLondon = fromLondon;
            this.name = name;
        }

        boolean isFromLondon() {
            return fromLondon;
        }
    }
}
