package practice.javalang8;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TestSearchQueryString {

    SearchQueryString searchQueryString = new SearchQueryString();

    @Test
    public void testValidQueryString() {

        String inputString = "ramabc sharmabc xyzbc";
        String queryString = "abc";

        List<String> out = searchQueryString.search(inputString, queryString);

        Assert.assertEquals(2, out.size());
    }

    @Test
    public void testNonMatchingQueryString() {

        String inputString = "ramab sharmab xyzbc";
        String queryString = "abc";

        List<String> out = searchQueryString.search(inputString, queryString);

        Assert.assertEquals(0, out.size());
    }

    @Test
    public void testEmptyQueryString() {
        String inputString = "ramabc sharmabc xyzbc";
        String queryString = "";

        List<String> out = searchQueryString.search(inputString, queryString);

        Assert.assertEquals(0, out.size());
    }

    @Test
    public void testEmptyInputString() {
        String inputString = "";
        String queryString = "abc";

        List<String> out = searchQueryString.search(inputString, queryString);

        Assert.assertEquals(0, out.size());
    }

    @Test
    public void testEmptyInputAndQueryString() {
        String inputString = "";
        String queryString = "";

        List<String> out = searchQueryString.search(inputString, queryString);

        Assert.assertEquals(0, out.size());
    }

    @Test
    public void testSomeScenario() {

        String inputString = "ramabc sharmabc xyzbc";
        String queryString = "Abc";

        List<String> out = searchQueryString.search(inputString, queryString);

        Assert.assertEquals(2, out.size());
    }

    @Test
    public void testQueryStringWithWhiteSpace() {

        String inputString = "ramabc sharmabc xyzbc";
        String queryString = "Abc rm";

        List<String> out = searchQueryString.search(inputString, queryString);

        Assert.assertEquals(2, out.size());
    }

}
