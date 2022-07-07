package main.java.PageObjects;

/**
 * This class has been created by Vigneshwar Motupalli on May 12, 2022
 * This class contains all the necessary Page elements of WikiPedia Page.
 */
public interface WikipediaHomePageElements {
    String getWikipediaLogo = "//a[@class='mw-wiki-logo']";
    String getWikipediaSearchBar = "//input[@class='vector-search-box-input']";
    String getWikipediaSearchButton = "//input[@id='searchButton']";
    String getWikiPediaPageTitle = "//h1[@class='firstHeading mw-first-heading']";
    String getWikipediaTable = "//table[@class='infobox vevent']";

    String getWikipediaRow = "tr";

    String getWikipediaTableRHS = "(((//table[@class='infobox vevent'])//tr//td))";
    String getWikipediaTableLHS = "(((//table[@class='infobox vevent'])//tr//th))";

    String getWikipediaHeaderData = "th";
    String getWikipediaUrl = "https://en.wikipedia.org/wiki/Main_Page";
}
