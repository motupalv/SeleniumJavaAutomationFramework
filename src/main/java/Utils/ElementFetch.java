package main.java.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.java.BaseTest;

import java.util.List;

/**
 * This class has been created by Vigneshwar Motupalli on May 12, 2022
 */
public class ElementFetch {

    public WebElement getWebElement(String identifierType, String identifierValue) {
        switch (identifierType) {
            case "ID":
                return BaseTest.driver.findElement(By.id(identifierValue));
            case "CSS":
                return BaseTest.driver.findElement(By.cssSelector(identifierValue));
            case "TAGNAME":
                return BaseTest.driver.findElement(By.tagName(identifierValue));
            case "XPATH":
                return BaseTest.driver.findElement(By.xpath(identifierValue));
            case "CLASSNAME":
                return BaseTest.driver.findElement(By.className(identifierValue));
            case "NAME":
                return BaseTest.driver.findElement(By.name(identifierValue));
            case "LINKTEXT":
                return BaseTest.driver.findElement(By.linkText(identifierValue));
            default:
                return null;
        }
    }

    public void getUrl(String url) {
        BaseTest.driver.get(url);
    }

    public List<WebElement> getListWebElements(String identifierType, String identifierValue) {
        switch (identifierType) {
            case "ID":
                return BaseTest.driver.findElements(By.id(identifierValue));
            case "CSS":
                return BaseTest.driver.findElements(By.cssSelector(identifierValue));
            case "TAGNAME":
                return BaseTest.driver.findElements(By.tagName(identifierValue));
            case "XPATH":
                return BaseTest.driver.findElements(By.xpath(identifierValue));
            case "CLASSNAME":
                return BaseTest.driver.findElements(By.className(identifierValue));
            case "NAME":
                return BaseTest.driver.findElements(By.name(identifierValue));
            case "LINKTEXT":
                return BaseTest.driver.findElements(By.linkText(identifierValue));
            default:
                return null;
        }
    }
}
