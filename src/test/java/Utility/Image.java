package Utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.imageio.ImageIO;
import java.net.HttpURLConnection;
import java.net.URL;

public class Image {
    static WebDriver driver;

    public Image(WebDriver driver) {
        this.driver = driver;
    }

    private static boolean isLoadedCheckWithJS(WebElement image) {
        Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript
                ("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", image);

        return ImagePresent;
    }

    public  Boolean hasImage(WebElement Im, String MarkerForRelativeUrls) {
        int Response;
        String Source = "";
        try {
            Source = Im.getAttribute("src");
            if (Source.equals("#")) {
                return false;
            }
            if (Source.startsWith(MarkerForRelativeUrls)) {
                String BaseUrl = new URL(driver.getCurrentUrl()).getHost();
                Source = BaseUrl + Source;
            }
            HttpURLConnection Connect = (HttpURLConnection) (new URL(Source)).openConnection();
            Response = Connect.getResponseCode();


            if (!((Response + "").startsWith("4") || (Response + "").startsWith("5"))) {

                if (!Im.isDisplayed()) {
                    return false;

                }
                if (!isLoadedCheckWithJS(Im)) {

                    return false;

                }

                ImageIO.read(new URL(Source)); //no exception means valid image
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
