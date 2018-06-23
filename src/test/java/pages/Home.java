package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class Home {
    WebDriver driver;

    @FindBy(css = "#webrazzipopulerwidget-6 > div > div > div.pw_post-title > a")
    List<WebElement> news;

    public Home(WebDriver driver) {
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 25);
        //This initElements method will create  all WebElements
        PageFactory.initElements(factory, this);
        this.driver=driver;
    }

    public void openNthNews(int n) {
        news.get(n - 1).click();
    }


}
