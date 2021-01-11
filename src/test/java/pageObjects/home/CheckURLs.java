package pageObjects.home;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckURLs {

    public static void main(String url) throws MalformedURLException, IOException {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdriver/mac/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get(url);

        List<WebElement> linksList = driver.findElements(By.xpath("sticky-wrapper"));

        linksList.addAll(driver.findElements(By.tagName("a")));

        List<WebElement> activeLinks = new ArrayList<WebElement>();

        //iterate linksList : exclude all the links or images which don’t have an href attribute

        for (int i = 0; i < linksList.size(); i++) {

            System.out.println(linksList.get(i).getAttribute("href"));

            if (linksList.get(i).getAttribute("href") != null &&
                    (!linksList.get(i).getAttribute("href").contains("javascript"))) {

                activeLinks.add(linksList.get(i));

            }
        }

        //check the href url with httpconnection api:

        for (int j = 10; j < activeLinks.size(); j++) {

            HttpURLConnection connection = (HttpURLConnection) new
                    URL(activeLinks.get(j).getAttribute("href")).openConnection();

            connection.connect();

            int response = connection.getResponseCode();

            connection.disconnect();

            System.out.println(activeLinks.get(j).getAttribute("href") + " ----> " + response);
        }
    }
}
