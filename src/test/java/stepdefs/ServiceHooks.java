package stepdefs;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class ServiceHooks {
    static WebDriver driver;
    public static News news;
    public static Home home;

    @Before
    public void initializeTest() {
        // Code to setup initial configurations
        System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        home = new Home(driver);
        news = new News(driver);

    }

    @After
    public void closure(Scenario scenario) {
        driver.quit();
    }
}
