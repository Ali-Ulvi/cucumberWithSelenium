package pages;

import Utility.Image;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class News {
    WebDriver driver;

    @FindBy(css = "header > h1")
    WebElement title;

    @FindBy(css = "div.post-content > p > img")
    WebElement image;

    @FindBy(css = "aside > div.post-info-author-date > span.post-info-author > a")
    WebElement author;

    public News(WebDriver driver) {
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 25);
        //This initElements method will create  all WebElements
        PageFactory.initElements(factory, this);
        this.driver = driver;

    }

    public String getNewsTitle() {
        return title.getText();
    }

    public String getBrowserTitle() {
        return driver.getTitle();
    }

    public boolean newsHasAuthor() {

        return !author.getText().isEmpty();

    }

    public boolean newsHasImage() {

        return (new Utility.Image(driver)).hasImage(image,"/");

    }
}
