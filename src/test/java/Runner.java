package test.java;

import main.java.PageEvents.IMDbHomePageEvents;
import main.java.PageEvents.WikipediaHomePageEvents;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * This class has been created by Vigneshwar Motupalli on May 12, 2022
 */
public class Runner extends BaseTest {
    @Test
    public void validateMovieReleaseDateAndCountryFromWikiPediaAndIMDb() throws InterruptedException {
        WikipediaHomePageEvents wikipediaHomePageEvents = new WikipediaHomePageEvents();
        IMDbHomePageEvents imDbHomePageEvents = new IMDbHomePageEvents();
        wikipediaHomePageEvents.getWikipediaHomePage();
        wikipediaHomePageEvents.getSearchBarAndInputSearchText();
        Assert.assertTrue(wikipediaHomePageEvents.getPageTitle(), "Incorrect Page");
        Assert.assertEquals(wikipediaHomePageEvents.getMovieCountry(), imDbHomePageEvents.getMovieOriginCountry());
        Assert.assertEquals(wikipediaHomePageEvents.getMovieReleaseDate(), imDbHomePageEvents.getMovieReleaseDate());
    }
}
